package com.curso.spring.sale.http.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.curso.spring.common.constants.DocType;
import com.curso.spring.common.estities.Customer;

@FeignClient(name = "customerClient", url = "${customer.microservice.baseURL}")
public interface CustomerClient {
	
	@GetMapping("/customer/findById/{customeId}")
	public ResponseEntity<String> findCustomer(@PathVariable String customeId);
	
	@GetMapping("/customer/findByDocAndTypeDoc/{customerId}/{typeDoc}")
	public ResponseEntity<String> findByDocAndTypeDoc(@PathVariable String customerId, @PathVariable DocType  typeDoc);

}
