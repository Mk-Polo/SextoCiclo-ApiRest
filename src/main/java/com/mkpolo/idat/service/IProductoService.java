package com.mkpolo.idat.service;

import java.util.List;

import com.mkpolo.idat.entity.Producto;

public interface IProductoService {

	public List<Producto> listartodos();
	
	public void guardar(Producto producto);
	
	public Producto buscarPorId(Long id);
	
	public void eliminar(Long id);
	
	public Producto buscarPorBarra(String barra);
	
	public boolean existePorBarra(String barra);
	
	public boolean existePorId(Long id);
}
