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
public final class Stock extends BaseModel{

    private int idProduit;
    private int nombre;
    private int seuil;

    private Stock() {
    }

    public Stock(int idProduit, int nombre, int seuil) {
       
        this.setIdProduit(idProduit); 
        this.setNombre(nombre);
        this.setSeuil(seuil);
    }
    
    public Stock(int idStock,int idProduit, int nombre, int seuil) {
       
        super.setId(seuil);
        this.setIdProduit(idProduit); 
        this.setNombre(nombre);
        this.setSeuil(seuil);
    }

    public int getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    public int getSeuil() {
        return seuil;
    }

    public void setSeuil(int seuil) {
        this.seuil = seuil;
    }
    
    public static Stock getStock(){
        return new Stock();
    }

 
}
