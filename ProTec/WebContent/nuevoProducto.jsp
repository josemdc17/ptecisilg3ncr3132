<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>EDITAR PRODUCTOS</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
  	<link rel="stylesheet" href="resources/css/bootstrap.css"/>
	</head>
	<body style="margin:30px; background-color: #f5ede9">
	<div class="contenedor">
		<img class="background-image" src="resources/images/llama.png" style="position: absolute;height: 60%; bottom: 0; margin-left:15%; z-index: -1;">
	<div style="text-align: right;">
		<form action="producto" method="POST">
				<input type="hidden" name="opcionPost" value="regresarGestionProducto">
				<button style="border-radius: 7px; background-color: #119e44; border-style: solid; border-color:green; color:white">Regresar</button>
		</form>
	</div>
			<h1>Nuevo Producto</h1>
			<br>
			<br>
			<form action="producto" method="POST">
				<div class="row">
					<input type="hidden" name="opcionPost" value="registrarProducto">
					<div class="col-2"></div>
					<div class="col-4">
						<h5>Nombre</h5>
							<input type="text" class="form-control" name="nombre" value="${objProducto.nombre}">
						<br>
						<h5>Categoria</h5>
							<input type="text" class="form-control" name="categoria" value="${objProducto.categoria}">
						<br>
						<h5>Unidad Medida</h5>
							<input type="text" class="form-control" name="unidMed" value="${objProducto.unidMed}">
						<br>
						<h5>Fecha Vencimiento</h5>
							<input type="text" class="form-control" name="fecVenc" value="${objProducto.fecVenc}">
						<br>
					</div>
					<div class="col-4">
						<h5>Peso</h5>
							<input type="text" class="form-control" name="peso" value="${objProducto.peso}">
						<br>
						<h5>Código Proveedor</h5>
							<input type="text" class="form-control" name="codProveedor" value="${objProducto.codProveedor}">
						<br>
						<h5>Estado:</h5> <select class="form-select" name="estado">
							  <option value="Disponible">Disponible</option>
							  <option value="No Disponible">No Disponible</option>
						</select><br><br>	
					</div>		
					<div class="col-2"></div>
					<div style="text-align: center">	
						<button  style="width:150px; justify-content: center; border-radius: 7px; background-color: #119e44; border-style: solid; border-color:green; color:white">Grabar</button> 
					</div>
				</div>
			</form>
			</div>
	</body>
</html>