package com.herokuapp.ggrosario.servlet.admin.rol;

import com.herokuapp.ggrosario.modelo.Rol;
import com.herokuapp.ggrosario.modelo.Tienda;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ojeda Alberto Daniel
 */
@WebServlet(name = "ModificarPermisosRolServlet", urlPatterns = {"/admin/modificar-permisos-rol"})
public class ModificarPermisosRolServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        // Los switches toman valores string "on" si están activados y "null" si están desactivados
        String idRol = request.getParameter("idRol");
        String altaRol = request.getParameter("altaRol");
        String bajaRol = request.getParameter("bajaRol");
        String modificarRol = request.getParameter("modificarRol");
        String altaAdministrador = request.getParameter("altaAdministrador");
        String bajaAdministrador = request.getParameter("bajaAdministrador");
        String modificarAdministrador = request.getParameter("modificarAdministrador");
        String altaEmpleado = request.getParameter("altaEmpleado");
        String bajaEmpleado = request.getParameter("bajaEmpleado");
        String modificarEmpleado = request.getParameter("modificarEmpleado");
        String altaCliente = request.getParameter("altaCliente");
        String bajaCliente = request.getParameter("bajaCliente");
        String modificarCliente = request.getParameter("modificarCliente");
        String altaCatalogo = request.getParameter("altaCatalogo");
        String bajaCatalogo = request.getParameter("bajaCatalogo");
        String modificarCatalogo = request.getParameter("modificarCatalogo");
        String altaCategoria = request.getParameter("altaCategoria");
        String bajaCategoria = request.getParameter("bajaCategoria");
        String modificarCategoria = request.getParameter("modificarCategoria");
        String altaJuego = request.getParameter("altaJuego");
        String bajaJuego = request.getParameter("bajaJuego");
        String modificarJuego = request.getParameter("modificarJuego");
        String altaReserva = request.getParameter("altaReserva");
        String bajaReserva = request.getParameter("bajaReserva");
        String modificarReserva = request.getParameter("modificarReserva");
        String accederPanelAdministracion = request.getParameter("accederPanelAdministracion");
        
        Rol unRol = (Rol) Tienda.getInstance().getRol(idRol);
        if (altaRol != null && altaRol.equals("on"))
            unRol.getPermisos().setAltaRol(true);
        else
            unRol.getPermisos().setAltaRol(false);
        
        if (bajaRol != null && bajaRol.equals("on"))
            unRol.getPermisos().setBajaRol(true);
        else
            unRol.getPermisos().setBajaRol(false);
        
        if (modificarRol != null && modificarRol.equals("on"))
            unRol.getPermisos().setModificacionRol(true);
        else
            unRol.getPermisos().setModificacionRol(false);
        
        if (altaAdministrador != null && altaAdministrador.equals("on"))
            unRol.getPermisos().setAltaAdministrador(true);
        else
            unRol.getPermisos().setAltaAdministrador(false);
        
        if (bajaAdministrador != null && bajaAdministrador.equals("on"))
            unRol.getPermisos().setBajaAdministrador(true);
        else
            unRol.getPermisos().setBajaAdministrador(false);
        
        if (modificarAdministrador != null && modificarAdministrador.equals("on"))
            unRol.getPermisos().setModificacionAdministrador(true);
        else
            unRol.getPermisos().setModificacionAdministrador(false);
        
        if (altaEmpleado != null && altaEmpleado.equals("on"))
            unRol.getPermisos().setAltaEmpleado(true);
        else
            unRol.getPermisos().setAltaEmpleado(false);
        
        if (bajaEmpleado != null && bajaEmpleado.equals("on"))
            unRol.getPermisos().setBajaEmpleado(true);
        else
            unRol.getPermisos().setBajaEmpleado(false);
        
        if (modificarEmpleado != null && modificarEmpleado.equals("on"))
            unRol.getPermisos().setModificacionEmpleado(true);
        else
            unRol.getPermisos().setModificacionEmpleado(false);
        
        if (altaCliente != null && altaCliente.equals("on"))
            unRol.getPermisos().setAltaCliente(true);
        else
            unRol.getPermisos().setAltaCliente(false);
        
        if (bajaCliente != null && bajaCliente.equals("on"))
            unRol.getPermisos().setBajaCliente(true);
        else
            unRol.getPermisos().setBajaCliente(false);
        
        if (modificarCliente != null && modificarCliente.equals("on"))
            unRol.getPermisos().setModificacionCliente(true);
        else
            unRol.getPermisos().setModificacionCliente(false);
        
        if (altaCatalogo != null && altaCatalogo.equals("on"))
            unRol.getPermisos().setAltaCatalogo(true);
        else
            unRol.getPermisos().setAltaCatalogo(false);
        
        if (bajaCatalogo != null && bajaCatalogo.equals("on"))
            unRol.getPermisos().setBajaCatalogo(true);
        else
            unRol.getPermisos().setBajaCatalogo(false);
        
        if (modificarCatalogo != null && modificarCatalogo.equals("on"))
            unRol.getPermisos().setModificacionCatalogo(true);
        else
            unRol.getPermisos().setModificacionCatalogo(false);
        
        if (altaCategoria != null && altaCategoria.equals("on"))
            unRol.getPermisos().setAltaCategoria(true);
        else
            unRol.getPermisos().setAltaCategoria(false);
        
        if (bajaCategoria != null && bajaCategoria.equals("on"))
            unRol.getPermisos().setBajaCategoria(true);
        else
            unRol.getPermisos().setBajaCategoria(false);
        
        if (modificarCategoria != null && modificarCategoria.equals("on"))
            unRol.getPermisos().setModificacionCategoria(true);
        else
            unRol.getPermisos().setModificacionCategoria(false);
        
        if (altaJuego != null && altaJuego.equals("on"))
            unRol.getPermisos().setAltaJuego(true);
        else
            unRol.getPermisos().setAltaJuego(false);
        
        if (bajaJuego != null && bajaJuego.equals("on"))
            unRol.getPermisos().setBajaJuego(true);
        else
            unRol.getPermisos().setBajaJuego(false);
        
        if (modificarJuego != null && modificarJuego.equals("on"))
            unRol.getPermisos().setModificacionJuego(true);
        else
            unRol.getPermisos().setModificacionJuego(false);
        
        if (altaReserva != null && altaReserva.equals("on"))
            unRol.getPermisos().setAltaReserva(true);
        else
            unRol.getPermisos().setAltaReserva(false);
        
        if (bajaReserva != null && bajaReserva.equals("on"))
            unRol.getPermisos().setBajaReserva(true);
        else
            unRol.getPermisos().setBajaReserva(false);
        
        if (modificarReserva != null && modificarReserva.equals("on"))
            unRol.getPermisos().setModificacionReserva(true);
        else
            unRol.getPermisos().setModificacionReserva(false);
        
        if (accederPanelAdministracion != null && accederPanelAdministracion.equals("on"))
            unRol.getPermisos().setAccederPanelAdministracion(true);
        else
            unRol.getPermisos().setAccederPanelAdministracion(false);
        
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Modifica los permisos de un rol";
    }

}
