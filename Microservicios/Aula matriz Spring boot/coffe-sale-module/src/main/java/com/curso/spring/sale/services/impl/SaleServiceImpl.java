package com.curso.spring.sale.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.spring.common.constants.DocType;
import com.curso.spring.common.estities.Customer;
import com.curso.spring.common.estities.Sale;
import com.curso.spring.sale.http.client.CustomerClient;
import com.curso.spring.sale.http.client.StoreClient;
import com.curso.spring.sale.services.SaleService;

@Service("saleService")
public class SaleServiceImpl implements SaleService {
	/*private RestTemplate restTemplate;
	
	private SaleServiceImpl (RestTemplateBuilder restTemplateBuilder) {
		restTemplate =  restTemplateBuilder.build();
	}

	@Override
	public Sale tryToCreateASale(Sale sale) {
		//TODO tafur pendiente de extraer la URL de manera externa. Posiblemente en el aplication.properties
		ResponseEntity<Boolean> validationResponse = 
		  restTemplate.getForEntity("http://localhost:8094/inventory/validate/{productId}/{storeId}", Boolean.class, 10,20);
		System.out.println("La respuesta del microservicio de stock es: " + validationResponse.getBody());
		return null;
	}*/
	
	@Autowired
	private StoreClient stockClient;
	
	@Override
	public Sale tryToCreateASale(Sale sale) {
		//consumir el microservicio pendiente por realizar la esistencia de un cliente. cliente no esxiste sout
		
		
		//Todo el identificador de la tienda no debe ir quemada, se puede definir como una propiedad
		sale.getProducts().stream().forEach((p)-> System.out.println("La respuesta del microservicio de stock "
				+ "para el productos es: " + p.getName()+ " " + 
				stockClient.validateInventory(p.getId(), (short)20).getBody()));
		
		//ResponseEntity<Boolean> validationResponse = stockClient.validateInventory((short)10, (short)20);
		//System.out.println("La respuesta del microservicio de stock es: " + validationResponse.getBody());
		
		//TODO aqui debe ir el resto de la logica para intentar hace la venta
		return null;
	}
	
	
	@Override
	public String getPrueba() {
		stockClient.getprueba();
		System.out.println("aui 4");
		// TODO Auto-generated method stub
		return null;
	}
	
	@Autowired
	private CustomerClient customerClient;


	@Override
	public String findByDocument(Customer customer) {

		String respuesta = customerClient.findCustomer(customer.getDocNumber()).getBody();
		
	

		// consumir el microservicio pendiente por realizar la esistencia de un cliente.
		// cliente no esxiste sout
		//System.out.println("valor de consulta  es " + customerClient.findCustomer(customer).getBody());
		/*
		 * String respuesta =customer.getDocNumber(); if (customer != null) {
		 * customerClient.findCustomer(respuesta);
		 * respuesta = "el documento del cliente es " +customer.getDocType() +
		 * "su numero es "+ customer.getDocNumber(); }else { respuesta =
		 * "No existe documento "; } System.out.println(respuesta);
		 */
		

		return respuesta;
	}


	@Override
	public String findTypeNumDoc(Customer customer) {
		String respuesta = customerClient.findByDocAndTypeDoc(customer.getDocNumber(), customer.getDocType()).getBody();
		return respuesta;
	}
	

	
	
}
