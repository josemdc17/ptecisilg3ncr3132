<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
  	<link rel="stylesheet" href="resources/css/bootstrap.css"/>
</head>
<body style="margin:50px; background-color: #f5ede9">
		<div style="text-align: right;">
			<form action="proveedor" method="GET">
			<input type="hidden" name="opcionGet" value="mostrarPrincipal">
			<button style="border-radius: 7px; background-color: #119e44; border-style: solid; border-color:green; color:white">Regresar</button>
		</form>
		</div>
		<h1>Gestión de Proveedores</h1>
		<br>
		<br>
		<h2>Criterios de Búsqueda</h2>
		<br>
		<form action="proveedor" method="GET">
			<input type="hidden" name="opcionGet" value="buscarProveedores">
			<div class="row">
				<div class="col-2">
					<h5>Estado:</h5> <select class="form-select" name="estado">
								  <option selected>Seleccione el estado</option>
								  <option value="Activo">Activo</option>
								  <option value="Inactivo">Inactivo</option>
							</select><br>
					<button style="border-radius: 7px; background-color: #119e44; border-style: solid; border-color:green; color:white">Buscar</button>
				</div>
			</div>
		</form>
		<br>
		<br>
		<h2>Resultados de Búsqueda</h2>
		<br>
		<br>
		<table  class="table">
			<tr>
				<td scope="col">Codigo</td>
				<td scope="col">Razon Social</td>
				<td scope="col">RUC</td>
				<td scope="col">Direccion</td>
				<td scope="col">Teléfono</td>
				<td scope="col">Acciones</td>
			</tr>
			<c:forEach items="${listaProveedores}" var="objProveedor">
				<tr>
					<td scope="row">${objProveedor.codigoProveedor}</td>
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
			<button style="border-radius: 7px; background-color: #119e44; border-style: solid; border-color:green; color:white">AÑADIR PROVEEDOR</button>
		</form>
	</body>
</html>