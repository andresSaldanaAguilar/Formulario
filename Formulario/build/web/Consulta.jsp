<%-- 
    Document   : Consulta
    Created on : 18/09/2017, 11:32:30 AM
    Author     : ANDRES-
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
    
    
    <div class="panel panel-default">
        <div class="panel-heading">
            <legend><h1>Consulta de usuario</h1></legend>
	    <h4>Ingrese la CURP del usuario que desea  buscar:</h4>
        </div>
        <div class="panel-body">
            <form action="ConsultaServlet" method="post">
                <div class="form-group">
                    <input type="text" class="form-control" id="CURP" name="CURP" placeholder="CURP" required>
                </div>
                <button type="submit" class="btn  btn-primary col-md-offset-4 col-md-4 ">Consultar</button>
            </form>
        </div>
    </div>
    <br>
        <a class="btn  btn-danger col-md-2" href="index.jsp">Regresar</a>
</div>
</body>
</html>
