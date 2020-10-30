package com.mkpolo.idat.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mkpolo.idat.entity.Producto;

@Repository
public interface ProductoRepository extends CrudRepository<Producto, Long>{

	Producto findByBarra(Long barra);
	boolean existsByBarra(Long barra);
}
