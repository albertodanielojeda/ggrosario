package com.herokuapp.ggrosario.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.herokuapp.ggrosario.util.HibernateUtil;
import java.util.Date;
import javax.persistence.OneToOne;

/**
 *
 * @author Ojeda Alberto Daniel
 */
@Entity
@Table(name = "juegos")
public class Juego implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion", columnDefinition = "text")
    private String descripcion;

    @Column(name = "precio")
    private double precio;

    @OneToOne
    private Stock stock;

    @ManyToOne
    private Categoria unaCategoria;

    @ManyToOne
    private Catalogo unCatalogo;

    @Column(name = "cover")
    private String cover;

    @Column(name = "fecha_alta")
    private Date fechaAlta;

    @OneToOne
    private Requisito requisitosMinimos;
    @OneToOne
    private Requisito requisitosRecomendados;

    @ManyToOne
    private Tienda unaTienda;

    @OneToMany(mappedBy = "unJuego")
    private List<ListaDeseosJuegos> unaListaDeseosJuegos;

    @OneToMany(mappedBy = "unJuego")
    private List<JuegoComentario> juegosComentarios;

    @OneToMany(mappedBy = "unJuego")
    private List<JuegoReserva> reservas;

    /**
     * Constructor nulo para inicializar las colecciones
     */
    public Juego() {
        this.unaListaDeseosJuegos = new ArrayList<>();
        this.juegosComentarios = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }

    /**
     * Constructor para instanciar un juego (cuando la tienda se organiza
     * únicamente por catálogos)
     *
     * @param nombre Nombre del juego
     * @param descripcion Descripción del juego
     * @param precio Precio del juego
     * @param requisitosMinimos Requisitos mínimos que debe cumplir una
     * computadora para ejecutar el juego
     * @param requisitosRecomendados Requisitos recomendados que debe cumplir
     * una computadora para ejecutar el juego
     * @param cover URL a la portada del juego
     * @param unCatalogo El catálogo al que pertenece el juego
     * @param unaTienda La tienda que vende el juego
     */
    public Juego(String nombre, String descripcion, double precio, String cover, Catalogo unCatalogo, Tienda unaTienda, Requisito requisitosMinimos, Requisito requisitosRecomendados) {
        this();
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cover = cover;
        this.unaTienda = unaTienda;
        this.fechaAlta = new Date();
        this.unCatalogo = unCatalogo;
        this.requisitosMinimos = requisitosMinimos;
        this.requisitosRecomendados = requisitosRecomendados;
        HibernateUtil.guardar(this);
    }

    /**
     * Constructor para instanciar un juego (cuando la tienda se organiza por
     * catálogos y categorías de catálogos)
     *
     * @param nombre Nombre del juego
     * @param descripcion Descripción del juego
     * @param precio Precio del juego
     * @param cover URL a la portada del juego
     * @param unCatalogo El catálogo al que pertenece el juego
     * @param unaCategoria La categoría del catálogo a la que pertenece el juego
     * @param unaTienda La tienda que vende el juego
     */
    public Juego(String nombre, String descripcion, double precio, String cover, Catalogo unCatalogo, Categoria unaCategoria, Tienda unaTienda) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cover = cover;
        this.unaTienda = unaTienda;
        this.fechaAlta = new Date();
        this.unCatalogo = unCatalogo;
        if (this.unCatalogo != null) {
            this.unCatalogo.addJuego(this);
        }
        this.unaCategoria = unaCategoria;
        if (this.unaCategoria != null) {
            this.unaCategoria.addJuego(this);
        }
        HibernateUtil.guardar(this);
    }

    public void addComentario(Comentario unComentario) {
        this.juegosComentarios.add(new JuegoComentario(this, unComentario));
        HibernateUtil.actualizar(this);
    }

    public void addReserva(Reserva unaReserva) {
        JuegoReserva juegoReserva = new JuegoReserva(this, unaReserva);
        this.reservas.add(juegoReserva);
        HibernateUtil.actualizar(this);
    }

    // <editor-fold defaultstate="collapsed" desc="Getters and setters methods. Click on the + sign on the left to edit the code.">
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean hasStock() {
        if (this.stock.getCantidad() > 0) {
            return true;
        }
        return false;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
        HibernateUtil.actualizar(this);
    }

    public Stock getStock() {
        return stock;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public Requisito getRequisitosMinimos() {
        return requisitosMinimos;
    }

    public void setRequisitosMinimos(Requisito requisitosMinimos) {
        this.requisitosMinimos = requisitosMinimos;
        HibernateUtil.actualizar(this);
    }

    public Requisito getRequisitosRecomendados() {
        return requisitosRecomendados;
    }

    public void setRequisitosRecomendados(Requisito requisitosRecomendados) {
        this.requisitosRecomendados = requisitosRecomendados;
        HibernateUtil.actualizar(this);
    }

    public Categoria getUnaCategoria() {
        return unaCategoria;
    }

    public void setUnaCategoria(Categoria unaCategoria) {
        this.unaCategoria = unaCategoria;
    }

    public Catalogo getUnCatalogo() {
        return unCatalogo;
    }

    public void setUnCatalogo(Catalogo unCatalogo) {
        this.unCatalogo = unCatalogo;
    }

    public List<JuegoComentario> getComentarios() {
        return juegosComentarios;
    }

    public void setComentarios(List<JuegoComentario> comentarios) {
        this.juegosComentarios = comentarios;
    }

    public Tienda getTienda() {
        return unaTienda;
    }

    public void setTienda(Tienda tienda) {
        this.unaTienda = tienda;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Tienda getUnaTienda() {
        return unaTienda;
    }

    public void setUnaTienda(Tienda unaTienda) {
        this.unaTienda = unaTienda;
    }

    public List<JuegoComentario> getJuegosComentarios() {
        return juegosComentarios;
    }

    public void setJuegosComentarios(List<JuegoComentario> juegosComentarios) {
        this.juegosComentarios = juegosComentarios;
    }

    public List<JuegoReserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<JuegoReserva> reservas) {
        this.reservas = reservas;
    }

    public List<ListaDeseosJuegos> getUnaListaDeseosJuegos() {
        return unaListaDeseosJuegos;
    }

    public void setUnaListaDeseosJuegos(List<ListaDeseosJuegos> unaListaDeseosJuegos) {
        this.unaListaDeseosJuegos = unaListaDeseosJuegos;
    }

    // </editor-fold>
}
