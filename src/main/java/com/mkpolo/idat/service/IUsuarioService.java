package com.mkpolo.idat.service;

import java.util.List;

import com.mkpolo.idat.entity.Usuario;

public interface IUsuarioService {
	
	public List<Usuario> listartodo();
	
	public void guardar (Usuario usuario);
	
	public Usuario buscarPorId(Long id);
	
	public void eliminar (Long id);
	
	
}
