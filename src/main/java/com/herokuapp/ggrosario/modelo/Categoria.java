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

/**
 *
 * @author Ojeda Alberto Daniel
 */
@Entity
@Table(name="categorias")
public class Categoria implements Serializable {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @Column(name="nombre")
    private String nombre;
    
    @ManyToOne
    private Catalogo unCatalogo;
    
    @OneToMany(mappedBy = "unaCategoria")
    private List<Juego> juegos;
    
    /**
     * Constructor nulo para inicializar las colecciones
     */
    public Categoria() {
        this.juegos = new ArrayList<>();
    }

    /**
     * Constructor para instanciar una categoría
     * @param nombre Nombre de la categoría
     * @param unCatalogo El catálogo al que pernecerá esta categoría
     */
    public Categoria(String nombre, Catalogo unCatalogo) {
        this.nombre = nombre;
        this.unCatalogo = unCatalogo;
        HibernateUtil.guardar(this);
    }

    /**
     * Agrega un juego para la categoría
     * @param unJuego Instancia de la clase Juego que queremos agregar 
     * a la colección de la categoría
     */
    public void addJuego(Juego unJuego) {
        this.juegos.add(unJuego);
    }

    /**
     * Intenta buscar y devolver un juego de la colección de la categoría según 
     * su ID.
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

    public Catalogo getUnCatalogo() {
        return unCatalogo;
    }

    public void setUnCatalogo(Catalogo unCatalogo) {
        this.unCatalogo = unCatalogo;
    }

    public List<Juego> getJuegos() {
        return juegos;
    }

    public void setJuegos(List<Juego> juegos) {
        this.juegos = juegos;
    }
    
    // </editor-fold>
}
