package com.herokuapp.ggrosario.servlet.admin.rol;

import com.herokuapp.ggrosario.exepciones.RolException;
import com.herokuapp.ggrosario.modelo.Tienda;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ojeda Alberto Daniel
 */
@WebServlet(name = "AgregarRolServlet", urlPatterns = {"/admin/agregar-rol"})
public class AgregarRolServlet extends HttpServlet {

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

        Tienda unaTienda = Tienda.getInstance();

        String nombreRol = request.getParameter("nombreRol");

        if (unaTienda.buscarRol(nombreRol) == null) {
            String mensaje;
            try {
                unaTienda.addRol(nombreRol);
                mensaje = "Rol agregado con éxito!";
            } catch (RolException ex) {
                mensaje = ex.getMessage();
                Logger.getLogger(AgregarRolServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.getSession().setAttribute("mensaje", mensaje);
        }
        request.getSession().setAttribute("unaTienda", unaTienda);
        response.sendRedirect("../admin/gestionRolesPermisos.jsp");

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Agrega un rol sin permisos al sistema";
    }

}
