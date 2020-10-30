package com.mkpolo.idat.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mkpolo.idat.entity.Area;

@Repository
public interface AreaRepository extends CrudRepository<Area, Long>{
	
	boolean existsByArea (String area); 
}
