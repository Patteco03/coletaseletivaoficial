package br.com.coleta.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@SuppressWarnings("serial")
@Entity
public class Comprador extends GenericDomain{
		
		@Column(nullable = false)
		private Boolean liberado;
		
		@OneToOne
		@JoinColumn(nullable = false)
		private Pessoa pessoa;
		public Boolean getLiberado() {
			return liberado;
		}
		public void setLiberado(Boolean liberado) {
			this.liberado = liberado;
		}
		public Pessoa getPessoa() {
			return pessoa;
		}
		public void setPessoa(Pessoa pessoa) {
			this.pessoa = pessoa;
		}
		
		
}
