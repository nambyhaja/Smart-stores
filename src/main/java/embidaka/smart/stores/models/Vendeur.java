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
public final class Vendeur extends BaseModel{
    private int idVendeur;
    private String nom;
    private String prenom;
    private String login;
    private String motDePasse;

    public Vendeur() {
    }

    public Vendeur(String nom, String prenon, String login, String motDePasse) {
        this.setNom(nom); 
        this.setPrenom(prenon); 
        this.setLogin(login); 
        this.setMotDePasse(motDePasse);
    }
    
    public Vendeur(int idVendeur, String nom, String prenon, String login, String motDePasse) {
        this.setIdVendeur(idVendeur);
        this.setNom(nom); 
        this.setPrenom(prenon); 
        this.setLogin(login); 
        this.setMotDePasse(motDePasse);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getIdVendeur() {
        if(this.idVendeur > 0 ) return this.idVendeur;
        return super.getId();
    }

    public void setIdVendeur(int idVendeur) {
        this.idVendeur = idVendeur;
        super.setId(idVendeur);
    }
    
    
    
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }
    
    public static Vendeur getVendeur(){
        return new Vendeur();
    }
}
