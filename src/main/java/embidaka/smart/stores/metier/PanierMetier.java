/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package embidaka.smart.stores.metier;

import embidaka.smart.store.dao.BaseModel;
import embidaka.smart.store.dao.GeneriqueDao;
import embidaka.smart.stores.models.Client;
import embidaka.smart.stores.models.Panier;
import java.util.List;

/**
 *
 * @author hjhonata
 */
public class PanierMetier {
    public static void creerPanier(int idClient) throws Exception
    {
        Client client = (Client) new GeneriqueDao().findId(idClient, Client.getClient());
        if(client != null)
        {
            List<BaseModel> listPanier = new GeneriqueDao().findByString(Panier.class, " idclient = " + idClient);
            if(listPanier == null || listPanier.isEmpty())
            {
                Panier p = new Panier(idClient);
                new GeneriqueDao().save(p);
            }
        }
        else{
            throw new Exception("Client inexistant");
        }
    }
}
