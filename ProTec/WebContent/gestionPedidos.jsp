<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>PEDIDOS</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
  	<link rel="stylesheet" href="resources/css/bootstrap.css"/>
  	
</head>
<body style="margin:50px; background-color: #f5ede9">
		<div style="text-align: right;">
			<form action="producto" method="GET">
				<input type="hidden" name="opcionGet" value="mostrarPrincipal">
				<button style="border-radius: 7px; background-color: #119e44; border-style: solid; border-color:green; color:white">Regresar</button>
			</form>
		</div>
		<h1>Gestión de Pedidos</h1>
		<br>
		<br>
		<h2>Criterios de Búsqueda</h2>
		<br>
		<form action="pedido" method="GET">
			<input type="hidden" name="opcionGet" value="buscarPedidos">
			<div class="row">
				<div class="col-2">
				<h5>Estado:</h5> <select class="form-select" name="estado">
							  <option value="Programado">Programado</option>
							  <option value="En Preparacion">En Preparacion</option>
							  <option value="Entregado">Entregado</option>
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
				<td scope="col">Número de Pedido</td>
				<td scope="col">Fecha del Pedido</td>
				<td scope="col">Fecha de Entrega</td>			
			</tr>
			<c:forEach items="${listaPedidos}" var="objPedido">
				<tr>
					<td scope="row">${objPedido.numPedido}</td>
					<td>${objPedido.fecPedido}</td>
					<td>${objPedido.fecEntrega}</td>
					<td><a href="pedido?opcionGet=mostrarDetallePedido&codigoPedido=${objPedido.codigoPedido}">Inspeccionar</a>
 					<td><a href="pedido?opcionGet=editarPedido&codigoPedido=${objPedido.codigoPedido}">Editar</a>
					<%-- <a href="producto?opcionGet=eliminarProducto&codigoProducto=${objProducto.codigoProducto}">Eliminar</a></td> --%>
				</tr>
			</c:forEach>
		</table>
		<br>
		<br>
		<form action="pedido" method="POST">
			<input type="hidden" name="opcionPost" value="mostrarNuevoPedido">
			<button style="border-radius: 7px; background-color: #119e44; border-style: solid; border-color:green; color:white">AÑADIR PEDIDO</button>
		</form>
		<br>
		<br>
	</body>
</html>