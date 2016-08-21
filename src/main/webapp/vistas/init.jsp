<%@page import="com.herokuapp.ggrosario.util.HibernateUtil"%>
<%@page import="com.herokuapp.ggrosario.modelo.Usuario"%>
<%@page import="com.herokuapp.ggrosario.modelo.Tienda"%>
<% Tienda unaTienda = (Tienda)HibernateUtil.obtener("GG Rosario", "Tienda"); %>
<% Usuario miUsuario = (Usuario)request.getSession().getAttribute("miUsuario"); %>