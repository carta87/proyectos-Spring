package com.curso.spring.sale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CoffeSaleModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoffeSaleModuleApplication.class, args);
	}

}
