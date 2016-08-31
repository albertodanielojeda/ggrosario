package com.herokuapp.ggrosario.modelo;

import com.herokuapp.ggrosario.exepciones.CategoriaException;
import com.herokuapp.ggrosario.exepciones.JuegoException;
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

/**
 *
 * @author Ojeda Alberto Daniel
 *
 */
@Entity
@Table(name = "catalogos")
public class Catalogo implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @OneToMany(mappedBy = "unCatalogo")
    private List<Categoria> categorias;

    @OneToMany(mappedBy = "unCatalogo")
    private List<Juego> juegos;

    @ManyToOne
    private Tienda unaTienda;

    public Catalogo() {
        this.categorias = new ArrayList<>();
        this.juegos = new ArrayList<>();
    }

    public Catalogo(String nombre, Tienda unaTienda) {
        this();
        this.nombre = nombre;
        this.unaTienda = unaTienda;
        HibernateUtil.guardar(this);
    }

    /**
     * Agrega una categoría al catálogo
     *
     * @param nombre Nombre de la categoría a crear
     * @throws CategoriaException Si el catálogo ya tiene una categoría con el
     * nombre especificado
     *
     */
    public void addCategoria(String nombre) throws CategoriaException {
        for (Categoria unaCategoria : this.categorias) {
            if (unaCategoria.getNombre().equals(nombre)) {
                throw new CategoriaException("Ya existe una categoría de nombre " + nombre + " en este catálogo");
            }
        }
        this.categorias.add(new Categoria(nombre, this));
    }

    /**
     * Agrega un juego al catálogo
     *
     * @param unJuego Juego que se agregará a la colección del catálogo
     */
    public void addJuego(Juego unJuego) {
        this.juegos.add(unJuego);
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
    
    public Juego buscarJuego(String nombre){
        for (Juego unJuego : this.juegos){
            if (unJuego.getNombre().toLowerCase().equals(nombre.toLowerCase())){
                return unJuego;
            }
        }
        return null;
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

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public Tienda getUnaTienda() {
        return unaTienda;
    }

    public void setUnaTienda(Tienda unaTienda) {
        this.unaTienda = unaTienda;
    }

    public List<Juego> getJuegos() {
        return juegos;
    }

    public void setJuegos(List<Juego> juegos) {
        this.juegos = juegos;
    }
    // </editor-fold>

}
