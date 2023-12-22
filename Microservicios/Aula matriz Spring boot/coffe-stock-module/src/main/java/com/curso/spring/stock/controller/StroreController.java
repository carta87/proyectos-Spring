package com.curso.spring.stock.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.spring.common.estities.Store;

@RestController
@RequestMapping("/store")
public class StroreController {
	
	@PostMapping("/create")
	public Store create(@RequestBody Store store) {
		//TODO tafur Pendiente realizar la implementacion metodo crear
		return null;
	}
	
	@PostMapping("/update")
	public void update (@RequestBody Store store) {
		//TODO tafur Pendiente realizar la implementacion metodo 
		
	}
	
	@GetMapping("/findbyId/{storeId}")
	public Store findById(@PathVariable Short storeId) {
		//TODO tafur Pendiente realizar la implementacion metodo busqueda por Id
		return null;
	}
	
    @GetMapping("/findAll")
	public List<Store> findAll(){
    	//TODO tafur Pendiente realizar la implementacion metodo buscar todos 
		return null;
	}
    
    @DeleteMapping("/delete/{storeId}")
    public void delete(@PathVariable Short storeId) {
    	//TODO tafur Pendiente realizar la implementacion metodo de eliminar
    	
    }

}
