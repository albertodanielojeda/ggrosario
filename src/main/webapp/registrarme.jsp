<%-- 
    Permite a un usuario visitante registrarse en el sistema
    Author     : Ojeda Alberto Daniel
--%>
<%@include file="vistas/init.jsp" %>
<%@page import="com.herokuapp.ggrosario.modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="vistas/assets.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%= unaTienda.getNombre()%> | Registro</title>
    </head>
    <body>
        <% Usuario unUsuario = (Usuario) request.getSession().getAttribute("unUsuario");%>
        <nav>
            <div class="nav-wrapper">
                <a href="#" class="brand-logo"><%= unaTienda.getNombre()%></a>
                <ul id="nav-mobile" class="right hide-on-med-and-down">
                    <% if (unUsuario == null || !unUsuario.hasRol(unaTienda.getRol("Administrador"))) { %>
                    <%@include file="vistas/menuVisitante.jsp" %>
                    <% } else if (unUsuario.hasRol(unaTienda.getRol("Administrador"))) { %>
                    <%@include file="vistas/menuAdministrador.jsp" %>
                    <% }%>
                </ul>
            </div>
        </nav>
        <div class="container">

            <div class="row">

                <h4>¡Registrate para poder reservar tus juegos favoritos!</h4>
                <div class="col s5">
                    <form action="registrar-usuario" method="POST">
                        <input type="text" hidden value="Cliente" name="rol"/> <!-- Keep an eye on this -->
                        <div class="row">
                            <div class="input-field col s6">
                                <label for="nombre">Nombre</label>
                                <input id="nombre" type="text" name="nombre" />
                            </div>
                            <div class="input-field col s6">
                                <label for="apellido">Apellido</label>
                                <input id="apellido" type="text" name="apellido" />
                            </div>
                        </div>

                        <div class="row">
                            <div class="input-field col s6">
                                <label for="email">E-mail</label>
                                <input id="email" type="text" name="email" />
                            </div>
                            <div class="input-field col s6">
                                <label for="nick">Nick</label>
                                <input id="nick" type="text" name="nick" />
                            </div>
                        </div>

                        <div class="row">
                            <div class="input-field col s6">
                                <label for="password">Password</label>
                                <input id="password" type="password" name="password" />
                            </div>
                            <div class="input-field col s6">
                                <label for="telefono">Teléfono</label>
                                <input id="telefono" type="tel" name="telefono" />
                            </div>
                        </div>

                        <div class="row">
                            <div class="input-field col s6">
                                <label for="fecha-nacimiento">Fecha de nacimiento</label>
                                <input id="fecha-nacimiento" type="date" class="datepicker" name="fecha-nacimiento" />
                            </div>
                            <div class="input-field col s6">
                                <button class="btn" type="submit" name="btnSignup">¡Registrarme!</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
