<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>PRODUCTOS</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
  	<link rel="stylesheet" href="resources/css/bootstrap.css"/>
  	<script type="text/javascript">
	  	function mostrarMotivoDeCambio(codigoProducto) {
	  	    var motivo = prompt("Por favor, ingrese el motivo del cambio:");
	  	    if (motivo != null && motivo != "") {
	  	        // Redirigir a la página de edición de producto y pasar el motivo como parámetro
	  	        window.location.href = "producto?opcionGet=editarProducto&codigoProducto=" + codigoProducto + "&motivo=" + encodeURIComponent(motivo);
	  	    }
	  	    else{
	  	    	alert("Motivo obligatorio si quiere realizar algún cambio")
	  	    }
	  	}
	</script>
  </head>
<body style="margin:50px; background-color: #f5ede9">
		<div style="text-align: right;">
			<form action="producto" method="GET">
				<input type="hidden" name="opcionGet" value="mostrarPrincipal">
				<button style="border-radius: 7px; background-color: #119e44; border-style: solid; border-color:green; color:white">Regresar</button>
			</form>
		</div>
		<h1>Gestión de Productos</h1>
		<br>
		<br>
		<h2>Criterios de Búsqueda</h2>
		<br>
		<form action="producto" method="GET">
			<input type="hidden" name="opcionGet" value="buscarProductos">
			<div class="row">
				<div class="col-2">
				<h5>Estado:</h5> <select class="form-select" name="estado">
							  <option selected>Seleccione el estado</option>
							  <option value="Disponible">Disponible</option>
							  <option value="No Disponible">No Disponible</option>
						</select><br>
				<button style="border-radius: 7px; background-color: #119e44;border-style: solid; border-color:green; color:white">Buscar</button>
				</div>
			</div>
		</form>
		<br>
		<br>
		<h2>Resultados de Búsqueda</h2>
		<br>
		<br>
		<table class="table">
			<tr>
				<td scope="col">Codigo</td>
				<td scope="col">Nombre</td>
				<td scope="col">Categoria</td>
				<td scope="col">Unidad Medida</td>
				<td scope="col">Fecha de Vencimiento</td>
				<td scope="col">Peso</td>
				<td scope="col">Proveedor</td>
				<td scope="col">Estado</td>
				<td scope="col">Acciones</td>		
			</tr>
			<c:forEach items="${listaProductos}" var="objProducto">
				<tr>
					<td scope="row">${objProducto.codigoProducto}</td>
					<td>${objProducto.nombre}</td>
					<td>${objProducto.categoria}</td>
					<td>${objProducto.unidMed}</td>
					<td>${objProducto.fecVenc}</td>
					<td>${objProducto.peso}</td>
					<td>${objProducto.codProveedor}</td>
					<td>${objProducto.estado}</td>
					<td><a href="producto?opcionGet=editarProducto&codigoProducto=${objProducto.codigoProducto}">Editar</a>
						<%--<a href="javascript:mostrarMotivoDeCambio(${objProducto.codigoProducto})">Motivo</a>
					<%-- <a href="producto?opcionGet=eliminarProducto&codigoProducto=${objProducto.codigoProducto}">Eliminar</a></td> --%>
				</tr>
			</c:forEach>
		</table>
		<br>
		<br>
		<form action="producto" method="POST">
			<input type="hidden" name="opcionPost" value="mostrarNuevoProducto">
			<button style="border-radius: 7px; background-color: #119e44; border-style: solid; border-color:green; color:white">AÑADIR PRODUCTO</button>
		</form>
	</body>
</html>