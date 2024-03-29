    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package embidaka.smart.stores.models;

import embidaka.smart.store.dao.BaseModel;
import embidaka.smart.store.dao.GeneriqueDao;
import java.math.BigDecimal;

/**
 *
 * @author nambi
 */
public final class Produit extends BaseModel {
    
    private Categorie categorie;
 
    private int idCategorie;
    private String code;
    private String designation;
    private String description;
    private String uid;
    private String photo;
    private double prix;
    private double tva;
    
    private int idProduit = -1;

    private Produit() {
    }

    public Produit(int idCategorie, String code, String designation, String description, String uid, String photo, double prix, double tva) throws Exception {
     
        this.setIdCategorie(idCategorie);
        this.setCode(code);
        this.setDesignation(designation); 
        this.setDescription(description);
        this.setUid(uid); 
        this.setPhoto(photo);
        this.setPrix(prix);
        this.setTva(tva);
    }
    
    public Produit(int idProduit, int idCategorie, String code, String designation, String description, String uid, String photo, double prix, double tva) throws Exception {
     
        this.setIdProduit(idProduit);
        this.setIdCategorie(idCategorie);
        this.setCode(code);
        this.setDesignation(designation); 
        this.setDescription(description);
        this.setUid(uid); 
        this.setPhoto(photo);
        this.setPrix(prix);
        this.setTva(tva);
    }
    
    public Produit(int idProduit, int idCategorie, String code, String designation, String description, String uid, String photo, BigDecimal prix, BigDecimal tva) throws Exception {
     
        this.setIdProduit(idProduit);
        this.setIdCategorie(idCategorie);
        this.setCode(code);
        this.setDesignation(designation); 
        this.setDescription(description);
        this.setUid(uid); 
        this.setPhoto(photo);
        this.setPrix(prix.doubleValue());
        this.setTva(tva.doubleValue());
    }

    public int getidCategorie() {
        return idCategorie;
    }
    public int getIdProduit() {
        if(this.idProduit > 0) {
            return this.idProduit;
        }
        return super.getId();
    }

    public void setIdProduit(int idProduit) {
        super.setId(idProduit);
        this.idProduit = idProduit;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIdCategorie(int idCategorie) throws Exception {
        
        this.idCategorie = idCategorie;
        this.categorie =(Categorie) new GeneriqueDao().findId(idCategorie, Categorie.getCategorie());
        if(categorie == null)
        {
            throw new Exception("La categorie associée avec ce Produit n'existe pas");
        }
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public double getTva() {
        return tva;
    }

    public void setTva(double tva) {
        this.tva = tva;
    }
    
    public static Produit getProduit(){
        return new Produit();
    }

}
