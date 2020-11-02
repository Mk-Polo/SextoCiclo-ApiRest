package com.mkpolo.idat.service;

import java.util.List;

import com.mkpolo.idat.entity.Persona;

public interface IPersonaService {

	public List<Persona> listarTodo();
	
	public Persona buscarPorId (Long id); 

	public void guardar(Persona persona);
	
	public Persona buscarPorDni(String dni);
	
	public Persona buscarPorNombre(String nombres);
	
	public Persona buscarPorApellidos(String apellidos);
	
	public void eliminar(Long id);
}
