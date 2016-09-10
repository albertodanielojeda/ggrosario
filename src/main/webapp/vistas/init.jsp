<%@page import="com.herokuapp.ggrosario.modelo.Tienda"%>
<%@page import="com.herokuapp.ggrosario.modelo.Usuario"%>
<% Tienda unaTienda = Tienda.getInstance(); %>
<% Usuario miUsuario = (Usuario)request.getSession().getAttribute("miUsuario"); %>
