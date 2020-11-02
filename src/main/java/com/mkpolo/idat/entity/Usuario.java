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
@Table(name = "Usuario")
public class Usuario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JoinColumn(name = "persona_id")
	@ManyToOne
	private Persona persona;
	
	@Column
	private String password;
	
	@JoinColumn (name = "tipousuario_id")
	@ManyToOne
	private Tpuser tpuser;

	
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Usuario(Long id, Persona persona, String password, Tpuser tpuser) {
		super();
		this.id = id;
		this.persona = persona;
		this.password = password;
		this.tpuser = tpuser;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Persona getPersona() {
		return persona;
	}


	public void setPersona(Persona persona) {
		this.persona = persona;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Tpuser getTpuser() {
		return tpuser;
	}


	public void setTpuser(Tpuser tpuser) {
		this.tpuser = tpuser;
	}
	
	
	
}
