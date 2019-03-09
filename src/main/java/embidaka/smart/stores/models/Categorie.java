/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package embidaka.smart.stores.models;

import embidaka.smart.store.dao.BaseModel;

/**
 *
 * @author nambi
 */
public final class Categorie extends BaseModel {

    
    private String designation;

    private Categorie() {
    }

    public Categorie(String designation) {
        this.setDesignation(designation);
    }


    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public BaseModel getInstance() {
        return new Categorie();
    }

}
