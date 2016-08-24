<%-- 
    Muestra los juegos conocidos por la tienda y permite agregar
    más juegos
    Author     : Ojeda Alberto Daniel
--%>
<%@page import="com.herokuapp.ggrosario.modelo.Juego"%>
<%@page import="com.herokuapp.ggrosario.modelo.Catalogo"%>
<%@include file="vistas/init.jsp" %>
<%@page import="com.herokuapp.ggrosario.modelo.Usuario"%>
<%@page import="com.herokuapp.ggrosario.util.HibernateUtil"%>
<%@page import="com.herokuapp.ggrosario.modelo.Tienda"%>
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
                <div class="col s4">
                    <%@include file="vistas/sideBar.jsp" %>
                </div>

                <div class="col s8">
                    <h3>Gestión de juegos</h3>
                    <a href="agregar-juego" class="btn right"><i class="material-icons">add</i>Agregar juego</a>
                    <table class="highlight centered responsive-table bordered">
                        <thead>
                            <tr>
                                <th data-field="nombre">Cover</th>
                                <th data-field="nombre">Nombre</th>
                                <th data-field="precio">Precio</th>
                                <th data-field="stock">En stock</th>
                                <th data-field="fechaAlta">Fecha de alta</th>
                            </tr>
                        </thead>

                        <tbody>
                            <% for (Juego juego : unaTienda.getJuegos()) {%>
                            <tr id="<%= juego.getId()%>">
                                <td><img src="<%= juego.getCover()%>" height="20%" width="20%"/></td>
                                <td><%= juego.getNombre()%></td>
                                <td><%= juego.getPrecio()%></td>
                                <td><%= juego.getStock()%></td>
                                <td><%= juego.getFechaAlta().toString().split(" ")[0]%></td>                                
                                <td><a href="verDetallesJuego?idJuego=<%= juego.getId()%>">Ver detalles</a></td>
                            </tr>
                            <%}%>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
