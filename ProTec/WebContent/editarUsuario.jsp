<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
  		<link rel="stylesheet" href="resources/css/bootstrap.css"/>
	</head>
	<body  style="margin:30px; background-color: #f5ede9">
	<div class="contenedor">
		<img class="background-image" src="resources/images/llama.png" style="position: absolute;height: 60%; bottom: 0; margin-left:15%; z-index: -1;">
		<div style="text-align: right;">
			<form action="usuario" method="POST">
					<input type="hidden" name="opcionPost" value="regresarGestionUsuario">
					<button style="border-radius: 7px; background-color: #119e44; border-style: solid; border-color:green; color:white">Regresar</button>
			</form>
		</div>
	<br>
		<h1>Editar Usuario</h1>
			<br>
			<br>
			<form action="usuario" method="POST">
				<div class="row">
					<input type="hidden" name="opcionPost" value="actualizarUsuario">
					<div class="col-2"></div>
					<div class="col-4">
							<h5>Codigo</h5>
							<input type="text" class="form-control" name="codigo" value="${objUsuario.codigo}" readonly>
						<br>
							<h5>Usuario</h5>
							<input type="text" class="form-control" name="correo" value="${objUsuario.correo}">
						<br>
							<h5>Password</h5>
							<input type="password" class="form-control" name="password" value="${objUsuario.password}">
						<br>
					</div>
					<div class="col-4">
							<h5>Perfil</h5> <select class="form-select" name="perfil">
							  <option value="Colaborador">Colaborador</option>
									  <option value="Administrativo">Administrativo</option>
						</select><br>
							<h5>Estado:</h5> <select class="form-select" name="estado">
							  <option value="Activo">Activo</option>
							  <option value="Inactivo">Inactivo</option>
						</select><br><br>
					</div>
					<div class="col-2"></div>			
					<div style="text-align: center">
						<button style="width:150px; justify-content: center; border-radius: 7px; background-color: #119e44; border-style: solid; border-color:green; color:white">Grabar</button>
					</div>
				</div>
			</form>
		</div>
	</body>
</html>