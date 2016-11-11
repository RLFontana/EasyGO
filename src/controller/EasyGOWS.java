package controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import util.PropertiesManager;

@Path("/")
public class EasyGOWS {
	
	@GET
	@Path("/")
	public Response index(){
		PropertiesManager.setProperties("teste", "teste");
		return Response.status(Response.Status.OK).entity("<h1>ok</h1>").build();
	}

}
