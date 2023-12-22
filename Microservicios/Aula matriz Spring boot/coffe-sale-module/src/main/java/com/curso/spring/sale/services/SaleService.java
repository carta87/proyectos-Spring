package com.curso.spring.sale.services;

import com.curso.spring.common.estities.Customer;
import com.curso.spring.common.estities.Sale;

public interface SaleService {
	public Sale tryToCreateASale(Sale sale);
	public String getPrueba();
	public String findByDocument(Customer customer);
	public String findTypeNumDoc (Customer customer);
	

}
