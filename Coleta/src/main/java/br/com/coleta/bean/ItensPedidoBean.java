package br.com.coleta.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.coleta.dao.ItensPedidoDAO;
import br.com.coleta.dao.ProdutoDAO;
import br.com.coleta.domain.ItensPedido;
import br.com.coleta.domain.Produto;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ItensPedidoBean implements Serializable {

	private ItensPedido itenspedido;

	private List<ItensPedido> itenspedidos;
	private List<Produto> produtos;

	@PostConstruct
	public void listar() {

		try {

			ItensPedidoDAO itenspedidoDAO = new ItensPedidoDAO();
			itenspedidos = itenspedidoDAO.listar();

		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao  tentar Listar");
			erro.printStackTrace();
		}

	}

	public void novo() {

		try {

			itenspedido = new ItensPedido();

			ProdutoDAO produtoDAO = new ProdutoDAO();
			produtos = produtoDAO.listar("nome");

		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao gerar um novo Pedido");
			erro.printStackTrace();
		}

	}
	
	public void salvar() {

		try {
			
			ItensPedidoDAO intesprodutoDAO = new ItensPedidoDAO();
			intesprodutoDAO.merge(itenspedido);
			
			itenspedido = new ItensPedido();
			
			ProdutoDAO produtoDAO = new ProdutoDAO();
			produtos = produtoDAO.listar();
			
			itenspedidos = intesprodutoDAO.listar();
			
			
			Messages.addGlobalInfo("Itens salvo com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar salvar");
			erro.printStackTrace();
		}
	}
	
public void excluir(ActionEvent evento){
		
		try{
		itenspedido =  (ItensPedido) evento.getComponent().getAttributes().get("itemSelecionado");
		
		ItensPedidoDAO itenspedidoDAO = new ItensPedidoDAO();
		itenspedidoDAO.excluir(itenspedido);
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		produtos = produtoDAO.listar();
		
		itenspedidos = itenspedidoDAO.listar();
		
		Messages.addGlobalInfo("Pedido excluido com sucesso!");
		}catch(RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar exluir!");
			erro.printStackTrace();
		}
		
	}

public void editar(ActionEvent evento){
	
	try{
	itenspedido =  (ItensPedido) evento.getComponent().getAttributes().get("itemSelecionado");
	
	ItensPedidoDAO itenspedidoDAO = new ItensPedidoDAO();
	itenspedidoDAO.editar(itenspedido);
	
	ProdutoDAO produtoDAO = new ProdutoDAO();
	produtos = produtoDAO.listar();
	
	itenspedidos = itenspedidoDAO.listar();
	
	Messages.addGlobalInfo("Pedido editado com sucesso!");
	}catch(RuntimeException erro) {
		Messages.addGlobalError("Ocorreu um erro ao tentar editar!");
		erro.printStackTrace();
	}
	
}

	public List<ItensPedido> getItenspedidos() {
		return itenspedidos;
	}

	public void setItenspedidos(List<ItensPedido> itenspedidos) {
		this.itenspedidos = itenspedidos;
	}

	public ItensPedido getItenspedido() {
		return itenspedido;
	}

	public void setItenspedido(ItensPedido itenspedido) {
		this.itenspedido = itenspedido;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

}
