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

import com.mkpolo.idat.entity.Marcas;
import com.mkpolo.idat.service.IMarcasService;

@RestController
@RequestMapping(value="/api/marcas/")
@CrossOrigin("*")
public class MarcasController {

	@Autowired
	private IMarcasService marcaService;
	
	@GetMapping(value="/all")
	public List<Marcas> listar(){
		return marcaService.listarMarcas();
	}
	
	@PostMapping(value="/save")
	public ResponseEntity<String> guardar(@RequestBody Marcas marca){
		if(marcaService.existeMarca(marca.getMarca())) {
			return new ResponseEntity("Marca existente, prueba con otra",HttpStatus.NOT_ACCEPTABLE);
		}
		marcaService.guardar(marca);
		return new ResponseEntity("Registro guardado con éxito",HttpStatus.CREATED);
	}
	
	@PutMapping(value="/editar")
	public ResponseEntity<String> editar(@RequestBody Marcas marca){
		marcaService.guardar(marca);
		return new ResponseEntity("Registro actualizado con éxito",HttpStatus.OK);
	}
	
	@DeleteMapping(value="/delete/{id}")
	public ResponseEntity<String> eliminar(@PathVariable Long id){
		if(marcaService.existeId(id)) {
			marcaService.eliminar(id);
			return new ResponseEntity("Registro eliminado con éxito", HttpStatus.OK);
		}else {
		return new ResponseEntity("Registro no encontrado", HttpStatus.NO_CONTENT);
		}
		}
}
