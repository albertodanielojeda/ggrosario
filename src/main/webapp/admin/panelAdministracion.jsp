<%-- 
    Página principal del panel de administración
    Author     : Ojeda Alberto Daniel
--%>
<%@include file="vistas/init.jsp" %>
<%@page import="com.herokuapp.ggrosario.modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <% if (miUsuario.canAccederPanelAdministracion()) { %>
    <head>
        <%@include file="vistas/assetsAdmin.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%= unaTienda.getNombre() %> | Panel de administración</title>
    </head>
    <body>
        <div class="no-container">
            <%@include file="vistas/navBar.jsp" %>
            <div class="row">
                <%@include file="vistas/sideBar.jsp" %>
                
                <div class="col s8">

                </div>
            </div>

        </div>
    </body>
    <% } else{ 
        response.sendError(404);
    }%>

</html>
