<%-- 
    Muestra la información asociada a un rol y permite
    modificar los permisos del mismo
    Author     : Ojeda Alberto Daniel
--%>
<%@page import="java.util.List"%>
<%@page import="com.herokuapp.ggrosario.modelo.ABMRol"%>
<%@page import="com.herokuapp.ggrosario.modelo.Rol"%>
<%@include file="vistas/init.jsp" %>
<%@page import="com.herokuapp.ggrosario.modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% boolean puedeEntrar = false; %>

<% for (Rol r : miUsuario.getRoles()) {
        if (r.getPermisos().canAltaRol() || r.getPermisos().canBajaRol() || r.getPermisos().canModificacionRol()) {
            puedeEntrar = true;
            miRol = r;
        }
    } %>

<% if (puedeEntrar && miRol.getPermisos().canModificacionRol()) {
%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="vistas/assetsAdmin.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="vistas/navBar.jsp" %>
        <div class="no-container">
            <div class="row">
                <div class="col s4">
                    <%@include file="vistas/sideBar.jsp" %>
                </div>
                <div class="col s8">
                    <% Rol unRol = (Rol) Tienda.getInstance().buscarRol(request.getParameter("idRol"));%>
                    <h3>Editar permisos para el rol <%= unRol.getNombre()%></h3>
                    <form action="modificar-permisos-rol" method="POST">
                        <table class="striped bordered">
                            <thead>
                                <tr>
                                    <th data-field="permisos">Permisos</th>
                                    <th data-field="Alta">Alta</th>
                                    <th data-field="Baja">Baja</th>
                                    <th data-field="Modificación">Modificación</th>
                                </tr>
                            </thead>

                            <tbody>
                                <tr>
                                    <td>
                                        Roles
                                    </td>
                                    <td>
                                        <div class="switch">
                                            <label>
                                                No
                                                <input name="altaRol" <% if (unRol.getPermisos().canAltaRol()) { %> checked <% } %> type="checkbox">
                                                <span class="lever"></span>
                                                Si
                                            </label>
                                        </div>
                                    </td>
                                    <td>
                                        <div class="switch">
                                            <label>
                                                No
                                                <input name="bajaRol" <% if (unRol.getPermisos().canBajaRol()) { %> checked <% } %> type="checkbox">
                                                <span class="lever"></span>
                                                Si
                                            </label>
                                        </div>
                                    </td>
                                    <td>
                                        <div class="switch">
                                            <label>
                                                No
                                                <input name="modificarRol" <% if (unRol.getPermisos().canModificacionRol()) { %> checked <% } %> type="checkbox">
                                                <span class="lever"></span>
                                                Si
                                            </label>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Usuarios
                                    </td>
                                    <td>
                                        <% List<Rol> roles = Tienda.getInstance().getRoles(); %>
                                        <div class="switch">
                                            <div class="input-field col s12">
                                                <select multiple name="altaUsuarios">
                                                    <option value="" disabled selected>Usuarios que puede dar de alta</option>
                                                    <% for (Rol r : roles) {%>
                                                    <% if (miRol.getPermisos().buscarAMBUsuarioRol(r.getNombre()) != null) { %>
                                                    <option <% if (unRol.getPermisos().buscarAMBUsuarioRol(r.getNombre()) != null && unRol.getPermisos().buscarAMBUsuarioRol(r.getNombre()).canAlta()){ %> selected="" <% } %> value="<%= r.getNombre()%>"><%= r.getNombre()%></option>
                                                    <% } %>
                                                    <% } %>
                                                </select>
                                            </div>
                                        </div>
                                    </td>
                                    <td>
                                        <div class="input-field col s12">
                                            <select multiple name="bajaUsuarios">
                                                <option value="" disabled selected>Usuarios que puede dar de baja</option>
                                                <% for (Rol r : roles) {%>
                                                <% if (miRol.getPermisos().buscarAMBUsuarioRol(r.getNombre()) != null) { %>
                                                <option <% if (unRol.getPermisos().buscarAMBUsuarioRol(r.getNombre()) != null && unRol.getPermisos().buscarAMBUsuarioRol(r.getNombre()).canBaja()){ %> selected="" <% } %> value="<%= r.getNombre()%>"><%= r.getNombre()%></option>
                                                <% } %>
                                                <% } %>
                                            </select>
                                        </div>
                                    </td>
                                    <td>
                                        <div class="input-field col s12">
                                            <select multiple name="modificarUsuarios">
                                                <option value="" disabled selected>Usuarios que puede modificar</option>
                                                <% for (Rol r : roles) {%>
                                                <% if (miRol.getPermisos().buscarAMBUsuarioRol(r.getNombre()) != null) { %>
                                                <option <% if (unRol.getPermisos().buscarAMBUsuarioRol(r.getNombre()) != null && unRol.getPermisos().buscarAMBUsuarioRol(r.getNombre()).canModificar()){ %> selected="" <% } %> value="<%= r.getNombre()%>"><%= r.getNombre()%></option>
                                                <% } %>
                                                <% } %>
                                            </select>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Catálogos
                                    </td>
                                    <td>
                                        <div class="switch">
                                            <label>
                                                No
                                                <input name="altaCatalogo" <% if (unRol.getPermisos().canAltaCatalogo()) { %> checked <% } %> type="checkbox">
                                                <span class="lever"></span>
                                                Si
                                            </label>
                                        </div>
                                    </td>
                                    <td>
                                        <div class="switch">
                                            <label>
                                                No
                                                <input name="bajaCatalogo" <% if (unRol.getPermisos().canBajaCatalogo()) { %> checked <% } %> type="checkbox">
                                                <span class="lever"></span>
                                                Si
                                            </label>
                                        </div>
                                    </td>
                                    <td>
                                        <div class="switch">
                                            <label>
                                                No
                                                <input name="modificarCatalogo" <%  if (unRol.getPermisos().canModificacionCatalogo()) { %> checked <% } %> type="checkbox">
                                                <span class="lever"></span>
                                                Si
                                            </label>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Categorías
                                    </td>
                                    <td>
                                        <div class="switch">
                                            <label>
                                                No
                                                <input name="altaCategoria" <% if (unRol.getPermisos().canAltaCategoria()) { %> checked <% } %> type="checkbox">
                                                <span class="lever"></span>
                                                Si
                                            </label>
                                        </div>
                                    </td>
                                    <td>
                                        <div class="switch">
                                            <label>
                                                No
                                                <input name="bajaCategoria" <% if (unRol.getPermisos().canBajaCategoria()) { %> checked <% } %> type="checkbox">
                                                <span class="lever"></span>
                                                Si
                                            </label>
                                        </div>
                                    </td>
                                    <td>
                                        <div class="switch">
                                            <label>
                                                No
                                                <input name="modificarCategoria" <% if (unRol.getPermisos().canModificacionCategoria()) { %> checked <% } %> type="checkbox">
                                                <span class="lever"></span>
                                                Si
                                            </label>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Juegos
                                    </td>
                                    <td>
                                        <div class="switch">
                                            <label>
                                                No
                                                <input name="altaJuego" <% if (unRol.getPermisos().canAltaJuego()) { %> checked <% } %> type="checkbox">
                                                <span class="lever"></span>
                                                Si
                                            </label>
                                        </div>
                                    </td>
                                    <td>
                                        <div class="switch">
                                            <label>
                                                No
                                                <input name="bajaJuego" <% if (unRol.getPermisos().canBajaJuego()) { %> checked <% } %> type="checkbox">
                                                <span class="lever"></span>
                                                Si
                                            </label>
                                        </div>
                                    </td>
                                    <td>
                                        <div class="switch">
                                            <label>
                                                No
                                                <input name="modificarJuego" <% if (unRol.getPermisos().canModificacionJuego()) { %> checked <% } %> type="checkbox">
                                                <span class="lever"></span>
                                                Si
                                            </label>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Reservas
                                    </td>
                                    <td>
                                        <div class="switch">
                                            <label>
                                                No
                                                <input name="altaReserva" <% if (unRol.getPermisos().canAltaReserva()) { %> checked <% } %> type="checkbox">
                                                <span class="lever"></span>
                                                Si
                                            </label>
                                        </div>
                                    </td>
                                    <td>
                                        <div class="switch">
                                            <label>
                                                No
                                                <input name="bajaReserva" <% if (unRol.getPermisos().canBajaReserva()) { %> checked <% } %> type="checkbox">
                                                <span class="lever"></span>
                                                Si
                                            </label>
                                        </div>
                                    </td>
                                    <td>
                                        <div class="switch">
                                            <label>
                                                No
                                                <input name="modificarReserva" <% if (unRol.getPermisos().canModificacionReserva()) { %> checked <% } %> type="checkbox">
                                                <span class="lever"></span>
                                                Si
                                            </label>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Acceder al panel de administración
                                    </td>
                                    <td>
                                        <div class="switch">
                                            <label>
                                                No
                                                <input name="accederPanelAdministracion" <% if (unRol.getPermisos().canAccederPanelAdministracion()) { %> checked <% }%> type="checkbox">
                                                <span class="lever"></span>
                                                Si
                                            </label>
                                        </div>
                                    </td>
                                    <td>

                                    </td>
                                    <td>

                                    </td>
                                </tr>
                            </tbody>
                        </table>
                        <input hidden name="idRol" value="<%= request.getParameter("idRol")%>"> <!-- Keep an eye on this -->
                        <button type="submit" class="btn">Guardar cambios</button>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
<% } else {
        response.sendError(404);
    }%>