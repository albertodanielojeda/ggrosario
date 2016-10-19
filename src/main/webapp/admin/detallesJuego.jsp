<%-- 
    Muestra la información asociada a un juego y permite
    realizar cambios en la misma
    Author     : Ojeda Alberto Daniel
--%>
<%@page import="com.herokuapp.ggrosario.modelo.Juego"%>
<%@include file="vistas/init.jsp" %>
<%@page import="com.herokuapp.ggrosario.modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% if (miUsuario == null) {
        response.sendRedirect("../registrarme");
    } else {
%>

<% boolean puedeEntrar = false; %>

<% for (Rol r : miUsuario.getRoles()) {
        if (r.getPermisos().canAltaJuego() || r.getPermisos().canBajaJuego() || r.getPermisos().canModificacionJuego()) {
            puedeEntrar = true;
            miRol = r;
        }
    } %>
<% if (puedeEntrar) {

%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="vistas/assetsAdmin.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Panel de administración | Detalles del juego</title>
    </head>
    <body>
        <% String mensajeEdicionJuego;
            if (request.getSession().getAttribute("mensajeEdicionJuego") != null) {
                mensajeEdicionJuego = (String) request.getSession().getAttribute("mensajeEdicionJuego");
        %>
        <script>
            Materialize.toast("<%= mensajeEdicionJuego%>", 4000);
        </script>
        <% request.getSession().removeAttribute("mensajeEdicionJuego");} %>
        <%@include file="vistas/navBar.jsp" %>
        <div class="no-container">
            <div class="row">
                <div class="col s4">
                    <%@include file="vistas/sideBar.jsp" %>
                </div>
                <div class="col s8">
                    <% Juego unJuego = (Juego) request.getSession().getAttribute("detallesJuego");%>
                    <% request.getSession().setAttribute("unJuego", unJuego);%>
                    <h3>Detalles del juego <b><%= unJuego.getNombre()%></b></h3>

                    <div class="row">
                        <div class="col s12 m7">
                            <div class="card horizontal">
                                <div class="card-image">
                                    <img src="<%= unJuego.getCover()%>">
                                </div>
                                <div class="card-stacked">
                                    <div class="card-content">
                                        <p><b>Nombre:</b> <%= unJuego.getNombre()%></p>
                                        <p><b>En stock:</b> <%= unJuego.getStock().getCantidad()%> unidades</p>
                                        <p><b>Precio:</b> $ <%= unJuego.getPrecio()%> </p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <blockquote>
                        <h3>Stock</h3>
                    </blockquote>
                    <p>Arrastre el indicador hasta que marque la cantidad deseada para agregar al stock</p>
                    <div class="row">
                        <form action="aumentar-stock" method="POST">

                            <div class="col s7">
                                <p class="range-field">
                                    <input type="range" name="stock" min="1" max="100" value="1" step="1"/>
                                </p>
                            </div>
                            <div class="col s4">
                                <button  type="submit" class="modal-action modal-close btn waves-effect waves-light">Sumar stock</button>
                            </div>

                        </form>

                    </div>

                    <blockquote>
                        <h3>Precio</h3>
                    </blockquote>
                    <p>Ingrese el nuevo precio del juego</p>
                    <div class="row">
                        <form action="cambiar-precio-juego" method="POST">

                            <div class="col s7">
                                <div class="input-field col s6">
                                    <label for="precioJuego">Precio</label>
                                    <input id="precioJuego" type="text" name="precio" />
                                </div>
                            </div>
                            <div class="col s4">
                                <button  type="submit" class="modal-action modal-close btn waves-effect waves-light">Cambiar precio</button>
                            </div>
                        </form>

                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
<% } else {
        response.sendError(404);
    } %>
<%}%>