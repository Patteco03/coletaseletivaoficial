package br.com.coleta.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.coleta.dao.EstadoDAO;
import br.com.coleta.domain.Estado;

@SuppressWarnings("serial")
@ManagedBean(name = "estadoBean")
@ViewScoped
public class EstadoBean implements Serializable {

	private Estado estado;

	private List<Estado> estados;

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	@PostConstruct
	public void listar() {

		try {

			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listar();

		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao  tentar Listar");
			erro.printStackTrace();
		}

	}

	public void novo() {
		estado = new Estado();

	}

	public void salvar() {

		try {
			EstadoDAO estadoDAO = new EstadoDAO();
			estadoDAO.merge(estado);

			novo();
			
			estados = estadoDAO.listar();

			Messages.addFlashGlobalInfo("Estado salvo com sucesso!");
		} catch (RuntimeException erro) {

			Messages.addFlashGlobalError("Ocorreu um erro ao  tentar salvar");
			erro.printStackTrace();

		}
	}
	
	
	public void excluir(ActionEvent evento){
		
		try{
		estado =  (Estado) evento.getComponent().getAttributes().get("estadoSelecionado");
		
		EstadoDAO estadoDAO = new EstadoDAO();
		estadoDAO.excluir(estado);
		
		estados = estadoDAO.listar();
		
		Messages.addGlobalInfo("Estado excluido com sucesso!");
		}catch(RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar exluir!");
			erro.printStackTrace();
		}
		
	}
	
public void editar(ActionEvent evento){
		
		try{
		estado =  (Estado) evento.getComponent().getAttributes().get("estadoSelecionado");
		
		EstadoDAO estadoDAO = new EstadoDAO();
		estadoDAO.editar(estado);
		
		estados = estadoDAO.listar();
		
		Messages.addGlobalInfo("Estado editado!");
		}catch(RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar Editar!");
			erro.printStackTrace();
		}
		
	}
}
