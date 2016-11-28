package br.com.coleta.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class ItemVenda extends GenericDomain {
	@Column(nullable = false)
	private Short quantidade;

	@Column(nullable = false, precision = 7, scale = 2)
	private BigDecimal precoParcial;

	@ManyToOne
	@JoinColumn(nullable = false)
	private ItensPedido itenspedido;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Venda venda;
	
	public Venda getVenda() {
		return venda;
	}
	
	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public Short getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Short quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getPrecoParcial() {
		return precoParcial;
	}

	public void setPrecoParcial(BigDecimal precoParcial) {
		this.precoParcial = precoParcial;
	}

	public ItensPedido getItenspedido() {
		return itenspedido;
	}

	public void setItenspedido(ItensPedido itenspedido) {
		this.itenspedido = itenspedido;
	}

}