package com.proyecto.softpymes.servicio;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.proyecto.softpymes.entidades.Empleado;

public interface EmpleadoService {

	public List<Empleado> findAll();

	public Page<Empleado> findAll(Pageable pageable);

	public void save(Empleado empleado);

	public Empleado findOne(long id);

	public void delete(long id);
}
