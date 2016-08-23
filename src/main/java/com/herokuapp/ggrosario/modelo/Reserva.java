package com.herokuapp.ggrosario.modelo;

import com.herokuapp.ggrosario.util.HibernateUtil;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Ojeda Alberto Daniel
 */
@Entity
@Table(name = "Reservas")
public class Reserva implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    private Usuario unUsuario;

    @ManyToOne
    private Juego unJuego;

    @Column(name = "fecha_alta")
    private GregorianCalendar fechaAlta;

    @Column(name = "fecha_baja")
    private GregorianCalendar fechaBaja;

    /**
     * Constructor nulo
     */
    public Reserva() {
    }

    /**
     * Constructor para instanciar una reserva
     *
     * @param unUsuario Usuario que hace la reserva
     * @param unJuego Juego que reserva el usuario
     */
    public Reserva(Usuario unUsuario, Juego unJuego) {
        this();
        this.unUsuario = (Usuario) unUsuario;
        this.unJuego = (Juego) unJuego;
        this.fechaAlta = new GregorianCalendar();
        this.fechaBaja = this.fechaAlta;
        this.fechaBaja.add(Calendar.DAY_OF_MONTH, 5); // Try to get out of hardcoding this
        HibernateUtil.guardar(this);
    }

    /**
     * Verifica si el juego que la reserva tiene asociado es el mismo que el que
     * se le envia
     *
     * @param unJuego Juego a comparar con el de la reserva
     * @return <code>true</code> si el juego enviado como parámetro es el mismo
     * que el que contiene la reserva, en caso contrario devuelve
     * <code>false</code>
     */
    public boolean isJuego(Juego unJuego) {
        return this.unJuego == unJuego;
    }
    
    public boolean isValida(){
        if (new GregorianCalendar().before(this.fechaBaja)){
            return true;
        }
        return false;
    }

    // <editor-fold defaultstate="collapsed" desc="Getters and setters methods. Click on the + sign on the left to edit the code.">
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUnUsuario() {
        return unUsuario;
    }

    public void setUnUsuario(Usuario unUsuario) {
        this.unUsuario = unUsuario;
    }

    public Juego getUnJuego() {
        return unJuego;
    }

    public void setUnJuego(Juego unJuego) {
        this.unJuego = unJuego;
    }

    public GregorianCalendar getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(GregorianCalendar fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public GregorianCalendar getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(GregorianCalendar fechaBaja) {
        this.fechaBaja = fechaBaja;
    }
    // <editor-fold>
}
