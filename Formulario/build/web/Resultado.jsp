<%-- 
    Document   : Resultado
    Created on : 18/09/2017, 11:33:29 AM
    Author     : ANDRES
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
	
	  <legend><h1>Datos obtenidos</h1></legend>
	  <h4 style="padding-bottom:10%;">Usuario registrado con la CURP:</h4>
		<p>Nombre(s):</p> <label><% //traemos los datos de db%></label>
		<p>Apellidos:</p> <label><% //traemos los datos de db%></label>
		<p>Fecha de nacimiento:</p> <label><% //traemos los datos de db%></label>
		<p>Correo Electronico:</p> <label><% //traemos los datos de db%></label>
		<p>Sexo:</p>
	<br>
	<br>
	<div class="row">
		<div class="col-md-offset-4 col-md-4 col-md-offset-4">
			<button type="submit" class="btn btn-lg btn-primary">Regresar</button>
		</div>
	</div>
</div>
</body>
</html>
