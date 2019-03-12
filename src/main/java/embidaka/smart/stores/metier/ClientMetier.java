/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package embidaka.smart.stores.metier;

import embidaka.smart.store.dao.BaseModel;
import embidaka.smart.store.dao.GeneriqueDao;
import embidaka.smart.stores.models.Client;
import embidaka.smart.stores.service.UtilServices;
import java.util.ArrayList;

/**
 *
 * @author hjhonata
 */
public class ClientMetier 
{
    public static Client login(String login, String motDePasse) throws Exception
    {
        Client result = null;
        ArrayList<BaseModel> val =  new GeneriqueDao().findByString(Client.class, " login = '" + login + "' AND motdepasse = '" +  motDePasse +"'");
        if(val!=null && val.size()>0)
        {
            result = (Client) val.get(0);
        }
        else
        {
            throw new Exception("Login et mot de passe invalide");
        }
        return result;
    }
}
