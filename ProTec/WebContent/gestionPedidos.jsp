<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h1>Gestión de Pedidos</h1>
		<br>
		<br>
		<h2>Criterios de Búsqueda</h2>
		<br>
		<br>
		<form action="usuario" method="GET">
			<input type="hidden" name="opcionGet" value="buscarUsuarios">
			Pedido: <select name="perfil">
						  <option value="Completos">Completos</option>
						  <option value="Incompletos">Incompletos</option>
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
				<td>Fecha</td>
				<td>Costo Total</td>
				<td>Acciones</td>
			</tr>
			<c:forEach items="${listaUsuarios}" var="objUsuario">
				<tr>
					<td>${objUsuario.codigo}</td>
					<td>${objUsuario.correo}</td>
					<td>${objUsuario.costototal}</td>
					<td><a href="usuario?opcionGet=editarUsuario&codigo=${objUsuario.codigo}">Inspeccionar</a>
					<td><a href="usuario?opcionGet=editarUsuario&codigo=${objUsuario.codigo}">Editar</a>
					<a href="usuario?opcionGet=eliminarUsuario&codigo=${objUsuario.codigo}">Eliminar</a></td>
			</tr>
			</c:forEach>
		</table>
		<br>
		<br>
		<form action="usuario" method="POST">
			<input type="hidden" name="opcionPost" value="mostrarNuevoUsuario">
			<button>AÑADIR PEDIDO</button>
		</form>
		<br>
		<br>
		<form action="home" method="GET">
			<input type="hidden" name="opcionGet" value="mostrarPrincipal">
			<button>VOLVER</button>
		</form>
	</body>
</html>