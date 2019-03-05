/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package embidaka.smart.stores.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
 
@Path("/produit")
public class ProductService {
 
	@GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String msg) {
                
		String output = "Product : " + msg;
		return Response.status(200).entity(output).build();
 
	}
 
}
