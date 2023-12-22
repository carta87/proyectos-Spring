package com.curso.spring.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ProyectConfig {
	
	//los beans tienen un alcalce o scope 
	@Bean //generar una unica intancia singleton por defecto
	public User fulanito() {//el nombre como lo va reconocer el contenedor
		User fulanitoUsr = new User("fulanitoss", "1234");
		return fulanitoUsr;
	}
	
	@Bean 
	public User sutanito() {
		User sutanito = new User("sutanito", "abch");
		return sutanito;
	}
	
}
