/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package embidaka.smart.stores.service;

import com.google.gson.Gson;
import embidaka.smart.stores.models.Livreur;
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
    @GET
    @Produces({"application/json"})
    @Path("/{param}")
    public Response getMsg(@PathParam("param") String msg) 
    {
            Livreur  lv = new Livreur("nom", "prenom", "login", "mdp");
        Gson gson = new Gson();
        String jsonInString = gson.toJson(lv);
            return Response.status(200).entity(jsonInString).build();

    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Path("/inscription")
    public Response inscription(Livreur livreur) 
    {
        Gson gson = new Gson();
        String jsonInString = gson.toJson(livreur);
        return Response.status(200).entity(jsonInString).build();
    }
}
