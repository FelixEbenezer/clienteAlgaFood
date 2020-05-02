package com.algaworks.algafood.client.postres;

import java.math.BigDecimal;

public class RestauranteInput {

  private String nome;
 private BigDecimal taxaFrete;
 // private BigDecimal precoFrete; 
  private CozinhaIdInput cozinha;
  private EnderecoInput endereco;
  
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}

/*
public BigDecimal getPrecoFrete() {
	return precoFrete;
}
public void setPrecoFrete(BigDecimal precoFrete) {
	this.precoFrete = precoFrete;
}*/

public BigDecimal getTaxaFrete() {
	return taxaFrete;
}
public void setTaxaFrete(BigDecimal taxaFrete) {
	this.taxaFrete = taxaFrete;
}
public CozinhaIdInput getCozinha() {
	return cozinha;
}
public void setCozinha(CozinhaIdInput cozinha) {
	this.cozinha = cozinha;
}
public EnderecoInput getEndereco() {
	return endereco;
}
public void setEndereco(EnderecoInput endereco) {
	this.endereco = endereco;
}
  
  
}  