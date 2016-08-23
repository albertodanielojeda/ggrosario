<%-- 
    Document   : miPerfil
    Created on : 21/08/2016, 18:02:05
    Author     : Ojeda Alberto Daniel
--%>
<%@page import="com.herokuapp.ggrosario.modelo.Reserva"%>
<%@page import="com.herokuapp.ggrosario.modelo.ListaDeseosJuegos"%>
<%@page import="com.herokuapp.ggrosario.modelo.Comentario"%>
<%@page import="com.herokuapp.ggrosario.modelo.Juego"%>
<%@include file="vistas/init.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="vistas/assets.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
        <div class="no-container">
            <%@include file="vistas/menu.jsp" %>
            <div class="row">
                <div class="col s4"></div>
                <div class="col s8">
                    <div class="row">
                        <div class="col s12">
                            <ul class="tabs">
                                <li class="tab col s3"><a class="active" href="#informacion">Información</a></li>
                                <li class="tab col s3"><a href="#misReservas">Mis reservas</a></li>
                                <li class="tab col s3"><a href="#miListaDeDeseos">Mi lista de deseos</a></li>
                                <li class="tab col s3"><a href="#misComentarios">Mis comentarios</a></li>
                            </ul>
                        </div>
                        <div id="informacion" class="col s12">
                            <p>Nick: <%= miUsuario.getNick()%></p>
                            <p>E-Mail: <%= miUsuario.getEmail()%></p>
                        </div>
                        <div id="misReservas" class="col s12">
                            <ul class="collapsible" data-collapsible="accordion">
                                <% for (Reserva unaReserva : miUsuario.getReservas()) {%>
                                <li>
                                    <div class="collapsible-header"><i class="material-icons">cloud</i><%= unaReserva.getUnJuego().getNombre()%></div>
                                    <div class="collapsible-body">
                                        <p>Precio: <%= unaReserva.getUnJuego().getPrecio()%></p>
                                        <p>Realizada: <%= unaReserva.getFechaAlta().toString()%></p>
                                        <p>Vence: <%= unaReserva.getFechaBaja().toString()%></p>
                                    </div>
                                </li>
                                <% } %>
                            </ul>
                        </div>
                        <div id="miListaDeDeseos" class="col s12">
                            <div class="row">
                                <%
                                    for (ListaDeseosJuegos ldj : miUsuario.getUnaListaDeseos().getUnaListaDeseosJuegos()) {
                                %>

                                <div class="col s3">
                                    <div class="card">
                                        <div class="card-image">
                                            <img src="<%= ldj.getUnJuego().getCover()%>">
                                            <span class="card-title black right"><b>$ <%= ldj.getUnJuego().getPrecio()%></b></span>
                                            <!-- Here we can put info and show it over the image! :D -->
                                        </div>

                                        <div class="card-action">
                                            <a href="#">Reservar</a>
                                        </div>
                                    </div>
                                </div>
                                <% } %>
                            </div>
                        </div>
                        <div id="misComentarios" class="col s12">
                            <div class="collection">
                                <% for (Comentario comment : miUsuario.getComentarios()) { %>
                                <a href="#!" class="collection-item"><%= comment.getDescripcion()%></a>
                                <% } %>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
