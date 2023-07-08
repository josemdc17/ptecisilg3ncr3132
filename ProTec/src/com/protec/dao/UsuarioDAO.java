package com.protec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.protec.model.Usuario;

public class UsuarioDAO {

	private String url;
	private Connection conexion;
	
	public UsuarioDAO() {
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
	/*
	public int validarUsuario(String correo, String password) throws SQLException {
		int usuarioValido = 0;
		Statement stmt = conexion.createStatement();
		String sentencia= "Select * from Usuario where correo='" + correo +"' and password='" + password + "'";
		ResultSet resultado = stmt.executeQuery(sentencia);
		while (resultado.next()) {
			usuarioValido = 1;
		}
		return usuarioValido;
	}*/
	public String validarUsuario(String correo, String password) throws SQLException {
	    String perfilUsuario = ""; 
	    Statement stmt = conexion.createStatement();
	    String sentencia = "SELECT perfil FROM Usuario WHERE correo='" + correo + "' AND password='" + password + "'";
	    ResultSet resultado = stmt.executeQuery(sentencia);
	    if (resultado.next()) {
	        perfilUsuario = resultado.getString("perfil");
	    }
	    return perfilUsuario;
	}

	
	public List<Usuario> buscarUsuarios(String perfil) throws SQLException{
		List<Usuario> listaUsuarios = new ArrayList<Usuario>();
		Statement stmt = conexion.createStatement();
		String sentencia= "Select * from Usuario where perfil='" + perfil +"'";
		ResultSet resultado = stmt.executeQuery(sentencia);
		while (resultado.next()) {
			int codigo = resultado.getInt(1);
			String correo = resultado.getString(2);
			String password = resultado.getString(3);
			String estado = resultado.getString(4);
			String perfilUsuario = resultado.getString(5);
			Usuario objUsuario = new Usuario();
			objUsuario.setCodigo(codigo);
			objUsuario.setCorreo(correo);
			objUsuario.setEstado(estado);
			objUsuario.setPassword(password);
			objUsuario.setPerfil(perfilUsuario);
			listaUsuarios.add(objUsuario);
		}
		return listaUsuarios;
	}
	
	public void registrarUsuario(String correo, String password, String perfil) throws SQLException {
		Statement stmt = conexion.createStatement();
		String sentencia= "Insert into Usuario (correo, password, estado, perfil) values ('" + correo + "','" + password + "','Activo','" + perfil + "')";
		stmt.execute(sentencia);
	}
	
	public void eliminarUsuario(int codigoUsuario) throws SQLException {
		Statement stmt = conexion.createStatement();
		String sentencia= "Delete from Usuario where codigo=" + codigoUsuario;
		stmt.execute(sentencia);
	}
	
	/*Método para devolvernos el valor usuario (mostrar)*/
	public Usuario buscarUsuario(int codigo) throws SQLException {
		Usuario objUsuario = new Usuario();
		Statement stmt = conexion.createStatement();
		String sentencia= "Select * from Usuario where codigo='" + codigo +"'";
		ResultSet resultado = stmt.executeQuery(sentencia);
		while (resultado.next()) {
			int codigoUsuario = resultado.getInt(1);
			String correo = resultado.getString(2);
			String password = resultado.getString(3);
			String estado = resultado.getString(4);
			String perfilUsuario = resultado.getString(5);
			objUsuario.setCodigo(codigo);
			objUsuario.setCorreo(correo);
			objUsuario.setEstado(estado);
			objUsuario.setPassword(password);
			objUsuario.setPerfil(perfilUsuario);
		}
		return objUsuario;
	}
	
	public void actualizarUsuario(int codigo, String correo, String password, String perfil, String estado) throws SQLException {
		Statement stmt = conexion.createStatement();
		String sentencia= "Update Usuario set correo='" + correo + "', password='" + password + "', perfil='" + perfil + "' , estado='" + estado + "' where codigo=" + codigo;
		stmt.execute(sentencia);
	}
	
	public String obtenerPerfilUsuario(String correo) throws SQLException {
	    String perfil = "";
	    Statement stmt = conexion.createStatement();
	    String sentencia = "SELECT perfil FROM Usuario WHERE correo='" + correo + "'";
	    ResultSet resultado = stmt.executeQuery(sentencia);
	    if (resultado.next()) {
	        perfil = resultado.getString("perfil");
	    }
	    return perfil;
	}

	
}
