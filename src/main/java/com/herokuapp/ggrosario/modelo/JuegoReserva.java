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
@Table(name = "juegos_reservas")
public class JuegoReserva implements Serializable {
    
    @Id
    @ManyToOne
    @JoinColumn(name = "fk_juego_id", referencedColumnName = "id")
    private Juego unJuego;

    @Id
    @ManyToOne
    @JoinColumn(name = "fk_reserva_id", referencedColumnName = "id")
    private Reserva unaReserva;

    public JuegoReserva() {
    }

    public JuegoReserva(Juego unJuego, Reserva unaReserva) {
        this.unJuego = (Juego) unJuego;
        this.unaReserva = (Reserva) unaReserva;
        HibernateUtil.guardar(this);
    }

    public Juego getUnJuego() {
        return unJuego;
    }

    public void setUnJuego(Juego unJuego) {
        this.unJuego = unJuego;
    }

    public Reserva getUnaReserva() {
        return unaReserva;
    }

    public void setUnaReserva(Reserva unaReserva) {
        this.unaReserva = unaReserva;
    }
    
    
}
