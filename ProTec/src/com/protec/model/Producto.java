package com.protec.model;

import java.util.Date;

public class Producto {
	private int codigoProducto;
	private String nombre;
	private int categoria;
	private String unidMed;
	private String fecVenc;
	private String peso;
	private int codProveedor;
	private String estado;
	
	
	public int getCodigoProducto() {
		return codigoProducto;
	}
	public void setCodigoProducto(int codigoProducto) {
		this.codigoProducto = codigoProducto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCategoria() {
		return categoria;
	}
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	public String getUnidMed() {
		return unidMed;
	}
	public void setUnidMed(String unidMed) {
		this.unidMed = unidMed;
	}
	
	public String getFecVenc() {
		return fecVenc;
	}
	public void setFecVenc(String fecVenc) {
		this.fecVenc = fecVenc;
	}
	public String getPeso() {
		return peso;
	}
	public void setPeso(String peso) {
		this.peso = peso;
	}
	public int getCodProveedor() {
		return codProveedor;
	}
	public void setCodProveedor(int codProveedor) {
		this.codProveedor = codProveedor;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}
