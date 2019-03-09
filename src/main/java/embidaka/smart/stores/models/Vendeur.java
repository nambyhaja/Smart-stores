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

    private String nom;
    private String prenon;
    private String login;
    private String motDePasse;

    public Vendeur() {
    }

    public Vendeur(String nom, String prenon, String login, String motDePasse) {
        this.setNom(nom); 
        this.setPrenon(prenon); 
        this.setLogin(login); 
        this.setMotDePasse(motDePasse);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenon() {
        return prenon;
    }

    public void setPrenon(String prenon) {
        this.prenon = prenon;
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

    @Override
    public BaseModel getInstance() {
        return new Vendeur();
    }

    
}
