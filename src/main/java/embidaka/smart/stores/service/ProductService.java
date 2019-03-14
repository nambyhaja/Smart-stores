/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package embidaka.smart.stores.service;

import com.google.gson.Gson;
import embidaka.smart.stores.dto.BaseDto;
import embidaka.smart.stores.metier.ProduitMetier;
import embidaka.smart.stores.models.Categorie;
import embidaka.smart.stores.models.Livreur;
import embidaka.smart.stores.models.Produit;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
 

@Path("/produits")
public class ProductService 
{
    /*@GET
    @Produces({"application/json"})
    @Path("/{param}")
    public Response getMsg(@PathParam("param") String msg) 
    {
            Livreur  lv = new Livreur("nom", "prenom", "login", "mdp");
        Gson gson = new Gson();
        String jsonInString = gson.toJson(lv);
            return Response.status(200).entity(jsonInString).build();

    }
    */
    
    @GET
    @Produces({"application/json"})
    @Path("/{param}")
    public Response getInfoProduct(@PathParam("param") String uid) 
    {
        BaseDto dtoResult = new BaseDto();
        dtoResult.setData(null);
        
        List<Produit> listProduit = new ArrayList<>();
        Categorie categ = new Categorie(1, "Categ TEST");
        listProduit.add(new Produit(1, 1, "code1", "produit 1", "descr produit 1", "UID123", "http://img.com/image1.jpg", 2000, 20.2));
        listProduit.add(new Produit(2, 1, "code2", "produit 2", "descr produit 2", "UID456", "http://img.com/image2.jpg", 3000, 20.2));    
        listProduit.add(new Produit(3, 1, "code3", "produit 3", "descr produit 3", "UID789", "http://img.com/image3.jpg", 4000, 20.2));
        
        
        for (Produit produit : listProduit) 
        {
            if(produit.getUid().equals(uid))
            {
                dtoResult.setStatusAsSuccess();
                dtoResult.setData(produit);
                break;
            }
        }
        if(dtoResult.getData() == null)
        {
            dtoResult.setStatusAsError();
            dtoResult.setStatus(200);
            dtoResult.setMessage("Produit introuvable");
            dtoResult.setDescriptionMessage("Produit introuvable");
        }
        
       
        Gson gson = new Gson();
        String jsonInString = gson.toJson(dtoResult);
            return Response.status(200).entity(jsonInString).build();

    }
    
    @GET
    @Produces({"application/json"})
    @Path("/")
    public Response getProducts() 
    {
        BaseDto dtoResult = new BaseDto();
        dtoResult.setData(null);
        
        List<Produit> listProduit = new ArrayList<>();
        try {
            listProduit = ProduitMetier.toutLesProduits();
            dtoResult.setStatusAsSuccess();
        } catch (Exception exc) {
            dtoResult.setStatusAsError();
            dtoResult.setStatus(401);
            dtoResult.setMessage(exc.getMessage());
            dtoResult.setDescriptionMessage(exc.getMessage());
        }
        //Categorie categ = new Categorie(1, "Categ TEST");
        
        
        
        /*listProduit.add(new Produit(1, 1, "code1", "produit 1", "descr produit 1", "UID123", "http://img.com/image1.jpg", 2000, 20.2));
        listProduit.add(new Produit(2, 1, "code2", "produit 2", "descr produit 2", "UID456", "http://img.com/image2.jpg", 3000, 20.2));    
        listProduit.add(new Produit(3, 1, "code3", "produit 3", "descr produit 3", "UID789", "http://img.com/image3.jpg", 4000, 20.2));
        */
        dtoResult.setStatusAsSuccess();
        dtoResult.setData(listProduit);
       
        Gson gson = new Gson();
        String jsonInString = gson.toJson(dtoResult);
            return Response.status(200).entity(jsonInString).build();

    }
    
}
