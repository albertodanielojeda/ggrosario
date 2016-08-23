package com.herokuapp.ggrosario.modelo;

import com.herokuapp.ggrosario.util.HibernateUtil;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Ojeda Alberto Daniel
 */
@Entity
@Table(name = "lista_deseos_juegos")
public class ListaDeseosJuegos implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "fk_lista_deseo_id", referencedColumnName = "id")
    private ListaDeseos unaListaDeseos;

    @Id
    @ManyToOne
    @JoinColumn(name = "fk_juego_id", referencedColumnName = "id")
    private Juego unJuego;

    /**
     * Constructor nulo
     */
    public ListaDeseosJuegos() {
    }

    /**
     * Constructor no nulo para crear un objeto que relaciona a una lista de
     * deseos con un juego
     *
     * @param unaListaDeseos Lista de deseos a relacionar con el juego
     * @param unJuego Juego a relacionar con la lista de deseos
     */
    public ListaDeseosJuegos(ListaDeseos unaListaDeseos, Juego unJuego) {
        this();
        this.unaListaDeseos = (ListaDeseos) unaListaDeseos;
        this.unJuego = (Juego) unJuego;
        HibernateUtil.guardar(this);
    }

    // <editor-fold defaultstate="collapsed" desc="Getters and setters methods. Click on the + sign on the left to edit the code.">
    public ListaDeseos getUnaListaDeseos() {
        return unaListaDeseos;
    }

    public void setUnaListaDeseos(ListaDeseos unaListaDeseos) {
        this.unaListaDeseos = unaListaDeseos;
    }

    public Juego getUnJuego() {
        return unJuego;
    }

    public void setUnJuego(Juego unJuego) {
        this.unJuego = unJuego;
    }
    // </editor-fold>

}
