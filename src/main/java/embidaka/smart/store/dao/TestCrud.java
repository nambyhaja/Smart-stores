/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package embidaka.smart.store.dao;

import embidaka.smart.stores.database.UtilDB;
import embidaka.smart.stores.models.BC;
import embidaka.smart.stores.models.Client;
import java.sql.Connection;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author aramanam
 */
public class TestCrud {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        GeneriqueDao gd = new GeneriqueDao();
        //Client c = new Client("nom", "prenom", "login", "motdepasse");
        List<BaseModel> c = gd.findAll(Client.getClient());
        for (BaseModel c1 : c) {
            System.out.println("c = " + c.get(0).getId());
        }
    }
    
}
