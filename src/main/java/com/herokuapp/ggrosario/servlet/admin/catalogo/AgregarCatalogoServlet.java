package com.herokuapp.ggrosario.servlet.admin.catalogo;

import com.herokuapp.ggrosario.exepciones.CatalogoException;
import com.herokuapp.ggrosario.modelo.Rol;
import com.herokuapp.ggrosario.modelo.Tienda;
import com.herokuapp.ggrosario.modelo.Usuario;
import com.herokuapp.ggrosario.util.HibernateUtil;
import java.io.IOException;
import java.util.Iterator;
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
@WebServlet(name = "AgregarCatalogoServlet", urlPatterns = {"/admin/agregar-catalogo"})
public class AgregarCatalogoServlet extends HttpServlet {

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

        boolean puedeAgregarCatalogos = false;
        Usuario usuario = (Usuario) request.getSession().getAttribute("miUsuario");

        if (usuario != null) {

            Iterator iterRolesUsuario = usuario.getRoles().iterator();

            while (iterRolesUsuario.hasNext() && puedeAgregarCatalogos == false) {
                Rol rol = (Rol) iterRolesUsuario.next();
                if (rol.getPermisos().canAltaCatalogo()) {
                    puedeAgregarCatalogos = true;
                }
            }

            if (puedeAgregarCatalogos) {
                Tienda unaTienda = Tienda.getInstance();
                try {
                    unaTienda.addCatalogo(request.getParameter("nombreCatalogo"));
                    request.getSession().setAttribute("success", true);
                } catch (CatalogoException ex) {
                    request.getSession().setAttribute("success", false);
                    Logger.getLogger(AgregarCatalogoServlet.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    request.getSession().setAttribute("unaTienda", unaTienda);
                    response.sendRedirect("../admin/gestion-catalogos");
                }
            }else{
                response.sendError(403);
            }
        }else{
            response.sendError(403);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
