/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package embidaka.smart.stores.service;

import com.google.gson.Gson;
import embidaka.smart.stores.dto.BaseDto;
import embidaka.smart.stores.metier.ClientMetier;
import embidaka.smart.stores.metier.PanierMetier;
import embidaka.smart.stores.models.Client;
import embidaka.smart.stores.models.ProduitPanier;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author hjhonata
 */
@Path("/paniers")
public class PanierService {
    @POST
    @Path("/creerpanier")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response creerPanier(String p) {
        Gson gson = new Gson();
        BaseDto result = new BaseDto();
        result.setData(null);
        Client client = gson.fromJson(p, Client.class);
        try
        {
            PanierMetier.creerPanier(client.getIdClient());
            result.setStatusAsSuccess();
        } catch(Exception exc) {
            result.setStatusAsError();
            result.setStatus(401);
            result.setMessage(exc.getMessage());
            result.setDescriptionMessage(exc.getMessage());
        }
        String jsonInString = gson.toJson(result);
        return Response.status(200).entity(jsonInString).build();
    }
    
    @POST
    @Path("/ajoutpanier")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response ajoutPanier(String p) {
        Gson gson = new Gson();
        BaseDto result = new BaseDto();
        result.setData(null);
        Client client = gson.fromJson(p, Client.class);
        ProduitPanier pp = gson.fromJson(p, ProduitPanier.class);
        try
        {
            PanierMetier.ajouterPanier(client.getIdClient(), pp.getIdProduit(), pp.getQuantite());
            result.setStatusAsSuccess();
        } catch(Exception exc) {
            result.setStatusAsError();
            result.setStatus(401);
            result.setMessage(exc.getMessage());
            result.setDescriptionMessage(exc.getMessage());
        }
        String jsonInString = gson.toJson(result);
        return Response.status(200).entity(jsonInString).build();
    }
}
