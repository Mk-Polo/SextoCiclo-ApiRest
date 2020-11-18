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

import com.mkpolo.idat.entity.Area;
import com.mkpolo.idat.service.IAreaService;

@RestController
@RequestMapping(value = "/api/area/")
@CrossOrigin("*")
public class AreaController {

	@Autowired
	private IAreaService areaServ;

	@GetMapping(value="/all")
	public List<Area> listar(){
		return areaServ.listarArea();
	}
	
	@PostMapping(value="/save")
	public ResponseEntity<String> guardar(@RequestBody Area area){
		if(areaServ.existeArea(area.getArea())) {
			return new ResponseEntity("Registro existente, prueba con otro",HttpStatus.NOT_ACCEPTABLE);
		}
		areaServ.guardar(area);
		return new ResponseEntity("Registro guardado con éxito",HttpStatus.OK);
	}
	
	@PutMapping(value="/editar")
	public ResponseEntity<String> editar(@RequestBody Area area){
		areaServ.guardar(area);
		return new ResponseEntity("Registro actualizado con éxito",HttpStatus.OK);
	}
	
	@DeleteMapping(value="/delete/{id}")
	public ResponseEntity<String> eliminar(@PathVariable Long id){
		if(areaServ.existeId(id)) {
			areaServ.eliminar(id);
			return new ResponseEntity("Registro eliminado con éxito", HttpStatus.OK);
		}else {
		return new ResponseEntity("Registro no encontrado", HttpStatus.NO_CONTENT);
		}
		}
}
