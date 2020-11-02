package com.mkpolo.idat.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mkpolo.idat.entity.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
	
}
