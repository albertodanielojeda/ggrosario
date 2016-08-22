<%-- 
    Document   : miPerfil
    Created on : 21/08/2016, 18:02:05
    Author     : Ojeda Alberto Daniel
--%>
<%@page import="com.herokuapp.ggrosario.modelo.Juego"%>
<%@include file="vistas/init.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="vistas/assets.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
        <% Juego unJuego = unaTienda.getUnJuego(Integer.valueOf(request.getParameter("idJuego"))); %>
        <%@include file="vistas/menuVisitante.jsp" %>
        <div class="no-container">
            <div class="row">
                <div class="col s4"></div>
                <div class="col s8"><%= unJuego.getNombre() %> <a href="agregar-a-lista-deseos?idJuego=<%= unJuego.getId()%>&AMP;idUsuario=<%= miUsuario.getNick() %>" class="btn small">Agregar a la lista de deseos</a></div>
            </div>
        </div>
    </body>
</html>
