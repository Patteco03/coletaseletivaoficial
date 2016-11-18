package br.com.coleta.dao;

import java.util.List;
import org.junit.Ignore;
import org.junit.Test;
import br.com.coleta.domain.Condominio;



public class CondominioDAOTest {

		@Test 
		@Ignore
		public void salvar(){
			Condominio condominio = new Condominio();
			condominio.setNome("Acacias");
			
			CondominioDAO condominioDAO = new CondominioDAO();
			condominioDAO.salvar(condominio);
		}
		
		@Test
		@Ignore
		public void listar() {
			CondominioDAO condominioDAO = new CondominioDAO ();

			List<Condominio> resultado = condominioDAO.listar(); 

			for (Condominio condominio : resultado) {
				System.out.println(+condominio.getCodigo() + " - " + condominio.getNome());
			}
		}
		
		@Test
		@Ignore
		public void buscar(){
			Long  codigo = 1L;
			
			CondominioDAO condominioDAO = new CondominioDAO();
			Condominio condominio = condominioDAO.buscar(codigo);
			
			if(condominio == null){
				System.out.println("Nenhum registro encontrado");
			}else{
				System.out.println("Registro encontrado");
				System.out.println(+condominio.getCodigo() + " - " + condominio.getNome());
			}		
		}
		
		@Test
		@Ignore
		public void excluir(){
			Long  codigo = 4L;
			
			CondominioDAO condominioDAO = new CondominioDAO();
			Condominio condominio = condominioDAO.buscar(codigo);
			
			if(condominio == null){
				System.out.println("Nenhum registro encontrado");
			}else{
				condominioDAO.excluir(condominio);
				System.out.println("Registro removido");
				System.out.println(+condominio.getCodigo() + " - " + condominio.getNome());
			}	
			
		}
		
		@Test
		public void Editar(){
			Long  codigo = 1L;
			
			CondominioDAO condominioDAO = new CondominioDAO();
			Condominio condominio = condominioDAO.buscar(codigo);
			
			if(condominio == null){
				System.out.println("Nenhum registro encontrado");
			}else{
				System.out.println("Registro editado - Antes: ");
				System.out.println(+condominio.getCodigo() + " - " + condominio.getNome());
				
				
				condominio.setNome("Pernambuco");
				condominioDAO.editar(condominio);
				
				System.out.println("Registro editado - Depois: ");
				System.out.println(+condominio.getCodigo() + " - " + condominio.getNome());
			}	
			
				
		}
		
		
}
