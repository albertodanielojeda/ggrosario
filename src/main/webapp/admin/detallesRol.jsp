<%-- 
    Muestra la información asociada a un rol y permite
    modificar los permisos del mismo
    Author     : Ojeda Alberto Daniel
--%>
<%@page import="com.herokuapp.ggrosario.modelo.Rol"%>
<%@include file="vistas/init.jsp" %>
<%@page import="com.herokuapp.ggrosario.modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                <%@include file="vistas/sideBar.jsp" %>
                <div class="col s8">
                    <% Rol unRol = (Rol) request.getSession().getAttribute("detallesRol");%>
                    <h3>Detalles del rol <b><%= unRol.getNombre()%></b></h3>
                </div>
            </div>
        </div>
    </body>
</html>
