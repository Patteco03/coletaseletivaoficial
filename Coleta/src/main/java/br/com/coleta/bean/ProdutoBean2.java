package br.com.coleta.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.coleta.domain.ItensPedido;
import br.com.coleta.domain.Produto;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ProdutoBean2 implements Serializable{
	
	private Produto produto;
	private ItensPedido itens;
	
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
		
	}

}
