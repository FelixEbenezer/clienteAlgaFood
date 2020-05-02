package com.algaworks.algafood.client.postres;

import java.math.BigDecimal;

import com.algaworks.algafood.client.model.CozinhaModel;

public class RestauranteModel {

  private Long id;
  private String nome;
  //private BigDecimal taxaFrete = BigDecimal.ZERO;
  private BigDecimal precoFrete; 
  private Boolean ativo;
  private Boolean aberto;

  private CozinhaModel cozinha;
  private EnderecoModel endereco;
  
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




public BigDecimal getPrecoFrete() {
	return precoFrete;
}
public void setPrecoFrete(BigDecimal precoFrete) {
	this.precoFrete = precoFrete;
}
/*
public BigDecimal getTaxaFrete() {
	return taxaFrete;
}
public void setTaxaFrete(BigDecimal taxaFrete) {
	this.taxaFrete = taxaFrete;
}*/
public Boolean getAtivo() {
	return ativo;
}
public void setAtivo(Boolean ativo) {
	this.ativo = ativo;
}
public Boolean getAberto() {
	return aberto;
}
public void setAberto(Boolean aberto) {
	this.aberto = aberto;
}
public CozinhaModel getCozinha() {
	return cozinha;
}
public void setCozinha(CozinhaModel cozinha) {
	this.cozinha = cozinha;
}
public EnderecoModel getEndereco() {
	return endereco;
}
public void setEndereco(EnderecoModel endereco) {
	this.endereco = endereco;
}
  
  @Override
	public String toString() {
		
		return id+nome+precoFrete;
	}

}