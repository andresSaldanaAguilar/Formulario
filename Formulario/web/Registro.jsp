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
  <title>Registro</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
  <link rel="stylesheet" href="Resources/Styles.css"> 
  <link rel="stylesheet" href="Resources/bootstrap-3.3.7-dist/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="Resources/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body style="background-color:#D8D8D8">

<div class="container" style="padding:1.7% 20% 0% 20%;">
	  
       <div class="panel panel-default">
            <div class="panel-heading">
            <h1>Registro de Usuario</h1>
            <h4>Ingresa los datos solicitados</h4>
            </div>
            <div class="panel-body">

            <form action="RegistroServlet" method="post" id="registro">
                    <div class="form-group">
                    <input type="text" class="form-control" id="nombre" placeholder="nombre(s)" name="nombre" required minlength="2" maxlength="50">
                    </div>
                    <div class="form-group">
                      <input type="text" class="form-control" id="apaterno" placeholder="apellido paterno" name="apaterno" required minlength="2" maxlength="50">
                    </div>
                    <div class="form-group">
                      <input type="text" class="form-control" id="amaterno" placeholder="apellido materno" name="amaterno" required minlength="2" maxlength="50">
                    </div>
                    <div class="form-group">
                      <input type="text" class="form-control" id="curp" placeholder="CURP" name="curp" required minlength="18" maxlength="18">
                    </div>
                    <div class="form-group">
                      <input type="date" class="form-control" id="f_nac" placeholder="fecha de nacimiento dd/mm/aaaa" name="f_nac" required min="1900-01-01" max="2016-12-31">
                    </div>
                    <div class="form-group">
                      <input type="email" class="form-control" id="email" placeholder="correo electrónico" name="email" required>
                    </div>             		
            </form>
            <label>Sexo</label>
            <div class="form-group">
                <select name="idSexo" form="registro" class="form-control">
                    <option value="0"><%=(String)request.getAttribute("Sexo0")%></option>
                    <option value="1"><%=(String)request.getAttribute("Sexo1")%></option>
                </select>
            </div>

            <button form="registro" type="submit" class="btn btn-primary col-md-4" style="margin: 0 auto;">Registrar</button>
            <a href="index.jsp" class="btn btn-danger col-md-2 col-md-offset-6">Regresar</a>
            </div>
            </div>
    </div>
        <%     
    //Registro existente
    if((String) request.getAttribute("mensajeDUP")!=null)
    {
       out.println("<script type=\"text/javascript\">");
       out.println("alert('El CURP ingresado ya ha sido registrado anteriormente.');");
       
       out.println("</script>");
    }
    //Error en la conexion de base de datos.
    if((String) request.getAttribute("mensajeERRBD")!=null)
    {
       out.println("<script type=\"text/javascript\">");
       out.println("alert('Error en la conexion de base de datos.');");
       //out.println("location='Registro.jsp';");
       out.println("</script>");
    }
    //Registro exitoso!
    if((String) request.getAttribute("mensajeEXITO")!=null)
    {
       out.println("<script type=\"text/javascript\">");
       out.println("alert('Registro exitoso!');");
       out.println("location='index.jsp';");
       out.println("</script>");
    }
%>	
        
</div>
</body>

</html>

