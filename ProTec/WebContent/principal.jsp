<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <title>Página Principal</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 0;
      padding: 0;
    }

    header {
      padding: 20px;
      display: flex;
      justify-content: center;
      align-items: center;
    }

    .logo {
      margin: 0;
      padding: 0;
    }

    .container {
      max-width: 960px;
      margin: 20px auto;
      padding: 20px;
    }

    .button {
      display: inline-block;
      margin-right: 10px;
      padding: 10px 20px;
      background-color: #4CAF50;
      color: #fff;
      text-decoration: none;
      border-radius: 4px;
    }
  </style>
</head>
<body style="background-color: #f5ede9">
  <header>
    <img src="resources/images/logo.png" alt="Logo" class="logo">
  </header>

  <div class="container">
    <a href="home?opcionGet=verGestionUsuarios" class="button">Gestión de Colaboradores</a>
    <a href="home?opcionGet=verGestionPedidos" class="button">Gestión de Pedidos</a>
    <a href="home?opcionGet=verGestionProveedores" class="button">Gestión de Proveedores</a>
    <a href="home?opcionGet=verGestionProductos" class="button">Gestión de Productos</a>
  </div>
</body>
</html>