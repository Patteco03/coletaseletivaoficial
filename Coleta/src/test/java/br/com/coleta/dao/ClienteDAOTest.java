package br.com.coleta.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.coleta.domain.Cliente;
import br.com.coleta.domain.Condominio;
import br.com.coleta.domain.Pessoa;

public class ClienteDAOTest {

	@Test
	public void salvar() {

		Long codigo = 1L;
		Long codigoCondominio = 1L;

		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(codigo);

		CondominioDAO condominioDAO = new CondominioDAO();
		Condominio condominio = condominioDAO.buscar(codigoCondominio);

		Cliente cliente = new Cliente();
		cliente.setLiberado(new Boolean(true));
		cliente.setPessoa(pessoa);
		cliente.setCondominio(condominio);

		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.salvar(cliente);

	}
	
	@Test
	@Ignore
	public void listar() {

		ClienteDAO clienteDAO = new ClienteDAO();
		List<Cliente> resultado = clienteDAO.listar();

		for (Cliente cliente : resultado) {
			
			System.out.println("Lista de Cliente ");
			System.out.println("Codigo : " + cliente.getCodigo());
			System.out.println("Nome: " + cliente.getPessoa().getNome());
			System.out.println("Ativo/Inativo " + cliente.getLiberado());
			System.out.println("Condominio " + cliente.getCondominio().getNome());
			
		}
		
	}
	
	@Test
	@Ignore
	public void buscar(){
		
		Long codigo = 2L;
		
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.buscar(codigo);
		
		System.out.println("Codigo : " + cliente.getCodigo());
		System.out.println("Nome: " + cliente.getPessoa().getNome());
		System.out.println("Ativo/Inativo " + cliente.getLiberado());
		System.out.println("Condominio " + cliente.getCondominio().getNome());
		
	}
	
	@Test
	@Ignore
	public void editar(){
		
		Long codigo = 3L;
		Long codigoCondominio = 3L;
		Long codigoCliente = 1L;

		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(codigo);
		
		System.out.println("------Dados do cliente------- ");
		System.out.println("Codigo: " + pessoa.getCodigo());
		System.out.println("Nome: " + pessoa.getNome());
		System.out.println("CPF/CPNJ: " + pessoa.getCpf());
		System.out.println("Email: " + pessoa.getEmail());
		
		
		CondominioDAO condominioDAO = new CondominioDAO();
		Condominio condominio = condominioDAO.buscar(codigoCondominio);
		
		System.out.println("------Dados do Condominio---------");
		System.out.println("Nome: " + condominio.getNome());
		
		
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.buscar(codigoCliente);
		
		System.out.println("Dados do cliente a ser Editado");
		System.out.println("Codigo : " + cliente.getCodigo());
		System.out.println("Nome: " + cliente.getPessoa().getNome());
		System.out.println("Ativo/Inativo " + cliente.getLiberado());
		System.out.println("Condominio " + cliente.getCondominio().getNome());
		
		cliente.setLiberado(new Boolean(false));
		cliente.setCondominio(condominio);
		cliente.setPessoa(pessoa);
		
		
		clienteDAO.editar(cliente);
		System.out.println("Cliente Editado");
		
		
	}
	
	@Test
	@Ignore
	public void excluir (){
		
		Long codigo = 1L;
		
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.buscar(codigo);
		
		clienteDAO.excluir(cliente);
		
		System.out.println("Dados do cliente a ser Editado");
		System.out.println("Codigo : " + cliente.getCodigo());
		System.out.println("Nome: " + cliente.getPessoa().getNome());
		System.out.println("Ativo/Inativo " + cliente.getLiberado());
		System.out.println("Condominio " + cliente.getCondominio().getNome());
		
		
	}

}
