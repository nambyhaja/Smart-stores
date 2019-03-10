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
public final class BC extends BaseModel {

    private int idClient;
    private Date DateCommande;
    private String uidBc;

    private BC() {
    }

    public BC(int idClient, Date DateCommande, String uidBc) {

        this.setIdClient(idClient);
        this.setDateCommande(DateCommande);
        this.setUidBc(uidBc);
    }
    
    public BC(int id, int idClient, Date DateCommande, String uidBc) {
        
        super.setId(id);
        this.setIdClient(idClient);
        this.setDateCommande(DateCommande);
        this.setUidBc(uidBc);
    }

    public int getIdBc() {
        return super.getId();
    }

    public void setIdBc(int idBc) {
        super.setId(idBc);
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public Date getDateCommande() {
        return DateCommande;
    }

    public void setDateCommande(Date DateCommande) {
        this.DateCommande = DateCommande;
    }

    public String getUidBc() {
        return uidBc;
    }

    public void setUidBc(String uidBc) {
        this.uidBc = uidBc;
    }
    
    public static BC getBc(){
        return new BC();
    }
 
}
