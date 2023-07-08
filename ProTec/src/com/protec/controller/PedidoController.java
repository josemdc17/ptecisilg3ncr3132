package com.protec.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.protec.dao.PedidoDAO;
import com.protec.model.Pedido;
import com.protec.model.Producto;

@WebServlet("/pedido")
public class PedidoController extends HttpServlet{

	private static final long serialVersionUID = 1L;
    private PedidoDAO objPedidoDAO = new PedidoDAO();   
	

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PedidoController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opcion = request.getParameter("opcionGet");
		switch (opcion) {
			case "buscarPedidos":{
				try {
					buscarPedidos(request,response);
					break;
				} catch (SQLException | ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			/*
			 * case "eliminarProducto":{ try { eliminarProducto(request,response); } catch
			 * (SQLException | ServletException | IOException e) { // TODO Auto-generated
			 * catch block e.printStackTrace(); } break; }
			 */
			case "editarPedido":{
				try {
					editarPedido(request,response);
				} catch (SQLException | ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
			case "mostrarDetallePedido":{
				try {
					mostrarDetallePedido(request,response);
				} catch (SQLException | ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
			case "mostrarDetallePedidoJefe":{
				try {
					mostrarDetallePedidoJefe(request,response);
				} catch (SQLException | ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}

		}
	}
    
    
    
    
    public void buscarPedidos(HttpServletRequest request,HttpServletResponse response) throws SQLException, ServletException, IOException {
		String estado = request.getParameter("estado");
		List<Pedido> listaPedidos = objPedidoDAO.buscarPedidos(estado);
		System.out.println(Arrays.toString(listaPedidos.toArray()));
		request.setAttribute("listaPedidos", listaPedidos);
		String nuevaPagina = "/gestionPedidos.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nuevaPagina);
		dispatcher.forward(request, response);
	}
    
    public void buscarAllPedidos(HttpServletRequest request,HttpServletResponse response) throws SQLException, ServletException, IOException {
		List<Pedido> listadoPedidos = objPedidoDAO.buscarAllPedidos();
		request.setAttribute("listadoPedidos", listadoPedidos);
		System.out.println(Arrays.toString(listadoPedidos.toArray()));
		String nuevaPagina = "/gestionJefe.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nuevaPagina);
		dispatcher.forward(request, response);
	}
    
    
    public void editarPedido(HttpServletRequest request,HttpServletResponse response) throws SQLException, ServletException, IOException {
		int codigoPedido = Integer.parseInt(request.getParameter("codigoPedido"));
		Pedido objPedido = objPedidoDAO.buscarPedido(codigoPedido);
		request.setAttribute("objPedido", objPedido);
		String nuevaPagina = "/editarPedido.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nuevaPagina);
		dispatcher.forward(request, response);
	}
    
	
    public void mostrarDetallePedido(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
    	int codigoPedido = Integer.parseInt(request.getParameter("codigoPedido"));
		Pedido objPedido = objPedidoDAO.buscarPedido(codigoPedido);
		request.setAttribute("objPedido", objPedido);
		String nuevaPagina = "/detallePedido.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nuevaPagina);
		dispatcher.forward(request, response);
	}
    
    public void mostrarDetallePedidoJefe(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
    	int codigoPedido = Integer.parseInt(request.getParameter("codigoPedido"));
		Pedido objPedido = objPedidoDAO.buscarPedido(codigoPedido);
		request.setAttribute("objPedido", objPedido);
		String nuevaPagina = "/detallePedidoJefe.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nuevaPagina);
		dispatcher.forward(request, response);
	}
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opcion = request.getParameter("opcionPost");
		switch (opcion) {
			case "mostrarNuevoPedido":{
				mostrarNuevoPedido(request, response);
				break;
			}
			case "registrarPedido":{
				try {
					registrarPedido(request, response);
				} catch (SQLException | ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
			case "actualizarPedido": {
				try {
					actualizarPedido(request, response);
				} catch (SQLException | ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
			
			case "regresarGestionPedidos":{
				regresarGestionPedidos(request, response);
				break;
			}
			case "actualizarEstado":{
				try {
				actualizarEstado(request, response);
				} catch (SQLException | ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
    
   
    
    public void mostrarNuevoPedido(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nuevaPagina = "/nuevoPedido.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nuevaPagina);
		dispatcher.forward(request, response);
		
	}
    
    
    public void regresarGestionPedidos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nuevaPagina = "/gestionPedidos.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nuevaPagina);
		dispatcher.forward(request, response);
		
	}
    
    public void registrarPedido(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		String nombreCliente = request.getParameter("nombreCliente");
		String direccionCliente = request.getParameter("direccionCliente");
		String telefCliente = request.getParameter("telefCliente");
		String fecPedido = request.getParameter("fecPedido");
		String fecEntrega = request.getParameter("fecEntrega");
		String detalle = request.getParameter("detalle");
		objPedidoDAO.registrarPedido(nombreCliente, direccionCliente, telefCliente, fecPedido, fecEntrega, detalle);
		String nuevaPagina = "/gestionPedidos.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nuevaPagina);
		dispatcher.forward(request, response);
	}
	
	public void actualizarPedido(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		int codigoPedido = Integer.parseInt(request.getParameter("codigoPedido"));
		String nombreCliente = request.getParameter("nombreCliente");
		String direccionCliente = request.getParameter("direccionCliente");
		String telefCliente = request.getParameter("telefCliente");
		String fecPedido = request.getParameter("fecPedido");
		String fecEntrega = request.getParameter("fecEntrega");
		String detalle = request.getParameter("detalle");
		String estado = request.getParameter("estado");
		objPedidoDAO.actualizarPedido(codigoPedido, nombreCliente, direccionCliente, telefCliente, fecPedido, fecEntrega, detalle, estado);
		String nuevaPagina = "/gestionPedidos.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nuevaPagina);
		dispatcher.forward(request, response);
	}
	
	public void actualizarEstado(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		int codigoPedido = Integer.parseInt(request.getParameter("codigoPedido"));
		String estado = request.getParameter("estado");
		objPedidoDAO.actualizarEstado(codigoPedido,estado);
		List<Pedido> listadoPedidos = objPedidoDAO.buscarAllPedidos();
		request.setAttribute("listadoPedidos", listadoPedidos);
        String nuevaPagina = "/gestionJefe.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nuevaPagina);
		dispatcher.forward(request, response);
	}
    
    
	
}
