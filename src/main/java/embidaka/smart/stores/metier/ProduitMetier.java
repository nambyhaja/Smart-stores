/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package embidaka.smart.stores.metier;

import embidaka.smart.store.dao.BaseModel;
import embidaka.smart.store.dao.GeneriqueDao;
import embidaka.smart.stores.models.Client;
import embidaka.smart.stores.models.Produit;
import embidaka.smart.stores.service.UtilServices;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hjhonata
 */
public class ProduitMetier {
    public static List<Produit> toutLesProduits() throws Exception
    {
        List<Produit> result = new ArrayList<>();
        List<BaseModel> val =  new GeneriqueDao().findAll(Produit.getProduit());
        val.forEach((baseModel) -> {
            result.add((Produit)baseModel);
        });
        return result;
    }
}
