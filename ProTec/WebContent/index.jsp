<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>LOGIN</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
	<link rel="stylesheet" href="resources/css/bootstrap.css"/>
</head>
<body style="background-color: #f5ede9">
	<div class="container">
    	<div class="row" style="position:absolute; top:50%; transform:translateY(-50%); margin-top:0">
    		<div class="col-5">
				<form action="home" method="POST">
					<input type="hidden" name="opcionPost" value="validarUsuario">
					<label class="form-label">Usuario</label>
				 	<input type="text" name="correo" class="form-control"><br>
				 	
				 	<label class="form-label">Contraseña</label>
				  	<input type="password" name="password" class="form-control"><br>
				  	
				  	<button type="submit" class="btn btn-primary" style="background-color: #119e44; border:green">Ingresar</button>
				</form>
			</div>
			
    		<div class="col-1"></div>
    		<div class="col-6">
    		<img src="resources/images/logo.png" style="height: 150px"> </div>
    	</div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
  </body>
</html>