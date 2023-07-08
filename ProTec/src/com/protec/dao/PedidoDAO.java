package com.protec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.protec.model.Pedido;
import com.protec.model.Producto;

public class PedidoDAO {
	
	private String url;
	private Connection conexion;
	
	public PedidoDAO() {
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
	
	public List<Pedido> buscarPedidos(String estado) throws SQLException{
		List<Pedido> listaPedidos = new ArrayList<Pedido>();
		Statement stmt = conexion.createStatement();
		String sentencia= "Select * from Pedido where estado='" + estado +"'";
		ResultSet resultado = stmt.executeQuery(sentencia);
		while (resultado.next()) {
			int codigoPedido = resultado.getInt(1);
			String nombreCliente = resultado.getString(2);
			String direccionCliente = resultado.getString(3);
			String telefCliente = resultado.getString(4);
			String fecPedido = resultado.getString(5);
			String fecEntrega = resultado.getString(6);
			String detalle = resultado.getString(7);
			String estadoPedido = resultado.getString(8);
			String numPedido = resultado.getString(9);

			Pedido objPedido = new Pedido();
			objPedido.setCodigoPedido(codigoPedido);
			objPedido.setNombreCliente(nombreCliente);
			objPedido.setDireccionCliente(direccionCliente);
			objPedido.setTelefCliente(telefCliente);
			objPedido.setFecPedido(fecPedido);
			objPedido.setFecEntrega(fecEntrega);
			objPedido.setDetalle(detalle);
			objPedido.setEstado(estadoPedido);
			objPedido.setNumPedido(numPedido);
			listaPedidos.add(objPedido);
		}
		return listaPedidos;
	}
	
	
	public Pedido buscarPedido(int codigoPedido) throws SQLException {
		Pedido objPedido = new Pedido();
		Statement stmt = conexion.createStatement();
		String sentencia= "Select * from Pedido where codigoPedido='" + codigoPedido +"'";
		ResultSet resultado = stmt.executeQuery(sentencia);
		while (resultado.next()) {
			int codPedido = resultado.getInt(1);
			String nombreCliente = resultado.getString(2);
			String direccionCliente = resultado.getString(3);
			String telefCliente = resultado.getString(4);
			String fecPedido = resultado.getString(5);
			String fecEntrega = resultado.getString(6);
			String detalle = resultado.getString(7);
			String estadoPedido = resultado.getString(8);
			String numPedido = resultado.getString(9);
			
			objPedido.setCodigoPedido(codigoPedido);
			objPedido.setNombreCliente(nombreCliente);
			objPedido.setDireccionCliente(direccionCliente);
			objPedido.setTelefCliente(telefCliente);
			objPedido.setFecPedido(fecPedido);
			objPedido.setFecEntrega(fecEntrega);
			objPedido.setDetalle(detalle);
			objPedido.setEstado(estadoPedido);
			objPedido.setNumPedido(numPedido);
		}
		return objPedido;
	}
	
	public List<Pedido> buscarAllPedidos() throws SQLException {
		List<Pedido> listadoPedidos = new ArrayList<>();
		Statement stmt = conexion.createStatement();
		String sentencia= "Select * from Pedido";
		ResultSet resultado = stmt.executeQuery(sentencia);
		while (resultado.next()) {
			int codigoPedido = resultado.getInt(1);
			String nombreCliente = resultado.getString(2);
			String direccionCliente = resultado.getString(3);
			String telefCliente = resultado.getString(4);
			String fecPedido = resultado.getString(5);
			String fecEntrega = resultado.getString(6);
			String detalle = resultado.getString(7);
			String estadoPedido = resultado.getString(8);
			String numPedido = resultado.getString(9);

			Pedido objPedido = new Pedido();
			objPedido.setCodigoPedido(codigoPedido);
			objPedido.setNombreCliente(nombreCliente);
			objPedido.setDireccionCliente(direccionCliente);
			objPedido.setTelefCliente(telefCliente);
			objPedido.setFecPedido(fecPedido);
			objPedido.setFecEntrega(fecEntrega);
			objPedido.setDetalle(detalle);
			objPedido.setEstado(estadoPedido);
			objPedido.setNumPedido(numPedido);
			listadoPedidos.add(objPedido);
		}
		return listadoPedidos;
	}
	

	public void registrarPedido(String nombreCliente, String direccionCliente, String telefCliente, String fecPedido, String fecEntrega, String detalle) throws SQLException {
		Statement stmt = conexion.createStatement();
		String sentencia= "Insert into Pedido (nombreCliente, direccionCliente, telefCliente, fecPedido, fecEntrega, estado, detalle) values ('" + nombreCliente + "','" + direccionCliente + "','" + telefCliente + "','" +  fecPedido + "','" + fecEntrega + "','Programado','" + detalle + "')";
		stmt.execute(sentencia);
	}
	
	
	public void actualizarPedido(int codigoPedido, String nombreCliente, String direccionCliente, String telefCliente, String fecPedido, String fecEntrega, String detalle, String estado) throws SQLException {
		Statement stmt = conexion.createStatement();
		String sentencia= "Update Pedido set nombreCliente='" + nombreCliente + "', direccionCliente='" + direccionCliente + "', telefCliente='" + telefCliente + "' , fecPedido='" + fecPedido + "' , fecEntrega='" + fecEntrega + "', detalle='" + detalle + "' , estado='" + estado + "' where codigoPedido=" + codigoPedido;
		stmt.execute(sentencia);
	}
	
	
	public void actualizarEstado(int codigoPedido,String estado)throws SQLException{
		Statement stmt = conexion.createStatement();
		if(estado.equals("Programado")) {
			String sentencia=" UPDATE Pedido SET estado = 'Preparacion'  WHERE codigoPedido =" + codigoPedido ;
			stmt.execute(sentencia);
		}
		if(estado.equals("Preparacion")) {
			String sentencia=" UPDATE Pedido SET estado = 'Entregado'  WHERE codigoPedido =" + codigoPedido;
			stmt.execute(sentencia);
		}
		
	}
}
