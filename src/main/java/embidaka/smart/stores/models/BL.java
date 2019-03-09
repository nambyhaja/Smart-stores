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
public final class BL extends BaseModel{

    private int idLivreur;
    private int idFacture;
    private Date dateDebut;
    private Date dateFin;

    private BL() {
    }

    public BL(int idLivreur, int idFacture, Date dateDebut, Date dateFin) {
      
        this.setIdLivreur(idLivreur);
        this.setIdFacture(idFacture);
        this.setDateDebut(dateDebut);
        this.setDateFin(dateFin);
    }

    public int getIdLivreur() {
        return idLivreur;
    }

    public void setIdLivreur(int idLivreur) {
        this.idLivreur = idLivreur;
    }

    public int getIdFacture() {
        return idFacture;
    }

    public void setIdFacture(int idFacture) {
        this.idFacture = idFacture;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    @Override
    public BaseModel getInstance() {
        return new BL();
    }
    
    
}
