/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package embidaka.smart.stores.main;

import embidaka.smart.stores.database.UtilDB;
import java.sql.Connection;

/**
 *
 * @author nambi
 */
public class Main {
    public static void main(String[] args){
        try{
            Connection c = UtilDB.getConnection();
        }catch(Exception ex){
            System.out.println("exception "+ex.getMessage());
        }
    }
}