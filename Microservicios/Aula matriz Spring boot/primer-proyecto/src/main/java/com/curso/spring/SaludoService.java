package com.curso.spring;

import org.springframework.stereotype.Service;

@Service //anotaciones estero-tipo, indicamos que es un Bean dentro del contexto
public class SaludoService {

	public String generarMensaje() {
		// TODO Auto-generated method stub
		return "hola saludo desde el service";
	}

	public String validarDatosCliente(Cliente cliente) {
		System.out.println(cliente.getDocumento());
	
		if (cliente.getDocumento().length() >5 && cliente.getDocumento().matches("[0-9]")) {
			return "acceso permitido";
		}else {
			return "acceso no permitido";
		}
	}
}
