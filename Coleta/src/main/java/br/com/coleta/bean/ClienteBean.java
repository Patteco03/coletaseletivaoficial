package br.com.coleta.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.coleta.dao.ClienteDAO;
import br.com.coleta.dao.PessoaDAO;
import br.com.coleta.domain.Cliente;
import br.com.coleta.domain.Condominio;
import br.com.coleta.domain.Pessoa;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ClienteBean implements Serializable {

	private List<Cliente> clientes;
	private List<Pessoa> pessoas;
	private List<Condominio> condominios;

	private Cliente cliente;
	
	

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public List<Condominio> getCondominios() {
		return condominios;
	}

	public void setCondominios(List<Condominio> condominios) {
		this.condominios = condominios;
	}

	
	@PostConstruct
	public void listar() {

		try {

			ClienteDAO clientaDAO = new ClienteDAO();
			clientes = clientaDAO.listar();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar Listar!");
			erro.printStackTrace();
		}

	}

	public void novo() {

		try {
			cliente = new Cliente();
			
			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoas = pessoaDAO.listar();
			
			condominios = new ArrayList<Condominio>();
			
			

		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao gerar Cliente");
			erro.printStackTrace();
		}

	}

	
	public void editar(ActionEvent evento) {

	}

	public void salvar() {

	}

	public void excluir() {

	}

}
