package br.com.coleta.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.coleta.domain.Pessoa;
import br.com.coleta.domain.Usuario;

public class UsuarioDAOTest {

	@Test
	@Ignore
	public void salvar() {

		Long codigo = 2L;

		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(codigo);

		Usuario usuario = new Usuario();
		usuario.setSenha("55142");
		usuario.setTipo(new Character('A'));
		usuario.setAtivo(new Boolean(false));
		usuario.setPessoa(pessoa);

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.salvar(usuario);

	}

	@Test
	@Ignore
	public void buscar() {

		Long codigo = 1L;

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscar(codigo);

		System.out.println("Login: " + usuario.getPessoa().getEmail());
		System.out.println("Senha: " + usuario.getSenha());
		System.out.println("Tipo: " + usuario.getTipo());
		System.out.println("Ativo/Inativo: " + usuario.getAtivo());

	}
	
	@Test
	@Ignore
	public void listar(){
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		List<Usuario> resultado = usuarioDAO.listar();
		
		for(Usuario usuario : resultado){
			System.out.println("------------USUARIO----------------------");
			System.out.println("Login: " + usuario.getPessoa().getEmail());
			System.out.println("Senha: " + usuario.getSenha());
			System.out.println("Tipo: " + usuario.getTipo());
			System.out.println("Ativo/Inativo: " + usuario.getAtivo());
			System.out.println("------------------------------------------");
		}
		
	}
	
	@Test
	@Ignore
	public void excluir(){
		Long codigo = 1L;
		
		UsuarioDAO usuariDAO = new UsuarioDAO();
		Usuario usuario = usuariDAO.buscar(codigo);
		
		usuariDAO.excluir(usuario);
		
		System.out.println("Usuario Removido");
		System.out.println("------------USUARIO----------------------");
		System.out.println("Login: " + usuario.getPessoa().getEmail());
		System.out.println("Senha: " + usuario.getSenha());
		System.out.println("Tipo: " + usuario.getTipo());
		System.out.println("Ativo/Inativo: " + usuario.getAtivo());
		System.out.println("------------------------------------------");
		
		
	}
	
	@Test
	public void editar(){
		
		Long codigoPessoa = 2L;
		Long codigoUsuario = 2L;
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(codigoPessoa);
		
		System.out.println("Cadastro Principal");
		System.out.println("----------Dados Pessoais-------- ");
		System.out.println("Codigo: " + pessoa.getCodigo());
		System.out.println("Nome: " + pessoa.getNome());
		System.out.println("CPF/CPNJ: " + pessoa.getCpf_cnpj());
		System.out.println("Email: " + pessoa.getEmail());
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscar(codigoUsuario);
		
		System.out.println("Cadastro a ser Editado");
		System.out.println("------------USUARIO----------------------");
		System.out.println("Login: " + usuario.getPessoa().getEmail());
		System.out.println("Senha: " + usuario.getSenha());
		System.out.println("Tipo: " + usuario.getTipo());
		System.out.println("Ativo/Inativo: " + usuario.getAtivo());
		System.out.println("------------------------------------------");
		
		usuario.setSenha("92145181");
		usuario.setPessoa(pessoa);
		
		usuarioDAO.editar(usuario);
		System.out.println("Cadastro Editado");
		System.out.println("------------USUARIO----------------------");
		System.out.println("Login: " + usuario.getPessoa().getEmail());
		System.out.println("Senha: " + usuario.getSenha());
		System.out.println("Tipo: " + usuario.getTipo());
		System.out.println("Ativo/Inativo: " + usuario.getAtivo());
		System.out.println("------------------------------------------");
		
	}
	
	

}
