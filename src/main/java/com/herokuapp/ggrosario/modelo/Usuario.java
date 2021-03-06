package com.herokuapp.ggrosario.modelo;

import com.herokuapp.ggrosario.exepciones.RolException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import com.herokuapp.ggrosario.util.HibernateUtil;

/**
 *
 * @author Ojeda Alberto Daniel
 */
@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

    @Id
    @Column(name = "email")
    private String email;
    @Id
    @Column(name = "nick")
    private String nick;

    @Column(name = "password")
    private String password;

    @Column(name = "fecha_nacimiento")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaNacimiento;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "telefono")
    private String telefono;

    @OneToOne
    private ListaDeseos unaListaDeseos;

    @ManyToOne
    private Tienda unaTienda;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Rol> roles;

    @OneToMany(mappedBy = "unUsuario")
    private List<Reserva> reservas;

    @OneToMany(mappedBy = "unUsuario")
    private List<UsuarioComentario> comentarios;

    /**
     * Constructor nulo para inicializar las colecciones
     */
    public Usuario() {
        this.roles = new ArrayList<>();
        this.comentarios = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }

    /**
     * Constructor para instanciar un usuario
     *
     * @param email E-Mail del usuario
     * @param nick Nick del usuario
     * @param password Contraseña del usuario
     * @param fechaNacimiento Fecha de nacimiento del usuario
     * @param nombre Nombre del usuario
     * @param apellido Apellido del usuario
     * @param telefono Teléfono del usuario
     * @param unRol Rol por defecto que tendrá el usuario
     * @param unaTienda Tienda a la que pertenecerá el usuario
     */
    public Usuario(String email, String nick, String password, Date fechaNacimiento, String nombre, String apellido, String telefono, Tienda unaTienda, Rol unRol) {
        this();
        this.email = email;
        this.nick = nick;
        this.password = password;
        this.fechaNacimiento = fechaNacimiento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.unaTienda = (Tienda) unaTienda;
        this.unaListaDeseos = new ListaDeseos(this);
        this.roles.add(unRol);
        unRol.addUsuario(this);
        HibernateUtil.guardar(this);
    }

    /**
     * Agrega un rol a un usuario
     *
     * @param unRol Rol que se quiere asignar al usuario
     * @throws RolException Si el usuario tiene asociado el rol especificado
     */
    public void addRol(Rol unRol) throws RolException {
        if (!this.hasRol(unRol.getNombre())) {
            unRol.addUsuario(this);
            this.roles.add(unRol);
            HibernateUtil.actualizar(this);
        } else {
            throw new RolException("El usuario ya tiene este rol");
        }
    }

    /**
     * Evalúa si este usuario tiene un rol determinado
     *
     * @param nombreRol Rol que se espera que el usuario tenga, o no
     * @return <code>true</code> Si tiene el rol especificado o
     * <code>false</code> en caso contrario
     */
    public boolean hasRol(String nombreRol) {
        for (Rol rol : this.roles){
            if (rol.getNombre().equals(nombreRol)){
                return true;
            }
        }
        return false;
    }

    /**
     * Evalúa si este usuario puede acceder al panel de administración
     *
     * @return <code>true</code> si tiene algún rol que le permita acceder al
     * panel de administración o <code>false</code> en caso contrario
     */
    public boolean canAccederPanelAdministracion() {
        for (Rol unRol : this.roles) {
            if (unRol.getPermisos().canAccederPanelAdministracion()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Agrega un juego a su lista de reservas
     *
     * @param unJuego Juego que el usuario quiere agregar a su lista de reservas
     * @param unaReserva Reserva asignada al usuario
     */
    public void addJuegoToReservas(Reserva unaReserva){
        this.reservas.add(unaReserva);
    }

    /**
     * Revisa si un juego existe o no en la lista de reservas del usuario
     *
     * @param unJuego Juego a revisar si está reservado o no por el usuario
     * @return <code>true</code> si el usuario ha reservado el juego, o
     * <code>false</code> en caso contrario
     */
    public boolean tieneReservado(Juego unJuego) {
        for (Reserva unaReserva : this.reservas) {
            if (unaReserva.getUnJuego() == unJuego) {
                return true;
            }
        }
        return false;
    }

    public void addComentario(Comentario unComentario) {
        UsuarioComentario usuarioComentario = new UsuarioComentario(this, unComentario);
        this.comentarios.add(usuarioComentario);
        unComentario.getUnJuego().addComentario(unComentario);
        HibernateUtil.actualizar(this);
    }
    
    public boolean canModificarCatalogo(){
        for (Rol rol : this.roles){
            if (rol.getPermisos().canModificacionCatalogo()){
                return true;
            }
        }
        return false;
    }
    
    public boolean canEliminarCatalogo(){
        for (Rol rol : this.roles){
            if (rol.getPermisos().canBajaCatalogo()){
                return true;
            }
        }
        return false;
    }
    
    public Reserva buscarReserva(int idReserva){
        for (Reserva reserva : this.reservas){
            if (reserva.getId() == idReserva){
                return reserva;
            }
        }
        return null;
    }

    // <editor-fold defaultstate="collapsed" desc="Getters and setters methods. Click on the + sign on the left to edit the code.">
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

    public ListaDeseos getUnaListaDeseos() {
        return unaListaDeseos;
    }

    public void setUnaListaDeseos(ListaDeseos unaListaDeseos) {
        this.unaListaDeseos = unaListaDeseos;
    }

    public Tienda getUnaTienda() {
        return unaTienda;
    }

    public void setUnaTienda(Tienda unaTienda) {
        this.unaTienda = unaTienda;
    }

    public List<UsuarioComentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<UsuarioComentario> comentarios) {
        this.comentarios = comentarios;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    // </editor-fold>
}
