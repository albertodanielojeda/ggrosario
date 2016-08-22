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

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "precio")
    private double precio;

    @Column(name = "stock")
    private int stock;

    @ManyToOne
    private Categoria unaCategoria;

    @ManyToOne
    private Catalogo unCatalogo;

    @OneToMany
    private List<Comentario> comentarios;

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
    private List<Reserva> reservas;

    /**
     * Constructor nulo para inicializar las colecciones
     */
    public Juego() {
        this.comentarios = new ArrayList<>();
    }

    /**
     * Constructor para instanciar un juego (cuando la tienda se organiza
     * únicamente por catálogos)
     *
     * @param nombre Nombre del juego
     * @param descripcion Descripción del juego
     * @param precio Precio del juegi
     * @param stock Cantidad de unidades del juego disponibles desde que se
     * registra en el sistema
     * @param cover URL a la portada del juego
     * @param unCatalogo El catálogo al que pertenece el juego
     * @param unaTienda La tienda que vende el juego
     */
    public Juego(String nombre, String descripcion, double precio, int stock, String cover, Catalogo unCatalogo, Tienda unaTienda) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.cover = cover;
        this.unaTienda = unaTienda;
        this.fechaAlta = new Date();
        this.unCatalogo = unCatalogo;
        if (this.unCatalogo != null) {
            this.unCatalogo.addJuego(this);
        }
        HibernateUtil.guardar(this);
    }

    /**
     * Constructor para instanciar un juego (cuando la tienda se organiza por
     * catálogos y categorías de catálogos)
     *
     * @param nombre Nombre del juego
     * @param descripcion Descripción del juego
     * @param precio Precio del juegi
     * @param stock Cantidad de unidades del juego disponibles desde que se
     * registra en el sistema
     * @param cover URL a la portada del juego
     * @param unCatalogo El catálogo al que pertenece el juego
     * @param unaCategoria La categoría del catálogo a la que pertenece el juego
     * @param unaTienda La tienda que vende el juego
     */
    public Juego(String nombre, String descripcion, double precio, int stock, String cover, Catalogo unCatalogo, Categoria unaCategoria, Tienda unaTienda) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
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

    public boolean isStock() {
        if (this.stock > 0) {
            return true;
        }
        return false;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getStock() {
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
    }

    public Requisito getRequisitosRecomendados() {
        return requisitosRecomendados;
    }

    public void setRequisitosRecomendados(Requisito requisitosRecomendados) {
        this.requisitosRecomendados = requisitosRecomendados;
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

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
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
    
    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }
    
    // </editor-fold>

}
