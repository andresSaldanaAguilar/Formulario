<%-- 
    Document   : Resultado
    Created on : 18/09/2017, 11:33:29 AM
    Author     : ANDRES
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Resultado encontrado</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="Resources/bootstrap-3.3.7-dist/css/bootstrap.min.css">
  <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
  <link rel="stylesheet" href="Resources/Styles.css"> 
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="Resources/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body style="background-color:#D8D8D8">

<div class="container" style="padding:5% 20%;">
    
    <div class="panel panel-default">
        <div class="panel-heading">
                <legend><h1>Datos obtenidos</h1></legend>
                <h4>Usuario registrado con la CURP:</h4>
                <text style="color:#3D77E3"><%=(String)request.getAttribute("CURP")%></text>
        </div>
        <div class="panel-body">
            <p><label>Nombre(s):</label><text> <%=(String)request.getAttribute("Nombre")%></text></p>
            <p><label>Apellidos:</label><text> <%=(String)request.getAttribute("Apellido_Paterno")%>  <%=(String)request.getAttribute("Apellido_Materno")%></text></p>
            <p><label>Fecha de nacimiento:</label><text> <%=(String)request.getAttribute("Fecha_Nacimiento")%></text></p>
            <p><label>Correo Electronico:</label><text> <%=(String)request.getAttribute("Correo")%></text></p>
            
            <%if(request.getAttribute("Sexo_idSexo").toString().equals("0")){%>
            <p><label>Sexo:</label><text> Masculino</text></p>
            <%}else{%>
            <p><label>Sexo:</label><text> Femenino</text></p>
            <%}%>
            
        </div>    
    </div>
    <a class="btn  btn-danger col-md-offset-5 col-md-2" href="Consulta.jsp">Regresar</a>
    </div>
</div>
</body>
</html>
