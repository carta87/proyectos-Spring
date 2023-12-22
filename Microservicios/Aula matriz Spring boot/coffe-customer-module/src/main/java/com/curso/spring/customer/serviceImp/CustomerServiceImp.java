package com.curso.spring.customer.serviceImp;

import org.springframework.stereotype.Service;

import com.curso.spring.common.constants.DocType;
import com.curso.spring.common.estities.Customer;
import com.curso.spring.customer.service.CustomerService;

@Service("customerService")
public class CustomerServiceImp implements CustomerService {


	
	@Override
	public String getCustomerNumTypeDoc (Customer customer) {
		
		Customer customerTem =  new Customer();
		customerTem.setDocNumber("1234");
		customerTem.setDocType(DocType.CC);
		
		String respuesta = customer.getDocNumber().equals(customerTem.getDocNumber())
				&& customer.getDocType().equals(customerTem.getDocType()) ? "Existe registro": "No existe Registro";
		
		return respuesta;
	}
	
}
