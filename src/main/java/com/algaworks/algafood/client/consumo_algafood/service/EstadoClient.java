package com.algaworks.algafood.client.consumo_algafood.service;

import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.algaworks.algafood.client.api.ClientApiException;
import com.algaworks.algafood.client.consumo_algafood.model.EstadoClientModel;
import com.sun.net.httpserver.Headers;

@Component
public class EstadoClient {
	
	
    String baseURL = "http://localhost:8080";
    String oauthPath = "/oauth/token";
    String estadosPath = "/v1/estados";

    RestTemplate restTemplate = new RestTemplate();
    
    	
    public String obterToken(RestTemplate restTemplate, String url) {
        byte[] authData = "alga-code:web123".getBytes();
        String encodedAuthData = new String(Base64.getEncoder().encode(authData));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + encodedAuthData);

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("code", "??????");
        params.add("redirect_uri", "http://localhost:8082");
        params.add("grant_type", "authorization_code");

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);
        Map<String, String> response = restTemplate.postForObject(url, request, Map.class);

        return response.get("access_token");
    }

    //obterEstados
    public static EstadoClientModel[] obterEstados(RestTemplate restTemplate, String url, String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + token);

        HttpEntity<Headers> request = new HttpEntity<Headers>(headers);

        ResponseEntity<EstadoClientModel[]> estados = restTemplate
                .exchange(url, HttpMethod.GET, request, EstadoClientModel[].class);

        return estados.getBody();
    }
    
    public List<EstadoClientModel> listar() {
        try {
    	String token = obterToken(restTemplate, baseURL + oauthPath);
            EstadoClientModel[] estados = obterEstados(restTemplate, baseURL + estadosPath, token);
    			
    	return Arrays.asList(estados);
        } catch (HttpClientErrorException e) {
            throw new ClientApiException(e.getMessage(), e);
        }
    }
    	
}

