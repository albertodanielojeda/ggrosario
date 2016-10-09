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
        <title><%= unaTienda.getNombre()%> | Inicar sesión o registrarme</title>
    </head>
    <body class="lighten-5 light-green">
        <% Usuario unUsuario = (Usuario) request.getSession().getAttribute("unUsuario");%>
        <header>
            <%@include file="vistas/menu.jsp" %>
        </header>
        <main>
            <div class="container">

                <div class="row">
                    <div class="col s4 left">
                        <h3>Iniciar sesión</h3>
                        <form id="loginForm" action="login" method="POST">
                            <div class="row">
                                <div class="input-field col s12">
                                    <label id="lblNick" for="nick" data-error="Ingrese su nick o su e-mail">Nick o e-mail</label>
                                    <input id="nick" type="text" name="nick" />
                                </div>
                            </div>
                            <div class="row">
                                <div class="input-field col s12">
                                    <label id="lblPassword" for="password" data-error="Ingrese su contraseña">Password</label>
                                    <input id="password" type="password" name="password" />
                                </div>
                            </div>
                            <div class="row">
                                <div class="input-field col s12">
                                    <button class="btn" type="submit" name="btnLogin">Iniciar sesion</button>
                                </div>
                            </div>
                        </form>
                        <% if ((request.getSession().getAttribute("success") != null) && !Boolean.parseBoolean(request.getSession().getAttribute("success").toString())) { %>
                        <script>
                            Materialize.toast("Los datos ingresados no corresponden", 3000);
                            <% request.getSession().removeAttribute("success"); %>
                        </script>
                        <% }%>
                    </div>

                    <div class="col s7 right">
                        <h4>¡Registrate para poder reservar tus juegos favoritos!</h4>
                        <form id="signupForm" action="registrar-usuario" method="POST">
                            <div class="row">
                                <div class="input-field col s6">
                                    <label for="nombre">Nombre</label>
                                    <input id="nombre" type="text" name="nombre" />
                                </div>
                                <div class="input-field col s6">
                                    <label for="apellido">Apellido</label>
                                    <input id="apellido" type="text" name="apellido"/>
                                </div>
                            </div>

                            <div class="row">
                                <div class="input-field col s6">
                                    <label for="email">E-mail</label>
                                    <input id="email" type="email" name="email" class="validate"/>
                                    <div></div>
                                </div>
                                <div class="input-field col s6">
                                    <label for="nick">Nick</label>
                                    <input id="nickNew" type="text" name="nick" />
                                </div>
                            </div>

                            <div class="row">
                                <div class="input-field col s6">
                                    <label for="password">Password</label>
                                    <input id="passwordNew" type="password" name="password" />
                                </div>
                                <div class="input-field col s6">
                                    <label for="telefono">Teléfono</label>
                                    <input id="telefono" type="tel" name="telefono" />
                                </div>
                            </div>

                            <div class="row">
                                <div class="input-field col s6">
                                    <label for="fecha-nacimiento">Fecha de nacimiento</label>
                                    <input id="fecha-nacimiento" type="date" class="datepicker" name="fechanacimiento" />
                                </div>
                                <div class="input-field col s6">
                                    <button class="btn" type="submit" name="btnSignup">¡Registrarme!</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </main>
        
            <%@include file="vistas/footer.jsp" %>
        
    </body>
</html>
