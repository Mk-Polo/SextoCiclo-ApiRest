package com.mkpolo.idat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mkpolo.idat.entity.Usuario;
import com.mkpolo.idat.service.IUsuarioService;

@RestController
@RequestMapping(value = "/api/usuario/")
@CrossOrigin("*")
public class UsuarioController {

	@Autowired
	private IUsuarioService usuarioService;
	
	@RequestMapping(value = "/all")
	public List<Usuario> listar(){
		return usuarioService.listartodo();
	}
	
	@PostMapping(value = "/save")
	public ResponseEntity<?> guardar(@RequestBody Usuario usuario){
		usuarioService.guardar(usuario);
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}
	
	@PutMapping(value = "/update")
	public ResponseEntity<String>editar(@RequestBody Usuario usuario){
		usuarioService.guardar(usuario);
        return new ResponseEntity("editado",HttpStatus.OK);
		
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<String> borrar(@PathVariable Long id){
		Usuario usuario = usuarioService.buscarPorId(id);
		if(usuario !=null) {
			usuarioService.eliminar(id);
		}else {
			return new ResponseEntity("ERROR",HttpStatus.NO_CONTENT);
			}
		return new ResponseEntity("ELIMINADO", HttpStatus.OK);
	}
}
