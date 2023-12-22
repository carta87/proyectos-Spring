package com.proyectoCRUD.proyectoCRUD.Service;

import java.util.List;

import com.proyectoCRUD.proyectoCRUD.Modelo.Persona;

public interface PersonaService {
	List<Persona> getAllPersonas();
	Persona getId(int id);
	Persona add(Persona persona);
	Persona edit(Persona persona);
	void delete (int id);
	
}
