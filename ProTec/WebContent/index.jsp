<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>Sistema Web ISIL</h1>
		<br>
		<br>
		<!-- Recordar que en el action va el nombre del controller (servlet) al cual vamos a llamar para
		ejecutar el proceso -->
		<form action="home" method="POST">
			<input type="hidden" name="opcionPost" value="validarUsuario">
			Usuario: <input type="text" name="correo"><br><br>
			Contraseña: <input type="password" name="password"><br><br>
			<button>Ingresar</button>
		</form>
	</body>
</html>