package com.algaworks.algafood.client.model;

import java.math.BigDecimal;

public class RestauranteResumoModel {

	private Long id;
	private String nome;
	//private BigDecimal taxaFrete;
	private CozinhaModel cozinha;
	private BigDecimal precoFrete; 
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/*
	public BigDecimal getTaxaFrete() {
		return taxaFrete;
	}
	public void setTaxaFrete(BigDecimal taxaFrete) {
		this.taxaFrete = taxaFrete;
	}*/
	public CozinhaModel getCozinha() {
		return cozinha;
	}
	public BigDecimal getPrecoFrete() {
		return precoFrete;
	}
	public void setPrecoFrete(BigDecimal precoFrete) {
		this.precoFrete = precoFrete;
	}
	public void setCozinha(CozinhaModel cozinha) {
		this.cozinha = cozinha;
	}
	
	
	
	public String toString() {
		return nome + " - " + precoFrete;
	}
	
}