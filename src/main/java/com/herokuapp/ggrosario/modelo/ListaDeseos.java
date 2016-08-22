package com.herokuapp.ggrosario.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.herokuapp.ggrosario.util.HibernateUtil;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author Ojeda Alberto Daniel
 */
@Entity
@Table(name = "lista_de_deseos")
public class ListaDeseos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @OneToMany(mappedBy = "unaListaDeseos")
    private List<ListaDeseosJuegos> unaListaDeseosJuegos;

    @OneToOne(mappedBy = "unaListaDeseos")
    private Usuario unUsuario;

    /**
     * Constructor nulo para inicializar las colecciones
     */
    public ListaDeseos() {
        this.unaListaDeseosJuegos = new ArrayList<>();
    }

    /**
     * Constructor para instanciar una lista de deseos de un usuario
     *
     * @param unUsuario Instancia de la clase Usuario a la que se le asignara la
     * lista de deseos
     */
    public ListaDeseos(Usuario unUsuario) {
        this();
        this.unUsuario = unUsuario;
        HibernateUtil.guardar(this);
    }

    /**
     * Agrega un juego a esta lista de deseos
     *
     * @param unJuego Instancia de la clase Juego que se agregará a esta lista
     * de deseos
     */
    public void addJuego(Juego unJuego) {
        if (!existeJuego(unJuego)) {
            ListaDeseosJuegos listaDeseosJuegos = new ListaDeseosJuegos(this, unJuego);
            this.unaListaDeseosJuegos.add(listaDeseosJuegos);
            HibernateUtil.actualizar(this);
        }
    }
    // No funciona como se espera
    public boolean existeJuego(Juego unJuego) {
        for (ListaDeseosJuegos listaDeseosJuegos : this.unaListaDeseosJuegos) {
            if (listaDeseosJuegos.getUnJuego() == unJuego) {
                return true;
            }
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

    public List<ListaDeseosJuegos> getUnaListaDeseosJuegos() {
        return unaListaDeseosJuegos;
    }

    public void setUnaListaDeseosJuegos(List<ListaDeseosJuegos> unaListaDeseosJuegos) {
        this.unaListaDeseosJuegos = unaListaDeseosJuegos;
    }

    public Usuario getUnUsuario() {
        return unUsuario;
    }

    public void setUnUsuario(Usuario unUsuario) {
        this.unUsuario = unUsuario;
    }

    // </editor-fold>
}
