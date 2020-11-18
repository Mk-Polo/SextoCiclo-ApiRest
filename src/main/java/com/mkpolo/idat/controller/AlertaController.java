package com.mkpolo.idat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mkpolo.idat.entity.Alerta;
import com.mkpolo.idat.service.IAlertaService;

@RestController
@RequestMapping(value = "/api/alerta/")
@CrossOrigin("*")
public class AlertaController {
	
	@Autowired
	private IAlertaService alertaService;
	
	@GetMapping(value="/all")
	public List<Alerta> getAll(){
		return alertaService.listarAlerta();
	}
	
	@GetMapping(value="/all/{estado}")
	public List<Alerta> getAllEstado(@PathVariable String estado){
		return alertaService.listarPorEstado(estado);
	}
	
	@PostMapping(value="/save")
	public ResponseEntity<String> guardar(@RequestBody Alerta alerta){
		alertaService.guardar(alerta);
		return new ResponseEntity("Registro guardado con éxito", HttpStatus.CREATED);
	}
	
	@PutMapping(value="/editar")
	public ResponseEntity<String> editar(@RequestBody Alerta alerta){
		alertaService.guardar(alerta);
		return new ResponseEntity("Registro actualizado con éxito", HttpStatus.OK);
	}
	
	
	@DeleteMapping(value="/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id){
		if(alertaService.existePorId(id)) {
			alertaService.eliminar(id);
			return new ResponseEntity("Alerta eliminada con éxito", HttpStatus.OK);
		}else {
			return new ResponseEntity("Registro no encontrado",HttpStatus.NO_CONTENT);
		}		
	}

}
