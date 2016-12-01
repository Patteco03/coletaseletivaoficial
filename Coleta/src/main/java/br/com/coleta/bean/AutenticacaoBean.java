package br.com.coleta.bean;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

import br.com.coleta.dao.UsuarioDAO;
import br.com.coleta.domain.Pessoa;
import br.com.coleta.domain.Usuario;

@ManagedBean
@SessionScoped
public class AutenticacaoBean {
	
	private Usuario usuario;
	private Usuario usuarioLogado;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}
	
	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	@PostConstruct
	public void iniciar() {
		usuario = new Usuario();
		usuario.setPessoa(new Pessoa());
	}

	public void autenticar() {
		try {
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarioLogado = usuarioDAO.autentiar(usuario.getPessoa().getEmail(), usuario.getSenha());
			
			if(usuarioLogado == null){
				Messages.addGlobalError("Email ou senha incorretos");
				return;
			}
			
			Faces.redirect("./web/modelo.xhtml");
		} catch (IOException erro) {
			erro.printStackTrace();
			Messages.addGlobalError(erro.getMessage());
		}
}


}
