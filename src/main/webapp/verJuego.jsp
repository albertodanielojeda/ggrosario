<%-- 
    Document   : miPerfil
    Created on : 21/08/2016, 18:02:05
    Author     : Ojeda Alberto Daniel
--%>
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
        <% Juego unJuego = unaTienda.getUnJuego(Integer.valueOf(request.getParameter("idJuego")));%>
        <%@include file="vistas/menuVisitante.jsp" %>
        <div class="no-container">
            <div class="row">
                <div class="col s4"></div>
                <div class="col s8">
                    <div class="row">
                        <h4><%= unJuego.getNombre()%></h4>
                        <div class="col s4">
                            <div class="row">
                                <img src="<%= unJuego.getCover()%>"/>
                            </div>
                            <div class="row">
                                <a href="agregar-a-lista-deseos?idJuego=<%= unJuego.getId()%>&AMP;idUsuario=<%= miUsuario.getNick()%>" class="right"><i class="material-icons left">favorite</i>Agregar a la lista de deseos</a>
                                <a href="reservar?idJuego=<%= unJuego.getId()%>&AMP;idUsuario=<%= miUsuario.getNick()%>" class="right"><i class="material-icons left">card_membership</i>Reservar ahora mismo</a>
                            </div>
                        </div>
                        <div class="col s8">
                            <div class="row">
                                <p><%= unJuego.getDescripcion()%></p>
                            </div>
                            <div class="row black">
                                <h3 class="white-text right-align">$<%= unJuego.getPrecio()%></h3>
                            </div>
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
                </div>
            </div>
        </div>
    </body>
</html>
