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
	<body style="margin:30px; background-color: #f5ede9">
		<div class="contenedor">
<!-- 		<img class="background-image" src="resources/images/llama.png" style="position: absolute;height: 60%; bottom: 0; margin-left:18%"> -->
			<div style="text-align: right;">
				<form action="usuario" method="POST">
						<input type="hidden" name="opcionPost" value="regresarGestionUsuario">
						<button style="border-radius: 7px; background-color: #119e44; border-style: solid; border-color:green; color:white">Regresar</button>
				</form>
			</div>
			<h1>Nuevo Usuario</h1>
			<br>
			<br>
			<form action="usuario" method="POST">
				<div class="row">
					<input type="hidden" name="opcionPost" value="registrarUsuario">
					<div class="col-5"></div>
					<div class="col-2">
						<h5>Usuario</h5>
						<input type="text" class="form-control" name="correo">
						<br>
						<h5>Password</h5>
						<input type="text" class="form-control" name="password">
						<br>
						<h5>Perfil:</h5> 
						<select class="form-select" name="perfil">
							<option value="Administrativo">Administrativo</option>
						</select><br><br>
					</div>
					<div class="col-5"></div>	
					
							<button  style="width:150px; margin-left:45%; justify-content: center; border-radius: 7px; background-color: #119e44; border-style: solid; border-color:green; color:white">Grabar</button> 
					
				</div>
			</form>
		</div>
	</body>
</html>