package br.com.coleta.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.coleta.dao.CondominioDAO;
import br.com.coleta.domain.Condominio;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class CondominioBean implements Serializable {

	private Condominio condominio;

	private List<Condominio> condominios;

	@PostConstruct
	public void listar() {

		try {

			CondominioDAO condominioDAO = new CondominioDAO();
			condominios = condominioDAO.listar();

		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao  tentar Listar");
			erro.printStackTrace();
		}

	}

	public void novo() {

		condominio = new Condominio();

	}

	public void salvar() {

		try {

			CondominioDAO condominioDAO = new CondominioDAO();
			condominioDAO.merge(condominio);
			
			condominios = condominioDAO.listar();
			
			novo();
			Messages.addFlashGlobalInfo("Condominio salvo com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao  tentar Listar");
			erro.printStackTrace();
		}

	}
	
	
public void excluir(ActionEvent evento){
		
		try{
		condominio =  (Condominio) evento.getComponent().getAttributes().get("condominioSelecionado");
		
		CondominioDAO condominioDAO = new CondominioDAO();
		condominioDAO.excluir(condominio);
		
		condominios = condominioDAO.listar();
		
		Messages.addGlobalInfo("Condominio excluido com sucesso!");
		}catch(RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar exluir!");
			erro.printStackTrace();
		}
		
	}

public void editar(ActionEvent evento){
	
	try{
	condominio =  (Condominio) evento.getComponent().getAttributes().get("condominioSelecionado");
	
	CondominioDAO condominioDAO = new CondominioDAO();
	condominioDAO.editar(condominio);
	
	condominios = condominioDAO.listar();
	
	Messages.addGlobalInfo("Estado editado com sucesso!");
	}catch(RuntimeException erro) {
		Messages.addGlobalError("Ocorreu um erro ao tentar Editar!");
		erro.printStackTrace();
	}
	
}

	public Condominio getCondominio() {
		return condominio;
	}

	public void setCondominio(Condominio condominio) {
		this.condominio = condominio;
	}

	public List<Condominio> getCondominios() {
		return condominios;
	}

	public void setCondominios(List<Condominio> condominios) {
		this.condominios = condominios;
	}

}
