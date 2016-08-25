package com.herokuapp.ggrosario.modelo;

import com.herokuapp.ggrosario.exepciones.CatalogoException;
import com.herokuapp.ggrosario.exepciones.JuegoException;
import com.herokuapp.ggrosario.exepciones.RolException;
import com.herokuapp.ggrosario.exepciones.UsuarioException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.herokuapp.ggrosario.util.HibernateUtil;
import java.util.Collections;
import java.util.Comparator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author Ojeda Alberto Daniel
 */
@Entity
@Table(name = "tienda")
public class Tienda implements Serializable {
    
    /* Columnas */
    @Id
    @Column(name = "nombre")
    private String nombre;

    /* Asociaciones */
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL)
    private List<Catalogo> catalogos;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "unaTienda", cascade = CascadeType.ALL)
    private List<Usuario> usuarios;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL)
    private List<Rol> roles;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "unaTienda")
    private List<Juego> juegos;

    private Configuracion unaConfiguracion;

    /**
     * Constructor nulo para inicializar las colecciones
     */
    public Tienda() {
        this.catalogos = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.roles = new ArrayList<>();
        this.juegos = new ArrayList<>();
    }

    /**
     * Constructor para instanciar una tienda
     *
     * @param nombre Nombre de la tienda
     * @param unaConfiguracion Propiedades del sistema de la tienda
     */
    public Tienda(String nombre, Configuracion unaConfiguracion) {
        this();
        this.nombre = nombre;
        this.unaConfiguracion = (Configuracion) unaConfiguracion;
        HibernateUtil.guardar(this);
    }
    
    /* Implementación del patrón Singleton */
    
    private static Tienda instance;
    
    public synchronized static Tienda getInstance(){
        if (instance == null){
            instance = (Tienda)HibernateUtil.obtener("GG Rosario", "Tienda");
        }
        //System.out.println(instance);
        return instance;
    }

    /**
     * Registra un usuario en la colección de la tienda
     *
     * @param email Email de registro del usuario
     * @param nick Nick del registro del usuario
     * @param password Contraseña del usuario
     * @param fechaNacimiento Fecha de nacimiento del usuario
     * @param nombre Nombre del usuario
     * @param apellido Apellido del usuario
     * @param telefono Teléfono del usuario
     * @param unRol Rol del usuario (debe existir antes de ser asignado)
     * @throws UsuarioException cuando ya existe un usuario registrado con
     * alguno de los siguientes datos: email, nick o telefono
     *
     */
    public void addUsuario(String email, String nick, String password, Date fechaNacimiento, String nombre, String apellido, String telefono, Rol unRol) throws UsuarioException {
        for (Usuario unUsuario : this.usuarios) {
            if (unUsuario.getEmail().equals(email)) {
                throw new UsuarioException("Ya se ha registrado un usuario con ese e-mail");
            } else if (unUsuario.getNick().equals(nick)) {
                throw new UsuarioException("Ya se ha registrado un usuario con ese nick");
            } else if (unUsuario.getTelefono().equals(telefono)) {
                throw new UsuarioException("Ya se ha registrado un usuario con ese teléfono");
            }
        }
        this.usuarios.add(new Usuario(email, nick, password, fechaNacimiento, nombre, apellido, telefono, this, unRol));
    }

    /**
     * Recupera un usuario de la colección de Tienda
     *
     * @param id Identificador del usuario (puede ser su email o su nick)
     * @return Usuario si lo encuentra o null si no lo encuentra
     *
     */
    public Usuario getUsuario(String id) {
        Iterator iter = this.usuarios.iterator();
        Usuario unUsuario = null;
        while (iter.hasNext()) {
            unUsuario = (Usuario) iter.next();
            if (unUsuario.getEmail().equals(id) || unUsuario.getNick().equals(id)) {
                return unUsuario;
            }
        }
        return unUsuario;
    }

    /**
     * Añade un rol para poder ser utilizado dentro del sistema de la tienda
     *
     * @param nombre Nombre del rol a agregar
     * @throws RolException Si ya existe un rol con el nombre especificado
     */
    public void addRol(String nombre) throws RolException {
        for (Rol unRol : this.roles) {
            if (unRol.getNombre().equals(nombre)) {
                throw new RolException("Ya existe un rol con ese nombre.");
            }
        }
        this.roles.add(new Rol(nombre));
        //HibernateUtil.actualizar(this);
    }

    /**
     * Intenta obtener un rol por su nombre
     *
     * @param nombre Nombre del rol a obtener
     * @return Una instancia de la clase Rol o <code>null</code> si no encuentra
     * ningun rol con el nombre especificado
     */
    public Rol getRol(String nombre) {
        Iterator iter = this.roles.iterator();
        Rol unRol = null;
        while (iter.hasNext()) {
            unRol = (Rol) iter.next();
            if (unRol.getNombre().equals(nombre)) {
                return unRol;
            }
        }
        return null;
    }

    /**
     * Agrega un catálogo a la tienda
     * @param nombre Nombre del catálogo a agregar
     * @throws CatalogoException Cuando la tienda ya tiene un catálogo con el nombre
     * especificado
     */
    public void addCatalogo(String nombre) throws CatalogoException {
        for (Catalogo unCatalogo : this.catalogos) {
            if (unCatalogo.getNombre().equals(nombre)) {
                throw new CatalogoException("Ya existe un catálogo con ese nombre");
            }
        }
        this.catalogos.add(new Catalogo(nombre, this));
        HibernateUtil.actualizar(this);
    }
    
    /**
     * Intenta buscar y recuperar un catálogo según su ID
     * @param id ID del catálogo a recuperar
     * @return Una instancia de la clase Catalogo si la tienda tiene un catálogo
     * con el ID especificado o <code>null</code> si la tienda no tiene ningún catálogo
     * con el ID especificado
     */
    public Catalogo getUnCatalogo(int id) {
        for (Catalogo unCatalogo : this.catalogos) {
            if (unCatalogo.getId() == id) {
                return unCatalogo;
            }
        }
        return null;
    }

    /**
     * Agrega un juego a la colección de juegos de la tienda (cuando la tienda
     * se organiza por catálogos y categorías de catálogos)
     *
     * @param nombre Nombre del juego
     * @param descripcion Descripción del juego
     * @param precio Precio del juegi
     * @param stock Cantidad de unidades del juego disponibles desde que se
     * registra en el sistema
     * @param cover URL a la portada del juego
     * @param unCatalogo El catálogo al que pertenece el juego
     * @param unaCategoria La categoría del catálogo a la que pertenece el juego
     */
    public void addJuego(String nombre, String descripcion, double precio, int stock, String cover, Catalogo unCatalogo, Categoria unaCategoria) throws JuegoException {
        for (Juego unJuego : this.juegos) {
            if (unJuego.getNombre().equals(nombre)) {
                throw new JuegoException("El juego ya está registrado en la tienda");
            }
        }
        this.juegos.add(new Juego(nombre, descripcion, precio, stock, cover, unCatalogo, unaCategoria, this));
    }
    
    /**
     * Agrega un juego a la colección de juegos de la tienda (cuando la tienda
     * se organiza únicamente por catálogos)
     *
     * @param nombre Nombre del juego
     * @param descripcion Descripción del juego
     * @param precio Precio del juegi
     * @param stock Cantidad de unidades del juego disponibles desde que se
     * @param requisitosMinimos Requisitos mínimos que debe cumplir una computadora 
     * para ejecutar el juego
     * @param requisitosRecomendados Requisitos recomendados que debe cumplir una 
     * computadora para ejecutar el juego
     * registra en el sistema
     * @param cover URL a la portada del juego
     * @param unCatalogo El catálogo al que pertenece el juego
     */
    public void addJuego(String nombre, String descripcion, double precio, int stock, String cover, Catalogo unCatalogo, Requisito requisitosMinimos, Requisito requisitosRecomendados) throws JuegoException {
        for (Juego unJuego : this.juegos) {
            if (unJuego.getNombre().equals(nombre)) {
                throw new JuegoException("El juego ya está registrado en la tienda");
            }
        }
        this.juegos.add(new Juego(nombre, descripcion, precio, stock, cover, unCatalogo, this, requisitosMinimos, requisitosRecomendados));
        //HibernateUtil.actualizar(this);
    }

    /**
     * Intenta buscar y devolver un juego de la colección del catálogo según su
     * ID.
     *
     * @param id ID del juego que se quiere obtener
     * @return Una instancia de la clase Juego o <code>null</code> si no se
     * encontró el juego por el ID
     */
    public Juego getUnJuego(int id) {
        for (Juego unJuego : this.juegos) {
            if (unJuego.getId() == id) {
                return unJuego;
            }
        }
        return null;
    }

    /**
     * Devuelve una colección con los juegos agregados a la tienda ordenados
     * desde el más reciente hasta el primero
     *
     * @return Colección de los juegos agregados a la tienda ordenados desde el
     * más reciente hasta el perimero o null si no hay juegos agregados a la
     * tienda
     */
    public List<Juego> ordenarJuegosMasReciente() {
        List<Juego> juegosOrdenadosMasRecientes = new ArrayList<>();
        for (int i = this.juegos.size() - 1; i >= 0; i--) {
            juegosOrdenadosMasRecientes.add(this.juegos.get(i));
        }
        return juegosOrdenadosMasRecientes;
    }
    
    /**
     * Ordena los juegos de la tienda en orden decreciente
     * según la demanda en sus reservas
     * @return una lista de juegos ordenada en orden decreciente
     * según la demanda en sus reservas
     */
    public List<Juego> ordenarJuegosMasReservados(){
        List<Juego> juegosMasReservados = this.juegos;
        Collections.sort(juegosMasReservados, new Comparator<Juego>(){
            @Override
            public int compare(Juego o1, Juego o2) {
                int valor = 0;
                if (o1.getReservas().size() == o2.getReservas().size()){
                    valor = 0;
                }
                if (o1.getReservas().size() >= o2.getReservas().size()){
                    valor = -1;
                }
                if (o1.getReservas().size() <= o2.getReservas().size()){
                    valor = 1;
                }
                return valor;
            }
        });
        return juegosMasReservados;
    }

    /**
     * Devuelve una colección con los ultimos juegos agregados a la tienda
     *
     * @return Colección de los últimos juegos agregados a la tienda o null si
     * no hay juegos agregados a la tienda
     */
    public List<Juego> getUltimosJuegos() {
        List<Juego> ultimosJuegos = new ArrayList<>();
        int ultimos = 4;
        for (int i = this.juegos.size() - 1; i >= 0 && ultimos > 0; i--) {
            ultimosJuegos.add(this.juegos.get(i));
            ultimos--;
        }
        return ultimosJuegos;
    }

    // <editor-fold defaultstate="collapsed" desc="Getters and setters methods. Click on the + sign on the left to edit the code.">
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Catalogo> getCatalogos() {
        return catalogos;
    }

    public void setCatalogos(List<Catalogo> catalogos) {
        this.catalogos = catalogos;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

    public List<Juego> getJuegos() {
        return juegos;
    }

    public void setJuegos(List<Juego> juegos) {
        this.juegos = juegos;
    }

    public Configuracion getUnaConfiguracion() {
        return unaConfiguracion;
    }

    public void setUnaConfiguracion(Configuracion unaConfiguracion) {
        this.unaConfiguracion = unaConfiguracion;
    }
    // </editor-fold>

}
