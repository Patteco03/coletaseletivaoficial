package br.com.coleta.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.coleta.dao.UsuarioDAO;
import br.com.coleta.domain.Usuario;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class UsuarioBean implements Serializable{
	
	private List<Usuario> usuarios;
	
	@PostConstruct
	public void listar(){
		
		try{
			
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarios = usuarioDAO.listar();
			
		}catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar Listar!");
			erro.printStackTrace();
		}
		
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}
