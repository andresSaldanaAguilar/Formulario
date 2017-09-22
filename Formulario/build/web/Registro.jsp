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

	<form action="RegistroServlet" method="post" id="registro">
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
	</form>
          
        <div class="form-group">
            <select name="idSexo" form="registro" class="form-control">
                <option value="0"><%=(String)request.getAttribute("Sexo0")%></option>
                <option value="1"><%=(String)request.getAttribute("Sexo1")%></option>
            </select>
        </div>
                    
        <button form="registro" type="submit" class="btn btn-primary col-md-4" style="margin: 0 auto;">Registrar</button>
        <a href="index.jsp" class="btn btn-danger col-md-2 col-md-offset-6">Regresar</a>
	
</div>
</body>

</html>

