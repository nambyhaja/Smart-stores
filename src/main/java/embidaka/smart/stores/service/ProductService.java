/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package embidaka.smart.stores.service;

import com.google.gson.Gson;
import embidaka.smart.stores.models.Categorie;
import embidaka.smart.stores.models.Livreur;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
 

@Path("/produits")
public class ProductService {
 
	@GET
        @Produces({"application/json"})
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String msg) {
                
                
                Livreur  lv = new Livreur();
            lv.setIdLivreur(1);
            lv.setNom("anarana");
            lv.setPrenom("8787");
            lv.setLogin("login");
            lv.setMotDePasse("mdp");
            lv.categorie = new Categorie();
            lv.categorie.setDesignation("zefzefzefzef");
            lv.categorie.setIdCategorie(1);
            Gson gson = new Gson();
            String jsonInString = gson.toJson(lv);
		return Response.status(200).entity(jsonInString).build();
 
	}
        
        @GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String msg) {
                
                
                Livreur  lv = new Livreur();
            lv.setIdLivreur(1);
            lv.setNom("anarana");
            lv.setPrenom("8787");
            lv.setLogin("login");
            lv.setMotDePasse("mdp");
            lv.categorie = new Categorie();
            lv.categorie.setDesignation("zefzefzefzef");
            lv.categorie.setIdCategorie(1);
            Gson gson = new Gson();
            String jsonInString = gson.toJson(lv);
		return Response.status(200).entity(jsonInString).build();
 
	}
 
}
