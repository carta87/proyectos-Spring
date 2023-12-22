package com.curso.spring.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.spring.common.constants.DocType;
import com.curso.spring.common.estities.Customer;
import com.curso.spring.customer.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/create")
	public Customer create(@RequestBody Customer custommer) {
		//TODO tafur Pendiente realizar la implementacion metodo creacion
		return null;
		
	}
	
	@PutMapping("/update")
	public void update(@RequestBody Customer customer) {
		//TODO tafur Pendiente realizar la implementacion metodo actualizacion
	}
	
	@GetMapping("/findById/{customeId}")
	public String findById(@PathVariable String customeId) {
		//TODO tafur Pendiente realizar la implementacion metodo buscar por ID
		System.out.println(customeId);
		System.out.println(DocType.CC.toString());
		
		Customer customer =  new Customer();
		customer.setDocNumber("1234");
		customer.setDocType(DocType.CC);
		//if (customer.getDocNumber().equals(customeId)) return customer;
		String respuesta = customer.getDocNumber().equals(customeId)? "Existe registro": "No existe Registro";
		
		return respuesta;
	}
	
	@GetMapping("/findByDocAndTypeDoc/{customerId}/{typeDoc}")
	public String findByDocAndTypeDoc(@PathVariable String customerId, @PathVariable DocType typeDoc ) {
	
		Customer customer = new Customer();
		customer.setDocNumber(customerId);
		customer.setDocType(typeDoc);
		
		String respuesta = customerService.getCustomerNumTypeDoc(customer);
		
		return respuesta;
	}
	
	@GetMapping("/findAll")
	public List<Customer> finAll(){
		//TODO tafur Pendiente realizar la implementacion metodo buscar en lista
		return null;
	}
	
	@DeleteMapping("/delete/{customeId}")
	public void delete(@PathVariable String customeId) {
		//TODO tafur Pendiente realizar la implementacion metodo de eliminar
		
	}

}
