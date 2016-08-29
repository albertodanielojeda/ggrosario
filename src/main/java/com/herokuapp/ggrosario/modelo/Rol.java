package com.herokuapp.ggrosario.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.herokuapp.ggrosario.util.HibernateUtil;
import javax.persistence.ManyToOne;

/**
 *
 * @author Ojeda Alberto Daniel
 */
@Entity
@Table(name = "roles")
public class Rol implements Serializable {

    @Id
    @Column(name = "nombre")
    private String nombre;

    @ManyToMany(mappedBy = "roles")
    private List<Usuario> usuarios;

    @OneToOne(cascade = CascadeType.ALL)
    private Permisos permisos;

    @ManyToOne
    private Tienda unaTienda;

    /**
     * Constructor nulo para inicializar las colecciones
     */
    public Rol() {
        this.usuarios = new ArrayList<>();
    }

    /**
     * Constructor para instanciar un nuevo rol
     *
     * @param nombre Nombre del rol
     * @param unaTienda Tienda a la que pertenece el rol
     */
    public Rol(String nombre, Tienda unaTienda) {
        this();
        this.nombre = nombre;
        this.permisos = new Permisos();
        this.permisos.setPermisosNuevoRol();
        this.unaTienda = (Tienda) unaTienda;
        HibernateUtil.guardar(this);
    }

    // <editor-fold defaultstate="collapsed" desc="Getters and setters methods. Click on the + sign on the left to edit the code.">
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Permisos getPermisos() {
        return permisos;
    }

    public void setPermisos(Permisos permisos) {
        this.permisos = permisos;
        HibernateUtil.actualizar(this);
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Tienda getUnaTienda() {
        return unaTienda;
    }

    public void setUnaTienda(Tienda unaTienda) {
        this.unaTienda = unaTienda;
    }

    // </editor-fold>
}
