package com.herokuapp.ggrosario.servlet.admin.rol;

import com.herokuapp.ggrosario.exepciones.RolException;
import com.herokuapp.ggrosario.modelo.ABMRol;
import com.herokuapp.ggrosario.modelo.Rol;
import com.herokuapp.ggrosario.modelo.Tienda;
import com.herokuapp.ggrosario.modelo.Usuario;
import com.herokuapp.ggrosario.util.HibernateUtil;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
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
        /* Los switches toman valores string "on" si están activados y "null" si están desactivados */
        String idRol = request.getParameter("idRol");
        Rol unRol = (Rol) Tienda.getInstance().buscarRol(idRol);

        String altaRol = request.getParameter("altaRol");
        String bajaRol = request.getParameter("bajaRol");
        String modificarRol = request.getParameter("modificarRol");

        /* Se pasan los String[] a Set<String> para trabajarlos más cómodamente */
        String altaUsuarios[] = request.getParameterValues("altaUsuarios");
        Set<String> nuevosAltaUsuarios = new HashSet<>();
        if (altaUsuarios != null) {
            nuevosAltaUsuarios.addAll(Arrays.asList(altaUsuarios));
        }
        String bajaUsuarios[] = request.getParameterValues("bajaUsuarios");
        Set<String> nuevosBajaUsuarios = new HashSet<>();
        if (bajaUsuarios != null) {
            nuevosBajaUsuarios.addAll(Arrays.asList(bajaUsuarios));
        }
        String modificarUsuarios[] = request.getParameterValues("modificarUsuarios");
        Set<String> nuevosModificarUsuarios = new HashSet<>();
        if (modificarUsuarios != null) {
            nuevosModificarUsuarios.addAll(Arrays.asList(modificarUsuarios));
        }
        Set<String> todosAMBRol = new HashSet<>();
        for (ABMRol abm : unRol.getPermisos().getAbmRoles()) {
            todosAMBRol.add(abm.getUnRol().getNombre());
        }
        for (String tipoUsuario : nuevosAltaUsuarios) {
            try {
                unRol.getPermisos().addAMBUsuarioRol(tipoUsuario);
            } catch (RolException ex) {
                System.out.println(ex.getMessage());
            } finally {
                unRol.getPermisos().buscarABMUsuarioRol(tipoUsuario).setCanAlta(false);
            }
        }

        for (String tipoUsuario : nuevosBajaUsuarios) {
            try {
                unRol.getPermisos().addAMBUsuarioRol(tipoUsuario);
            } catch (RolException ex) {
                System.out.println(ex.getMessage());
            } finally {
                unRol.getPermisos().buscarABMUsuarioRol(tipoUsuario).setCanBaja(false);
            }
        }

        for (String tipoUsuario : nuevosModificarUsuarios) {
            try {
                unRol.getPermisos().addAMBUsuarioRol(tipoUsuario);
            } catch (RolException ex) {
                System.out.println(ex.getMessage());
            } finally {
                unRol.getPermisos().buscarABMUsuarioRol(tipoUsuario).setCanModificar(false);
            }
        }

        /* Chequea para cada ABMRol de los permisos a modificar del rol */
        for (ABMRol abmRol : unRol.getPermisos().getAbmRoles()) {
            /* Si el nombre de un rol NO estaba marcado en la lista de altas, no lo puede dar de alta */
            if (!nuevosAltaUsuarios.contains(abmRol.getUnRol().getNombre())) {
                abmRol.setCanAlta(false);
            } else {
                /* Si estaba marcado, lo puede dar de alta */
                abmRol.setCanAlta(true);
            }
            /* Si el nombre de un rol NO estaba marcado en la lista de bajas, no lo puede dar de baja */
            if (!nuevosBajaUsuarios.contains(abmRol.getUnRol().getNombre())) {
                abmRol.setCanBaja(false);
            } else {
                /* Si estaba marcado, lo puede dar de baja */
                abmRol.setCanBaja(true);
            }
            /* Si el nombre de un rol NO estaba marcado en la lista de modificacion, no lo puede modificar */
            if (!nuevosModificarUsuarios.contains(abmRol.getUnRol().getNombre())) {
                abmRol.setCanModificar(false);
            } else {
                /* Si estaba marcado, lo puede modificar */
                abmRol.setCanModificar(true);
            }
        }

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

        if (altaRol != null && altaRol.equals("on")) {
            unRol.getPermisos().setAltaRol(true);
        } else {
            unRol.getPermisos().setAltaRol(false);
        }

        if (bajaRol != null && bajaRol.equals("on")) {
            unRol.getPermisos().setBajaRol(true);
        } else {
            unRol.getPermisos().setBajaRol(false);
        }

        if (modificarRol != null && modificarRol.equals("on")) {
            unRol.getPermisos().setModificacionRol(true);
        } else {
            unRol.getPermisos().setModificacionRol(false);
        }

        if (altaCatalogo != null && altaCatalogo.equals("on")) {
            unRol.getPermisos().setAltaCatalogo(true);
        } else {
            unRol.getPermisos().setAltaCatalogo(false);
        }

        if (bajaCatalogo != null && bajaCatalogo.equals("on")) {
            unRol.getPermisos().setBajaCatalogo(true);
        } else {
            unRol.getPermisos().setBajaCatalogo(false);
        }

        if (modificarCatalogo != null && modificarCatalogo.equals("on")) {
            unRol.getPermisos().setModificacionCatalogo(true);
        } else {
            unRol.getPermisos().setModificacionCatalogo(false);
        }

        if (altaCategoria != null && altaCategoria.equals("on")) {
            unRol.getPermisos().setAltaCategoria(true);
        } else {
            unRol.getPermisos().setAltaCategoria(false);
        }

        if (bajaCategoria != null && bajaCategoria.equals("on")) {
            unRol.getPermisos().setBajaCategoria(true);
        } else {
            unRol.getPermisos().setBajaCategoria(false);
        }

        if (modificarCategoria != null && modificarCategoria.equals("on")) {
            unRol.getPermisos().setModificacionCategoria(true);
        } else {
            unRol.getPermisos().setModificacionCategoria(false);
        }

        if (altaJuego != null && altaJuego.equals("on")) {
            unRol.getPermisos().setAltaJuego(true);
        } else {
            unRol.getPermisos().setAltaJuego(false);
        }

        if (bajaJuego != null && bajaJuego.equals("on")) {
            unRol.getPermisos().setBajaJuego(true);
        } else {
            unRol.getPermisos().setBajaJuego(false);
        }

        if (modificarJuego != null && modificarJuego.equals("on")) {
            unRol.getPermisos().setModificacionJuego(true);
        } else {
            unRol.getPermisos().setModificacionJuego(false);
        }

        if (altaReserva != null && altaReserva.equals("on")) {
            unRol.getPermisos().setAltaReserva(true);
        } else {
            unRol.getPermisos().setAltaReserva(false);
        }

        if (bajaReserva != null && bajaReserva.equals("on")) {
            unRol.getPermisos().setBajaReserva(true);
        } else {
            unRol.getPermisos().setBajaReserva(false);
        }

        if (modificarReserva != null && modificarReserva.equals("on")) {
            unRol.getPermisos().setModificacionReserva(true);
        } else {
            unRol.getPermisos().setModificacionReserva(false);
        }

        if (accederPanelAdministracion != null && accederPanelAdministracion.equals("on")) {
            unRol.getPermisos().setAccederPanelAdministracion(true);
        } else {
            unRol.getPermisos().setAccederPanelAdministracion(false);
        }
        
        HibernateUtil.actualizar(Tienda.getInstance());

        request.getSession().setAttribute("unaTienda", Tienda.getInstance());
        response.sendRedirect("verDetallesRol?idRol=" + idRol);

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
