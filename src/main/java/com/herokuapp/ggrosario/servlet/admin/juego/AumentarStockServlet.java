package com.herokuapp.ggrosario.servlet.admin.juego;

import com.herokuapp.ggrosario.modelo.Juego;
import com.herokuapp.ggrosario.modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alber
 */
@WebServlet(name = "AumentarStockServlet", urlPatterns = {"/admin/aumentar-stock"})
public class AumentarStockServlet extends HttpServlet {

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

        Usuario usuario = (Usuario) request.getSession().getAttribute("miUsuario");
        Juego unJuego = (Juego) request.getSession().getAttribute("unJuego");
        String stock = request.getParameter("stock");
        String mensajeEdicionJuego = null;
        try {
            if (Integer.parseInt(stock) > 0) {
                unJuego.getStock().setCantidad(unJuego.getStock().getCantidad() + Integer.parseInt(stock));
                mensajeEdicionJuego = "Datos del juego modificados con éxito!";
            }else{
                throw new NumberFormatException("Se debe ingresar un número positivo para poder modificar el stock");
            }
        } catch (NumberFormatException e) {
            mensajeEdicionJuego = "Se debe ingresar un número positivo para poder modificar el stock";
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
    }// </editor-fold>

}
