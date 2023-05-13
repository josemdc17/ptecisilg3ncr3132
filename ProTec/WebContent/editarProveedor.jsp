<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	<body>
		<h1>Editar Proveedor</h1>
			<br>
			<br>
			<form action="proveedor" method="POST">
				<input type="hidden" name="opcionPost" value="actualizarProveedor">
				Codigo Proveedor: <input type="text" name="codigoProveedor" value="${objProveedor.codigoProveedor}" readonly><br><br>
				Razón Social: <input type="text" name="razSoc" value="${objProveedor.razSoc}"><br><br>
				RUC: <input type="text" name="ruc" value="${objProveedor.ruc}"><br><br>
				Direccion: <input type="text" name="direccion" value="${objProveedor.direccion}"><br><br>
				Teléfono: <input type="text" name="telefono" value="${objProveedor.telefono}"><br><br>
				Estado: <select name="estado">
								<option value="Activo">Activo</option>
							  	<option value="Inactivo">Inactivo</option>
						</select><br><br>		
				<button>Grabar</button>
			</form>
	</body>
</html>