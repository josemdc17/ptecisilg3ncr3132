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

import com.protec.dao.UsuarioDAO;
import com.protec.model.Usuario;

/**
 * Servlet implementation class Usuario
 */
@WebServlet("/usuario")
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UsuarioDAO objUsuarioDAO = new UsuarioDAO();   
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opcion = request.getParameter("opcionGet");
		switch (opcion) {
			case "buscarUsuarios":{
				try {
					buscarUsuarios(request,response);
					break;
				} catch (SQLException | ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			case "eliminarUsuario":{
				try {
					eliminarUsuario(request,response);
				} catch (SQLException | ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
			case "editarUsuario":{
				try {
					editarUsuario(request,response);
				} catch (SQLException | ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
			case "mostrarPrincipal":{
				mostrarPrincipal(request,response);
				break;
			}
		}
	}

	public void buscarUsuarios(HttpServletRequest request,HttpServletResponse response) throws SQLException, ServletException, IOException {
		String perfil = request.getParameter("perfil");
		List<Usuario> listaUsuarios = objUsuarioDAO.buscarUsuarios(perfil);
		request.setAttribute("listaUsuarios", listaUsuarios);
		String nuevaPagina = "/gestionUsuarios.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nuevaPagina);
		dispatcher.forward(request, response);
	}
	
	public void eliminarUsuario(HttpServletRequest request,HttpServletResponse response) throws SQLException, ServletException, IOException {
		int codigoUsuario = Integer.parseInt(request.getParameter("codigo"));
		objUsuarioDAO.eliminarUsuario(codigoUsuario);
		String nuevaPagina = "/gestionUsuarios.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nuevaPagina);
		dispatcher.forward(request, response);
	}
	
	public void editarUsuario(HttpServletRequest request,HttpServletResponse response) throws SQLException, ServletException, IOException {
		int codigoUsuario = Integer.parseInt(request.getParameter("codigo"));
		Usuario objUsuario = objUsuarioDAO.buscarUsuario(codigoUsuario);
		request.setAttribute("objUsuario", objUsuario);
		String nuevaPagina = "/editarUsuario.jsp";
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
			case "mostrarNuevoUsuario":{
				mostrarNuevoUsuario(request, response);
				break;
			}
			case "registrarUsuario":{
				try {
					registrarUsuario(request, response);
				} catch (SQLException | ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
			case "actualizarUsuario": {
				try {
					actualizarUsuario(request, response);
				} catch (SQLException | ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
			case "regresarGestionUsuario":{
				regresarGestionUsuario(request, response);
				break;
			}
		}
	}
	
	public void mostrarNuevoUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nuevaPagina = "/nuevoUsuario.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nuevaPagina);
		dispatcher.forward(request, response);
		
	}
	
	public void regresarGestionUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nuevaPagina = "/gestionUsuarios.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nuevaPagina);
		dispatcher.forward(request, response);
		
	}
	
	
	public void registrarUsuario(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		String correo = request.getParameter("correo");
		String password = request.getParameter("password");
		String perfil = request.getParameter("perfil");
		objUsuarioDAO.registrarUsuario(correo, password, perfil);
		String nuevaPagina = "/gestionUsuarios.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nuevaPagina);
		dispatcher.forward(request, response);
	}
	
	public void actualizarUsuario(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		int codigoUsuario = Integer.parseInt(request.getParameter("codigo"));
		String correo = request.getParameter("correo");
		String password = request.getParameter("password");
		String perfil = request.getParameter("perfil");
		String estado = request.getParameter("estado");
		objUsuarioDAO.actualizarUsuario(codigoUsuario, correo, password, perfil, estado);
		String nuevaPagina = "/gestionUsuarios.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nuevaPagina);
		dispatcher.forward(request, response);
	}

}
