<%-- 
    Document   : categoria
    Created on : 30/08/2016, 17:50:34
    Author     : Ojeda Alberto Daniel
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.herokuapp.ggrosario.modelo.Juego"%>
<%@include file="vistas/init.jsp" %>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="vistas/assets.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>GG Rosario - <%= unaTienda.buscarCatalogo(Integer.valueOf(request.getParameter("id"))).getNombre()%></title>
    </head>
    <body>
        <header>
            <%@include file="vistas/menu.jsp" %>
        </header>
        <main>
            <div class="no-container">
                <div class="row">
                    <div class="col s1"></div>
                    <div class="col s10">
                        <div class="row">
                            <h3 class="col s8">Juegos de <%= unaTienda.buscarCatalogo(Integer.valueOf(request.getParameter("id"))).getNombre()%></h3>
                            <div class="col s4">
                                <form method="GET" action="buscar-juegos">
                                    <div class="input-field">
                                        <input name="idCatalogo" type="hidden" value="<%= request.getParameter("id")%>">
                                        <label><i class="material-icons left">search</i>Buscá tus juegos favoritos</label>
                                        <input class="tooltipped" data-position="bottom" data-delay="50" data-tooltip="Tip: Separá con comas para buscar más de un juego :)" name="buscarJuegos" type="search" required>
                                    </div>
                                </form>
                            </div>
                        </div>
                        <div class="row">
                            <% if ((request.getSession().getAttribute("encontrado")) != null && Boolean.valueOf(request.getSession().getAttribute("encontrado").toString())) {
                                    List<Juego> juegosEncontrados = (ArrayList<Juego>) request.getSession().getAttribute("juegosEncontrados");
                                    for (Juego juego : juegosEncontrados) {%>
                            <div class="col s3">
                                <a class="img-link" href="info-juego?idJuego=<%= juego.getId()%>">
                                    <div class="card">
                                        <div class="card-image">
                                            <img src="<%= juego.getCover()%>"/>
                                            <span class="card-title black precio-card"><b>$ <%= juego.getPrecio()%></b></span>
                                            <!-- Here we can put info and show it over the image! :D -->
                                        </div>
                                        <div class="card-action center white-text black">
                                            Ver juego
                                        </div>
                                    </div>
                                </a>
                            </div>
                            <% request.getSession().removeAttribute("encontrado");
                                                } %>
                            <% } else {
                                List<Juego> juegosCatalogo = unaTienda.buscarCatalogo(Integer.valueOf(request.getParameter("id"))).getJuegos();
                                for (Juego juego : juegosCatalogo) {%>
                            <div class="col s3">
                                <a class="img-link" href="info-juego?idJuego=<%= juego.getId()%>">
                                    <div class="card">
                                        <div class="card-image">
                                            <img src="<%= juego.getCover()%>"/>
                                            <span class="card-title black precio-card"><b>$ <%= juego.getPrecio()%></b></span>
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
