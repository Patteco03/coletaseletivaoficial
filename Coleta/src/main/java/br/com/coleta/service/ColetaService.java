package br.com.coleta.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

//http://localhost:8080/Coleta/rest/coleta
@Path("coleta")
public class ColetaService {
	
	@GET
	public String exibir(){
		return "Curso de Java";
	}

}
