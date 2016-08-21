package com.herokuapp.ggrosario.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.herokuapp.ggrosario.util.HibernateUtil;

/**
 *
 * @author Ojeda Alberto Daniel
 */
@Entity
@Table(name="lista_de_deseos")
public class ListaDeseos implements Serializable {
    
    // <editor-fold defaultstate="collapsed" desc="Class attributes. Click on the + sign on the left to edit the code.">
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id") private int id;
    
    @OneToMany
    private List<Juego> juegos;
    
    @OneToOne(mappedBy = "unaListaDeseos")
    private Usuario unUsuario;
    // </editor-fold>

    /**
     * Constructor nulo para inicializar las colecciones
     */
    public ListaDeseos() {
        this.juegos = new ArrayList<>();
    }

    /**
     * Constructor para instanciar una lista de deseos de un usuario
     * @param unUsuario Instancia de la clase Usuario a la que se le asignara
     * la lista de deseos
     */
    public ListaDeseos(Usuario unUsuario) {
        this();
        this.unUsuario = unUsuario;
        HibernateUtil.guardar(this);
    }
    
    /**
     * Agrega un juego a esta lista de deseos
     * @param unJuego Instancia de la clase Juego que se agregará a esta 
     * lista de deseos
     */
    public void addJuego(Juego unJuego){
        this.juegos.add(unJuego);
    }

    // <editor-fold defaultstate="collapsed" desc="Getters and setters methods. Click on the + sign on the left to edit the code.">
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Juego> getJuegos() {
        return juegos;
    }

    public void setJuegos(List<Juego> juegos) {
        this.juegos = juegos;
    }
    
    public Usuario getUnUsuario() {
        return unUsuario;
    }

    public void setUnUsuario(Usuario unUsuario) {
        this.unUsuario = unUsuario;
    }
    
    // </editor-fold>
    
    
}
