<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>Gestión de Colaboradores</h1>
		<br>
		<br>
		<h2>Criterios de Búsqueda</h2>
		<br>
		<br>
		<form action="usuario" method="GET">
			<input type="hidden" name="opcionGet" value="buscarUsuarios">
			Perfil: <select name="perfil">
						  <option value="Colaborador">Colaborador</option>
						  <option value="Administrativo">Administrativo</option>
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
				<td>Usuario</td>
				<td>Estado</td>
				<td>Acciones</td>
			</tr>
			<c:forEach items="${listaUsuarios}" var="objUsuario">
				<tr>
					<td>${objUsuario.codigo}</td>
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
			<button>AÑADIR USUARIO</button>
		</form>
	</body>
</html>