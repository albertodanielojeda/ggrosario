package com.herokuapp.ggrosario.servlet.admin.reserva;

import com.google.gson.Gson;
import com.herokuapp.ggrosario.exepciones.JuegoException;
import com.herokuapp.ggrosario.modelo.Reserva;
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
@WebServlet(name = "ConfirmarCanjeReservaServlet", urlPatterns = {"/admin/confirmar-canje-reserva"})
public class ConfirmarCanjeReservaServlet extends HttpServlet {

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
        String idReserva = request.getParameter("idR");
        String idUsuario = request.getParameter("idU");

        Tienda unaTienda = Tienda.getInstance();
        String errorBuscarReserva = null;
        try {
            Reserva reserva = unaTienda.buscarUsuario(idUsuario).buscarReserva(Integer.parseInt(idReserva));
            if (reserva != null) {
                if (reserva.getUnJuego().getStock().getCantidad() > 0) {
                    request.getSession().setAttribute("reservaEncontrada", reserva);
                    reserva.setEstado(unaTienda.getUnaConfiguracion().getEstadoReservaCumplida());
                    reserva.getUnJuego().getStock().setCantidad(reserva.getUnJuego().getStock().getCantidad() - 1);
                }else{
                    throw new JuegoException("No hay unidades de juego disponible para canjear");
                }
            }
        } catch (NumberFormatException e) {
            errorBuscarReserva = "El número de la reserva debe ser un entero positivo";
            request.getSession().setAttribute("errorBuscarReserva", errorBuscarReserva);
        } catch (JuegoException ex) {
            errorBuscarReserva = ex.getMessage();
            request.getSession().setAttribute("errorBuscarReserva", errorBuscarReserva);
        }

        Gson gson = new Gson();
        String mensaje = "¡Canje realizado con éxito!";
        mensaje = gson.toJson(mensaje);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(mensaje);
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
