package com.herokuapp.ggrosario.servlet.auth;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.herokuapp.ggrosario.modelo.Tienda;
import com.herokuapp.ggrosario.modelo.Usuario;
import javax.servlet.annotation.WebServlet;

/**
 *
 * @author Ojeda Alberto Daniel
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

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

        String id = request.getParameter("nick");
        String password = request.getParameter("password");

        Usuario miUsuario = (Usuario) Tienda.getInstance().buscarUsuario(id);

        if (miUsuario != null && miUsuario.getPassword().equals(password)) {
            request.getSession().setAttribute("miUsuario", miUsuario);
            request.getSession().setAttribute("success", true);
        } else {
            request.getSession().setAttribute("success", false);
            response.sendRedirect("registrarme");
            return;
        }
        request.getSession().setAttribute("unaTienda", Tienda.getInstance());
        response.sendRedirect("index");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Servlet for login users";
    }

}
