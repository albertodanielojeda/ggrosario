<%-- 
    Muestra la información asociada a un usuario y permite
    realizar cambios en la misma
    Author     : Ojeda Alberto Daniel
--%>
<%@include file="vistas/init.jsp" %>
<%@page import="com.herokuapp.ggrosario.modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% if (miRol != null && miRol.getPermisos().canModificacionAdministrador() || miRol.getPermisos().canModificacionEmpleado() || miRol.getPermisos().canModificacionCliente()) { %>
<html>
    <head>
        <%@include file="vistas/assetsAdmin.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="vistas/navBar.jsp" %>
        <div class="no-container">
            <div class="row">
                <%@include file="vistas/sideBar.jsp" %>
                <div class="col s8">
                    <% Usuario unUsuario = (Usuario) request.getSession().getAttribute("detallesUsuario");%>
                    <h3>Detalles del usuario <b><%= unUsuario.getNick()%></b></h3>
                </div>
            </div>
        </div>
    </body>
</html>
<% } else {
    response.sendError(404);
} %>