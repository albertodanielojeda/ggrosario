<%-- 
    Página principal del panel de administración
    Author     : Ojeda Alberto Daniel
--%>
<%@include file="vistas/init.jsp" %>
<%@page import="com.herokuapp.ggrosario.modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% if (miUsuario == null) {
        response.sendRedirect("../registrarme");
    } else {
%>

<% if (miUsuario.canAccederPanelAdministracion()) {%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="vistas/assetsAdmin.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%= unaTienda.getNombre()%> | Panel de administración</title>
    </head>
    <body>
        <%@include file="vistas/navBar.jsp" %>
        <div class="no-container">
            <div class="row">
                <div class="col s4">
                    <%@include file="vistas/sideBar.jsp" %>
                </div>

                <div class="col s8">

                </div>
            </div>

        </div>
    </body>
</html>
<% } else {
        response.sendError(404);
    }%>
<%}%>