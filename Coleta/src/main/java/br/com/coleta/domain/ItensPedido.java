package br.com.coleta.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class ItensPedido  extends GenericDomain{
		
		@Column(length = 10, nullable = false)
		private Integer quantidade;
		
		@Column(nullable = false, precision = 6, scale = 2)
		private BigDecimal valor_parcial;
		
		@Column(nullable = false)
		private Float peso;
		
		@ManyToOne
		@JoinColumn(nullable = false)
		private Produto produto;

		public Integer getQuantidade() {
			return quantidade;
		}

		public void setQuantidade(Integer quantidade) {
			this.quantidade = quantidade;
		}

		public BigDecimal getValor_parcial() {
			return valor_parcial;
		}

		public void setValor_parcial(BigDecimal valor_parcial) {
			this.valor_parcial = valor_parcial;
		}

		public Float getPeso() {
			return peso;
		}

		public void setPeso(Float peso) {
			this.peso = peso;
		}

		public Produto getProduto() {
			return produto;
		}

		public void setProduto(Produto produto) {
			this.produto = produto;
		}
}
