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
public final class DetailCommande extends BaseModel{

    private int idBc;
    private int nombre;

    private DetailCommande() {
    }

    public DetailCommande(int idBc, int nombre) {
      
        this.setIdBc(idBc);
        this.setNombre(nombre);
    }

    public int getIdBc() {
        return idBc;
    }

    public void setIdBc(int idBc) {
        this.idBc = idBc;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    @Override
    public BaseModel getInstance() {
        return new DetailCommande();
    }
    
    
}
