package com.herokuapp.ggrosario.servlet.init;

import com.herokuapp.ggrosario.exepciones.CatalogoException;
import com.herokuapp.ggrosario.exepciones.RolException;
import com.herokuapp.ggrosario.exepciones.UsuarioException;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.herokuapp.ggrosario.modelo.Configuracion;
import com.herokuapp.ggrosario.modelo.Permisos;
import com.herokuapp.ggrosario.modelo.Rol;
import com.herokuapp.ggrosario.modelo.Tienda;
import javax.servlet.annotation.WebServlet;

/**
 *
 * @author Ojeda Alberto Daniel
 */
@WebServlet(name = "InitServlet", urlPatterns = {"/init"})
public class InitServlet extends HttpServlet {

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
        Configuracion unaConfiguracion = new Configuracion(5, 10, true, false);
        Tienda unaTienda = new Tienda("GG Rosario", unaConfiguracion);

        try {
            unaTienda.addRol("Administrador");
            Rol unRol = unaTienda.getRol("Administrador");
            Permisos permisosAdministrador = new Permisos();
            permisosAdministrador.setCanDoAll(true);
            unRol.setPermisos(permisosAdministrador);
        } catch (RolException ex) {
            Logger.getLogger(InitServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            unaTienda.addRol("Empleado");
            Rol unRol = unaTienda.getRol("Empleado");
            Permisos permisosEmpleados = new Permisos();
            permisosEmpleados.setPermisosEmpleado();
            unRol.setPermisos(permisosEmpleados);
        } catch (RolException ex) {
            Logger.getLogger(InitServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            unaTienda.addRol("Cliente");
            Rol unRol = unaTienda.getRol("Cliente");
            Permisos permisosClientes = new Permisos();
            permisosClientes.setPermisosCliente();
            unRol.setPermisos(permisosClientes);
        } catch (RolException ex) {
            Logger.getLogger(InitServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            unaTienda.addCatalogo("Catálogo de " + unaTienda.getNombre());
        } catch (CatalogoException ex) {
            Logger.getLogger(InitServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            unaTienda.addUsuario("default@ggrosario.com", "default", "default", new Date("02/03/1994"), "Administrador", "Default", "0800-default", unaTienda.getRol("Administrador"));

        } catch (UsuarioException ex) {
            Logger.getLogger(InitServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        request.getSession().setAttribute("unaTienda", unaTienda);
        response.sendRedirect("index");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Servlet para inicializar el sistema por única vez";
    }// </editor-fold>

}
