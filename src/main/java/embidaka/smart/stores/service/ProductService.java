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
    @Path("/uid/{param}")
    public Response getInfoProductByUID(@PathParam("param") String uid) 
    {
        BaseDto dtoResult = new BaseDto();
        dtoResult.setData(null);
        
        try 
        {
            Produit produit = ProduitMetier.infoProduitByUid(uid);
            if(produit != null)
            {
                dtoResult.setStatusAsSuccess();
                dtoResult.setData(produit);
            }
            else
            {
                dtoResult.setStatusAsError();
                dtoResult.setStatus(200);
                dtoResult.setMessage("Produit introuvable");
                dtoResult.setDescriptionMessage("Produit introuvable");
            }
        } catch (Exception exc) {
            dtoResult.setStatusAsError();
            dtoResult.setStatus(401);
            dtoResult.setMessage(exc.getMessage());
            dtoResult.setDescriptionMessage(exc.getMessage());
        }
        Gson gson = new Gson();
        String jsonInString = gson.toJson(dtoResult);
            return Response.status(200).entity(jsonInString).build();
    }
    
    @GET
    @Produces({"application/json"})
    @Path("/id/{param}")
    public Response getInfoProductById(@PathParam("param") String id) 
    {
        BaseDto dtoResult = new BaseDto();
        dtoResult.setData(null);
        
        try 
        {
            Produit produit = ProduitMetier.infoProduitById(Integer.parseInt(id));
            if(produit != null)
            {
                dtoResult.setStatusAsSuccess();
                dtoResult.setData(produit);
            }
            else
            {
                dtoResult.setStatusAsError();
                dtoResult.setStatus(200);
                dtoResult.setMessage("Produit introuvable");
                dtoResult.setDescriptionMessage("Produit introuvable");
            }
        } catch (Exception exc) {
            dtoResult.setStatusAsError();
            dtoResult.setStatus(401);
            dtoResult.setMessage(exc.getMessage());
            dtoResult.setDescriptionMessage(exc.getMessage());
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
        dtoResult.setStatusAsSuccess();
        dtoResult.setData(listProduit);
       
        Gson gson = new Gson();
        String jsonInString = gson.toJson(dtoResult);
            return Response.status(200).entity(jsonInString).build();

    }
    
}
