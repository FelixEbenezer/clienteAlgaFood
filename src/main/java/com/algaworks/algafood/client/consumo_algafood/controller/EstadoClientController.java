package com.algaworks.algafood.client.consumo_algafood.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.client.consumo_algafood.model.EstadoClientModel;
import com.algaworks.algafood.client.consumo_algafood.service.EstadoClient;

@RestController
@RequestMapping("/estadosClient")
public class EstadoClientController {
	

	@Autowired
	private EstadoClient estadoClient; 
	
	@GetMapping
	public List<EstadoClientModel> listarCidadeClient() {

		return estadoClient.listar();

	}

}
