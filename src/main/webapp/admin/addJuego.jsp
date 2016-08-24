<%-- 
    Document   : addJuego
    Created on : 24/08/2016, 16:22:56
    Author     : Ojeda Alberto Daniel
--%>
<%@page import="com.herokuapp.ggrosario.modelo.Catalogo"%>
<%@include file="vistas/init.jsp" %>
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
                <div class="col s4">
                    <%@include file="vistas/sideBar.jsp" %>
                </div>
                <div class="col s8">
                    <h4>Nuevo juego</h4>
                    <form action="registrar-juego" method="POST" enctype="multipart/form-data">
                        <div class="row">
                            <div class="row">
                                <div class="input-field col s12">
                                    <label for="nombreJuego">Nombre</label>
                                    <input id="nombreJuego" type="text" name="nombre" />
                                </div>
                            </div>
                            <div class="row">
                                <div class="input-field col s12">
                                    <label for="descripcionJuego">Descripción</label>
                                    <textarea class="materialize-textarea" id="descripcionJuego" name="descripcion"></textarea>
                                </div>
                            </div>
                            <div class="row">
                                <div class="input-field col s6">
                                    <label for="precioJuego">Precio</label>
                                    <input id="precioJuego" type="text" name="precio" />
                                </div>
                                <div class="input-field col s6">
                                    <label for="cantidadStock">Cantidad en stock</label>
                                    <input id="cantidadStock" type="text" name="stock" />
                                </div>
                            </div>
                            <div class="row">
                                <div class="input-field col s6">
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
                                <div class="file-field input-field col s6">
                                    <div class="btn right">
                                        <span>Imagen</span>
                                        <input id="imagenJuego" type="file" name="cover">
                                    </div>
                                    <div class="file-path-wrapper">
                                        <input class="file-path validate" type="text">
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <table class="striped bordered">
                                    <thead>
                                        <tr>
                                            <th>Tipo de requerimiento</th>
                                            <th>Mínimo</th>
                                            <th>Recomendado</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <th>Sistema operativo</th>
                                            <th>
                                                <div class="input-field col s12">
                                                    <input id="minOS" type="text" name="minOS" />
                                                </div>
                                            </th>
                                            <th>
                                                <div class="input-field col s12">
                                                    <input id="recOS" type="text" name="recOS" />
                                                </div>
                                            </th>
                                        </tr>
                                        <tr>
                                            <th>CPU</th>
                                            <th>
                                                <div class="input-field col s12">
                                                    <input id="minCPU" type="text" name="minCPU" />
                                                </div>
                                            </th>
                                            <th>
                                                <div class="input-field col s12">
                                                    <input id="recCPU" type="text" name="recCPU" />
                                                </div>
                                            </th>
                                        </tr>
                                        <tr>
                                            <th>Memoria RAM</th>
                                            <th>
                                                <div class="input-field col s12">
                                                    <input id="minRAM" type="text" name="minRAM" />
                                                </div>
                                            </th>
                                            <th>
                                                <div class="input-field col s12">
                                                    <input id="recRAM" type="text" name="recRAM" />
                                                </div>
                                            </th>
                                        </tr>
                                        <tr>
                                            <th>GPU</th>
                                            <th>
                                                <div class="input-field col s12">
                                                    <input id="minGPU" type="text" name="minGPU" />
                                                </div>
                                            </th>
                                            <th>
                                                <div class="input-field col s12">
                                                    <input id="recGPU" type="text" name="recGPU" />
                                                </div>
                                            </th>
                                        </tr>
                                        <tr>
                                            <th>Disco duro</th>
                                            <th>
                                                <div class="input-field col s12">
                                                    <input id="minHDD" type="text" name="minHDD" />
                                                </div>
                                            </th>
                                            <th>
                                                <div class="input-field col s12">
                                                    <input id="recHDD" type="text" name="recHDD" />
                                                </div>
                                            </th>
                                        </tr>

                                    </tbody>
                                </table>
                            </div>
                            <div class="row">
                                <button  type="submit" class="modal-action modal-close btn waves-effect waves-light">Agregar juego</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
