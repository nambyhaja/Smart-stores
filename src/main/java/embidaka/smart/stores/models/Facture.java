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
public final class Facture extends BaseModel {

    private int idBc;
    private double remise;

    private Facture() {
    }

    public Facture(int idBc, double remise) {
        
        this.setIdBc(idBc);
        this.setRemise(remise);
    }
    
    public Facture(int idFacture, int idBc, double remise) {
        
        super.setId(idBc);
        this.setIdBc(idBc);
        this.setRemise(remise);
    }

    public int getIdBc() {
        return idBc;
    }

    public void setIdBc(int idBc) {
        this.idBc = idBc;
    }

    public double getRemise() {
        return remise;
    }

    public void setRemise(double remise) {
        this.remise = remise;
    }
    
    public static Facture getFacture(){
        return new Facture();
    }

}
