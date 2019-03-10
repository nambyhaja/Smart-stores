/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package embidaka.smart.stores.models;

import embidaka.smart.store.dao.BaseModel;
import java.sql.Date;

/**
 *
 * @author aramanam
 */
public final class Prix extends BaseModel{
    
    private int idProduit;
    private double prixUnitaire;
    private Date datePrix;

    private Prix() {
    }

    public Prix(int idProduit, double prixUnitaire, Date datePrix) {
    
        this.setIdProduit(idProduit); 
        this.setPrixUnitaire(prixUnitaire); 
        this.setDatePrix(datePrix);
    }
    
    public Prix(int idPrix, int idProduit, double prixUnitaire, Date datePrix) {
        
        super.setId(idPrix);
        this.setIdProduit(idProduit); 
        this.setPrixUnitaire(prixUnitaire); 
        this.setDatePrix(datePrix);
    }

    public int getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public Date getDatePrix() {
        return datePrix;
    }

    public void setDatePrix(Date datePrix) {
        this.datePrix = datePrix;
    }
    
    public static Prix getPrix(){
        return new Prix();
    }
    
}
