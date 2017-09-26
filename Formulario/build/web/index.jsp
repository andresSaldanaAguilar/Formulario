<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Inicio</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="Resources/bootstrap-3.3.7-dist/css/bootstrap.min.css">
  <link rel="stylesheet" href="Resources/font-awesome-4.7.0/css/font-awesome.css">   
  <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
  <link rel="stylesheet" href="Resources/Styles.css">  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="Resources/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

</head>
<body style="background-color:#D8D8D8">

<div class="container"  style="padding:6% 0% 0% 0%;">
       <div class="panel panel-default" >
            
            <div class="panel-body">
                <div class="container" style="padding:5% 0% 5% 15%">
                <div style="float: left">
                    <h1 style="color:#3D77E3"><i class="fa fa-address-book-o fa-5x" aria-hidden="true"></i><h1>
                </div>
                
                <div style="float: left; padding-left: 10%">
                <legend><h1>Sistema de registro y consulta</h1></legend>
                <h4 style="padding-bottom:10%;">Selecciona opcion para continuar:</h4>
                <form action="CargaServlet" method="post">
                    <div class="row">
                        <div class="col-md-offset-4 col-md-4 col-md-offset-4">
                            <button type="submit" class="btn btn-lg btn-primary">Registrar Usuario</button>
                        </div>
                    </div>
                </form>
                <br>

                <div class="row">
                        <div class="col-md-offset-4 col-md-4 col-md-offset-4">
                            <a type="submit" class="btn btn-lg btn-primary" href="Consulta.jsp">Consultar Usuario</a>
                        </div>
                </div>
                </div>
                </div>
            </div>
       </div>
</div>
</body>
</html>

