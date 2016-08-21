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
    <body>
        <div class="no-container">
            <%@include file="vistas/menu.jsp" %>
            <div class="row">

                <div class="col s9 left">
                    <h3>¡Nuevos!</h3>
                    <div class="row items">
                        <%
                            for (Juego j : unaTienda.getUltimosJuegos()) {
                        %>

                        <div class="col s3">
                            <div class="card">
                                <div class="card-image">
                                    <img src="<%= j.getCover()%>">
                                    <span class="card-title black right"><b>$ <%= j.getPrecio()%></b></span>
                                    <!-- Here we can put info and show it over the image! :D -->
                                </div>
                                
                                <div class="card-action">
                                    <a href="#">Reservar</a>
                                </div>
                            </div>
                        </div>
                        <% } %>
                    </div>
                    <h3>Los más reservados</h3>
                    <div class="row items">
                        <div class="col s3">
                            <div class="imagen">
                                <img src="Imagenes/minecraft.jpg"/>

                                <h5 class="center">Minecraft</h5>
                            </div>
                            <a class="btn right" href="#!">Ver detalles</a>
                        </div>
                        <div class="col s3">
                            <div class="imagen">
                                <img src="Imagenes/overwatch.jpg"/>

                                <h5 class="center">Overwatch</h5>
                            </div>
                            <a class="btn right" href="#!">Ver detalles</a>
                        </div>
                        <div class="col s3">
                            <div class="imagen">
                                <img src="Imagenes/lifeisstrange.jpg"/>

                                <h5 class="center">Life is strange</h5>
                            </div>
                            <a class="btn right" href="#!">Ver detalles</a>
                        </div>
                        <div class="col s3">
                            <div class="imagen">
                                <img src="Imagenes/f12016.jpg"/>
                                <h5 class="center">F1 2016</h5>
                            </div>

                            <a class="btn right" href="#!">Ver detalles</a>
                        </div>
                    </div>
                </div>

                <div class="barra-lateral col s3 right">
                    <% if (miUsuario == null) { %>
                    <h3>Iniciar sesión</h3>
                    <form action="login" method="POST">
                        <div class="row">
                            <div class="input-field col s12">
                                <label for="nick">Nick o e-mail</label>
                                <input id="nick" type="text" name="nick" />
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s12">
                                <label for="password">Password</label>
                                <input id="password" type="password" name="password" />
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s12">
                                <button class="btn" type="submit" name="btnLogin">Iniciar sesion</button>
                            </div>
                        </div>
                    </form>
                    <% } %>
                </div>
            </div>
    </body>
</html>
