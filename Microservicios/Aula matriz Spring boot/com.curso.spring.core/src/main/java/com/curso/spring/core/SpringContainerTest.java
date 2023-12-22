package com.curso.spring.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringContainerTest {

	public static void main(String[] args) {
	 var context = new AnnotationConfigApplicationContext(ProyectConfig.class);
	 
	 //cuando existe un unico bean en el contendor 
	 // var foundUser = context.getBean(User.class);
	  //var foundUser2 = context.getBean(User.class);
	 
	 //para que reconozca los dos beans por su nombre
	 var foundUser = context.getBean("fulanito");
	 var foundUser2 = context.getBean("sutanito");
	 context.close();
	 System.out.println("la info del usuarios recuperdo del contenedor es  "+ foundUser);
	 System.out.println("la info del usuarios recuperdo del contenedor es  "+ foundUser2);
	 if(foundUser == foundUser2) {//comparando a nivel de referencia en memoria
		 System.out.println("son el mismo objecto");
		 
	 }else {
		 System.out.println("No son el mismo objecto");
	 }
	}
}
