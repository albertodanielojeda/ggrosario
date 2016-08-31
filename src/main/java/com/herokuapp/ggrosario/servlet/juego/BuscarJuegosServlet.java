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
        /* Obtiene el id del catálogo en el que buscar los juegos */
        String idCatalogo = request.getParameter("idCatalogo");
        /* Obtiene la cadena de juegos a buscar */
        String juegosABuscar = request.getParameter("buscarJuegos");
        
        /* Recuperamos los objetos para poder buscar el juego*/
        Tienda unaTienda = Tienda.getInstance();
        Catalogo unCatalogo = unaTienda.buscarCatalogo(Integer.valueOf(idCatalogo));
        
        /* Estructura donde se guardarán los juegos encontrados */
        List<Juego> juegosEntontrados = new ArrayList<>();
        /* Si se busca más de un juego, la cadena contentrá comas <","> */
        if (juegosABuscar.contains(",")) {
            /* Divide la cadena en un array usando la coma como delimitador */
            String[] nombresJuegos = juegosABuscar.split(",");
            /* Por cada nombre de juego en el array */
            for (String nombreJuego : nombresJuegos) {
                /* Se va a comparar el nombre de cada juego por el primero del array (siempre en minúsculas) */
                for (Juego juegoCatalogo : unCatalogo.getJuegos()) {
                    /* Si un juego contiene en su nombre una secuencia de caracteres igual a la que 
                     se está buscando, lo agrega a la colección de juegos encontrados */
                    if (juegoCatalogo.getNombre().toLowerCase().contains(nombreJuego.trim().toLowerCase())) {
                        juegosEntontrados.add(juegoCatalogo);
                    }
                }
            }
        /* Si la cadena de búsqueda no tiene comas, se busca el juego tal como se introdujo */
        } else {
            for (Juego juegoCatalogo : unCatalogo.getJuegos()) {
                if (juegoCatalogo.getNombre().toLowerCase().contains(juegosABuscar.trim().toLowerCase())) {
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
