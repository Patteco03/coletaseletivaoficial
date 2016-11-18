package br.com.coleta.domain;


import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class Produto extends GenericDomain{
	
	@Column(length = 80, nullable = false)
	private String nome;
	
	@Column(length = 50, nullable = false)
	private String descricao;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	

}
