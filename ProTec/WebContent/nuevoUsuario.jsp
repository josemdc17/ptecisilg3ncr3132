<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>Nuevo Usuario</h1>
		<br>
		<br>
		<form action="usuario" method="POST">
			<input type="hidden" name="opcionPost" value="registrarUsuario">
			Correo: <input type="text" name="correo"><br><br>
			Password: <input type="password" name="password"><br><br>
			Perfil: <select name="perfil">
							  <option value="Colaborador">Colaborador</option>
							  <option value="Administrativo">Administrativo</option>
					</select><br><br>		
			<button>Grabar</button>
		</form>
	</body>
</html>