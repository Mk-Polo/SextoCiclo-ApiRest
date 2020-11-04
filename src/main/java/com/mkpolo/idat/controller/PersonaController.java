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

import com.mkpolo.idat.entity.Persona;
import com.mkpolo.idat.service.IPersonaService;

@RestController
@RequestMapping(value = "/api/persona/")
@CrossOrigin("*")
public class PersonaController {
	
  @Autowired
  private IPersonaService personaServ;
  
  @GetMapping(value = "/all")
  public List<Persona>getAll(){
	  return personaServ.listarTodo();
  }
	
  @PostMapping(value = "/save")
  public ResponseEntity<String> save(@RequestBody Persona persona){
	  
	  Persona existe = personaServ.buscarPorDni(persona.getDni());
	  if(existe != null) {
		  return new ResponseEntity("EXISTE",HttpStatus.OK);
	  }else {
	  personaServ.guardar(persona);
	  return new ResponseEntity("CREADO",HttpStatus.OK);
	  }
  }
  
  @PutMapping(value = "/update")
  public ResponseEntity<Persona> update(@RequestBody Persona persona){
	  personaServ.guardar(persona);
	  return new ResponseEntity("actualizado", HttpStatus.OK);
  }
  
  @DeleteMapping(value = "delete/{id}")
  public ResponseEntity<Persona>delete(@PathVariable Long id){
	  Persona persona = personaServ.buscarPorId(id);
	  if(persona != null) {
		  personaServ.eliminar(id);
	  }else {
		return new ResponseEntity("error", HttpStatus.NO_CONTENT);
	}
	  return new ResponseEntity("eliminado", HttpStatus.OK);
  }
  
  @GetMapping(value = "/finddni/{dni}")
  public Persona finddni(@PathVariable String dni){
	  Persona persona = personaServ.buscarPorDni(dni);
	  if (persona == null) {
		return new Persona();
	}
	  return persona;
  }
  
  @GetMapping(value = "/findnombre/{nombres}")
  public Persona findnombre(@PathVariable String nombres) {
	  Persona persona = personaServ.buscarPorNombre(nombres);
	  if (persona == null) {
		return new Persona();
	}
	  return persona;
  }
  
  @GetMapping(value = "/findapellido")
  public Persona findapellido(@PathVariable String apellidos) {
	  Persona persona = personaServ.buscarPorApellidos(apellidos);
	  if (persona == null) {
		return new Persona();
	}
	  return persona;
  }
}

