package com.herokuapp.ggrosario.servlet.juego;

import com.herokuapp.ggrosario.modelo.Tienda;
import com.herokuapp.ggrosario.modelo.Usuario;
import com.herokuapp.ggrosario.util.HibernateUtil;
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
@WebServlet(name = "AgregarJuegoListaDeseosServlet", urlPatterns = {"/agregar-a-lista-deseos"})
public class AgregarJuegoListaDeseosServlet extends HttpServlet {

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
        String idJuego = request.getParameter("idJuego");
        String idUsuario = request.getParameter("idUsuario");
        Usuario miUsuario = (Usuario)request.getSession().getAttribute("miUsuario");
        if (miUsuario.getNick().equals(idUsuario)){
            Tienda unaTienda = (Tienda)HibernateUtil.obtener("GG Rosario", "Tienda");
            miUsuario.getUnaListaDeseos().addJuego(unaTienda.getUnJuego(Integer.valueOf(idJuego)));
            request.getSession().setAttribute("miUsuario", miUsuario);
            response.getWriter().print("Listo!");
        }else{
            response.getWriter().print("Error!");
        }
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
        return "Agrega un juego a la lista de deseos de un usuario";
    }

}
