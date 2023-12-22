package com.proyectoCRUD.proyectoCRUD.ServiceImp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proyectoCRUD.proyectoCRUD.Modelo.Persona;
import com.proyectoCRUD.proyectoCRUD.Respositorio.PersonaRespitorio;
import com.proyectoCRUD.proyectoCRUD.Service.PersonaService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PersonaServiceImp implements PersonaService {
	
	private PersonaRespitorio personaRespitorio;
	
	@Autowired
	public List<Persona> getAllPersonas() {
		System.out.println("listar");
		return personaRespitorio.findAll();
	}

	@Override
	public Persona getId(int id) {
		System.out.println("tarer el id =" + id);
		return personaRespitorio.findById(id).orElse(null);
	}

	@Override
	public Persona add(Persona persona) {
		System.out.println("guardar");
		return personaRespitorio.save(persona);
	}

	@Override
	public Persona edit(Persona persona) {
		System.out.println("actrualizar");
		return personaRespitorio.save(persona);
	}

	@Override
	public void delete(int id) {
	   personaRespitorio.deleteById(id);
	}

}
