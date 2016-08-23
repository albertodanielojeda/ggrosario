<%@page import="com.herokuapp.ggrosario.util.HibernateUtil"%>
<%@page import="com.herokuapp.ggrosario.modelo.Usuario"%>
<%@page import="com.herokuapp.ggrosario.modelo.Tienda"%>
<% Usuario miUsuario = (Usuario)request.getSession().getAttribute("miUsuario"); %>
<% Tienda unaTienda = (Tienda)request.getSession().getAttribute("unaTienda"); %>

<% if (unaTienda == null) { %>
    <% unaTienda = (Tienda)HibernateUtil.obtener("GG Rosario", "Tienda"); %>
<% } %>
