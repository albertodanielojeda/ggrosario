package com.herokuapp.ggrosario.servlet.usuario;

import com.herokuapp.ggrosario.exepciones.UsuarioException;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.herokuapp.ggrosario.modelo.Tienda;
import com.herokuapp.ggrosario.modelo.Usuario;
import com.herokuapp.ggrosario.util.HibernateUtil;
import javax.servlet.annotation.WebServlet;

/**
 *
 * @author Ojeda Alberto Daniel
 */
@WebServlet(name = "RegistrarUsuarioServlet", urlPatterns = {"/registrar-usuario"})
public class RegistrarUsuarioServlet extends HttpServlet {

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
        String rol = request.getParameter("rol");
        /** Gets null **/
        Usuario usuarioRegistrante = (Usuario)request.getSession().getAttribute("usuarioRegistrante");
        String email = request.getParameter("email");
        String nick = request.getParameter("nick");
        String password = request.getParameter("password");
        String fechaNacimiento = request.getParameter("fechanacimiento");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String telefono = request.getParameter("telefono");
        
        // Cuando se usa el formulario de "Regisrarse"
        if (rol == null){
            rol = "Cliente";
        }
        
        try {
            Tienda.getInstance().addUsuario(email, nick, password, new Date(fechaNacimiento), nombre, apellido, telefono, Tienda.getInstance().buscarRol(rol));
        } catch (UsuarioException ex) {
            Logger.getLogger(RegistrarUsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.getSession().setAttribute("unaTienda", Tienda.getInstance());
        
        if (usuarioRegistrante != null && usuarioRegistrante.canAccederPanelAdministracion()){
            response.sendRedirect("admin/gestion-usuarios?rol="+rol);
        }else{
            response.sendRedirect("index");
        }
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
