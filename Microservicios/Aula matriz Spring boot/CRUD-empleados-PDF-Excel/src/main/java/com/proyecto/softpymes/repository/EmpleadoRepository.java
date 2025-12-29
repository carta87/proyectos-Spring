package com.proyecto.softpymes.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.proyecto.softpymes.entidades.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {


}
