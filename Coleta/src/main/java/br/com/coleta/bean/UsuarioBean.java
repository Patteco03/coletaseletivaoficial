package br.com.coleta.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.coleta.dao.PessoaDAO;
import br.com.coleta.dao.UsuarioDAO;
import br.com.coleta.domain.Pessoa;
import br.com.coleta.domain.Usuario;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class UsuarioBean implements Serializable {

	private Pessoa pessoa;
	private Usuario usuario;
	private List<Pessoa> pessoas;
	private List<Usuario> usuarios;

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	@PostConstruct
	public void listar() {

		try {

			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarios = usuarioDAO.listar();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar Listar!");
			erro.printStackTrace();
		}

	}

	public void novo() {

		try {

			usuario = new Usuario();

			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoas = pessoaDAO.listar();

		} catch (RuntimeException erro) {

			Messages.addFlashGlobalError("Erro ao gerar um novo Usuário");
			erro.printStackTrace();

		}
	}

	public void salvar() {
		try {

			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarioDAO.merge(usuario);

			usuarios = usuarioDAO.listar();

			novo();

			pessoa = new Pessoa();

			Messages.addGlobalInfo("Usuário salvo com sucesso");
		} catch (

		RuntimeException erro) {

			Messages.addFlashGlobalError("Erro ao salvar Usuário");
			erro.printStackTrace();

		}

	}

	public void excluir(ActionEvent evento) {

		try {
			
			usuario = (Usuario) evento.getComponent().getAttributes().get("usuarioSelecionado");
			
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarioDAO.excluir(usuario);
			
			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoas = pessoaDAO.listar();
			
			usuarios = usuarioDAO.listar();
				
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar exluir!");
			erro.printStackTrace();
		}

	}
	
	public void editar(ActionEvent evento) {

		try {
			
			usuario = (Usuario) evento.getComponent().getAttributes().get("usuarioSelecionado");
			
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarioDAO.editar(usuario);
			
			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoas = pessoaDAO.listar();
			
			usuarios = usuarioDAO.listar();
				
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar editar!");
			erro.printStackTrace();
		}

	}

}
