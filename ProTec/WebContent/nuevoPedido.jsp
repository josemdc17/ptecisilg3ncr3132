<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>EDITAR PEDIDOS</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
  	<link rel="stylesheet" href="resources/css/bootstrap.css"/>
  	<script>
		function mostrarFechaActual() {
			var campoFecha = document.getElementById("fecPedido");
			var fechaActual = new Date();
			var dia = String(fechaActual.getDate()).padStart(2, '0');
			var mes = String(fechaActual.getMonth() + 1).padStart(2, '0');
			var año = fechaActual.getFullYear();
			var fecha = dia + '-' + mes + '-' + año;
			campoFecha.value = fecha;
		}
	</script>
	</head>
	<body onload="mostrarFechaActual()" style="margin:30px; background-color: #f5ede9">
	<div class="contenedor">
		<img class="background-image" src="resources/images/llama.png" style="position: absolute;height: 60%; bottom: 0; margin-left:15%; z-index: -1;">
	<div style="text-align: right;">
		<form action="pedido" method="POST">
				<input type="hidden" name="opcionPost" value="regresarGestionPedidos">
				<button style="border-radius: 7px; background-color: #119e44; border-style: solid; border-color:green; color:white">Regresar</button>
		</form>
	</div>
			<h1>Nuevo Pedido</h1>
			<br>
			<br>
			<form action="pedido" method="POST">
				<div class="row" >
					<input type="hidden" name="opcionPost" value="registrarPedido">
					<div class="col-2"></div>
					<div class="col-4">
						<h5>Nombre del Cliente</h5>
							<input type="text" class="form-control" name="nombreCliente">
						<br>
						<h5>Dirección del Cliente</h5>
							<input type="text" class="form-control" name="direccionCliente">
						<br>
						<h5>Teléfono del Cliente</h5>
							<input type="text" class="form-control" name="telefCliente">
						<br>
						<h5>Fecha Del Pedido</h5>
							<input type="text" class="form-control" name="fecPedido" id="fecPedido" readonly>
						<br>
						<h5>Fecha De Entrega</h5>
							<input type="text" class="form-control" name="fecEntrega">
						<br>
					</div>
					<div class="col-4">
						<h5>Productos del Pedido</h5>
							<input type="text" class="form-control" name="detalle" style="width: 550px; height: 100px;"">
						<br>
					
						<h5>Estado del Pedido:</h5> <select class="form-select" name="estado">
							  <option value="Programado">Programado</option>
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