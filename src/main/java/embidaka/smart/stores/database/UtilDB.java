/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package embidaka.smart.stores.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 *
 * @author nambi
 */
public final class UtilDB 
{
    private UtilDB(){}
    private static Connection connexion;
    
    private static final String DATABASE = "smartstore";
    private static final String URL = "localhost";
    private static final String PORT = "5432";
    private static final String LOGIN = "postgres";
    private static final String PASSWORD = "admin";
    private static final String SSL = "true";
    private static final String SSLFACTORY = "org.postgresql.ssl.NonValidatingFactory";
    
    public static Connection getConnection() throws Exception
    {
        if(UtilDB.connexion == null || UtilDB.connexion.isClosed())
        {
            String url = "jdbc:postgresql://" + UtilDB.URL;
            url+=":" + UtilDB.PORT;
            url+="/" + UtilDB.DATABASE;
            Properties props = new Properties();
            props.setProperty("user",UtilDB.LOGIN);
            props.setProperty("password", UtilDB.PASSWORD);
            props.setProperty("ssl", UtilDB.SSL);
            props.setProperty("sslfactory", UtilDB.SSLFACTORY);
            connexion = DriverManager.getConnection(url, props);
            if(connexion != null)
            {
                connexion.setAutoCommit(false);
            }
        }
        return connexion;
    }
}
