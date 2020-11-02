package com.mkpolo.idat.service;

import java.util.List;

import com.mkpolo.idat.entity.Tpuser;

public interface ITipousuarioService {
	
	public List<Tpuser> listarTipoUsuario();
	
	public void guardar (Tpuser tpuser );
	
	public Tpuser buscarPorId(Long id);
	
	public void eliminar(Long id);
	
	
	
	

}
