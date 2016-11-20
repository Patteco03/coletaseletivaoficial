package br.com.coleta.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.coleta.dao.CidadeDAO;
import br.com.coleta.dao.EstadoDAO;
import br.com.coleta.dao.PessoaDAO;
import br.com.coleta.domain.Cidade;
import br.com.coleta.domain.Estado;
import br.com.coleta.domain.Pessoa;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class PessoaBean implements Serializable {
	
	private Estado estado;
	private Pessoa pessoa;
	private List<Pessoa> pessoas;
	private List<Cidade> cidades;
	private List<Estado> estados;
	
	
	public Estado getEstado() {
		return estado;
	}
	
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	@PostConstruct
	public void listar() {

		try {

			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoas = pessoaDAO.listar("nome");

		} catch (RuntimeException erro) {

			Messages.addFlashGlobalError("Erro ao tentar listar as pessoas");
			erro.printStackTrace();

		}

	}

	public void novo() {

		try {
			pessoa = new Pessoa();

			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listar();
			
			estado = new Estado();

			cidades = new ArrayList<Cidade>();
		} catch (RuntimeException erro) {

			Messages.addFlashGlobalError("Erro ao gerar uma nova pessoa");
			erro.printStackTrace();

		}

	}

	public void editar(ActionEvent evento) {
		
		try{
			pessoa = (Pessoa) evento.getComponent().getAttributes().get("pessoaSelecionado");
			
			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoaDAO.editar(pessoa);
			
			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listar();
			
			CidadeDAO cidadeDAO = new CidadeDAO();
			cidades = cidadeDAO.listar();
			
			pessoas = pessoaDAO.listar("nome");
			
			Messages.addGlobalInfo("Pessoa editada com sucesso!");
		}catch(RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar editar!");
			erro.printStackTrace();
		}

	}

	public void salvar() {
		try{
			
			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoaDAO.merge(pessoa);
			
			pessoas = pessoaDAO.listar();
			
			novo();
			
			estado = new Estado();
		
		}catch (RuntimeException erro) {

			Messages.addFlashGlobalError("Erro ao salvar pessoa");
			erro.printStackTrace();

		}

	}

	public void excluir(ActionEvent evento) {
		
		try{
			pessoa = (Pessoa) evento.getComponent().getAttributes().get("pessoaSelecionado");
			
			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoaDAO.excluir(pessoa);
			
			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listar();
			
			CidadeDAO cidadeDAO = new CidadeDAO();
			cidades = cidadeDAO.listar();
			
			pessoas = pessoaDAO.listar("nome");
			
		}catch(RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar exluir!");
			erro.printStackTrace();
		}

	}
	
	public void popular(){
		
		try{
		if(estado != null){
			
			CidadeDAO cidadeDAO = new CidadeDAO();
			cidades = cidadeDAO.buscarPorEstado(estado.getCodigo());
			
		}else{
			
			cidades = new ArrayList<>();
			
		}
		
		}catch (RuntimeException erro) {

			Messages.addFlashGlobalError("Erro ao listar Cidade");
			erro.printStackTrace();

		}
		
		
	}

}
