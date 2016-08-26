package com.herokuapp.ggrosario.modelo;

import com.herokuapp.ggrosario.util.HibernateUtil;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Ojeda Alberto Daniel
 */

@Entity
@Table(name = "stocks")
public class Stock implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @Column(name = "cantidad")
    private int cantidad;
    
    @ManyToOne
    @JoinColumn(name = "fk_tienda_nombre", referencedColumnName = "nombre")
    private Tienda unaTienda;
    
    @OneToOne
    @JoinColumn(name = "fk_juego_id", referencedColumnName = "id")
    private Juego unJuego;

    public Stock() {
    }

    public Stock(int cantidad, Tienda unaTienda, Juego unJuego) {
        this();
        this.cantidad = cantidad;
        this.unaTienda = (Tienda) unaTienda;
        this.unJuego = (Juego) unJuego;
        HibernateUtil.guardar(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Tienda getUnaTienda() {
        return unaTienda;
    }

    public void setUnaTienda(Tienda unaTienda) {
        this.unaTienda = unaTienda;
    }

    public Juego getUnJuego() {
        return unJuego;
    }

    public void setUnJuego(Juego unJuego) {
        this.unJuego = unJuego;
    }
    
    
    
}
