/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package embidaka.smart.stores.service;

import com.google.gson.Gson;
import embidaka.smart.stores.models.Client;
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

@Path("/clients")
public class ClientService {
    //Example POST
    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response post(String p) {
        Gson gson = new Gson();
        String jsonInString = "";
        
        Client client = gson.fromJson(p, Client.class);
        if(client != null && client.getLogin().equals("admin") && client.getMotDePasse().equals("admin"))
        {
            client.setStatusAsSuccess();
            jsonInString = gson.toJson(client);
        }
        else
        {
            client.setStatusAsError();
            client.setStatus(401);
            client.setMessage("Login ou mot de passe invalide");
            client.setDescription("Login ou mot de passe invalide");
            jsonInString = gson.toJson(client);
        }
        
        return Response.status(200).entity(jsonInString).build();
    }
}
