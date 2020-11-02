package com.mkpolo.idat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mkpolo.idat.entity.Usuario;
import com.mkpolo.idat.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepo;
	
	@Override
	public List<Usuario> listartodo() {
		
		return (List<Usuario>)usuarioRepo.findAll();
	}

	@Override
	public void guardar(Usuario usuario) {
		usuarioRepo.save(usuario);
		
	}

	@Override
	public Usuario buscarPorId(Long id) {
		return usuarioRepo.findById(id).orElse(null) ;
	}

	@Override
	public void eliminar(Long id) {
		usuarioRepo.deleteById(id);	
	}

	
}
