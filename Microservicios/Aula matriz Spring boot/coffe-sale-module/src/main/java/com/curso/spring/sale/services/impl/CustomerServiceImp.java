package com.curso.spring.sale.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.curso.spring.sale.http.client.CustomerClient;
import com.curso.spring.sale.services.CustomerService;

@Service("customerService")
public class CustomerServiceImp implements CustomerService {
	
	@Autowired
	private CustomerClient customerClient;

	@Override
	public String findByDocument(String customer) {
		//String respuesta = customerClient.findCustomer(customer).getBody();

		// consumir el microservicio pendiente por realizar la esistencia de un cliente.
		// cliente no esxiste sout
		//System.out.println("valor de consulta  es " + customerClient.findCustomer(customer).getBody());
		/*
		 * String respuesta =customer.getDocNumber(); if (customer != null) {
		 * customerClient.findCustomer(respuesta);
		 * 
		 * 
		 * respuesta = "el documento del cliente es " +customer.getDocType() +
		 * "su numero es "+ customer.getDocNumber(); }else { respuesta =
		 * "No existe documento "; } System.out.println(respuesta);
		 */

		return "Prueba";
	}
	
	

}
