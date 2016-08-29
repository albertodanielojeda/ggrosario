<%-- 
    Document   : miPerfil
    Created on : 21/08/2016, 18:02:05
    Author     : Ojeda Alberto Daniel
--%>
<%@page import="com.herokuapp.ggrosario.modelo.JuegoComentario"%>
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
        <% Juego unJuego = unaTienda.buscarJuego(Integer.valueOf(request.getParameter("idJuego")));
            if (unJuego == null) {
                unJuego = (Juego) unaTienda.buscarJuego(Integer.valueOf(request.getParameter("idJuego")));
            } else {
                request.getSession().setAttribute("unJuego", unJuego);
            }

        %>
        <div class="no-container">
            <%@include file="vistas/menu.jsp" %>
            <div class="row">
                <div class="col s8">
                    <div class="row">
                        <div class="col s4">
                            <div class="row">
                                <img src="<%= unJuego.getCover()%>"/>
                            </div>
                            <% if (miUsuario != null) {%>
                            <div class="row">
                                <a href="agregar-a-lista-deseos?idJuego=<%= unJuego.getId()%>&AMP;idUsuario=<%= miUsuario.getNick()%>" class="right"><i class="material-icons left">favorite</i>Agregar a la lista de deseos</a>
                                <a href="reservar?idJuego=<%= unJuego.getId()%>&AMP;idUsuario=<%= miUsuario.getNick()%>" class="right"><i class="material-icons left">card_membership</i>Reservar ahora mismo</a>
                            </div>
                            <% } else {%>
                            <div class="row">
                                <a href="registrarme" class="right"><i class="material-icons left">favorite</i>Agregar a la lista de deseos</a>
                                <a href="registrarme" class="right"><i class="material-icons left">card_membership</i>Reservar ahora mismo</a>
                            </div>
                            <% }%>
                        </div>
                        <div class="col s8">

                            <div class="row">

                                <ul class="tabs">
                                    <li class="tab col s3"><a href="#info-juego">Información</a></li>
                                    <li class="tab col s3"><a class="active" href="#requisitos-minimos">Requisitos mínimos</a></li>
                                    <li class="tab col s3"><a href="#requisitos-recomendados">Requisitos recomendados</a></li>
                                </ul>

                                <div id="info-juego" class="col s12">
                                    <div class="row">
                                        <p><%= unJuego.getDescripcion()%></p>
                                    </div>
                                </div>
                                <div id="requisitos-minimos" class="col s12">
                                    <div class="row">
                                        <table class="bordered highlight">
                                            <thead>
                                                <tr>
                                                    <th data-field="id"><p>Requisitos mínimos</p></th>
                                                </tr>
                                            </thead>

                                            <tbody>
                                                <tr>
                                                    <td>Sistema Operativo</td>
                                                    <td><%= unJuego.getRequisitosMinimos().getOs().toString()%></td>
                                                </tr>
                                                <tr>
                                                    <td>CPU</td>
                                                    <td><%= unJuego.getRequisitosMinimos().getCpu().toString()%></td>
                                                </tr>
                                                <tr>
                                                    <td>Memoria RAM</td>
                                                    <td><%= unJuego.getRequisitosMinimos().getRam().toString()%></td>
                                                </tr>
                                                <tr>
                                                    <td>GPU</td>
                                                    <td><%= unJuego.getRequisitosMinimos().getGpu().toString()%></td>
                                                </tr>
                                                <tr>
                                                    <td>Disco duro</td>
                                                    <td><%= unJuego.getRequisitosMinimos().getHdd().toString()%></td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                                <div id="requisitos-recomendados" class="col s12">
                                    <div class="row">
                                        <table class="bordered highlight">
                                            <thead>
                                                <tr>
                                                    <th data-field="id"><p>Requisitos recomendados</p></th>

                                                </tr>
                                            </thead>

                                            <tbody>
                                                <tr>
                                                    <td>Sistema Operativo</td>
                                                    <td><%= unJuego.getRequisitosRecomendados().getOs().toString()%></td>
                                                </tr>
                                                <tr>
                                                    <td>CPU</td>
                                                    <td><%= unJuego.getRequisitosRecomendados().getCpu().toString()%></td>
                                                </tr>
                                                <tr>
                                                    <td>Memoria RAM</td>
                                                    <td><%= unJuego.getRequisitosRecomendados().getRam().toString()%></td>
                                                </tr>
                                                <tr>
                                                    <td>GPU</td>
                                                    <td><%= unJuego.getRequisitosRecomendados().getGpu().toString()%></td>
                                                </tr>
                                                <tr>
                                                    <td>Disco duro</td>
                                                    <td><%= unJuego.getRequisitosRecomendados().getHdd().toString()%></td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>

                            <div class="row black">
                                <h3 class="white-text right-align">$<%= unJuego.getPrecio()%></h3>
                            </div>

                            <% if (miUsuario != null) { %>
                            <div class="row">
                                <form action="comentar" method="POST">
                                    <div class="row">
                                        <div class="input-field col s12">
                                            <textarea name="comentario-enviado" id="comment-box" class="materialize-textarea"></textarea>
                                            <label for="comment-box">Comenta acerca de este juego...</label>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <button class="btn" type="submit">Enviar comentario</button>
                                    </div>
                                </form>
                            </div>
                            <% } else { %>
                            <div class="row">
                                <h5><a href="registrarme">Registrate para poder comentar</a></h5>
                            </div>
                            <% } %>
                        </div>
                    </div>
                </div>
                <div class="col s4">
                    <h5>Comentarios</h5>
                    <% if (unJuego.getComentarios().size() == 0) { %>
                    <div class="row">
                        <div class="card-panel orange">
                            <div class="black-text">
                                <p>Este juego no tiene comentarios. Soyez le premier!</p>
                            </div>
                        </div>
                    </div>
                    <% } else { %>
                    <% for (JuegoComentario juegoComentario : unJuego.getComentarios()) {%>
                    <div class="row">
                        <div class="card-panel grey">
                            <div class="black-text">
                                <p><b><%= juegoComentario.getUnComentario().getUnUsuario().getNick()%>:</b></p>
                                <p><%= juegoComentario.getUnComentario().getDescripcion() %></p>
                            </div>
                        </div>
                    </div>
                    <% } %>
                    <% }%>
                </div>
            </div>
        </div>
    </body>
</html>
