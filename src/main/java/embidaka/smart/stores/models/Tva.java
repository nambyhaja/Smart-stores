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
public final class Tva extends BaseModel{

    private int idProduit;
    private Date dateApplication;
    private double taux;

    private Tva() {
    }

    public Tva(int idProduit, Date dateApplication, double taux) {
       
        this.setIdProduit(idProduit);
        this.setDateApplication(dateApplication);
        this.setTaux(taux);
    }
    
    public Tva(int idTva, int idProduit, Date dateApplication, double taux) {
       
        super.setId(idTva);
        this.setIdProduit(idProduit);
        this.setDateApplication(dateApplication);
        this.setTaux(taux);
    }

    public int getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    public Date getDateApplication() {
        return dateApplication;
    }

    public void setDateApplication(Date dateApplication) {
        this.dateApplication = dateApplication;
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }
    
    public static Tva getTva(){
        return new Tva();
    }
}
