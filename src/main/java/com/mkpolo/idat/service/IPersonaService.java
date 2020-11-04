package com.mkpolo.idat.service;

import java.util.List;

import com.mkpolo.idat.entity.Persona;

public interface IPersonaService {

	public List<Persona> listarTodo();
	
	public Persona buscarPorId (Long id); 

	public void guardar(Persona persona);
	
	public boolean existePorDni(String dni);
	public Persona buscarPorDni(String dni);
	
	public boolean existePorNombre(String nombres);
	public Persona buscarPorNombre(String nombres);
	
	public boolean existePorApellidos(String apellidos);
	public Persona buscarPorApellidos(String apellidos);
	
	public void eliminar(Long id);
}
