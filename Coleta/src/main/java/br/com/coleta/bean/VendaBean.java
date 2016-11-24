package br.com.coleta.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.coleta.dao.ItensPedidoDAO;
import br.com.coleta.dao.ProdutoDAO;
import br.com.coleta.domain.ItensPedido;
import br.com.coleta.domain.Produto;


@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class VendaBean implements Serializable {
	private List<Produto> produtos;
	private List<ItensPedido> itenspedidos;
	
	public List<ItensPedido> getItenspedidos() {
		return itenspedidos;
	}
	
	public void setItenspedidos(List<ItensPedido> itenspedidos) {
		this.itenspedidos = itenspedidos;
	}
	
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
			produtos = produtoDAO.listar("descricao");
			
			ItensPedidoDAO itenspedidoDAO = new ItensPedidoDAO();
			itenspedidos = itenspedidoDAO.listar();

			
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar carregar a tela de vendas");
			erro.printStackTrace();
		}
	}
}