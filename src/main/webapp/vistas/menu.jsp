    <% if (miUsuario != null) {%>
    <ul id="opcionesUsuario" class="dropdown-content">
        <li><a href="mi-perfil">Mi perfil</a></li>
            <% if (miUsuario.canAccederPanelAdministracion()) { %>
        <li><a href="admin/panel-administracion">Panel de administración</a></li>
            <%} %>

        <li class="divider"></li>
        <li><a href="logout">Cerrar sesión</a></li>
    </ul>
    <%}%>
    <nav>
        <div class="nav-wrapper">
            <a href="index" class="brand-logo"><%= unaTienda.getNombre()%></a>
            <ul id="nav-mobile" class="right hide-on-med-and-down">
                <% if (miUsuario != null) {%>
                <%@include file="menuVisitante.jsp" %>
                <li><a class="dropdown-button" href="#!" data-activates="opcionesUsuario">¡Hola <%= miUsuario.getNick()%>!<i class="material-icons right">arrow_drop_down</i></a></li>
                    <% } else if (miUsuario == null) { %>
                    <%@include file="menuVisitante.jsp" %>
                <li><a href="registrarme"><b>Registrarse</b></a></li>
                    <% }%>
            </ul>
        </div>
    </nav>