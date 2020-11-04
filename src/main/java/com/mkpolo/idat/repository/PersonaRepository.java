package com.mkpolo.idat.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mkpolo.idat.entity.Persona;
@Repository
public interface PersonaRepository extends CrudRepository<Persona, Long> {

	boolean existsByDni(String dni);
	boolean existsByNombres(String nombres);
	boolean existsByApellidos(String apellidos);
	
	
	
	Persona findByDni(String dni);
	Persona findByNombres(String nombres);
	Persona findByApellidos(String apellidos);
	
}
