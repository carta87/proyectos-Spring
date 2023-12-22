package com.curso.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {
	
	@Autowired //anivel constructor, campo
	private SaludoService service;//ademas que se inyecte una unica instancia- singleton
	
	
	@GetMapping("/saludo")
	public String salududar() {
		//bajo acoplamiento y cuando el framework se encarge de las instancias
		//SaludoService service = new SaludoService();
		//return service.generarMensaje();
		return service.generarMensaje();
	}
	
	@PostMapping("/user/save")
	public String saveUser(@RequestBody User userToSave) {
		System.out.println("el usuuario recibido es  " + userToSave);
		return "usuario recibido";
	}
	
	@PostMapping("/cliente")
	public String validarcliente(@RequestBody Cliente cliente) {
		
		return service.validarDatosCliente(cliente);
	}
	
	

}
