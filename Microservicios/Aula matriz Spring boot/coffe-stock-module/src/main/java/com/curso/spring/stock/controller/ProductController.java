package com.curso.spring.stock.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.spring.common.estities.Product;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@PostMapping("/create")
	public Product create(@RequestBody Product product) {
		//TODO tafur Pendiente realizar la implementacion metodo para crear
		return null;
	}
	
	@PostMapping("/update")
	public void update (@RequestBody Product product) {
		//TODO tafur Pendiente realizar la implementacion metodo de actualizar
		
	}
	
	@GetMapping("/findbyId/{productId}")
	public Product findById(@PathVariable Short productId) {
		//TODO tafur Pendiente realizar la implementacion metodo busqueada por ID
		return null;
	}
	
    @GetMapping("/findAll")
	public List<Product> findAll(){
    	//TODO tafur Pendiente realizar la implementacion metodo para encontar todos
		return null;
	}
    
    @DeleteMapping("/delete/{productId}")
    public void delete(@PathVariable Short productId) {
    	//TODO tafur Pendiente realizar la implementacion metodo de eliminar por ID
    	
    }


}
