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
    
    private static final String DATABASE = "d19jbk3cllkmll";
    private static final String URL = "ec2-46-137-121-216.eu-west-1.compute.amazonaws.com";
    private static final String PORT = "5432";
    private static final String LOGIN = "pfocsurjevcpgi";
    private static final String PASSWORD = "e5a66b990c9b4b8f4a288e82583730a47bfed92631fcf5fc279cb63099481af5";
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
