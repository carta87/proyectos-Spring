package com.proyectoCRUD.proyectoCRUD.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.proyectoCRUD.proyectoCRUD.Modelo.Persona;
import com.proyectoCRUD.proyectoCRUD.Service.PersonaService;

import lombok.AllArgsConstructor;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/personas")
@AllArgsConstructor
public class PersonaController {
	
	private  PersonaService personaService;
	
	@GetMapping ("/listar")
	public List<Persona> getListaPersonas() {
		return personaService.getAllPersonas();
	}
	
	@PostMapping("/agregar")
	public Persona agregar(@RequestBody Persona persona) {
		return personaService.add(persona);
	}
	
	@GetMapping("/obtenerId/{id}")
	public Persona obtenerId (@PathVariable int id ) {
		return personaService.getId(id);
	}
	
	@PutMapping("/actualizar/{id}")
	public Persona actualizar (@RequestBody Persona persona,  @PathVariable int id ) {
		persona.setId(id);
		return personaService.edit(persona);
	}
	
	@DeleteMapping("eliminar/{id}")
	public void eliminar(@PathVariable int id) {
		 personaService.delete(id);	
	}
}
