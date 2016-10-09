<%-- 
    Document   : canjeReserva
    Created on : 09/10/2016, 01:24:31
    Author     : Ojeda Alberto Daniel
--%>
<%@page import="com.herokuapp.ggrosario.modelo.Reserva"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="vistas/init.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="vistas/assetsAdmin.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Panel de administración | Canje de reservas</title>
    </head>
    <body>
        <%@include file="vistas/navBar.jsp" %>
        <div class="no-container">
            <div class="row">
                <div class="col s4">
                    <%@include file="vistas/sideBar.jsp" %>
                </div>
                <div class="col s8">
                    <h4>Canje de reservas</h4>
                    <form id="formBuscarReserva" action="buscar-reserva" method="GET">
                        <div class="row">
                            <div class="input-field col s7">
                                <label for="idReserva">ID Reserva</label>
                                <input id="idReserva" type="text" name="idReserva" />
                            </div>
                            <div class="input-field col s7">
                                <label for="idUsuario">ID Usuario (nick o e-mail)</label>
                                <input id="idUsuario" type="text" name="idUsuario" />
                            </div>
                        </div>
                        <div class="row">
                            <button  type="submit" class="modal-action modal-close btn waves-effect waves-light">Buscar reserva</button>
                        </div>
                    </form>
                </div>
                <div class="row">
                    <% if (request.getSession().getAttribute("reservaEncontrada") == null) { %>
                    <h3>No se encontró la reserva para el usuario indicado</h3>
                    <% } else { %>
                    <% Reserva reserva = (Reserva) request.getSession().getAttribute("reservaEncontrada"); %>
                    <div class="row items">
                        <div class="col s4">
                            <div class="card horizontal">
                                <div class="card-image">
                                    <img src="<%= reserva.getUnJuego().getCover()%>"/>
                                    <!-- Here we can put info and show it over the image! :D -->
                                </div>
                                <div class="card-stacked">
                                    <div class="card-content">
                                        <p>ID: <%= reserva.getId()%></p>
                                        <p>Precio: <%= reserva.getUnJuego().getPrecio()%></p>
                                        <p>Realizada: <%= reserva.getFechaAltaAsString()%></p>
                                        <p>Vence: <%= reserva.getFechaBajaAsString()%></p>
                                        <p>Estado: <%= reserva.getEstado()%></p>
                                    </div>
                                    <div class="card-action">
                                        <% if (reserva.isValida()) { %>
                                        <a href="#">Confirmar canje</a>
                                        <% } else if (reserva.isCaducada() || reserva.isCumplida()) {%>
                                        <a href="#">Esta reserva ya caducó o ya fue canjeada</a>
                                        <% } %>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>

                    <% request.getSession().removeAttribute("reservaEncontrada"); } %>
                </div>
            </div>
        </div>
    </body>
</html>
