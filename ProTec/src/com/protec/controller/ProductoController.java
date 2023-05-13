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
import com.protec.dao.ProductoDAO;
import com.protec.model.Proveedor;
import com.protec.model.Producto;


@WebServlet("/producto")
public class ProductoController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
    private ProductoDAO objProductoDAO = new ProductoDAO();   
	

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductoController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opcion = request.getParameter("opcionGet");
		switch (opcion) {
			case "buscarProductos":{
				try {
					buscarProductos(request,response);
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
			case "editarProducto":{
				try {
					editarProducto(request,response);
				} catch (SQLException | ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}

		}
	}
    
    public void buscarProductos(HttpServletRequest request,HttpServletResponse response) throws SQLException, ServletException, IOException {
		String estado = request.getParameter("estado");
		List<Producto> listaProductos = objProductoDAO.buscarProductos(estado);
		request.setAttribute("listaProductos", listaProductos);
		String nuevaPagina = "/gestionProductos.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nuevaPagina);
		dispatcher.forward(request, response);
	}
    
	/*
	 * public void eliminarProducto(HttpServletRequest request,HttpServletResponse
	 * response) throws SQLException, ServletException, IOException { int
	 * codProducto= Integer.parseInt(request.getParameter("codigoProducto"));
	 * objProductoDAO.eliminarProducto(codProducto); String nuevaPagina =
	 * "/gestionProductos.jsp"; RequestDispatcher dispatcher =
	 * getServletContext().getRequestDispatcher(nuevaPagina);
	 * dispatcher.forward(request, response); }
	 */
    
    public void editarProducto(HttpServletRequest request,HttpServletResponse response) throws SQLException, ServletException, IOException {
		int codProducto = Integer.parseInt(request.getParameter("codigoProducto"));
		Producto objProducto = objProductoDAO.buscarProducto(codProducto);
		request.setAttribute("objProducto", objProducto);
		String nuevaPagina = "/editarProducto.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nuevaPagina);
		dispatcher.forward(request, response);
	}
    
    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opcion = request.getParameter("opcionPost");
		switch (opcion) {
			case "mostrarNuevoProducto":{
				mostrarNuevoProducto(request, response);
				break;
			}
			case "registrarProducto":{
				try {
					registrarProducto(request, response);
				} catch (SQLException | ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
			case "actualizarProducto": {
				try {
					actualizarProducto(request, response);
				} catch (SQLException | ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
		}
	}
    
    
    public void mostrarNuevoProducto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nuevaPagina = "/nuevoProducto.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nuevaPagina);
		dispatcher.forward(request, response);
		
	}
	
	public void registrarProducto(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		String nombre = request.getParameter("nombre");
		int categoria = Integer.parseInt(request.getParameter("categoria"));
		String unidMed = request.getParameter("unidMed");
		String fecVenc = request.getParameter("fecVenc");
		String peso = request.getParameter("peso");
		int codProveedor = Integer.parseInt(request.getParameter("codProveedor"));
		objProductoDAO.registrarProducto(nombre, categoria, unidMed, fecVenc, peso, codProveedor);
		String nuevaPagina = "/gestionProductos.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nuevaPagina);
		dispatcher.forward(request, response);
	}
	
	public void actualizarProducto(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		int codProducto = Integer.parseInt(request.getParameter("codigoProducto"));
		String nombre = request.getParameter("nombre");
		int categoria = Integer.parseInt(request.getParameter("categoria"));
		String unidMed = request.getParameter("unidMed");
		String fecVenc = request.getParameter("fecVenc");
		String peso = request.getParameter("peso");
		int codProveedor = Integer.parseInt(request.getParameter("codProveedor"));
		String estado = request.getParameter("estado");
		objProductoDAO.actualizarProducto(codProducto, nombre, categoria, unidMed, fecVenc, peso, codProveedor, estado);
		String nuevaPagina = "/gestionProductos.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nuevaPagina);
		dispatcher.forward(request, response);
	}
    

	
}
