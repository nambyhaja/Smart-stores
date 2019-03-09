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
public final class StatusLivraison extends BaseModel {

    private int idbl;
    private boolean status;
    private Date dateStatus;
    private String motif;

    private StatusLivraison() {
    }

    public StatusLivraison(int idbl, boolean status, Date dateStatus, String motif) {
       
        this.setIdbl(idbl);
        this.setStatus(status);
        this.setDateStatus(dateStatus);
        this.setMotif(motif);
    }

    public int getIdbl() {
        return idbl;
    }

    public void setIdbl(int idbl) {
        this.idbl = idbl;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getDateStatus() {
        return dateStatus;
    }

    public void setDateStatus(Date dateStatus) {
        this.dateStatus = dateStatus;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    @Override
    public BaseModel getInstance() {
        return new StatusLivraison();
    }
    
    

}
