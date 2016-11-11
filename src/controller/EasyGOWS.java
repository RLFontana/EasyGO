package controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import dal.dao.ClienteDao;
import model.Cliente;

@Path("/")
public class EasyGOWS {
	
	@GET
	@Path("/")
	public Response index(){
		return Response.status(Response.Status.OK).entity("<h1>ok</h1>").build();
	}
	
	@GET
	@Path("/teste")
	public Response teste(){
		String body = "";
		List<Cliente> clientes = new ArrayList<Cliente>();
		ClienteDao clienteDao = new ClienteDao();
		clientes = clienteDao.getClientes();
		for(Cliente cliente : clientes){
			body += "<p>" + cliente.getNome() + "</p>";
		}
		return Response.status(Response.Status.OK).entity(body).build();
	}

}
