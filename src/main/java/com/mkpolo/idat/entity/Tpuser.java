package com.mkpolo.idat.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Tipousuario")
public class Tpuser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy =GenerationType.IDENTITY )
	private Long id;
	
	@Column
	private String rol;

	
	public Tpuser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tpuser(Long id, String rol) {
		super();
		this.id = id;
		this.rol = rol;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
	
	
	
	
}
