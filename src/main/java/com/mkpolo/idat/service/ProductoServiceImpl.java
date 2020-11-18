package com.mkpolo.idat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mkpolo.idat.entity.Producto;
import com.mkpolo.idat.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements IProductoService {

	@Autowired
	private ProductoRepository productoRepo;
	
	@Override
	public List<Producto> listartodos() {
		return (List<Producto>) productoRepo.findAll();
	}

	@Override
	public void guardar(Producto producto) {
		productoRepo.save(producto);
	}

	@Override
	public Producto buscarPorId(Long id) {
		return productoRepo.findById(id).orElse(null);
	}

	@Override
	public void eliminar(Long id) {
		productoRepo.deleteById(id);
	}

	@Override
	public Producto buscarPorBarra(Long barra) {
		return productoRepo.findByBarra(barra);
	}

	@Override
	public boolean existePorBarra(Long barra) {
		return productoRepo.existsByBarra(barra);
	}

	@Override
	public boolean existePorId(Long id) {
		return productoRepo.existsById(id);
	}

}
