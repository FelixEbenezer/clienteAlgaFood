package com.algaworks.algafood.client.api;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import com.algaworks.algafood.client.model.RestauranteResumoModel;
import com.algaworks.algafood.client.postres.RestauranteInput;
import com.algaworks.algafood.client.postres.RestauranteModel;


public class RestauranteClient {

	private static final String RESOURCE_PATH = "/restaurantes";
	
	private RestTemplate restTemplate;
	private String url;
	
	
	
	public RestauranteClient(RestTemplate restTemplate, String url) {

		this.restTemplate = restTemplate;
		this.url = url;
	}



	public List<RestauranteResumoModel> listar() {
		try {
			URI resourceUri = URI.create(url + RESOURCE_PATH);
			
			RestauranteResumoModel[] restaurantes = restTemplate
					.getForObject(resourceUri, RestauranteResumoModel[].class);
			
			return Arrays.asList(restaurantes);
		} catch (RestClientResponseException e) {
			throw new ClientApiException(e.getMessage(), e);
		}
	}
	//buscarPor id do RestauranteResumoModel 
	public RestauranteResumoModel buscarPor(Long id) {
		//GET: https://localhost:8080/restaurantes/id
		//tbem com getForObject
		try {
		URI resourceUri = URI.create(url+RESOURCE_PATH+"/"+id);
		
		RestauranteResumoModel restaurante = restTemplate.getForObject(resourceUri, RestauranteResumoModel.class);
		return restaurante;
		}catch (RestClientResponseException e) {
			throw new ClientApiException(e.getMessage(), e);
		}
	}
	
	//buscarPor id do RestauranteModel 
	public RestauranteModel buscarPorResModel(Long id) {
		//GET: https://localhost:8080/restaurantes/id
		//tbem com getForObject
		try {
		URI resourceUri = URI.create(url+RESOURCE_PATH+"/"+id);
		
		RestauranteModel restaurante = restTemplate.getForObject(resourceUri, RestauranteModel.class);
		return restaurante;
		}catch (RestClientResponseException e) {
			throw new ClientApiException(e.getMessage(), e);
		}
	}
	
	public void removerRes(Long id) {
		
		//DELETE: https://localhost:8080/restaurantes/id
		//com getForObject
				try {
				URI resourceUri = URI.create(url+RESOURCE_PATH+"/"+id);
				
				restTemplate.delete(resourceUri);
				}catch (RestClientResponseException e) {
					throw new ClientApiException(e.getMessage(), e);
				}
		
	}
	
	public RestauranteModel adicionar(RestauranteInput restaurante) {
		  var resourceUri = URI.create(url + RESOURCE_PATH);
		  
		  try {
		    return restTemplate
		        .postForObject(resourceUri, restaurante, RestauranteModel.class);
		  } catch (HttpClientErrorException e) {
		    throw new ClientApiException(e.getMessage(), e);
		  }
		}
	
	public RestauranteModel atualizar(Long id, RestauranteInput restaurante) {
		  var resourceUri = URI.create(url + RESOURCE_PATH);
		  
		  try {
			//  RestauranteModel restauranteAtual = restTemplate.getForObject(resourceUri, RestauranteModel.class);
			  RestauranteModel restauranteAtual = buscarPorResModel(id);
			  
			  return restTemplate
		        .postForObject(resourceUri, restauranteAtual, RestauranteModel.class);
		  } catch (HttpClientErrorException e) {
		    throw new ClientApiException(e.getMessage(), e);
		  }
		}
	
}