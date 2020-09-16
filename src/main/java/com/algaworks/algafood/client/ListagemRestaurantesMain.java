package com.algaworks.algafood.client;
import org.springframework.web.client.RestTemplate;

import com.algaworks.algafood.client.api.ClientApiException;
import com.algaworks.algafood.client.api.RestauranteClient;
import com.algaworks.algafood.client.model.RestauranteResumoModel;

public class ListagemRestaurantesMain {

	public static void main(String[] args) {
		try {
		//	RestauranteResumoModel resTa = new RestauranteResumoModel();
			RestTemplate restTemplate = new RestTemplate();
			
			RestauranteClient restauranteClient = new RestauranteClient(
					restTemplate, "http://localhost:8080");
			
			restauranteClient. listar().stream()
				.forEach(restaurante -> System.out.println(restaurante));
			System.out.println("************************************");
//			RestauranteResumoModel res = restauranteClient.buscarPor(1L);
	//		System.out.println(res);
/*			System.out.println("************************************");
		//	restauranteClient.removerRes(7L);
			System.out.println("Item deletado com sucesso");
			System.out.println("LISTAR TAXA FRETE DO RESTAURANTE");
			BigDecimal txFre = resTa.getPrecoFrete();
			System.out.println(txFre);*/
		} catch (ClientApiException e) {
			if (e.getProblem() != null) {
				System.out.println("Status: "+e.getProblem().getStatus());
				System.out.println("Timestamp: "+e.getProblem().getTimestamp());
				System.out.println("userMessage: "+e.getProblem().getUserMessage());
						
			} else {
				System.out.println("Erro desconhecido");
				e.printStackTrace();
			}
		}
	}
	
}