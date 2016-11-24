package br.com.coleta.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.coleta.dao.ProdutoDAO;
import br.com.coleta.domain.Produto;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class PedidoBean implements Serializable{
	
	private List<Produto> produtos;

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	
	@PostConstruct
	public void listar() {

		try {

			ProdutoDAO produtoDAO = new ProdutoDAO();
			produtos = produtoDAO.listar();

		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao  tentar carregar a tela de vendas");
			erro.printStackTrace();
		}

	}
	
	

}
