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

import com.mkpolo.idat.entity.Tpuser;
import com.mkpolo.idat.service.ITipousuarioService;

@RestController
@RequestMapping(value = "/api/tipousuario/")
@CrossOrigin("*")
public class TipousuarioController {

	@Autowired
	private ITipousuarioService tipousuarioServ;
	
	
	@GetMapping(value = "/all")
	public List<Tpuser> getAllTipoU(){
		return tipousuarioServ.listarTipoUsuario();
	} 
	
	
	@PostMapping(value = "/save")
	private ResponseEntity<Tpuser> save(@RequestBody Tpuser tpuser)  {
		tipousuarioServ.guardar(tpuser);
		return new ResponseEntity("creado", HttpStatus.OK);
	}
	
	
	
	@PutMapping(value = "/update")
	public ResponseEntity<String> edit(@RequestBody Tpuser tpuser){
		tipousuarioServ.guardar(tpuser);
		return new ResponseEntity("actualizado", HttpStatus.OK);
	}
	
	
	@DeleteMapping(value ="/delete" )
	public ResponseEntity<String> delete(@PathVariable Long id){
		Tpuser tpuser = tipousuarioServ.buscarPorId(id);
		if (tpuser != null) {
			tipousuarioServ.eliminar(id);
		}else {
			return new ResponseEntity("error", HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity("eliminado", HttpStatus.OK);
	}
}
