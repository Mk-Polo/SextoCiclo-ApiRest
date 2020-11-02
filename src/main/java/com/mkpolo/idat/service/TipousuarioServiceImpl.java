package com.mkpolo.idat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mkpolo.idat.entity.Tpuser;
import com.mkpolo.idat.repository.TipoUsuarioRepository;

@Service
public class TipousuarioServiceImpl implements ITipousuarioService{

	@Autowired
	private TipoUsuarioRepository tipousuarioRepo;
	
	@Override
	public List<Tpuser> listarTipoUsuario() {

		return (List<Tpuser>) tipousuarioRepo.findAll();
	}

	@Override
	public void guardar(Tpuser tpuser) {
     tipousuarioRepo.save(tpuser);
		
	}

	@Override
	public Tpuser buscarPorId(Long id) {
     
		return tipousuarioRepo.findById(id).orElse(null) ;
	}

	@Override
	public void eliminar(Long id) {
             tipousuarioRepo.deleteById(id);
		
	}

	
	
	
	

}
