package br.com.coleta.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.google.gson.Gson;

import br.com.coleta.dao.EstadoDAO;
import br.com.coleta.domain.Estado;

@Path("estado")
public class EstadoService {
	
	@GET
	public String listar(){
		
	 EstadoDAO estadoDAO = new EstadoDAO();
	 List<Estado> estados = estadoDAO.listar("nome");
		
	 Gson gson = new Gson();
	 String json = gson.toJson(estados);
	 
	return json;
	 
	}
	
	@GET
	@Path("{codigo}")
	public String buscar(@PathParam("codigo") Long codigo){
		
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo);	
		
		Gson gson = new Gson();
		 String json = gson.toJson(estado);
		 
		return json;
		
	}

}
