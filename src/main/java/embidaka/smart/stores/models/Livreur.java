/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package embidaka.smart.stores.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import embidaka.smart.store.dao.BaseModel;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author nambi
 */
public final class Livreur extends BaseModel{
    
    private int idLLivreur;
    private String nom;
    private String prenom;
    private String login;
    private String motDePasse;

    private Livreur() {
    }

    public Livreur(String nom, String prenom, String login, String motDePasse) {
      
        this.setNom(nom); 
        this.setPrenom(prenom);
        this.setLogin(login);
        this.setMotDePasse(motDePasse); 
    }
    
    public Livreur(int idLivreur, String nom, String prenom, String login, String motDePasse) {
        super.setId(idLivreur);
        this.setNom(nom); 
        this.setPrenom(prenom);
        this.setLogin(login);
        this.setMotDePasse(motDePasse); 
    }

    public int getIdLLivreur() {
        if(this.idLLivreur > 0) return this.idLLivreur;
        return super.getId();
    }

    public void setIdLLivreur(int idLLivreur) {
        this.idLLivreur = idLLivreur;
        super.setId(idLLivreur);
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
    
    public static Livreur getLivreur(){
        return new Livreur();
    }

      
}
