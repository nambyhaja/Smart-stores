/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package embidaka.smart.stores.models;

import embidaka.smart.store.dao.BaseModel;
import embidaka.smart.stores.service.UtilServices;

/**
 *
 * @author aramanam
 */
public final class Client extends BaseModel {

    private String nom;
    private String prenom;
    private String login;
    private String motDePasse;
    
    //AZA IASANA SAINA FA ILAY ID AO @ BASE MODEL IHANY NO IZY
    private int idClient = -1;

    public Client() {
    }

    public Client(String nom, String prenom, String login, String motDePasse) throws Exception {

        this.setNom(nom);
        this.setPrenom(prenom);
        this.setLogin(login);
        this.setMotDePasse(motDePasse);
    }
    public Client(int idClient, String nom, String prenom, String login, String motDePasse) throws Exception {
        
        super.setId(idClient);
        this.setNom(nom);
        this.setPrenom(prenom);
        this.setLogin(login);
        this.setMotDePasse(motDePasse);
    }
    
    

    public int getIdClient() {
        if(this.idClient > 0) return this.idClient;
        return super.getId();
    }

    public void setIdClient(int idClient) {
        super.setId(idClient);
        this.idClient = idClient;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) throws Exception {
        
        if(!nom.isEmpty() && nom != null){
            this.nom = nom;
        }else{
            throw new Exception("Erreur : Le nom ne doit pas être vide ");
        }
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) throws Exception {
        if(!prenom.isEmpty() && prenom != null){
            this.prenom = prenom;
        }else{
            throw new Exception("Erreur : Le prénom ne doit pas être vide ");
        }
        
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) throws Exception {
        if(!login.isEmpty() && login != null){
            this.login = login;
        }else{
            throw new Exception("Erreur : login null ou vide ");
        }
        
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) throws Exception {
        if(!motDePasse.isEmpty()){
            this.motDePasse = motDePasse;
        }else{
            throw new Exception("Erreur : Mot de passe null ou vide  ...");
        }
        
    }

    public static Client getClient() {
        return new Client();
    }

}
