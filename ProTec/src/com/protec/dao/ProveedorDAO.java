package com.protec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.protec.model.Proveedor;
import com.protec.model.Usuario;

public class ProveedorDAO {
	
	private String url;
	private Connection conexion;
	
	
	public ProveedorDAO() {
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
	
	
	public List<Proveedor> buscarProveedores(String estado) throws SQLException{
		List<Proveedor> listaProveedores = new ArrayList<Proveedor>();
		Statement stmt = conexion.createStatement();
		String sentencia= "Select * from Proveedor where estado='" + estado +"'";
		ResultSet resultado = stmt.executeQuery(sentencia);
		while (resultado.next()) {
			int codigoProveedor = resultado.getInt(1);
			String razSoc = resultado.getString(2);
			String ruc = resultado.getString(3);
			String direccion = resultado.getString(4);
			String telefono = resultado.getString(5);
			String estadoProveedor = resultado.getString(5);
			Proveedor objProveedor = new Proveedor();
			objProveedor.setCodigoProveedor(codigoProveedor);
			objProveedor.setRazSoc(razSoc);
			objProveedor.setRuc(ruc);
			objProveedor.setDireccion(direccion);
			objProveedor.setTelefono(telefono);
			objProveedor.setEstado(estadoProveedor);
			listaProveedores.add(objProveedor);
		}
		return listaProveedores;
	}
	
	public void registrarProveedor(String razSoc, String ruc, String direccion, String telefono) throws SQLException {
		Statement stmt = conexion.createStatement();
		String sentencia= "Insert into Proveedor (razSoc, ruc, direccion , estado, telefono) values ('" + razSoc + "','" + ruc + "', '" + direccion + "','Activo','" + telefono + "')";
		stmt.execute(sentencia);
	}
	
	
	
	/*Método para devolvernos el valor usuario (mostrar)*/
	public Proveedor buscarProveedor(int codigoProveedor) throws SQLException {
		Proveedor objProveedor = new Proveedor();
		Statement stmt = conexion.createStatement();
		String sentencia= "Select * from Proveedor where codigoProveedor='" + codigoProveedor +"'";
		ResultSet resultado = stmt.executeQuery(sentencia);
		while (resultado.next()) {
			int codProveedor = resultado.getInt(1);
			String razSoc = resultado.getString(2);
			String ruc = resultado.getString(3);
			String direccion = resultado.getString(4);
			String telefono = resultado.getString(5);
			String estado = resultado.getString(6);
			objProveedor.setCodigoProveedor(codigoProveedor);
			objProveedor.setRazSoc(razSoc);
			objProveedor.setRuc(ruc);
			objProveedor.setDireccion(direccion);
			objProveedor.setTelefono(telefono);
			objProveedor.setEstado(estado);
		}
		return objProveedor;
	}
	
	public void actualizarProveedor(int codigoProveedor, String razSoc, String ruc, String direccion, String telefono, String estado) throws SQLException {
		Statement stmt = conexion.createStatement();
		String sentencia= "Update Proveedor set razSoc='" + razSoc + "', ruc='" + ruc + "', direccion='" + direccion + "' , telefono='" + telefono + "'  , estado='" + estado + "' where codigoProveedor=" + codigoProveedor;
		stmt.execute(sentencia);
	}
}
