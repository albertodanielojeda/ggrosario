/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.ggrosario.servlet.juego;

import com.herokuapp.ggrosario.exepciones.JuegoException;
import com.herokuapp.ggrosario.modelo.Juego;
import com.herokuapp.ggrosario.modelo.Tienda;
import com.herokuapp.ggrosario.modelo.Usuario;
import com.herokuapp.ggrosario.util.HibernateUtil;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "ReservarJuegoServlet", urlPatterns = {"/reservar"})
public class ReservarJuegoServlet extends HttpServlet {

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
        Usuario miUsuario = (Usuario) request.getSession().getAttribute("miUsuario");
        if (miUsuario.getNick().equals(idUsuario)) {

            try {
                Tienda unaTienda = (Tienda) HibernateUtil.obtener("GG Rosario", "Tienda");
                Juego unJuego = (Juego)unaTienda.getUnJuego(Integer.valueOf(idJuego));
                miUsuario.addJuegoToReservas(unJuego);
                unJuego.setStock(unJuego.getStock() - 1);
                request.getSession().setAttribute("miUsuario", miUsuario);
                response.getWriter().print("Listo!");
            } catch (JuegoException ex) {
                Logger.getLogger(ReservarJuegoServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
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
        return "Reserva un juego para un cliente";
    }

}
