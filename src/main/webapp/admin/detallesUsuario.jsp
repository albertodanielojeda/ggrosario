<%-- 
    Muestra la información asociada a un usuario y permite
    realizar cambios en la misma
    Author     : Ojeda Alberto Daniel
--%>
<%@include file="vistas/init.jsp" %>
<%@page import="com.herokuapp.ggrosario.modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% if (miUsuario == null) {
        response.sendRedirect("../registrarme");
    } else {
%>

<% boolean puedeEntrar = false; %>
<% for (Rol r : miUsuario.getRoles()) {
        for (ABMRol abmRol : r.getPermisos().getAbmRoles()) {

            if (abmRol.canAlta() || abmRol.canBaja() || abmRol.canModificar()) {
                puedeEntrar = true;
                miRol = r;
                miABMRol = abmRol;
            }
        }
    }

%>
<% if (miABMRol != null && puedeEntrar){ %>

<!DOCTYPE html>
<html>
    <head>
        <%@include file="vistas/assetsAdmin.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Panel de administración | Detalles del usuario</title>
    </head>
    <body>
        <%@include file="vistas/navBar.jsp" %>
        <div class="no-container">
            <div class="row">
                <div class="col s4">
                <%@include file="vistas/sideBar.jsp" %>
                </div>
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

<%}%>