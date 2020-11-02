package com.mkpolo.idat.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mkpolo.idat.entity.Persona;
@Repository
public interface PersonaRepository extends CrudRepository<Persona, Long> {

	Persona existsByDni(String dni);
	Persona existsByNombres(String nombres);
	Persona existsByApellidos(String apellidos);
	
}
