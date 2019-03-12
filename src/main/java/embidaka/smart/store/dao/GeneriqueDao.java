package embidaka.smart.store.dao;

import embidaka.smart.stores.database.UtilDB;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class GeneriqueDao {

    private String getValue(Field[] data) {

        int taille = data.length;
        String reponse = "?";
        for (int i = 1; i < taille; i++) {

            reponse = reponse + ",?";
        }
        return reponse;
    }

    private String getListeAttribue(Field[] data) {

        String reponse = data[0].getName();
        for (int i = 1; i < data.length; i++) {

            reponse = reponse + "," + data[i].getName();
        }
        return reponse;
    }

    private Field[] refactorWithoutArray(Field[] data) {

        List<Field> temp = new ArrayList<>();
        for (Field data1 : data) {

            if (!data1.getType().equals(ArrayList.class) && !data1.getType().equals(List.class)) {
                temp.add(data1);
            }
        }
        return temp.toArray(new Field[temp.size()]);
    }

    private String getStringUpdate(Field[] data) {

        String reponse = data[0].getName() + "=?";
        for (int i = 1; i < data.length; i++) {

            reponse = reponse + ", " + data[i].getName() + "=?";
        }
        return reponse;
    }

    private Class<?> getType(int type) throws Exception {

        switch (type) {
            case Types.VARCHAR:
            case Types.CHAR:
                return String.class;
            case Types.INTEGER:
                return int.class;
            case Types.DATE:
                return Date.class;
            default:
                throw new Exception("Classe non specifier dans la base");
        }
    }

    @SuppressWarnings("rawtypes")
    private Class[] getListClassAttribut(Class<?> model) throws Exception {

        Field[] attribut = model.getDeclaredFields();
        List<Class> temp = new ArrayList<>();
        for (int i = 0; i < attribut.length; i++) {

            if (attribut[i].getType().equals(List.class) || attribut[i].getType().equals(ArrayList.class)) {

                String c = attribut[i].getName();
                c = c.substring(5);
                String packageTemp = model.getName();
                packageTemp = packageTemp.replace(model.getSimpleName(), "");
                char[] char_table = c.toCharArray();
                char_table[0] = Character.toUpperCase(char_table[0]);
                c = new String(char_table);
                c = packageTemp + c;
                Class<?> t = Class.forName(c);
                temp.add(t);
            }
        }
        return temp.toArray(new Class[temp.size()]);
    }

    public void save(BaseModel model) throws Exception {

        Field[] attribut = this.refactorWithoutArray(model.getClass().getDeclaredFields());
        String nom = model.getClass().getSimpleName();
        Connection conn = null;
        PreparedStatement stmt = null;
//        int id = 0;
        try {

            String sql = "INSERT INTO " + nom + "(id" + nom + "," + getListeAttribue(attribut) + ") VALUES (?," + getValue(attribut) + ");";
            conn = UtilDB.getConnection();
            stmt = conn.prepareStatement(sql);
            int id = maxID(model, conn) + 1;
            System.out.println("id = " + id);
            stmt.setInt(1, id);
            int u = 1;
            for (int i = 0; i < attribut.length; i++) {

                attribut[i].setAccessible(true);
                stmt.setObject(u + 1, attribut[i].get(model));
                u++;
            }
            stmt.executeUpdate();
            conn.commit();
        } catch (Exception e) {

            conn.rollback();
            throw e;
        } finally {

            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    public void update(BaseModel model) throws Exception {

        Field[] attribut = this.refactorWithoutArray(model.getClass().getDeclaredFields());
        String nom = model.getClass().getSimpleName();
        Connection conn = null;
        PreparedStatement stmt = null;
        try {

            String sql = "UPDATE " + nom + " SET " + getStringUpdate(attribut) + "  WHERE id" + nom + "=?;";
            conn = UtilDB.getConnection();
            stmt = conn.prepareStatement(sql);
            for (int i = 0; i < attribut.length; i++) {

                attribut[i].setAccessible(true);
                stmt.setObject(i + 1, attribut[i].get(model));
            }
            stmt.setInt(attribut.length + 1, model.getId());
            stmt.executeUpdate();
            conn.commit();
        } catch (Exception e) {

            conn.rollback();
            throw e;
        } finally {

            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    public void delete(BaseModel model) throws Exception {

        String className = model.getClass().getSimpleName();
        Connection conn = null;
        PreparedStatement stmt = null;
        try {

            String sql = "DELETE from " + className + " where id" + className + " =  ?";
            conn = UtilDB.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setObject(1, model.getId());
            stmt.executeUpdate();
            conn.commit();
        } catch (Exception e) {

            conn.rollback();
            throw e;
        } finally {

            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    @SuppressWarnings("rawtypes")
    public List<BaseModel> findAll(BaseModel classType) throws Exception {

        ArrayList<BaseModel> reponse = new ArrayList<>();
        String name = classType.getClass().getSimpleName();
        String allName = classType.getClass().getName();
        Class<?> model = Class.forName(allName);

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        try {

            String sql = "select * from " + name;
            conn = UtilDB.getConnection();
            stmt = conn.prepareStatement(sql);
            res = stmt.executeQuery();
            while (res.next()) {

                ArrayList<Object> value = new ArrayList<>();
                ArrayList<Class> type = new ArrayList<>();
                ResultSetMetaData rsmd = res.getMetaData();
                int typeDB = 0;
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {

                    typeDB = rsmd.getColumnType(i);
                    Class<?> tempClass = this.getType(typeDB);
                    type.add(tempClass);
                    value.add(res.getObject(i));
                }
                Class[] types = type.toArray(new Class[type.toArray().length]);
                Constructor<?> constructor = model.getConstructor(types);

                Object object = constructor.newInstance(value.toArray());

                reponse.add((BaseModel) object);
            }

        } catch (Exception e) {

            throw e;
        } finally {

            if (res != null) {
                res.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return reponse;
    }

    @SuppressWarnings("rawtypes")
    private ArrayList<BaseModel> findAll(Class<?> mere, Class<?> fille, String where) throws Exception {

        ArrayList<BaseModel> reponse = new ArrayList<>();
        String name = fille.getSimpleName();
        String allName = fille.getName();

        String nameMere = mere.getSimpleName();

        Class<?> model = Class.forName(allName);

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        try {

            String sql = "select * from " + name + " where id" + nameMere + " = " + where;
            conn = UtilDB.getConnection();
            stmt = conn.prepareStatement(sql);
            res = stmt.executeQuery();
            while (res.next()) {

                ArrayList<Object> value = new ArrayList<>();
                ArrayList<Class> type = new ArrayList<>();
                ResultSetMetaData rsmd = res.getMetaData();
                int typeDB = 0;
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {

                    typeDB = rsmd.getColumnType(i);
                    Class<?> tempClass = this.getType(typeDB);
                    type.add(tempClass);
                    value.add(res.getObject(i));
                }
                Class[] types = type.toArray(new Class[type.toArray().length]);
                Constructor<?> constructor = model.getConstructor(types);

                Object object = constructor.newInstance(value.toArray());

                reponse.add((BaseModel) object);
            }

        } catch (Exception e) {

            throw e;
        } finally {

            if (res != null) {
                res.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return reponse;
    }

    @SuppressWarnings("rawtypes")
    public List<BaseModel> findAll(BaseModel classType, boolean cascade) throws Exception {

        ArrayList<BaseModel> reponse = null;
        String allName = classType.getClass().getName();
        Class<?> model = Class.forName(allName);

        try {

            reponse = (ArrayList<BaseModel>) this.findAll(classType);
            if (cascade) {

                Class[] listEtranger = this.getListClassAttribut(model);
                if (listEtranger != null) {

                    for (int indiceReponse = 0; indiceReponse < reponse.size(); indiceReponse++) {

                        for (int i = 0; i < listEtranger.length; i++) {

                            Method temp = model.getMethod("set" + listEtranger[i].getSimpleName(), ArrayList.class);
                            temp.invoke(reponse.get(indiceReponse), this.findAll(model, listEtranger[i], String.valueOf(reponse.get(indiceReponse).getId())));
                        }
                    }
                }
            }
        } catch (Exception e) {

            throw e;
        }
        return reponse;
    }

    public BaseModel findId(int id, BaseModel classType) throws Exception {

        List<BaseModel> liste = findAll(classType);
        int nb = liste.size();
        for (int i = 0; i < nb; i++) {

            if (liste.get(i).getId() == id) {
                return liste.get(i);
            }
        }
        return null;
    }

    /*public BaseModel findId(BaseModel classType, boolean cascade) throws Exception {

        List<BaseModel> liste = findAll(classType, true);
        int nb = liste.size();
        for (int i = 0; i < nb; i++) {

            if (liste.get(i).getId() == classType.getId()) {
                return liste.get(i);
            }
        }
        return null;
    }*/

    public int maxID(BaseModel classType, Connection conn) throws Exception {

        int out = 0;
        String name = classType.getClass().getSimpleName();
        String allName = classType.getClass().getName();
        Class<?> model = Class.forName(allName);
        PreparedStatement stmt = null;
        ResultSet res = null;
        try {

            String sql = "select max(id" + name + ") from " + name;
            stmt = conn.prepareStatement(sql);
            res = stmt.executeQuery();

            while (res.next()) {
                if (res.getObject("max") != null) {
                    out = (int) res.getObject("max");
                }
            }

        } catch (Exception e) {

            throw e;
        } finally {

            if (res != null) {
                res.close();
            }
            if (stmt != null) {
                stmt.close();
            }
//            if (conn != null) {
//                conn.close();
//            }
        }
        System.out.println("ty e out eeeeeee " + out);
        return out;
    }
    
    @SuppressWarnings("rawtypes")
    public ArrayList<BaseModel> findByString(Class<?> fille, String where) throws Exception {

        ArrayList<BaseModel> reponse = new ArrayList<>();
        String name = fille.getSimpleName();
        String allName = fille.getName();

        //String nameMere = mere.getSimpleName();

        Class<?> model = Class.forName(allName);

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        try {

            String sql = "select * from " + name + " where " + where;
            conn = UtilDB.getConnection();
            stmt = conn.prepareStatement(sql);
            res = stmt.executeQuery();
            while (res.next()) {

                ArrayList<Object> value = new ArrayList<>();
                ArrayList<Class> type = new ArrayList<>();
                ResultSetMetaData rsmd = res.getMetaData();
                int typeDB = 0;
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {

                    typeDB = rsmd.getColumnType(i);
                    Class<?> tempClass = this.getType(typeDB);
                    type.add(tempClass);
                    value.add(res.getObject(i));
                }
                Class[] types = type.toArray(new Class[type.toArray().length]);
                Constructor<?> constructor = model.getConstructor(types);

                Object object = constructor.newInstance(value.toArray());

                reponse.add((BaseModel) object);
            }

        } catch (Exception e) {

            throw e;
        } finally {

            if (res != null) {
                res.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return reponse;
    }
}
