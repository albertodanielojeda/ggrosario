package com.herokuapp.ggrosario.modelo;

import com.herokuapp.ggrosario.util.HibernateUtil;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.Hibernate;

/**
 *
 * @author Ojeda Alberto Daniel
 */
@Entity
@Table(name = "lista_deseos_juegos")
public class ListaDeseosJuegos implements Serializable {
    
    @Id @ManyToOne
    @JoinColumn(name="fk_lista_deseo_id", referencedColumnName = "id")
    private ListaDeseos unaListaDeseos;
    
    @Id @ManyToOne
    @JoinColumn(name="fk_juego_id", referencedColumnName = "id")
    private Juego unJuego;

    public ListaDeseosJuegos() {
    }

    public ListaDeseosJuegos(ListaDeseos unaListaDeseos, Juego unJuego) {
        this();
        this.unaListaDeseos = unaListaDeseos;
        this.unJuego = unJuego;
        HibernateUtil.guardar(this);
    }

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
    
    
    
    
}
