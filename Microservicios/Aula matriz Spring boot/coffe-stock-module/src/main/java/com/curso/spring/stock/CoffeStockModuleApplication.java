package com.curso.spring.stock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class CoffeStockModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoffeStockModuleApplication.class, args);
	}

}
