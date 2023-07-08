package com.protec.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.protec.dao.PedidoDAO;
import com.protec.dao.UsuarioDAO;
import com.protec.model.Pedido;

/**
 * Servlet implementation class Home
 */
@WebServlet("/home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	private PedidoDAO objPedidoDAO = new PedidoDAO();  
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opcion = request.getParameter("opcionGet");
		switch (opcion) {
			case "verGestionUsuarios": {
				verGestionUsuarios(request,response);
				break;
			}
			case "verGestionPedidos": {
				verGestionPedidos(request,response);
				break;
			}
			case "verGestionProveedores": {
				verGestionProveedores(request,response);
				break;
			}
			case "verGestionProductos": {
				verGestionProductos(request,response);
				break;
			}
		}
	}

	public void verGestionUsuarios(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nuevaPagina = "/gestionUsuarios.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nuevaPagina);
		dispatcher.forward(request, response);
	}
	
	public void verGestionPedidos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nuevaPagina = "/gestionPedidos.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nuevaPagina);
		dispatcher.forward(request, response);
	}
	
	public void verGestionProveedores(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nuevaPagina = "/gestionProveedores.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nuevaPagina);
		dispatcher.forward(request, response);
	}
	
	public void verGestionProductos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nuevaPagina = "/gestionProductos.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nuevaPagina);
		dispatcher.forward(request, response);
	}
	public void mostrarPrincipal(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nuevaPagina = "/principal.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nuevaPagina);
		dispatcher.forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opcion = request.getParameter("opcionPost");
		switch (opcion) {
			case "validarUsuario" : {
				try {
					validarUsuario(request,response);
				} catch (SQLException | ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
		}
	}
	
	private void validarUsuario(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
	    String nuevaPagina;
	    String correo = request.getParameter("correo");
	    String password = request.getParameter("password");
	    String perfil = usuarioDAO.validarUsuario(correo, password);
	    if (perfil.equals("Administrativo")) {
	        nuevaPagina = "/principal.jsp";
	    } else if (perfil.equals("Jefe")) {
	    	List<Pedido> listadoPedidos = objPedidoDAO.buscarAllPedidos();
			request.setAttribute("listadoPedidos", listadoPedidos);
	        nuevaPagina = "/gestionJefe.jsp";
	    } else {
	        nuevaPagina = "/index.jsp?error=1";
	    }
	    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nuevaPagina);
	    dispatcher.forward(request, response);
	}

}
