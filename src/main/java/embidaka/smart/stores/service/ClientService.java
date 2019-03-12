/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package embidaka.smart.stores.service;

import com.google.gson.Gson;
import embidaka.smart.stores.dto.BaseDto;
import embidaka.smart.stores.metier.ClientMetier;
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
    public Response login(String p) {
        Gson gson = new Gson();
        BaseDto result = new BaseDto();
        result.setData(null);
        Client client = gson.fromJson(p, Client.class);
        try
        {
            if(client != null)
            {
                client = ClientMetier.login(client.getLogin(), client.getMotDePasse());
                result.setStatusAsSuccess();
                result.setData(client);
            }
            else
            {
                result.setStatusAsError();
                result.setStatus(401);
                result.setMessage("Login ou mot de passe invalide");
                result.setDescriptionMessage("Login ou mot de passe invalide");
            }
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
