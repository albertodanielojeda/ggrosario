<%-- 
    Document   : miPerfil
    Created on : 21/08/2016, 18:02:05
    Author     : Ojeda Alberto Daniel
--%>
<%@page import="com.herokuapp.ggrosario.modelo.UsuarioComentario"%>
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
        <title><%= unaTienda.getNombre()%> | Mi perfil</title>
    </head>
    <body class="lighten-5 light-green">
        <header>
            <%@include file="vistas/menu.jsp" %>
        </header>
        <main>
            <div class="no-container">
                <div class="row">

                    <div class="col s12">
                        <div class="row">
                            <div class="col s12">
                                <ul class="tabs">
                                    <li class="tab col s3"><a class="active" href="#informacion">Información</a></li>
                                    <li class="tab col s3"><a href="#misReservas">Mis reservas</a></li>
                                    <li class="tab col s3"><a href="#miListaDeDeseos">Mi lista de deseos</a></li>
                                    <li class="tab col s3"><a href="#misComentarios">Mis comentarios</a></li>
                                </ul>
                            </div>
                            <div id="informacion" class="col s9">
                                <p>Nick: <%= miUsuario.getNick()%></p>
                                <p>E-Mail: <%= miUsuario.getEmail()%></p>
                            </div>
                            <div id="misReservas" class="col s9">
                                <%if (miUsuario.getReservas().isEmpty()) {%>
                                <div class="row">
                                    <h4 class="center">No tienes juegos reservados</h4>
                                </div>
                                <%} else {%>
                                <div class="row items">
                                    <% for (Reserva unaReserva : miUsuario.getReservas()) {%>
                                    <div class="col s3">
                                        <div class="card">
                                            <div class="card-image">
                                                <img src="<%= unaReserva.getUnJuego().getCover()%>"/>
                                                <span class="card-title black right"><b>$ <%= unaReserva.getUnJuego().getPrecio()%></b></span>
                                                <!-- Here we can put info and show it over the image! :D -->
                                            </div>

                                            <div class="card-action">
                                                <p>Precio: <%= unaReserva.getUnJuego().getPrecio()%></p>
                                                <p>Realizada: <%= unaReserva.getFechaAltaAsString()%></p>
                                                <p>Vence: <%= unaReserva.getFechaBajaAsString()%></p>
                                                <p>Estado: <%= unaReserva.getEstado()%></p>
                                            </div>
                                        </div>
                                    </div>
                                    <%}
                                        }%>
                                </div>
                            </div>
                            <div id="miListaDeDeseos" class="col s9">
                                <% if (miUsuario.getUnaListaDeseos().getUnaListaDeseosJuegos().isEmpty()) { %>
                                <div class="row">
                                    <h4 class="center">No tienes juegos en tu lista de deseos</h4>
                                </div>
                                <%} else {%>
                                <div class="row items">
                                    <% for (ListaDeseosJuegos ldj : miUsuario.getUnaListaDeseos().getUnaListaDeseosJuegos()) {%>
                                    <div class="col s3">
                                        <div class="card">
                                            <div class="card-image">
                                                <img src="<%= ldj.getUnJuego().getCover()%>"/>
                                                <span class="card-title black right"><b>$ <%= ldj.getUnJuego().getPrecio()%></b></span>
                                                <!-- Here we can put info and show it over the image! :D -->
                                            </div>

                                            <div class="card-action">
                                                <a href="#">Reservar</a>
                                            </div>
                                        </div>
                                    </div>
                                    <% }
                                        } %>
                                </div>
                            </div>
                            <div id="misComentarios" class="col s9">
                                <% if (miUsuario.getComentarios().isEmpty()) { %>
                                <div class="row">
                                    <h4 class="center">Aún no has hecho comentarios</h4>
                                </div>
                                <% } else { %>
                                <div class="collection">
                                    <% for (UsuarioComentario usuarioComentario : miUsuario.getComentarios()) {%>
                                    <a href="#!" class="collection-item"><%= usuarioComentario.getUnComentario().getDescripcion()%></a>
                                    <% }%>
                                </div>
                                <% }%>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </main>
        <%@include file="vistas/footer.jsp" %>
    </body>
</html>
