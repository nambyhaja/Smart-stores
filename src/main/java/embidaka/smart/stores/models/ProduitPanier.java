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
public class ProduitPanier extends BaseModel{
           
    private int idPanier;
    private int idProduit;
    private int quantite;
    
    private int idProduitPanier = -1;

    private ProduitPanier() {
    }

    public ProduitPanier(int idPanier, int idProduit, int quantite) {
        this.idPanier = idPanier;
        this.idProduit = idProduit;
        this.quantite = quantite;
    }
    
    public ProduitPanier(int idProduitPanier, int idPanier, int idProduit, int quantite) {
        
        this.setIdProduitPanier(idProduitPanier);
        this.idPanier = idPanier;
        this.idProduit = idProduit;
        this.quantite = quantite;
    }

    public int getIdProduitPanier() {
        if(this.idProduitPanier > 0) return this.idProduitPanier;
        return super.getId();
    }

    public void setIdProduitPanier(int idProduitPanier) {
        super.setId(idProduitPanier);
        this.idProduitPanier = idProduitPanier;
    }
    
    

    public int getIdPanier() {
        return idPanier;
    }

    public void setIdPanier(int idPanier) {
        this.idPanier = idPanier;
    }

    public int getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
    
    public static ProduitPanier getProduitPanier(){
        return new ProduitPanier();
    }
           
           
}
