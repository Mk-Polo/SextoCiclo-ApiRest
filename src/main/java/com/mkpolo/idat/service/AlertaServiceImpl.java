package com.mkpolo.idat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mkpolo.idat.entity.Alerta;
import com.mkpolo.idat.repository.AlertaRepository;

@Service
public class AlertaServiceImpl implements IAlertaService {
	
	@Autowired
	private AlertaRepository alertaRepo;

	@Override
	public List<Alerta> listarAlerta() {
		return (List<Alerta>) alertaRepo.findAll();
	}

	@Override
	public List<Alerta> listarPorEstado(String estado) {
		return (List<Alerta>) alertaRepo.findByEstado(estado);
	}

	@Override
	public void guardar(Alerta alerta) {
		alertaRepo.save(alerta);
	}

	@Override
	public Alerta buscarPorId(Long id) {
		return alertaRepo.findById(id).orElse(null);
	}

	@Override
	public void eliminar(Long id) {
		alertaRepo.deleteById(id);
	}

	@Override
	public boolean existePorId(Long id) {
		return alertaRepo.existsById(id);
	}

}
