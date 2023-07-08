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
  	<style>
  	.custom-button {
	border-radius: 7px;
	border-style: solid;
	border-color: green;
	color: white;
	background-color: #119e44;
}

.custom-button:disabled {
	background-color: #555;
	border-color: #555;
}</style>
</head>
<body style="margin:50px; background-color: #f5ede9">
		<h1>Lista de Pedidos - Almacén</h1>
		<br>
		<br>
		<br>
		<br>
		<table class="table">
			<tr>
				<td scope="col">Numero de Pedido</td>
				<td scope="col">Estado</td>
				<td scope="col">Fecha de Entrega</td>			
			</tr>
			<c:forEach items="${listadoPedidos}" var="objPedido">
				<tr>
					<td scope="row">${objPedido.numPedido}</td>
					<td>${objPedido.estado}</td>
					<td>${objPedido.fecEntrega}</td>
					<td><a href="pedido?opcionGet=mostrarDetallePedidoJefe&codigoPedido=${objPedido.codigoPedido}">Inspeccionar</a>
 					<td><form action="pedido" method="POST">
							<input type="hidden" name="opcionPost" value="actualizarEstado">
							<input type="hidden" name="codigoPedido" value="${objPedido.codigoPedido}">
							<input type="hidden" name="estado" value="${objPedido.estado}">
							<button class="custom-button" ${objPedido.estado == 'Entregado' ? 'disabled' : ''}>CAMBIAR ESTADO</button>
						</form>
					</td>
					<%-- <a href="producto?opcionGet=eliminarProducto&codigoProducto=${objProducto.codigoProducto}">Eliminar</a></td> --%>
				</tr>
			</c:forEach>
		</table>
		<br>
		<br>
	</body>
</html>