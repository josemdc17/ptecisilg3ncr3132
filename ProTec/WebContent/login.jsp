<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>PRUEBA LOGIN</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
  	<link rel="stylesheet" href="resources/css/bootstrap.css"/>
  </head>
  <body>
    <div class="container">
    	<br>
    	<br>
    	<center><h1>LOGIN</h1></center><br><br><br>
    	
    	<div class="row">
    		<div class="col-2"></div>
    		<div class="col-4">
	    		<form action="home" method="POST">
	    		<input type="hidden" name="opcionPost" value="validarUsuario">
				  <label class="form-label">Usuario</label>
				  <input type="text" class="form-control"><br>
				  
				  <label class="form-label">Contrase�a</label>
				  <input type="password" class="form-control"><br>
				 
				  
				  <div class="mb-3 form-check">
				    <input type="checkbox" class="form-check-input" id="exampleCheck1">
				    <label class="form-check-label" for="exampleCheck1">Check me out</label>
				  </div>
				  <button type="submit" class="btn btn-primary">Ingresar</button>
				</form>
    		</div>
    		<div class="col-4"></div>
    		<div class="col-2"></div>
    	</div>
    	
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
  </body>
</html>