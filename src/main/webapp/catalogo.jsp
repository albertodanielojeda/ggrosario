<%-- 
    Document   : categoria
    Created on : 30/08/2016, 17:50:34
    Author     : Ojeda Alberto Daniel
--%>
<%@include file="vistas/init.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="vistas/assets.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>GG Rosario - <%= unaTienda.buscarCatalogo(Integer.valueOf(request.getParameter("id"))).getNombre() %></title>
    </head>
    <body>
        <header>
            <%@include file="vistas/menu.jsp" %>
        </header>
        <main>
            
        </main>
        <%@include file="vistas/footer.jsp" %>
    </body>
</html>
