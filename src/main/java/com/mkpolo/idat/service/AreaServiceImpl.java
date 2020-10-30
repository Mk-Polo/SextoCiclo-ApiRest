package com.mkpolo.idat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mkpolo.idat.entity.Area;
import com.mkpolo.idat.repository.AreaRepository;

@Service
public class AreaServiceImpl implements IAreaService {
	
	@Autowired
	private AreaRepository areaRepo;

	@Override
	public List<Area> listarArea() {
		return (List<Area>) areaRepo.findAll();
	}

	@Override
	public void guardar(Area area) {
		areaRepo.save(area);
	}

	@Override
	public Area buscarPorId(Long id) {
		return areaRepo.findById(id).orElse(null);
	}

	@Override
	public void eliminar(Long id) {
		areaRepo.deleteById(id);
	}

	@Override
	public boolean existeArea(String area) {
		return areaRepo.existsByArea(area);
	}

	@Override
	public boolean existeId(Long id) {
		return areaRepo.existsById(id);
	}

}
