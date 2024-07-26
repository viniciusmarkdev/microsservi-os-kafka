package com.kipper.vendaservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/venda")
public class VendaController {
	
	
	@Autowired
	private KafkaTemplate<String , String > kafkaTemplate;
	
	@PostMapping
	public ResponseEntity<Void> realizarVenda(@RequestBody String idProduto ){
		
		kafkaTemplate.send("estoque-topico", idProduto);
		//Exemplos do que poderiamos fazer
		//Salvando no banco de dados
		//criando a venda 
		//disparando microserviço para processar pagamento
		//atualizando estoque do produto
		
		
		return ResponseEntity.ok().build();
	}

}
