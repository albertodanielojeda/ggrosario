package com.herokuapp.ggrosario.modelo;

import com.herokuapp.ggrosario.util.HibernateUtil;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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

    @OneToOne
    private Juego unJuego;

    @Column(name = "fecha_alta")
    private Calendar fechaAlta;

    @Column(name = "fecha_baja")
    private Calendar fechaBaja;

    @OneToOne(mappedBy = "unaReserva")
    private EstadoReserva estadoReserva;
    
    @Column(name = "estado")
    private String estado;

    private static final SimpleDateFormat formatoDia = new SimpleDateFormat("dd/MM/yyyy");

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
        this.fechaAlta = Calendar.getInstance();
        this.fechaBaja = Calendar.getInstance();
        Date fechaActual = new Date();
        this.fechaAlta.setTime(fechaActual);
        this.fechaBaja.setTime(fechaActual);
        this.fechaBaja.add(Calendar.DATE, Tienda.getInstance().getUnaConfiguracion().getDiasValidezReserva());
        this.estado = Tienda.getInstance().getUnaConfiguracion().getEstadoReservaNueva();
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

    public boolean isValida() {
        if (new GregorianCalendar().before(this.fechaBaja) && this.estado.equals(Tienda.getInstance().getUnaConfiguracion().getEstadoReservaNueva())) {
            return true;
        }
        return false;
    }
    
    public boolean isCaducada(){
        if (new GregorianCalendar().after(this.fechaBaja) && this.estado.equals(Tienda.getInstance().getUnaConfiguracion().getEstadoReservaCaducada())){
            return true;
        }
        return false;
    }
    
    public boolean isCumplida(){
        if (this.estado.equals(Tienda.getInstance().getUnaConfiguracion().getEstadoReservaCumplida())){
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

    public EstadoReserva getEstadoReserva() {
        return estadoReserva;
    }

    public void setEstadoReserva(EstadoReserva estadoReserva) {
        this.estadoReserva = estadoReserva;
        HibernateUtil.actualizar(this);
    }

    public String getFechaAltaAsString() {
        return formatoDia.format(fechaAlta.getTime());
    }

    public Calendar getFecha() {
        return fechaAlta;
    }

    public void setFechaAlta(Calendar fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getFechaBajaAsString() {
        return formatoDia.format(fechaBaja.getTime());
    }

    public Calendar getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(Calendar fechaBaja) {
        this.fechaBaja = fechaBaja;
    }
    
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
        HibernateUtil.actualizar(this);
    }
    // <editor-fold>
}
