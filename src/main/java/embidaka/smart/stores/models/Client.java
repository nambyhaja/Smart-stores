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
public final class Client extends BaseModel {

    private String nom;
    private String prenom;
    private String login;
    private String motDePasse;

    public Client() {
    }

    public Client(String nom, String prenom, String login, String motDePasse) {

        this.setNom(nom);
        this.setPrenom(prenom);
        this.setLogin(login);
        this.setMotDePasse(motDePasse);
    }
    public Client(int idClient, String nom, String prenom, String login, String motDePasse) {
        
        super.setId(idClient);
        this.setNom(nom);
        this.setPrenom(prenom);
        this.setLogin(login);
        this.setMotDePasse(motDePasse);
    }

    public int getIdClient() {
        return super.getId();
    }

    public void setIdClient(int idClient) {
        super.setId(idClient);
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

    public static Client getClient() {
        return new Client();
    }

}
