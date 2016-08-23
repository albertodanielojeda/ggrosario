package com.herokuapp.ggrosario.servlet.admin.juego;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.herokuapp.ggrosario.exepciones.JuegoException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.herokuapp.ggrosario.modelo.Catalogo;
import com.herokuapp.ggrosario.modelo.Tienda;
import com.herokuapp.ggrosario.util.HibernateUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Map;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Part;

/**
 *
 * @author Ojeda Alberto Daniel
 */
@WebServlet(name = "RegistrarJuegoServlet", urlPatterns = {"/admin/registrar-juego"})
@MultipartConfig
public class RegistrarJuegoServlet extends HttpServlet {

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

        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        String precio = request.getParameter("precio");
        String stock = request.getParameter("stock");
        Part coverPart = request.getPart("cover");
        String idCatalogo = request.getParameter("listaCatalogos");

        String apiKey = "594979417922161";
        String apiSecret = "kW0lFSLADk8vp8ma_QgX6dFFMjE";
        String cloudName = "ggrosario";

        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", cloudName,
                "api_key", apiKey,
                "api_secret", apiSecret));

        InputStream fileContent = coverPart.getInputStream();
        File toUpload = new File(coverPart.getSubmittedFileName());
        FileOutputStream fos = new FileOutputStream(toUpload);
        int dato;
        while ((dato = fileContent.read()) != -1) {
            fos.write(dato);
        }

        Map uploadMapResult = cloudinary.uploader().upload(toUpload, ObjectUtils.emptyMap());
        
        Tienda unaTienda = Tienda.getInstance();
        if (unaTienda.getUnaConfiguracion().isRegistroJuegosCatalogo()) {
            Catalogo unCatalogo = unaTienda.getUnCatalogo(Integer.valueOf(idCatalogo));
            if (unCatalogo != null) {
                try {
                    unaTienda.addJuego(nombre, descripcion, Double.valueOf(precio), Integer.valueOf(stock), uploadMapResult.get("secure_url").toString(), unCatalogo, null);

                } catch (JuegoException ex) {
                    Logger.getLogger(RegistrarJuegoServlet.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    request.getSession().setAttribute("unaTienda", unaTienda);
                    response.sendRedirect("../admin/gestion-juegos");
                }
            }

        } else if (unaTienda.getUnaConfiguracion().isRegistroJuegosCategoriaDeCatalogo()) {

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
