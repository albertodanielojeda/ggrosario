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

<% Juego unJuego = unaTienda.buscarJuego(Integer.valueOf(request.getParameter("idJuego")));
    if (unJuego == null) {
        unJuego = (Juego) unaTienda.buscarJuego(Integer.valueOf(request.getParameter("idJuego")));
    } else {
        request.getSession().setAttribute("unJuego", unJuego);
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <%@include file="vistas/assets.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%= unaTienda.getNombre()%> | <%= unJuego.getNombre()%></title>
    </head>
    <body class="lighten-5 light-green">
        <%
            if (request.getSession().getAttribute("exitoFavorito") != null) {
                boolean exito = (Boolean) request.getSession().getAttribute("exitoFavorito");

                if (exito) { %>
        <script>
            Materialize.toast("El juego fue agregado a la lista de deseos!", 4000);
        </script>
        <%
        } else {
        %>
        <script>
            Materialize.toast("Hubo un error al agregar el juego a la lista de deseos!", 4000);
        </script>
        <%
                }

            request.getSession().removeAttribute("exitoFavorito");
            }
        %>
        
        <%
            if (request.getSession().getAttribute("exitoReserva") != null) {
                boolean exito = (Boolean) request.getSession().getAttribute("exitoReserva");

                if (exito) { %>
        <script>
            Materialize.toast("El juego fue reservado!", 4000);
        </script>
        <%
        } else {
        %>
        <script>
            Materialize.toast("Hubo un error al reservar el juego!", 4000);
        </script>
        <%
                }

            request.getSession().removeAttribute("exitoReserva");
            }
        %>
        <header>
            <%@include file="vistas/menu.jsp" %>
        </header>
        <main>
            <div class="no-container">
                <div class="row">
                    <div class="col s9 left">
                        <div class="row">

                            <div class="col s4">

                                <div class="card">
                                    <div class="card-image">
                                        <img src="<%= unJuego.getCover()%>"/>
                                        <span class="card-title black precio-card"><b>$ <%= unJuego.getPrecio()%></b></span>
                                        <!-- Here we can put info and show it over the image! :D -->
                                    </div>
                                    <% if (miUsuario != null) {%>
                                    <div class="row card-action white-text black">
                                        <a href="agregar-a-lista-deseos?idJuego=<%= unJuego.getId()%>&AMP;idUsuario=<%= miUsuario.getNick()%>" class="right"><i class="material-icons left">favorite</i>Agregar a la wishlist</a>
                                        <a href="reservar?idJuego=<%= unJuego.getId()%>&AMP;idUsuario=<%= miUsuario.getNick()%>" class="right"><i class="material-icons left">card_membership</i>Reservar ahora mismo</a>
                                    </div>
                                    <% } else {%>
                                    <div class="row card-action white-text black">
                                        <a href="registrarme" class="right"><i class="material-icons left">favorite</i>Agregar a la wishlist</a>
                                        <a href="registrarme" class="right"><i class="material-icons left">card_membership</i>Reservar ahora mismo</a>
                                    </div>
                                    <% }%>
                                </div>

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

                                <% if (miUsuario != null) { %>
                                <div class="row">
                                    <form id="formComentar" action="comentar" method="POST">
                                        <div class="row">
                                            <div class="input-field col s12">
                                                <textarea name="comentario-enviado" id="cajaComentario" class="materialize-textarea"></textarea>
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
                    <div class="col s3 right">
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
                            <div class="col s12">
                                <div class="card blue-grey darken-1">
                                    <div class="card-content white-text">
                                        <p><%= juegoComentario.getUnComentario().getDescripcion()%></p>
                                    </div>
                                    <div class="card-action">
                                        <div class="right-align"><%=juegoComentario.getUnComentario().getUnUsuario().getNick()%></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <% } %>
                        <% }%>
                    </div>
                </div>
            </div>
        </main>

        <%@include file="vistas/footer.jsp" %>

    </body>
</html>
