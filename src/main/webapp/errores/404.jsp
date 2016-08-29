<%-- 
    Document   : 404
    Created on : 15/08/2016, 04:13:34
    Author     : alber
--%>
<%@include file="../vistas/init.jsp" %>
<%@page isErrorPage="true"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="../css/materialize.min.css"/>
        <link rel="stylesheet" type="text/css" href="../css/init.css"/>
        <script src="../js/jquery-3.1.0.min.js" type="text/javascript"></script>
        <script src="../js/materialize.min.js" type="text/javascript"></script>
        <script src="../js/init.js" type="text/javascript"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%= unaTienda.getNombre() %> | Error 404</title>
    </head>
    <body>
        <div class="row valign-wrapper">
            <div class="col s12 center">
                <h1>Ups... no tenemos lo que estás buscando :)</h1>
                <h3>Error 404 - File not found</h3>
            </div>
        </div>
    </body>
</html>
