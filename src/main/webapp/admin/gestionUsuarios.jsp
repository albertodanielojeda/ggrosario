<%-- 
    Muestra el listado de usuarios que tienen un determinado rol (el nombre
    del rol a considerar es enviado por GET
    Author     : Ojeda Alberto Daniel
--%>
<%@include file="vistas/init.jsp" %>
<%@page import="com.herokuapp.ggrosario.modelo.Usuario"%>
<%@page import="com.herokuapp.ggrosario.util.HibernateUtil"%>
<%@page import="com.herokuapp.ggrosario.modelo.Tienda"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% boolean puedeEntrar = false; %>

<% for (Rol r : miUsuario.getRoles()) {
        if (r.getPermisos().canAltaAdministrador() || r.getPermisos().canAltaEmpleado() || r.getPermisos().canAltaCliente()) {
            puedeEntrar = true;
            miRol = r;
        }
    } %>


<% if (puedeEntrar) { %>
<!DOCTYPE html>
<html>

    <head>
        <%@include file="vistas/assetsAdmin.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% if (unaTienda.getRol(request.getParameter("rol")) == null) {
                response.sendError(404);
            }%>
        <%@include file="vistas/navBar.jsp" %>
        <div class="no-container">

            <div id="addUsuario" class="modal modal-fixed-footer">
                <div class="modal-content">
                    <h4>Registrar un nuevo <%= request.getParameter("rol").toLowerCase()%></h4>
                    <% if (miRol.getPermisos().canAltaAdministrador() || miRol.getPermisos().canAltaEmpleado() || miRol.getPermisos().canAltaCliente()) {%>
                    <div class="col s5">
                        <form action="../registrar-usuario" method="POST">
                            <input type="text" hidden value="<%= request.getParameter("rol")%>" name="rol"/> <!-- Keep an eye on this -->
                            <% request.getSession().setAttribute("usuarioRegistrante", miUsuario);
                            %>
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
                                    <button class="btn" type="submit" name="btnLogin">Registrar usuario</button>
                                </div>
                            </div>
                        </form>
                    </div>
                    <% }
                       %>
                </div>
                <div class="modal-footer">
                </div>

            </div>
            <div class="row">
                <div class="col s4">
                    <%@include file="vistas/sideBar.jsp" %>
                </div>
                <div class="col s8">

                    <h3>Gestión de <%= request.getParameter("rol")%></h3>
                    <table>
                        <thead>
                            <tr>
                                <th data-field="id">E-Mail</th>
                                <th data-field="name">Nick</th>
                                <th data-field="price">Contraseña</th>
                                <th data-field="price">Nombre</th>
                                <th data-field="price">Apellido</th>
                                <th data-field="price">Teléfono</th>
                            </tr>
                        </thead>

                        <tbody>
                            <% for (Usuario user : unaTienda.getUsuarios()) {
                                    if (user.hasRol(unaTienda.getRol(request.getParameter("rol")))) {%>

                            <tr id="<%= user.getNick()%>">
                                <td><%= user.getEmail()%></td>
                                <td><%= user.getNick()%></td>
                                <td><%= user.getPassword()%></td>
                                <td><%= user.getNombre()%></td>
                                <td><%= user.getApellido()%></td>
                                <td><%= user.getTelefono()%></td>
                                <td><a href="verDetallesUsuario?idUsuario=<%= user.getNick()%>" class="verMasAdministrador">Ver más</a></td>
                            </tr>
                            <%      }
                                }%>
                        </tbody>
                    </table>
                    <% if (miRol.getPermisos().canAltaAdministrador() || miRol.getPermisos().canAltaEmpleado() || miRol.getPermisos().canAltaCliente()) {%>
                    <a href="#addUsuario" class="btn modal-trigger-add-usuario"><i class="material-icons">add</i>Registrar <%= request.getParameter("rol")%></a>
                    <% } %>
                </div>
            </div>
        </div>
    </body>

</html>
<% } else {
        response.sendError(404);
    }%>
