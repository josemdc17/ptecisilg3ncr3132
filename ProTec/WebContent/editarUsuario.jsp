<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>Editar Usuario</h1>
			<br>
			<br>
			<form action="usuario" method="POST">
				<input type="hidden" name="opcionPost" value="actualizarUsuario">
				Codigo: <input type="text" name="codigo" value="${objUsuario.codigo}" readonly><br><br>
				Correo: <input type="text" name="correo" value="${objUsuario.correo}"><br><br>
				Password: <input type="password" name="password" value="${objUsuario.password}"><br><br>
				Perfil: <select name="perfil">
								  <option value="Colaborador">Colaborador</option>
								  <option value="Administrativo">Administrativo</option>
						</select><br><br>
				Estado: <select name="estado">
								  <option value="Activo">Activo</option>
								  <option value="Inactivo">Inactivo</option>
						</select><br><br>			
				<button>Grabar</button>
			</form>
	</body>
</html>