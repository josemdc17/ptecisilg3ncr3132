<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	<body>
		<h1>Nuevo Proveedor</h1>
		<br>
		<br>
		<form action="proveedor" method="POST">
			<input type="hidden" name="opcionPost" value="registrarProveedor">
			Razón Social: <input type="text" name="razSoc"><br><br>
			RUC: <input type="text" name="ruc"><br><br>
			Direccion: <input type="text" name="direccion"><br><br>
			Teléfono: <input type="text" name="telefono"><br><br>
			Estado: <select name="estado">
							  <option value="Activo">Activo</option>
							  <option value="Inactivo">Inactivo</option>
					</select><br><br>		
			<button>Grabar</button>
		</form>
	</body>
</html>