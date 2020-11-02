package com.mkpolo.idat.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mkpolo.idat.entity.Tpuser;

@Repository
public interface TipoUsuarioRepository extends CrudRepository<Tpuser, Long >{


}
