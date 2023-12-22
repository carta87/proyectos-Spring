package com.curso.spring.sale.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.spring.common.constants.DocType;
import com.curso.spring.common.estities.Customer;
import com.curso.spring.common.estities.Sale;
import com.curso.spring.sale.http.client.CustomerClient;
import com.curso.spring.sale.services.SaleService;

@RestController
@RequestMapping("/sale")
public class SaleController {
	@Autowired
	@Qualifier("saleService")
	private SaleService saleService;
	
	//@Autowired
	@Qualifier("customerService")
	private CustomerClient customerClient;
	
	
	@PostMapping("/create")
	public Sale tryToCreateSale(@RequestBody Sale sale) {
		saleService.tryToCreateASale(sale);
		//TODO tafur Pendiente realizar la implementacion metodo para intentar crear una venta
		return null;
	}
	
	@DeleteMapping("/delete/{saleId}")
	public Boolean cancelASale(@PathVariable Integer saleId) {
		//TODO tafur Pendiente realizar la implementacion metodo para cancelar una venta
		return false;
	}
	
	@PostMapping("/invoice")
	public void generateInvoice(@RequestBody Sale sale) {
		//TODO tafur Pendiente realizar la implementacion metodo para crear una factura
		
	}
	
	@GetMapping("/prueba")
	public String prueba() {
		//TODO tafur Pendiente realizar la implementacion metodo para validar
		return "Funciona...preuba";
	}
	
	@GetMapping("/customerID/{idCustomer}")
	public String customerID(@PathVariable String idCustomer) {
		
		//TODO tafur Pendiente realizar la implementacion metodo para validar
		Customer recogerDatos = new Customer();
		recogerDatos.setDocNumber(idCustomer);
		String  respuesta = saleService.findByDocument(recogerDatos);
		
		//saleService.findByDocument(respuesta);
		return respuesta;
	
	}
	
	@GetMapping("/findByDocAndTypeDoc/{customerId}/{typeDoc}")
	public String findByDocAndTypeDoc(@PathVariable String customerId, @PathVariable DocType typeDoc) {
		
		Customer customer = new Customer();
		customer.setDocNumber(customerId);
		customer.setDocType(typeDoc);
		
		String respuesta = saleService.findTypeNumDoc(customer);
		return respuesta;
	}
       
}
