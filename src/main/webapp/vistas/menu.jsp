<nav class="green">
    <div class="nav-wrapper container">
        <a href="index" class="brand-logo"><i class="material-icons left">videogame_asset</i><%= unaTienda.getNombre()%></a>
        <ul class="right hide-on-med-and-down">
            <% if (miUsuario != null) {%>
            <li><a href="mi-perfil"><i class="material-icons left">account_circle</i>¡Hola <%= miUsuario.getNick()%>!</a></li>
            <li><a href="logout"><i class="material-icons left">directions_run</i>Cerrar sesión</a></li>
            <% if (miUsuario.canAccederPanelAdministracion()){ %>
            <li><a href="admin/panel-administracion"><i class="material-icons">build</i></a></li>
            <% } %>
            <% } else if (miUsuario == null) { %>
            <li><a href="registrarme"><b>Registrarse o iniciá sesión<i class="material-icons right">input</i></b></a></li>
                <% }
               %>
        </ul>
    </div>
</nav>
<%@include file="menuCatalogos.jsp" %>