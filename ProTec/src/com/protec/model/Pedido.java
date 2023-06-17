package com.protec.model;

public class Pedido {
	private int codigoPedido;
	private String nombreCliente;
	private String direccionCliente;
	private String telefCliente;
	private String fecPedido;
	private String fecEntrega;
	private String detalle;
	private String estado;
	
	public int getCodigoPedido() {
		return codigoPedido;
	}
	public void setCodigoPedido(int codigoPedido) {
		this.codigoPedido = codigoPedido;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public String getDireccionCliente() {
		return direccionCliente;
	}
	public void setDireccionCliente(String direccionCliente) {
		this.direccionCliente = direccionCliente;
	}
	public String getTelefCliente() {
		return telefCliente;
	}
	public void setTelefCliente(String telefCliente) {
		this.telefCliente = telefCliente;
	}
	public String getFecPedido() {
		return fecPedido;
	}
	public void setFecPedido(String fecPedido) {
		this.fecPedido = fecPedido;
	}
	public String getFecEntrega() {
		return fecEntrega;
	}
	public void setFecEntrega(String fecEntrega) {
		this.fecEntrega = fecEntrega;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
}
