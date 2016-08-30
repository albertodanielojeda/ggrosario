package com.herokuapp.ggrosario.servlet.juego;

import com.herokuapp.ggrosario.modelo.Catalogo;
import com.herokuapp.ggrosario.modelo.Juego;
import com.herokuapp.ggrosario.modelo.Tienda;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ojeda Alberto Daniel
 */
@WebServlet(name = "BuscarJuegosServlet", urlPatterns = {"/buscar-juegos"})
public class BuscarJuegosServlet extends HttpServlet {

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
        String idCatalogo = request.getParameter("idCatalogo");
        String juegosABuscar = request.getParameter("buscarJuegos");
        Tienda unaTienda = Tienda.getInstance();
        Catalogo unCatalogo = unaTienda.buscarCatalogo(Integer.valueOf(idCatalogo));
        List<Juego> juegosEntontrados = new ArrayList<>();
        if (juegosABuscar.contains(",")) {
            String[] nombresJuegos = juegosABuscar.split(",");
            for (String nombreJuego : nombresJuegos) {
                for (Juego juegoCatalogo : unCatalogo.getJuegos()) {
                    if (juegoCatalogo.getNombre().toLowerCase().contains(nombreJuego.trim().toLowerCase())) {
                        juegosEntontrados.add(juegoCatalogo);
                    }
                }
            }

        } else {
            String juegoABuscar = juegosABuscar.split(",")[0];
            for (Juego juegoCatalogo : unCatalogo.getJuegos()) {
                if (juegoCatalogo.getNombre().toLowerCase().contains(juegoABuscar.trim().toLowerCase())) {
                    juegosEntontrados.add(juegoCatalogo);
                }
            }
        }

        if (juegosEntontrados.isEmpty()) {
            request.getSession().setAttribute("encontrado", false);
        } else {
            request.getSession().setAttribute("encontrado", true);
            request.getSession().setAttribute("juegosEncontrados", juegosEntontrados);
        }

        response.sendRedirect("catalogo?id=" + idCatalogo);
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
        return "Busca uno o más juegos";
    }

}
