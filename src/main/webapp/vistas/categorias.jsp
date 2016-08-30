<%@page import="com.herokuapp.ggrosario.modelo.Catalogo"%>
<nav class="light-green z-depth-0">
    <div class="nav-wrapper container">
        <ul class="right">
            <% for (Catalogo unCatalogo : unaTienda.getCatalogos()) {%>
            <li><a href="sass.html"><%= unCatalogo.getNombre()%></a></li>
            <%}%>
        </ul>
    </div>
</nav>