package com.herokuapp.ggrosario.servlet.init;

import com.herokuapp.ggrosario.exepciones.CatalogoException;
import com.herokuapp.ggrosario.exepciones.JuegoException;
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
        Rol unRol;

        try {
            unaTienda.addRol("Administrador");
            unRol = unaTienda.getRol("Administrador");
            Permisos permisosAdministrador = new Permisos();
            permisosAdministrador.setCanDoAll(true);
            unRol.setPermisos(permisosAdministrador);
        } catch (RolException ex) {
            Logger.getLogger(InitServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            unaTienda.addRol("Empleado");
            unRol = unaTienda.getRol("Empleado");
            Permisos permisosEmpleados = new Permisos();
            permisosEmpleados.setPermisosEmpleado();
            unRol.setPermisos(permisosEmpleados);
        } catch (RolException ex) {
            Logger.getLogger(InitServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            unaTienda.addRol("Cliente");
            unRol = unaTienda.getRol("Cliente");
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

        try {
            unaTienda.addJuego("F1 - 2016", "F1 - 2016", 29.99, 100, "http://res.cloudinary.com/ggrosario/image/upload/v1471671688/kxloejlvrubty5bmq0qo.jpg", unaTienda.getCatalogos().get(0));
            unaTienda.addJuego("GTA V", "GTA V", 29.99, 100, "http://res.cloudinary.com/ggrosario/image/upload/v1471806142/qrzeksimej9uol0lsajj.jpg", unaTienda.getCatalogos().get(0));
            unaTienda.addJuego("No Man's Sky", "No Man's Sky", 29.99, 100, "http://res.cloudinary.com/ggrosario/image/upload/v1471671724/b60vehbpz6xsasguyru3.jpg", unaTienda.getCatalogos().get(0));
            unaTienda.addJuego("Life is strange", "Life is Strange", 29.99, 100, "http://res.cloudinary.com/ggrosario/image/upload/v1471653826/lnr0gnqywhaygz7o0wn7.jpg", unaTienda.getCatalogos().get(0));
            unaTienda.addJuego("TWD - Season 1", "TWD - Season 1", 29.99, 100, "http://res.cloudinary.com/ggrosario/image/upload/v1471672925/qjmbkzoyx9osimcal8is.jpg", unaTienda.getCatalogos().get(0));
            unaTienda.addJuego("TWD - Season 2", "TWD - Season 2", 29.99, 100, "http://res.cloudinary.com/ggrosario/image/upload/v1471673327/rxooukv6569bgyutgmtq.jpg", unaTienda.getCatalogos().get(0));
            unaTienda.addJuego("Minecraft Story mode", "Minecraft story mode", 29.99, 100, "http://res.cloudinary.com/ggrosario/image/upload/v1471669709/py3dtjdeogwur8oyhhku.jpg", unaTienda.getCatalogos().get(0));
            unaTienda.addJuego("Minecraft", "Minecraft", 29.99, 100, "http://res.cloudinary.com/ggrosario/image/upload/v1471653658/vxlkg6gqeoojkczcymxu.jpg", unaTienda.getCatalogos().get(0));
            unaTienda.addJuego("Overwatch", "Overwatch", 29.99, 100, "http://res.cloudinary.com/ggrosario/image/upload/v1471673661/qfqsk4wuu7lvndo1wlbj.jpg", unaTienda.getCatalogos().get(0));

        } catch (JuegoException ex) {
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
