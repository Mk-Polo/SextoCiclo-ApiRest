package com.mkpolo.idat.service;

import java.util.List;

import com.mkpolo.idat.entity.Area;

public interface IAreaService {
	
	public List<Area> listarArea();
	
	public void guardar (Area area);
	
	public Area buscarPorId(Long id);
	
	public void eliminar(Long id);
	
	public boolean existeArea(String area);
	
	public boolean existeId(Long id);

}
