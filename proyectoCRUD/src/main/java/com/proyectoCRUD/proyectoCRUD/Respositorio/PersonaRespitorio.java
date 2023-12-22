package com.proyectoCRUD.proyectoCRUD.Respositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import com.proyectoCRUD.proyectoCRUD.Modelo.Persona;

public interface PersonaRespitorio extends JpaRepository<Persona, Integer> {

}
