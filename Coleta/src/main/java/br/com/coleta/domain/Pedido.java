package br.com.coleta.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
public class Pedido extends GenericDomain {

	@Column(nullable = false, precision = 6, scale = 2)
	private BigDecimal preco_total;

	@Column(length = 30, nullable = false)
	private String descricao;

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataPedido;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Comprador comprador;

	@ManyToOne
	@JoinColumn(nullable = false)
	private ItensPedido itenspedido;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Cliente cliente;
	
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public BigDecimal getPreco_total() {
		return preco_total;
	}

	public void setPreco_total(BigDecimal preco_total) {
		this.preco_total = preco_total;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}

	public Comprador getComprador() {
		return comprador;
	}

	public void setComprador(Comprador comprador) {
		this.comprador = comprador;
	}

	public ItensPedido getItenspedido() {
		return itenspedido;
	}

	public void setItenspedido(ItensPedido itenspedido) {
		this.itenspedido = itenspedido;
	}
	

}
