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
import javax.persistence.Table;

/**
 *
 * @author Ojeda Alberto Daniel
 */
@Entity
@Table(name = "estados_reservas")
public class EstadoReserva implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @Column(name = "descripcion")
    private String descripcion;
    
    @ManyToOne
    @JoinColumn(name = "fk_reserva_id", referencedColumnName = "id")
    private Reserva unaReserva;

    public EstadoReserva() {
    }

    public EstadoReserva(String descripcion, Reserva unaReserva) {
        this();
        this.descripcion = descripcion;
        this.unaReserva = (Reserva) unaReserva;
        HibernateUtil.guardar(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Reserva getUnaReserva() {
        return unaReserva;
    }

    public void setUnaReserva(Reserva unaReserva) {
        this.unaReserva = unaReserva;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
        HibernateUtil.actualizar(this);
    }
    
}
