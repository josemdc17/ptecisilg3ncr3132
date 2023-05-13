<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h1>Gestión de Proveedores</h1>
		<br>
		<br>
		<h2>Criterios de Búsqueda</h2>
		<br>
		<br>
		<form action="proveedor" method="GET">
			<input type="hidden" name="opcionGet" value="buscarProveedores">
			Estado: <select name="estado">
						  <option value="Activo">Activo</option>
						  <option value="Inactivo">Inactivo</option>
					</select>
			<button>Buscar</button>
		</form>
		<br>
		<br>
		<h2>Resultados de Búsqueda</h2>
		<br>
		<br>
		<table>
			<tr>
				<td>Codigo</td>
				<td>Razon Social</td>
				<td>RUC</td>
				<td>Direccion</td>
				<td>Teléfono</td>
				<td>Acciones</td>
			</tr>
			<c:forEach items="${listaProveedores}" var="objProveedor">
				<tr>
					<td>${objProveedor.codigoProveedor}</td>
					<td>${objProveedor.razSoc}</td>
					<td>${objProveedor.ruc}</td>
					<td>${objProveedor.direccion}</td>
					<td>${objProveedor.telefono}</td>
					<td><a href="proveedor?opcionGet=editarProveedor&codigoProveedor=${objProveedor.codigoProveedor}">Editar</a>
					<%-- <a href="?=${objProveedor.codigoProveedor}">Eliminar</a></td> --%>
				</tr>
			</c:forEach>
		</table>
		<br>
		<br>
		<form action="proveedor" method="POST">
			<input type="hidden" name="opcionPost" value="mostrarNuevoProveedor">
			<button>AÑADIR PROVEEDOR</button>
		</form>
	</body>
</html>