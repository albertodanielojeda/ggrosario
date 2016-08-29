<%-- 
    Muestra la información asociada a un juego y permite
    realizar cambios en la misma
    Author     : Ojeda Alberto Daniel
--%>
<%@page import="com.herokuapp.ggrosario.modelo.Juego"%>
<%@include file="vistas/init.jsp" %>
<%@page import="com.herokuapp.ggrosario.modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% boolean puedeEntrar = false; %>

<% for (Rol r : miUsuario.getRoles()) {
        if (r.getPermisos().canAltaJuego()|| r.getPermisos().canBajaJuego()|| r.getPermisos().canModificacionJuego()) {
            puedeEntrar = true;
            miRol = r;
        }
    } %>
<% if (puedeEntrar) { %>
<!DOCTYPE html>
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
                <div class="col s4">
                    <%@include file="vistas/sideBar.jsp" %>
                </div>
                <div class="col s8">
                    <% Juego unJuego = (Juego) request.getSession().getAttribute("detallesJuego");%>
                    <h3>Detalles del juego <b><%= unJuego.getNombre()%></b></h3>
                </div>
            </div>
        </div>
    </body>
</html>
<% } else {
    response.sendError(404);
} %>