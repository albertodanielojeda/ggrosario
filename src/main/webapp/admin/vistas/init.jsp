<%--
    JSP que inicializa variables globales a los JSP que los implementen
--%>
<%@page import="com.herokuapp.ggrosario.modelo.Usuario"%>
<%@page import="com.herokuapp.ggrosario.modelo.Tienda"%>
<% Tienda unaTienda = (Tienda)request.getSession().getAttribute("unaTienda"); %>
<% Usuario miUsuario = (Usuario)request.getSession().getAttribute("miUsuario"); %>