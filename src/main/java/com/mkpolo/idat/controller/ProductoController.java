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
import com.mkpolo.idat.entity.Producto;
import com.mkpolo.idat.service.IProductoService;

@RestController
@RequestMapping(value = "/api/producto/")
@CrossOrigin("*")
public class ProductoController {

	@Autowired
	private IProductoService productoServ;
	
	@GetMapping(value="/all")
	public List<Producto> getAll(){
		return productoServ.listartodos();
	}
	
	@PostMapping(value="/save")
	public ResponseEntity<Producto> save(@RequestBody Producto producto){
		productoServ.guardar(producto);
		return new ResponseEntity("CREADO", HttpStatus.OK);
	}
	
	@PutMapping(value="/editar")
	public ResponseEntity<String> editar(@RequestBody Producto producto){
		productoServ.guardar(producto);
		return new ResponseEntity("EDITADO", HttpStatus.OK);
	}
	
	@DeleteMapping(value="/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id){
		Producto producto = productoServ.buscarPorId(id);
		
		if (producto != null) {
			productoServ.eliminar(id);
		}else {
			return new ResponseEntity("ERROR",HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity("ELIMINADO", HttpStatus.OK);
	}
	
	@GetMapping(value="/existe/{barra}")
	public ResponseEntity<String> existeBarra(@PathVariable Long barra) {
		if(productoServ.existePorNombre(barra)) {
			return new ResponseEntity("EXISTE", HttpStatus.OK);
		}
		return new ResponseEntity("NUEVO", HttpStatus.OK);
	}
	
	@GetMapping(value="/buscar/{barra}")
	public Producto buscarBarra(@PathVariable Long barra) {
		Producto product = productoServ.buscarPorBarra(barra);
		if(product == null) {
			return new Producto();
		}
		return product;
	}
}
