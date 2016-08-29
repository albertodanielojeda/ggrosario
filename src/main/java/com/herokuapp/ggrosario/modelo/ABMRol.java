package com.herokuapp.ggrosario.modelo;

import com.herokuapp.ggrosario.util.HibernateUtil;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Ojeda Alberto Daniel
 */
@Entity
@Table(name = "amb_rol")
public class ABMRol implements Serializable {
    
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @OneToOne
    private Rol unRol;
    
    @ManyToOne
    private Permisos permisos;
    
    @Column(name = "can_alta")
    private boolean canAlta;
    @Column(name = "can_baja")
    private boolean canBaja;
    @Column(name = "can_modificar")
    private boolean canModificar;

    public ABMRol() {
    }

    public ABMRol(Rol unRol, boolean canAlta, boolean canBaja, boolean canModificar, Permisos permisos) {
        this();
        this.unRol = unRol;
        this.canAlta = canAlta;
        this.canBaja = canBaja;
        this.canModificar = canModificar;
        this.permisos = permisos;
        HibernateUtil.guardar(this);
    }

    public Rol getUnRol() {
        return unRol;
    }

    public void setUnRol(Rol unRol) {
        this.unRol = unRol;
    }

    public boolean canAlta() {
        return canAlta;
    }

    public void setCanAlta(boolean canAlta) {
        this.canAlta = canAlta;
        HibernateUtil.actualizar(this);
    }

    public boolean canBaja() {
        return canBaja;
    }

    public void setCanBaja(boolean canBaja) {
        this.canBaja = canBaja;
        HibernateUtil.actualizar(this);
    }

    public boolean canModificar() {
        return canModificar;
    }

    public void setCanModificar(boolean canModificar) {
        this.canModificar = canModificar;
        HibernateUtil.actualizar(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Permisos getPermisos() {
        return permisos;
    }

    public void setPermisos(Permisos permisos) {
        this.permisos = permisos;
    }
    
    
}
