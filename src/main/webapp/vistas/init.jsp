<%@page import="com.herokuapp.ggrosario.modelo.Usuario"%>
<%@page import="com.herokuapp.ggrosario.modelo.Tienda"%>
<% Usuario miUsuario = (Usuario)request.getSession().getAttribute("miUsuario"); %>
<% Tienda unaTienda = Tienda.getInstance(); %>
