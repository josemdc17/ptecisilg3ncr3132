package com.protec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.protec.model.Producto;
import com.protec.model.Proveedor;
import com.protec.model.Usuario;

public class ProductoDAO {
	
	private String url;
	private Connection conexion;
	
	public ProductoDAO() {
		/*Aqui vamos a realizar la conexion con la BD*/
		/*1. La ruta donde est� la base de datos
		 *   jdbc:TipoBaseDatos://ServidorBD:1433;dataBaseName=nombreInstanciaBD;user=usuarioBD;password=password;
		 */
		this.url = "jdbc:sqlserver://DESKTOP-QEDQMHM\\SQLEXPRESS:1433;databaseName=ProTec;user=sa;password=Password1";
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			this.conexion = DriverManager.getConnection(url);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Producto> buscarProductos(String estado) throws SQLException{
		List<Producto> listaProductos = new ArrayList<Producto>();
		Statement stmt = conexion.createStatement();
		String sentencia= "Select * from Producto where estado='" + estado +"'";
		ResultSet resultado = stmt.executeQuery(sentencia);
		while (resultado.next()) {
			int codigoProducto = resultado.getInt(1);
			String nombre = resultado.getString(2);
			int categoria = resultado.getInt(3);
			String unidMed = resultado.getString(4);
			String fecVen = resultado.getString(5);
			String peso = resultado.getString(6);
			int codigoProveedor = resultado.getInt(7);
			String estadoProducto = resultado.getString(8);
			Producto objProducto = new Producto();
			objProducto.setCodigoProducto(codigoProducto);
			objProducto.setNombre(nombre);
			objProducto.setCategoria(categoria);
			objProducto.setUnidMed(unidMed);
			objProducto.setFecVenc(fecVen);
			objProducto.setPeso(peso);
			objProducto.setCodProveedor(codigoProveedor);
			objProducto.setEstado(estadoProducto);
			listaProductos.add(objProducto);
		}
		return listaProductos;
	}
	
	public void registrarProducto(String nombre, int categoria, String unidMed, String fecVenc, String peso, int codProveedor) throws SQLException {
		Statement stmt = conexion.createStatement();
		String sentencia= "Insert into Producto (nombre, categoria, unidMed, fecVenc, peso, estado, codProveedor) values ('" + nombre + "','" + categoria + "','" + unidMed + "','" +  fecVenc + "','" + peso + "','Disponible','" + codProveedor + "')";
		stmt.execute(sentencia);
	}
	
	public void eliminarProducto(int codigoProducto) throws SQLException {
		Statement stmt = conexion.createStatement();
		String sentencia= "Delete from Producto where codigoProducto=" + codigoProducto;
		stmt.execute(sentencia);
	}
	
	
	
	
	
	/*Método para devolvernos el valor usuario (mostrar)*/
	public Producto buscarProducto(int codigoProducto) throws SQLException {
		Producto objProducto = new Producto();
		Statement stmt = conexion.createStatement();
		String sentencia= "Select * from Producto where codProducto='" + codigoProducto +"'";
		ResultSet resultado = stmt.executeQuery(sentencia);
		while (resultado.next()) {
			int codProducto = resultado.getInt(1);
			String nombre = resultado.getString(2);
			int categoria = resultado.getInt(3);
			String unidMed = resultado.getString(4);
			String fecVenc = resultado.getString(5);
			String peso = resultado.getString(6);
			int codProveedor = resultado.getInt(7);
			String estado = resultado.getString(8);
			objProducto.setCodigoProducto(codigoProducto);
			objProducto.setNombre(nombre);
			objProducto.setCategoria(categoria);
			objProducto.setUnidMed(unidMed);
			objProducto.setFecVenc(fecVenc);
			objProducto.setPeso(peso);
			objProducto.setCodProveedor(codProveedor);
			objProducto.setEstado(estado);
		}
		return objProducto;
	}
	
	public void actualizarProducto(int codigoProducto, String nombre, int categoria, String unidMed, String fecVenc, String peso, int codProveedor, String estado) throws SQLException {
		Statement stmt = conexion.createStatement();
		String sentencia= "Update Producto set nombre='" + nombre + "', categoria='" + categoria + "', unidMed='" + unidMed + "' , fecVenc='" + fecVenc + "' , peso='" + peso + "', codProveedor='" + codProveedor + "' , estado='" + estado + "' where codProducto=" + codigoProducto;
		stmt.execute(sentencia);
	}
	
	
	
	
}
