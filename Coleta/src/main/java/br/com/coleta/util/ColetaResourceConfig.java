package br.com.coleta.util;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

// http://localhost:8080/Coleta/rest
@ApplicationPath("rest")
public class ColetaResourceConfig extends ResourceConfig{
	
	public ColetaResourceConfig(){
		
		packages("br.com.coleta.service");
	}

}
