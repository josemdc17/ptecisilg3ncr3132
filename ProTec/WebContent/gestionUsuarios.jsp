<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
  		<link rel="stylesheet" href="resources/css/bootstrap.css"/>
	</head>
	<body style="margin:50px; background-color: #f5ede9">
		<div style="text-align: right;">
			<form action="usuario" method="GET">
			<input type="hidden" name="opcionGet" value="mostrarPrincipal">
			<button style="border-radius: 7px; background-color: #119e44; border-style: solid; border-color:green; color:white">Regresar</button>
			</form>
		</div>
		<h1>Gestión de Colaboradores</h1>
		<br>
		<br>
		<h2>Criterios de Búsqueda</h2>
		<br>
		<br>
		<form action="usuario" method="GET">
			<input type="hidden" name="opcionGet" value="buscarUsuarios">
			<div class="row">
				<div class="col-2">
					<h5>Perfil:</h5> <select class="form-select" name="perfil">
								  <option selected>Seleccione el perfil</option>
						<!--  <option value="Colaborador">Colaborador</option> -->
						  		<option value="Administrativo">Administrativo</option>
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
				<td scope="col">Usuario</td>
				<td scope="col">Estado</td>
				<td scope="col">Acciones</td>
			</tr>
			<c:forEach items="${listaUsuarios}" var="objUsuario">
				<tr>
					<td scope="row">${objUsuario.codigo}</td>
					<td>${objUsuario.correo}</td>
					<td>${objUsuario.estado}</td>
					<td><a href="usuario?opcionGet=editarUsuario&codigo=${objUsuario.codigo}">Editar</a>
					<%-- <a href="usuario?opcionGet=eliminarUsuario&codigo=${objUsuario.codigo}">Eliminar</a></td> --%>
			</tr>
			</c:forEach>
		</table>
		<br>
		<br>
		<form action="usuario" method="POST">
			<input type="hidden" name="opcionPost" value="mostrarNuevoUsuario">
			<button style="border-radius: 7px; background-color: #119e44; border-style: solid; border-color:green; color:white">AÑADIR USUARIO</button>
		</form>
	</body>
</html>