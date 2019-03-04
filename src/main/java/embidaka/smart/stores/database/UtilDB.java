/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package embidaka.smart.stores.database;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author nambi
 */
public class UtilDB {
    public static Connection getConnection()throws Exception{
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/laravel", "postgres", "namby");    
    }
}
