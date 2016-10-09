<%-- 
    Muestra la información asociada a un juego y permite
    realizar cambios en la misma
    Author     : Ojeda Alberto Daniel
--%>
<%@page import="com.herokuapp.ggrosario.modelo.Catalogo"%>
<%@page import="com.herokuapp.ggrosario.modelo.Juego"%>
<%@include file="vistas/init.jsp" %>
<%@page import="com.herokuapp.ggrosario.modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="vistas/assetsAdmin.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Panel de administración | Detalles del catálogo</title>
    </head>
    <body>
        <%@include file="vistas/navBar.jsp" %>
        <div class="no-container">
            <div class="row">
                <div class="col s4">
                <%@include file="vistas/sideBar.jsp" %>
                </div>
                <div class="col s8">
                    <% Catalogo unCatalogo = (Catalogo) request.getSession().getAttribute("detallesCatalogo");%>
                    <h3>Detalles del catálogo <b><%= unCatalogo.getNombre()%></b></h3>
                </div>
            </div>
        </div>
    </body>
</html>
