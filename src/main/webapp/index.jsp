<%-- 
    Página principal de la tienda GG Rosario
    Author     : Ojeda Alberto Daniel
--%>

<%@page import="com.herokuapp.ggrosario.modelo.Juego"%>
<%@page import="com.herokuapp.ggrosario.modelo.Rol"%>
<%@page import="com.herokuapp.ggrosario.modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="vistas/init.jsp" %>
        <%@include file="vistas/assets.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body class="lighten-5 light-green">
        <header>
            <%@include file="vistas/menu.jsp" %>
        </header>
        <main>
            <div class="no-container">
                <div class="row">
                    <div class="col s1"></div>
                    <div class="col s10">
                        <h3 class="center">¡Nuevos!</h3>
                        <div class="row items">
                            <% for (Juego j : unaTienda.getUltimosJuegos()) {%>
                            <div class="col s3">
                                <a class="img-link" href="info-juego?idJuego=<%= j.getId()%>">
                                    <div class="card">
                                        <div class="card-image">
                                            <img src="<%= j.getCover()%>"/>
                                            <span class="card-title black precio-card"><b>$ <%= j.getPrecio()%></b></span>
                                            <!-- Here we can put info and show it over the image! :D -->
                                        </div>
                                        <div class="card-action center white-text black">
                                            Ver juego
                                        </div>
                                    </div>
                                </a>
                            </div>
                            <% } %>
                        </div>
                        <h3 class="center">Los más reservados</h3>
                        <div class="row items">
                            <% for (Juego j : unaTienda.ordenarJuegosMasReservados()) { %>
                            <% if (j.getReservas().size() >= unaTienda.getUnaConfiguracion().getReservasMinimas()) {%>
                            <div class="col s3">
                                <a class="img-link" href="info-juego?idJuego=<%= j.getId()%>">
                                    <div class="card z-depth-5">
                                        <div class="card-image">
                                            <img src="<%= j.getCover()%>">
                                            <span class="card-title black right"><b>$ <%= j.getPrecio()%></b></span>
                                            <!-- Here we can put info and show it over the image! :D -->
                                        </div>
                                            <div class="card-action center white-text black">
                                                Ver juego
                                            </div>
                                    </div>
                                </a>
                            </div>
                            <% } %>
                            <% }%>
                        </div>
                    </div>
                    <div class="col s1"></div>

                </div>

            </div>
        </main>

        <%@include file="vistas/footer.jsp" %>

    </body>
</html>
