package com.herokuapp.ggrosario.modelo;

import java.io.Serializable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ojeda Alberto Daniel
 */

public final class Configuracion implements Serializable{

    /* Cantidad de días hábiles de validez de una reserva */
    private int diasValidezReserva;

    /* Cantidad de reservas minimas que debe tener un juego para aparecer entre los más reservados */
    private int reservasMinimas;

    /* Lugar donde se registran los juegos (en un catálogo o en una categoría de un catálogo) */
    private boolean registroJuegosCatalogo;
    private boolean registroJuegosCategoriaDeCatalogo;
    
    private String estadoReservaNueva;
    private String estadoReservaCaducada;
    private String estadoReservaCumplida;
    
    private Properties propiedades;
    
    private static final String NOMBRE_ARCHIVO_PROPIEDADES = "configuracion.properties";

    public Configuracion() {
        try {
            InputStream contenidoArchivoPropiedades = getClass().getClassLoader().getResourceAsStream(NOMBRE_ARCHIVO_PROPIEDADES);
            propiedades = new Properties();
            propiedades.load(contenidoArchivoPropiedades);
            contenidoArchivoPropiedades.close();
            this.setDiasValidezReserva(Integer.valueOf(propiedades.getProperty("validezReserva")));
            this.setReservasMinimas(Integer.valueOf(propiedades.getProperty("reservasMinimas")));
            this.setRegistroJuegosCatalogo(Boolean.valueOf(propiedades.getProperty("organizacionCatalogos")));
            if (this.isRegistroJuegosCatalogo()){
                propiedades.setProperty("organizacionCategoriasCatalogos", "false");
            }else{
                propiedades.setProperty("organizacionCategoriasCatalogos", "true");
            }
            this.setRegistroJuegosCategoriaDeCatalogo(Boolean.valueOf(propiedades.getProperty("organizacionCategoriasCatalogos")));
            this.setEstadoReservaNueva(propiedades.getProperty("estadoReservaNueva"));
            this.setEstadoReservaCaducada(propiedades.getProperty("estadoReservaCaducada"));
            this.setEstadoReservaCumplida(propiedades.getProperty("estadoReservaCumplida"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Configuracion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Configuracion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Getters and setters methods. Click on the + sign on the left to edit the code.">
    public int getDiasValidezReserva() {
        return diasValidezReserva;
    }

    public void setDiasValidezReserva(int diasValidezReserva) {
        this.propiedades.setProperty("validezReserva", String.valueOf(diasValidezReserva));
        this.diasValidezReserva = Integer.valueOf(this.propiedades.getProperty("validezReserva"));
    }

    public int getReservasMinimas() {
        return reservasMinimas;
    }

    public void setReservasMinimas(int reservasMinimas) {
        this.propiedades.setProperty("reservasMinimas", String.valueOf(reservasMinimas));
        this.reservasMinimas = Integer.valueOf(this.propiedades.getProperty("reservasMinimas"));
    }

    public boolean isRegistroJuegosCatalogo() {
        return registroJuegosCatalogo;
    }

    public void setRegistroJuegosCatalogo(boolean registroJuegosCatalogo) {
        boolean valor;
        this.propiedades.setProperty("organizacionCatalogos", String.valueOf(registroJuegosCatalogo));
        this.registroJuegosCatalogo = Boolean.valueOf(this.propiedades.getProperty("organizacionCatalogos"));
        if (this.isRegistroJuegosCatalogo()){
            propiedades.setProperty("organizacionCategoriasCatalogos", "false");
            valor = Boolean.valueOf(propiedades.getProperty("organizacionCategoriasCatalogos"));
            this.registroJuegosCategoriaDeCatalogo = valor;
        }else{
            propiedades.setProperty("organizacionCategoriasCatalogos", "true");
            valor = Boolean.valueOf(propiedades.getProperty("organizacionCategoriasCatalogos"));
            this.registroJuegosCategoriaDeCatalogo = valor;
        }
    }

    public boolean isRegistroJuegosCategoriaDeCatalogo() {
        return registroJuegosCategoriaDeCatalogo;
    }

    public void setRegistroJuegosCategoriaDeCatalogo(boolean registroJuegosCategoriaDeCatalogo) {
        boolean valor;
        this.propiedades.setProperty("organizacionCategoriasCatalogos", String.valueOf(registroJuegosCategoriaDeCatalogo));
        this.registroJuegosCategoriaDeCatalogo = Boolean.valueOf(this.propiedades.getProperty("organizacionCategoriasCatalogos"));
        if (this.isRegistroJuegosCategoriaDeCatalogo()){
            propiedades.setProperty("organizacionCatalogos", "false");
            valor = Boolean.valueOf(propiedades.getProperty("organizacionCatalogos"));
            this.registroJuegosCatalogo = valor;
        }else{
            propiedades.setProperty("organizacionCatalogos", "true");
            valor = Boolean.valueOf(propiedades.getProperty("organizacionCatalogos"));
            this.registroJuegosCatalogo = valor;
        }
    }
    
    public String getEstadoReservaNueva() {
        return estadoReservaNueva;
    }

    public void setEstadoReservaNueva(String estadoReservaNueva) {
        this.estadoReservaNueva = estadoReservaNueva;
    }

    public String getEstadoReservaCaducada() {
        return estadoReservaCaducada;
    }

    public void setEstadoReservaCaducada(String estadoReservaCaducada) {
        this.estadoReservaCaducada = estadoReservaCaducada;
    }

    public String getEstadoReservaCumplida() {
        return estadoReservaCumplida;
    }

    public void setEstadoReservaCumplida(String estadoReservaCumplida) {
        this.estadoReservaCumplida = estadoReservaCumplida;
    }

    // </editor-fold>

}
