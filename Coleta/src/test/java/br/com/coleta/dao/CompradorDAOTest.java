package br.com.coleta.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.coleta.domain.Comprador;
import br.com.coleta.domain.Pessoa;

public class CompradorDAOTest {

	@Test
	public void salvar() {

		Long codigo = 4L;

		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(codigo);

		Comprador comprador = new Comprador();

		comprador.setLiberado(new Boolean(true));
		comprador.setPessoa(pessoa);

		CompradorDAO compradorDAO = new CompradorDAO();
		compradorDAO.salvar(comprador);
	}
	
	@Test
	@Ignore
	public void listar(){
			
		CompradorDAO compradorDAO = new CompradorDAO();
		List<Comprador> resultado = compradorDAO.listar();
		
		
		for(Comprador comprador: resultado){
		System.out.println("Codigo: " + comprador.getCodigo());
		System.out.println("Ativo/Inativo: " + comprador.getLiberado());
		System.out.println("Nome: " + comprador.getPessoa().getNome());
		}
		
	}
	
	@Test
	@Ignore
	public void buscar(){
		
		Long condigo = 1L;
		
		CompradorDAO compradorDAO = new CompradorDAO();
		Comprador comprador = compradorDAO.buscar(condigo);
		
		System.out.println("Codigo: " + comprador.getCodigo());
		System.out.println("Ativo/Inativo: " + comprador.getLiberado());
		System.out.println("Nome: " + comprador.getPessoa().getNome());
	}
	
	@Test
	@Ignore
	public void editar(){
		
		Long codigoPessoa  = 4L;
		Long codigoComprador = 1L;
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(codigoPessoa);
		
		System.out.println("Cadastro Principal");
		System.out.println("----------Dados Pessoais-------- ");
		System.out.println("Codigo: " + pessoa.getCodigo());
		System.out.println("Nome: " + pessoa.getNome());
		System.out.println("CPF/CPNJ: " + pessoa.getCpf_cnpj());
		System.out.println("Email: " + pessoa.getEmail());
		
		CompradorDAO compradorDAO = new CompradorDAO();
		Comprador comprador = compradorDAO.buscar(codigoComprador);
		
		System.out.println("Comprador a Ser Editado");
		System.out.println("Codigo: " + comprador.getCodigo());
		System.out.println("Ativo/Inativo: " + comprador.getLiberado());
		System.out.println("Nome: " + comprador.getPessoa().getNome());
		
		comprador.setLiberado(new Boolean(false));
		comprador.setPessoa(pessoa);
		
		compradorDAO.editar(comprador);
		System.out.println("Comprador  Editado");
		System.out.println("Codigo: " + comprador.getCodigo());
		System.out.println("Ativo/Inativo: " + comprador.getLiberado());
		System.out.println("Nome: " + comprador.getPessoa().getNome());
		
	}
	
	
	@Test
	@Ignore
	public void excluir(){
		
		Long codigoComprador = 1L;
		
		CompradorDAO compradorDAO = new CompradorDAO();
		Comprador comprador = compradorDAO.buscar(codigoComprador);
		
		compradorDAO.excluir(comprador);
		System.out.println("Comprador  Excluido");
		System.out.println("Codigo: " + comprador.getCodigo());
		System.out.println("Ativo/Inativo: " + comprador.getLiberado());
		System.out.println("Nome: " + comprador.getPessoa().getNome());
		
		
	}

}
