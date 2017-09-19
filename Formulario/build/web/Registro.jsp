<%-- 
    Document   : Registro
    Created on : 18/09/2017, 11:33:04 AM
    Author     : ANDRES
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.Connection"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="Resources/bootstrap-3.3.7-dist/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="Resources/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body style="background-color:#D8D8D8">

<div class="container" style="padding:5% 20%;">
	
	  <h1>Registro de Usuario</h1>
	  <h4>Ingresa los datos solicitados</h4>

	  <form action="RegistroServlet" method="post">
		<div class="form-group">
		  <input type="text" class="form-control" id="nombre" placeholder="nombre(s)" name="nombre">
		</div>
		<div class="form-group">
		  <input type="text" class="form-control" id="apaterno" placeholder="apellido paterno" name="apaterno">
		</div>
			<div class="form-group">
		  <input type="text" class="form-control" id="amaterno" placeholder="apellido materno" name="amaterno">
		</div>
		<div class="form-group">
		  <input type="text" class="form-control" id="curp" placeholder="CURP" name="curp">
		</div>
			<div class="form-group">
		  <input type="text" class="form-control" id="f_nac" placeholder="fecha de nacimiento dd/mm/aaaa" name="f_nac">
		</div>
		<div class="form-group">
		  <input type="email" class="form-control" id="email" placeholder="correo electrónico" name="email">
		</div>
		<div class="dropdown">
		  <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
			Sexo
			<span class="caret"></span>
		  </button>
		  <ul class="dropdown-menu form-group" aria-labelledby="dropdownMenu1">
			<li><a href="#"><label><% //traemos los datos de db%></label></a></li>
			<li><a href="#"><label><% //traemos los datos de db%></label></a></li>
		  </ul>
		</div>
		<br>
		<button type="submit" class="btn btn-lg btn-primary col-md-4" style="margin: 0 auto;">Registrar</button>

	  </form>
	
</div>
</body>

</html>

