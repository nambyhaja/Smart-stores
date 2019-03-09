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
public final class Client extends BaseModel{
    
    private String nom;
    private String prenom;
    private String login;
    private String motDePasse;

    private Client() {
    }

    public Client(String nom, String prenom, String login, String motDePasse) {
       
        this.setNom(nom);
        this.setPrenom(prenom); 
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

    @Override
    public BaseModel getInstance() {
        return new Client();
    }
    public static Client getClient() {
        return new Client();
    }
    
}
