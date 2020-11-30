package com.mkpolo.idat.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Producto")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "area_id")
	private Area area;
	
	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;
	
	@ManyToOne
	@JoinColumn(name = "marca_id")
	private Marcas marca;
	
	@Column
	private String producto;
	
	@Column
	private String barra;
	
	@Column
	private String peso;
	
	@Column
	private int dias;
	
	@Column
	private String imagen;

	public Producto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Producto(Long id, Area area, Categoria categoria, Marcas marca, String producto, String barra, String peso,
			int dias, String imagen) {
		super();
		this.id = id;
		this.area = area;
		this.categoria = categoria;
		this.marca = marca;
		this.producto = producto;
		this.barra = barra;
		this.peso = peso;
		this.dias = dias;
		this.imagen = imagen;
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

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Marcas getMarca() {
		return marca;
	}

	public void setMarca(Marcas marca) {
		this.marca = marca;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public String getBarra() {
		return barra;
	}

	public void setBarra(String barra) {
		this.barra = barra;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public int getDias() {
		return dias;
	}

	public void setDias(int dias) {
		this.dias = dias;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	
}
