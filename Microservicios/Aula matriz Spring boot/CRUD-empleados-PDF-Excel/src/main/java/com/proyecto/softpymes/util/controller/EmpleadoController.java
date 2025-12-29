package com.proyecto.softpymes.util.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.softpymes.entidades.Empleado;
import com.proyecto.softpymes.servicio.EmpleadoService;
import com.proyecto.softpymes.util.PageRender;

@RestController
public class EmpleadoController {

	@Autowired
	private EmpleadoService empleadoService;
	
	@GetMapping({"/","/listar", ""})
	public String ListarEmpleados(@RequestParam(name = "page", defaultValue = "0") int page, Model modelo) {
		Pageable pagaRequest = PageRequest.ofSize(5);
		Page<Empleado> empleados = empleadoService.findAll(pagaRequest);
		PageRender<Empleado> pageRender = new PageRender<>("/lista", empleados);
		
		modelo.addAttribute("titulo", "listado Empleados");
		modelo.addAttribute("empleados", empleados);
		modelo.addAttribute("page", pageRender);
		
		return "listar";
		
	}
}
