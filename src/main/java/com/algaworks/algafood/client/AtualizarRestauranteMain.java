package com.algaworks.algafood.client;

import java.math.BigDecimal;

import org.springframework.web.client.RestTemplate;

import com.algaworks.algafood.client.api.ClientApiException;
import com.algaworks.algafood.client.api.RestauranteClient;
import com.algaworks.algafood.client.postres.CidadeIdInput;
import com.algaworks.algafood.client.postres.CozinhaIdInput;
import com.algaworks.algafood.client.postres.EnderecoInput;
import com.algaworks.algafood.client.postres.RestauranteInput;
import com.algaworks.algafood.client.postres.RestauranteModel;

public class AtualizarRestauranteMain {

  public static void main(String[] args) {
    try {
      var restTemplate = new RestTemplate();
      var restauranteClient = new RestauranteClient(
          restTemplate, "http://localhost:8080");

      var cozinha = new CozinhaIdInput();
      cozinha.setId(1L);

      var cidade = new CidadeIdInput();
      cidade.setId(1L);

      var endereco = new EnderecoInput();
      endereco.setCidade(cidade);
      endereco.setCep("38500-111");
      endereco.setLogradouro("Rua Xyz");
      endereco.setNumero("300");
      endereco.setBairro("Centro");

      var restaurante = new RestauranteInput();
      restaurante.setNome("Comida MineiraAtualizada");
      restaurante.setTaxaFrete(new BigDecimal(109.5));
   //   restaurante.setPrecoFrete(new BigDecimal(9.5));
      restaurante.setCozinha(new CozinhaIdInput());
      restaurante.setCozinha(cozinha);
      restaurante.setEndereco(endereco);

      RestauranteModel restauranteModel = restauranteClient.atualizar(1L, restaurante);

      System.out.println(restauranteModel);
    } catch (ClientApiException e) {
      if (e.getProblem() != null) {
        System.out.println(e.getProblem().getUserMessage());
        
        e.getProblem().getObjects().stream()
          .forEach(p -> System.out.println("- " + p.getUserMessage()));
        
      } else {
        System.out.println("Erro desconhecido");
        e.printStackTrace();
      }
    }
  }
}        