<%--
    SideBar del panel de administraci�n
--%>

<%@page import="com.herokuapp.ggrosario.modelo.Rol"%>
<%@page import="com.herokuapp.ggrosario.modelo.Tienda"%>
<%@page import="com.herokuapp.ggrosario.util.HibernateUtil"%>

    <div class="collection with-header">
        <h4>Gesti�n</h4>
        <a href="../index" class="collection-item">Home</a>
        <a href="canje-reservas" class="collection-item">Canje de reservas</a>
        <% for (Rol unRol : unaTienda.getRoles()){ %>
            <a href="gestion-usuarios?rol=<%= unRol.getNombre() %>" class="collection-item">Gesti�n de <%= unRol.getNombre() %></a>
        <%}%>
        <a href="gestion-catalogos" class="collection-item">Gesti�n de cat�logos</a>
        <a href="#" class="collection-item">Gesti�n de categor�as</a>
        <a href="gestion-juegos" class="collection-item">Gesti�n de juegos</a>
        <a href="gestionRolesPermisos.jsp" class="collection-item">Gesti�n de roles y permisos</a>
        <a href="../logout" class="collection-item blue black-text">Cerrar sesi�n</a>
    </div>
