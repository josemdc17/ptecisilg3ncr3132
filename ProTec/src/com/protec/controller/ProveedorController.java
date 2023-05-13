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

import com.protec.dao.ProveedorDAO;
import com.protec.dao.UsuarioDAO;
import com.protec.model.Proveedor;
import com.protec.model.Usuario;


@WebServlet("/proveedor")
public class ProveedorController extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
    private ProveedorDAO objProveedorDAO = new ProveedorDAO();   
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProveedorController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opcion = request.getParameter("opcionGet");
		switch (opcion) {
			case "buscarProveedores":{
				try {
					buscarProveedores(request,response);
					break;
				} catch (SQLException | ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			case "editarProveedor":{
				try {
					editarProveedor(request,response);
				} catch (SQLException | ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}

		}
	}
    
    public void buscarProveedores(HttpServletRequest request,HttpServletResponse response) throws SQLException, ServletException, IOException {
		String estado = request.getParameter("estado");
		List<Proveedor> listaProveedores = objProveedorDAO.buscarProveedores(estado);
		request.setAttribute("listaProveedores", listaProveedores);
		String nuevaPagina = "/gestionProveedores.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nuevaPagina);
		dispatcher.forward(request, response);
	}
    
    public void editarProveedor(HttpServletRequest request,HttpServletResponse response) throws SQLException, ServletException, IOException {
		int codigoProveedor = Integer.parseInt(request.getParameter("codigoProveedor"));
		Proveedor objProveedor = objProveedorDAO.buscarProveedor(codigoProveedor);
		request.setAttribute("objProveedor", objProveedor);
		String nuevaPagina = "/editarProveedor.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nuevaPagina);
		dispatcher.forward(request, response);
	}
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opcion = request.getParameter("opcionPost");
		switch (opcion) {
			case "mostrarNuevoProveedor":{
				mostrarNuevoProveedor(request, response);
				break;
			}
			case "registrarProveedor":{
				try {
					registrarProveedor(request, response);
				} catch (SQLException | ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
			case "actualizarProveedor": {
				try {
					actualizarProveedor(request, response);
				} catch (SQLException | ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
		}
	}
    
    public void mostrarNuevoProveedor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nuevaPagina = "/nuevoProveedor.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nuevaPagina);
		dispatcher.forward(request, response);
		
	}
    
    public void registrarProveedor(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
    	String razSoc = request.getParameter("razSoc");
		String ruc = request.getParameter("ruc");
		String direccion = request.getParameter("direccion");
		String telefono = request.getParameter("telefono");
		objProveedorDAO.registrarProveedor(razSoc, ruc, direccion, telefono);
		String nuevaPagina = "/gestionProveedores.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nuevaPagina);
		dispatcher.forward(request, response);
	}
	
	public void actualizarProveedor(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		int codigoProveedor= Integer.parseInt(request.getParameter("codigoProveedor"));
		String razSoc = request.getParameter("razSoc");
		String ruc = request.getParameter("ruc");
		String direccion = request.getParameter("direccion");
		String telefono = request.getParameter("telefono");
		String estado = request.getParameter("estado");
		objProveedorDAO.actualizarProveedor(codigoProveedor, razSoc, ruc, direccion, telefono , estado);
		String nuevaPagina = "/gestionProveedores.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nuevaPagina);
		dispatcher.forward(request, response);
	}
    
    
}
