/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package embidaka.smart.stores.models;

import embidaka.smart.store.dao.BaseModel;

/**
 *
 * @author aramanam
 */
public final class Panier extends BaseModel {

    private int idClient;

    private Panier() {
    }

    public Panier(int idClient) {
        this.idClient = idClient;
    }
    
    public Panier(int idPanier, int idClient) {
        super.setId(idPanier);
        this.setIdClient(idClient);
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }
    
    public static Panier getPanier(){
        return new Panier();
    }
}
