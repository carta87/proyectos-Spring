package com.curso.spring.sale.http.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "stockClient", url = "${stock.microservice.baseURL}")
public interface StoreClient {
	
	@GetMapping("/inventory/validate/{productId}/{storeId}")
	public ResponseEntity<Boolean> validateInventory(@PathVariable short productId, @PathVariable short storeId);
	
	@GetMapping("/inventory/prueba")
	public ResponseEntity<String> getprueba();

}
