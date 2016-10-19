package com.herokuapp.ggrosario.servlet.admin.juego;

import com.herokuapp.ggrosario.modelo.Juego;
import com.herokuapp.ggrosario.modelo.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alber
 */
@WebServlet(name = "CambiarPrecioJuegoServlet", urlPatterns = {"/admin/cambiar-precio-juego"})
public class CambiarPrecioJuegoServlet extends HttpServlet {

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
        
        Usuario usuario = (Usuario) request.getSession().getAttribute("miUsuario");
        Juego unJuego = (Juego) request.getSession().getAttribute("unJuego");
        String precio = request.getParameter("precio");
        String mensajeEdicionJuego = null;
        try {
            if (Double.parseDouble(precio) > 0) {
                unJuego.setPrecio(Double.parseDouble(precio));
                mensajeEdicionJuego = "Datos del juego modificados con éxito!";
            }else{
                throw new NumberFormatException("Se debe ingresar un número decimal positivo para poder modificar el precio");
            }
        } catch (NumberFormatException e) {
            mensajeEdicionJuego = "Se debe ingresar un número decimal positivo para poder modificar el precio";
        }
        request.getSession().setAttribute("mensajeEdicionJuego", mensajeEdicionJuego);
        response.sendRedirect("../admin/verDetallesJuego?idJuego="+unJuego.getId());

        
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
