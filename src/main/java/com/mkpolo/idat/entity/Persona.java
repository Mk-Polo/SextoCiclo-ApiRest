package com.mkpolo.idat.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "persona")
public class Persona implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	
	@ManyToOne
	@JoinColumn(name = "area_id")
	public Area area;
	
	@Column
	public String  nombres;
	@Column
	public String apellidos;
	@Column
	public String dni;
	@Column
	public String telefono;
	@Column
	public String correo;
	
	
	public Persona() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Persona(Long id, Area area, String nombres, String apellidos, String dni, String telefono, String correo) {
		super();
		this.id = id;
		this.area = area;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.dni = dni;
		this.telefono = telefono;
		this.correo = correo;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Area getArea() {
		return area;
	}


	public void setArea(Area area) {
		this.area = area;
	}


	public String getNombres() {
		return nombres;
	}


	public void setNombres(String nombres) {
		this.nombres = nombres;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}

	
	 
	
	
	
}
