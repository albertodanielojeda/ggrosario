<%-- 
    Muestra los juegos conocidos por la tienda y permite agregar
    más juegos
    Author     : Ojeda Alberto Daniel
--%>
<%@page import="com.herokuapp.ggrosario.modelo.Juego"%>
<%@page import="com.herokuapp.ggrosario.modelo.Catalogo"%>
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
            <div id="addJuego" class="modal modal-fixed-footer">
                <div class="modal-content">
                    <h4>Nuevo juego</h4>
                    <form action="registrar-juego" method="POST" enctype="multipart/form-data">
                        <div class="row">
                            <div class="row">
                                <div class="input-field col s5">
                                    <label for="nombreJuego">Nombre</label>
                                    <input id="nombreJuego" type="text" name="nombre" />
                                </div>
                                <div class="input-field col s5">
                                    <label for="descripcionJuego">Descripción</label>
                                    <textarea class="materialize-textarea" id="descripcionJuego" name="descripcion"></textarea>
                                </div>
                            </div>
                            <div class="row">
                                <div class="input-field col s5">
                                    <label for="precioJuego">Precio</label>
                                    <input id="precioJuego" type="text" name="precio" />
                                </div>
                                <div class="input-field col s5">
                                    <label for="cantidadStock">Cantidad en stock</label>
                                    <input id="cantidadStock" type="text" name="stock" />
                                </div>
                            </div>
                            <div class="row">
                                <div class="input-field col s5">
                                    <select name="listaCatalogos" id="listaCatalogos">
                                        <option value="" selected>Elige un catálogo</option>
                                        <% for (Catalogo unCatalogo : unaTienda.getCatalogos()) {%>
                                        <option value="<%= unCatalogo.getId()%>"><%= unCatalogo.getNombre()%></option>
                                        <%}%>
                                    </select>
                                    <label>Catálogo del juego</label>
                                </div>
                                <% if (unaTienda.getUnaConfiguracion().isRegistroJuegosCategoriaDeCatalogo()) { %>
                                    <div class="input-field col s5">
                                    <select id="listaCategoriasCatalogos">
                                        <option value="" selected>Elige una categoria</option>
                                        <% for (Catalogo unCatalogo : unaTienda.getCatalogos()) {%>
                                        <option value="<%= unCatalogo.getId()%>"><%= unCatalogo.getNombre()%></option>
                                        <%}%>
                                    </select>
                                    <label>Catálogo del juego</label>
                                </div>
                                <%}%>
                            </div>
                            <div class="row">
                                <div class="col s5">
                                    <label for="imagenJuego">Imagen</label>
                                    <input id="imagenJuego" type="file" name="cover" />
                                </div>
                            </div>
                            <div class="row">
                                <button  type="submit" class="modal-action modal-close btn waves-effect waves-light">Agregar juego</button>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                </div>

            </div>
            <div class="row">
                <%@include file="vistas/sideBar.jsp" %>
                
                <div class="col s8">
                    <h3>Gestión de juegos</h3>
                    <table class="highlight centered responsive-table bordered">
                        <thead>
                            <tr>
                                <th data-field="nombre">Cover</th>
                                <th data-field="nombre">Nombre</th>
                                <th data-field="precio">Precio</th>
                                <th data-field="stock">En stock</th>
                                <th data-field="fechaAlta">Fecha de alta</th>
                            </tr>
                        </thead>

                        <tbody>
                            <% for (Juego juego : unaTienda.getJuegos()) { %>
                            <tr id="<%= juego.getId() %>">
                                <td><img src="<%= juego.getCover() %>" height="20%" width="20%"/></td>
                                <td><%= juego.getNombre() %></td>
                                <td><%= juego.getPrecio() %></td>
                                <td><%= juego.getStock() %></td>
                                <td><%= juego.getFechaAlta().toString().split(" ")[0] %></td>                                
                                <td><a href="verDetallesJuego?idJuego=<%= juego.getId() %>">Ver detalles</a></td>
                            </tr>
                            <%}%>
                        </tbody>
                    </table>
                    <a href="#addJuego" class="btn modal-trigger-add-juego"><i class="material-icons">add</i>Agregar juego</a>
                </div>
            </div>
        </div>
    </body>
</html>
