package com.mkpolo.idat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mkpolo.idat.entity.Persona;
import com.mkpolo.idat.repository.PersonaRepository;

@Service
public class PersonaServiceImpl implements IPersonaService {

	@Autowired
	private PersonaRepository personaRepo;
	
	@Override
	public List<Persona> listarTodo() {
		
		return (List<Persona>) personaRepo.findAll();
	}

	@Override
	public Persona buscarPorId(Long id) {
		
		return personaRepo.findById(id).orElse(null);
	}

	@Override
	public void guardar(Persona persona) {
		personaRepo.save(persona);
		
	}

	@Override
	public Persona buscarPorDni(String dni) {
		
		return personaRepo.existsByDni(dni);
	}

	@Override
	public Persona buscarPorNombre(String nombres) {
		
		return personaRepo.existsByNombres(nombres);
	}

	@Override
	public Persona buscarPorApellidos(String apellidos) {
		
		return personaRepo.existsByApellidos(apellidos);
	}

	@Override
	public void eliminar(Long id) {
		personaRepo.deleteById(id);
		
	}

}
