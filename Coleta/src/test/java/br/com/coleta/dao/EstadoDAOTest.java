package br.com.coleta.dao;


import java.util.List;
import org.junit.Ignore;
import org.junit.Test;
import br.com.coleta.domain.Estado;

public class EstadoDAOTest {

	@Test
	public void salvar() {
		Estado estado = new Estado();
		estado.setNome("Acre");
		estado.setSigla("Ac");

		EstadoDAO estadoDAO = new EstadoDAO();
		estadoDAO.salvar(estado);
	}

	@Test
	@Ignore
	public void listar() {
		EstadoDAO estadoDAO = new EstadoDAO();

		List<Estado> resultado = estadoDAO.listar();

		for (Estado estado : resultado) {
			System.out.println(estado.getSigla() + " - " + estado.getNome());
		}
	}
	
	@Test
	@Ignore
	public void buscar(){
		Long  codigo = 5L;
		
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo);
		
		if(estado == null){
			System.out.println("Nenhum registro encontrado");
		}else{
			System.out.println("Registro encontrado");
			System.out.println(estado.getSigla() + " - " + estado.getNome());
		}		
	}
	
	@Test
	@Ignore
	public void excluir(){
		Long  codigo = 4L;
		
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo);
		
		if(estado == null){
			System.out.println("Nenhum registro encontrado");
		}else{
			estadoDAO.excluir(estado);
			System.out.println("Registro Removido");
			System.out.println(estado.getSigla() + " - " + estado.getNome());
		}	
		
	}
	
	@Test
	@Ignore
	public void Editar(){
		Long  codigo = 6L;
		
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo);
		
		if(estado == null){
			System.out.println("Nenhum registro encontrado");
		}else{
			System.out.println("Registro editado - Antes: ");
			System.out.println(estado.getSigla() + " - " + estado.getNome());
			
			estado.setNome("Santa Catarina");
			estado.setSigla("SC");
			estadoDAO.editar(estado);
			
			System.out.println("Registro editado - Depois: ");
			System.out.println(estado.getSigla() + " - " + estado.getNome());
		}	
		
			
	}
	
	

}
