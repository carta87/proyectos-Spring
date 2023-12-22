package com.curso.spring.stock.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
	
	@GetMapping("/validate/{product}/{storeId}")
	public Boolean validateInventoryByproductAndStore(@PathVariable Short product, @PathVariable Short storeId) {
		//TODO tafur Pendiente realizar la implementacion metodo para validar
		return false;
	}
	
	@GetMapping("/prueba")
	public String prueba() {
		//TODO tafur Pendiente realizar la implementacion metodo para validar
		return "Funciona";
	}
}
