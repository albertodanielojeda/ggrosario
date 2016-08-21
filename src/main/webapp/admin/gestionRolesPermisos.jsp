<%-- 
    Muestra los roles administrados en la tienda junto con sus
    respectivos permisos.
    También permite agregar un nuevo rol y asignarle los permisos apropiados, según
    se considere.
    Author     : Ojeda Alberto Daniel
--%>
<%@include file="vistas/init.jsp" %>
<%@page import="com.herokuapp.ggrosario.modelo.Usuario"%>
<%@page import="com.herokuapp.ggrosario.util.HibernateUtil"%>
<%@page import="com.herokuapp.ggrosario.modelo.Tienda"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                <%@include file="vistas/sideBar.jsp" %>
                <div class="col s8">
                    
                    <h3>Gestión de roles y permisos</h3>
                    <table>
                        <thead>
                            <tr>
                                <th data-field="id">Nombre rol</th>
                                <th data-field="name">Permisos</th>
                            </tr>
                        </thead>

                        <tbody>
                            <% for (Rol unRol : unaTienda.getRoles()) { %>

                            <tr id="<%= unRol.getNombre()%>">
                                <td><%= unRol.getNombre()%></td>
                                <td><%= unRol.getPermisos()%></td>
                                <td><a href="verDetallesRol?idRol=<%= unRol.getNombre()%>">Modificar permisos del rol</a></td>
                            </tr>
                            <%
                                }%>
                        </tbody>
                    </table>
                        <div class="col s5">
                        <form action="agregar-rol" method="POST">
                            <div class="row">
                                <div class="input-field col s6">
                                    <label for="nombreRol">Nombre del rol</label>
                                    <input id="nombreRol" type="text" name="nombreRol" />
                                </div>
                                <div class="input-field col s6">
                                    <button class="btn" type="submit">Agregar rol</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
