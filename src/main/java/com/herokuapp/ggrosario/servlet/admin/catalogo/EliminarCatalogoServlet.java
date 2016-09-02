/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.ggrosario.servlet.admin.catalogo;

import com.google.gson.Gson;
import com.herokuapp.ggrosario.modelo.Catalogo;
import com.herokuapp.ggrosario.modelo.Tienda;
import com.herokuapp.ggrosario.modelo.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ojeda Alberto Daniel
 */
@WebServlet(name = "EliminarCatalogoServlet", urlPatterns = {"/admin/eliminar-catalogo"})
public class EliminarCatalogoServlet extends HttpServlet {

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
        Usuario miUsuario = (Usuario) request.getSession().getAttribute("miUsuario");
        if (miUsuario != null && miUsuario.canEliminarCatalogo()) {
            Gson gson = new Gson();
            String respuesta;
            String mensaje;
            Tienda unaTienda = Tienda.getInstance();
            Catalogo unCatalogo = unaTienda.buscarCatalogo(Integer.valueOf(request.getParameter("id")));

            if (unCatalogo != null && unCatalogo.getJuegos().isEmpty()) {
                if (unaTienda.eliminarCatalogo(unCatalogo)) {
                    mensaje = "El catálogo ha sido eliminado satisfactoriamente";
                } else {
                    mensaje = "El catálogo a eliminar no existe o ya fue eliminado";
                }
            } else {
                mensaje = "El catálogo tiene juegos asociados y no puede ser dado de baja";
            }

            request.getSession().setAttribute("unaTienda", Tienda.getInstance());
            respuesta = gson.toJson(mensaje);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(respuesta);
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
