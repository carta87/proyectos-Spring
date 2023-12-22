package com.curso.spring.discount.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/discount")
public class DiscountController {
	
	@GetMapping("/getByDate/{date}")
	public Float getDiscountByDate(@PathVariable String date) {
		//TODO tafur Pendiente realizar la implementacion metodo obtener descuento por fecha
		return 0.0F;
	}

}
