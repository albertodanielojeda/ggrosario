package com.herokuapp.ggrosario.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.herokuapp.ggrosario.util.HibernateUtil;

/**
 *
 * @author Ojeda Alberto Daniel
 */
@Entity
@Table(name = "configuracion")
public class Configuracion implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    /* Cantidad de días hábiles de validez de una reserva */
    @Column(name = "dias_validez_reserva")
    private int diasValidezReserva;

    /* Cantidad de reservas minimas que debe tener un juego para aparecer entre los más reservados */
    @Column(name = "reservas_minimas")
    private int reservasMinimas;

    /* Lugar donde se registran los juegos (en un catálogo o en una categoría de un catálogo) */
    @Column(name = "registro_juegos_catalogo")
    private boolean registroJuegosCatalogo;
    @Column(name = "registro_juegos_categoria_catalogo")
    private boolean registroJuegosCategoriaDeCatalogo;
    
    public Configuracion() {
    }

    public Configuracion(int diasValidezReserva, int reservasMinimas, boolean registroJuegosCatalogo, boolean registroJuegosCategoriaDeCatalogo) {
        this();
        this.diasValidezReserva = diasValidezReserva;
        this.reservasMinimas = reservasMinimas;
        this.registroJuegosCatalogo = registroJuegosCatalogo;
        this.registroJuegosCategoriaDeCatalogo = registroJuegosCategoriaDeCatalogo;
    }

    // <editor-fold defaultstate="collapsed" desc="Getters and setters methods. Click on the + sign on the left to edit the code.">
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDiasValidezReserva() {
        return diasValidezReserva;
    }

    public void setDiasValidezReserva(int diasValidezReserva) {
        this.diasValidezReserva = diasValidezReserva;
        HibernateUtil.actualizar(this);
    }

    public int getReservasMinimas() {
        return reservasMinimas;
    }

    public void setReservasMinimas(int reservasMinimas) {
        this.reservasMinimas = reservasMinimas;
        HibernateUtil.actualizar(this);
    }

    public boolean isRegistroJuegosCatalogo() {
        return registroJuegosCatalogo;
    }

    public void setRegistroJuegosCatalogo(boolean registroJuegosCatalogo) {
        this.registroJuegosCatalogo = registroJuegosCatalogo;
        this.registroJuegosCategoriaDeCatalogo = false;
        HibernateUtil.actualizar(this);
    }

    public boolean isRegistroJuegosCategoriaDeCatalogo() {
        return registroJuegosCategoriaDeCatalogo;
    }

    public void setRegistroJuegosCategoriaDeCatalogo(boolean registroJuegosCategoriaDeCatalogo) {
        this.registroJuegosCategoriaDeCatalogo = registroJuegosCategoriaDeCatalogo;
        this.registroJuegosCatalogo = false;
        HibernateUtil.actualizar(this);
    }
    // </editor-fold>

}
