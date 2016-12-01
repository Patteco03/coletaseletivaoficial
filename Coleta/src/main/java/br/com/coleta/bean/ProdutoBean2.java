package br.com.coleta.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.coleta.dao.ItensPedidoDAO;
import br.com.coleta.domain.ItensPedido;
import br.com.coleta.domain.Produto;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ProdutoBean2 implements Serializable{
	
	private Produto produto;
	private ItensPedido itens;
	private Boolean exibirDados;
	
	public Boolean getExibirDados() {
		return exibirDados;
	}
	
	public void setExibirDados(Boolean exibirDados) {
		this.exibirDados = exibirDados;
	}
	
	
	public ItensPedido getItens() {
		return itens;
	}
	
	public void setItens(ItensPedido itens) {
		this.itens = itens;
	}
	
	public Produto getProduto() {
		return produto;
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	
	@PostConstruct
	public void novo (){
		
		produto = new Produto();
		
		itens = new ItensPedido();
		
		exibirDados = false;
	}
	
	public void buscar(){
		
		try{
			
			ItensPedidoDAO itensPedidoDAO = new ItensPedidoDAO();
			ItensPedido resultado = itensPedidoDAO.buscar(itens.getCodigo());
			
			 if(resultado == null){
				 exibirDados = false;
				 Messages.addGlobalWarn("Não existe produto cadastrado para o código informado");
				 
			 }else{
				 exibirDados = true;
				 itens = resultado;
				 
			 }
			
		}catch (RuntimeException erro) {
			Messages.addGlobalInfo("Ocorreu um erro ao testar buscar o produto!");
			erro.printStackTrace();
		}
		
	}

}
