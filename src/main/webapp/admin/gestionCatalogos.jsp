<%-- 
    Document   : gestionUsuarios
    Created on : 14/08/2016, 18:31:27
    Author     : Ojeda Alberto Daniel
--%>
<%@page import="com.herokuapp.ggrosario.modelo.Catalogo"%>
<%@include file="vistas/init.jsp" %>
<%@page import="com.herokuapp.ggrosario.modelo.Usuario"%>
<%@page import="com.herokuapp.ggrosario.util.HibernateUtil"%>
<%@page import="com.herokuapp.ggrosario.modelo.Tienda"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% if (miUsuario == null) {
        response.sendRedirect("../registrarme");
    } else {
%>

<% boolean puedeEntrar = false; %>

<% for (Rol r : miUsuario.getRoles()) {
        if (r.getPermisos().canAltaCatalogo() || r.getPermisos().canBajaCatalogo() || r.getPermisos().canModificacionCatalogo()) {
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
        <title>Panel de administración | Gestión de catálogos</title>
    </head>
    <body>
        <% if (request.getSession().getAttribute("mensajeGestionCatalogos") != null) {
                String mensaje = (String) request.getSession().getAttribute("mensajeGestionCatalogos");
        %>
        <script>
            Materialize.toast("<%= mensaje%>", 4000);
        </script>
        <% request.getSession().removeAttribute("mensajeGestionCatalogos");
            }%>

        <%@include file="vistas/navBar.jsp" %>
        <div class="no-container">
            <div class="row">
                <div class="col s4">
                    <%@include file="vistas/sideBar.jsp" %>
                </div>
                <div class="col s8">

                    <h3>Gestión de catálogos</h3>
                    <table>
                        <thead>
                            <tr>
                                <th data-field="id">Nombre</th>
                            </tr>
                        </thead>

                        <tbody>
                            <% for (Catalogo unCatalogo : unaTienda.getCatalogos()) {%>

                            <tr id="<%= unCatalogo.getId()%>">
                                <td><%= unCatalogo.getNombre()%></td>

                                <% if (miRol.getPermisos().canModificacionCatalogo()) { %>
                                <td><a class="editar-nombre-catalogo" href="#!"><i class="material-icons left">mode_edit</i>Cambiar nombre</a></td>
                                <% } %>
                                <% if (miRol.getPermisos().canBajaCatalogo()) { %>
                                <td><a class="eliminar-catalogo" href="#!"><i class="material-icons left">delete_forever</i>Eliminar</a></td>
                                <% } %>
                            </tr>
                            <%
                                }%>
                        </tbody>
                    </table>
                    <% if (miRol.getPermisos().canAltaCatalogo()) { %>
                    <div class="col s5">
                        <form id="formNuevoCatalogo" action="agregar-catalogo" method="POST">
                            <div class="row">
                                <div class="input-field col s6">
                                    <label for="nombreCatalogo">Nombre del catálogo</label>
                                    <input id="nombreCatalogo" type="text" name="nombreCatalogo" />
                                </div>
                                <div class="input-field col s6">
                                    <button class="btn" type="submit" name="btnLogin">Agregar catálogo</button>
                                </div>
                            </div>
                        </form>
                    </div>
                    <% } %>
                </div>
            </div>
        </div>
    </body>
</html>
<% } else {
        response.sendError(403);
    }%>

<%}%>