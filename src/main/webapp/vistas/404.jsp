<%-- 
    Document   : 404
    Created on : 15/08/2016, 04:13:34
    Author     : alber
--%>

<%@page isErrorPage="true"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="assets.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%= unaTienda.getNombre() %> | Error 404</title>
    </head>
    <body>
        <div class="row valign-wrapper">
            <div class="col s12 center">
                <h1>Ups... esto no debería haber sucedido :)</h1>
                <h3>Error 404 - File not found</h3>
            </div>
        </div>
    </body>
</html>
