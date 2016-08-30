package com.herokuapp.ggrosario.modelo;

import com.herokuapp.ggrosario.exepciones.RolException;
import com.herokuapp.ggrosario.util.HibernateUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Ojeda Alberto Daniel
 */
@Entity
@Table(name = "permisos")
public class Permisos implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "alta_rol")
    private boolean altaRol;

    @Column(name = "baja_rol")
    private boolean bajaRol;

    @Column(name = "modificar_rol")
    private boolean modificarRol;

    @Column(name = "alta_administrador")
    private boolean altaAdministrador;

    @Column(name = "baja_administrador")
    private boolean bajaAdministrador;

    @Column(name = "modificar_administrador")
    private boolean modificarAdministrador;

    @Column(name = "alta_empleado")
    private boolean altaEmpleado;

    @Column(name = "baja_empleado")
    private boolean bajaEmpleado;

    @Column(name = "modificar_empleado")
    private boolean modificarEmpleado;

    @Column(name = "alta_cliente")
    private boolean altaCliente;

    @Column(name = "baja_cliente")
    private boolean bajaCliente;

    @Column(name = "modificar_cliente")
    private boolean modificarCliente;

    @Column(name = "alta_catalogo")
    private boolean altaCatalogo;

    @Column(name = "baja_catalogo")
    private boolean bajaCatalogo;

    @Column(name = "modificar_catalogo")
    private boolean modificarCatalogo;

    @Column(name = "alta_categoria")
    private boolean altaCategoria;

    @Column(name = "baja_categoria")
    private boolean bajaCategoria;

    @Column(name = "modificar_categoria")
    private boolean modificarCategoria;

    @Column(name = "alta_juego")
    private boolean altaJuego;

    @Column(name = "baja_juego")
    private boolean bajaJuego;

    @Column(name = "modificar_juego")
    private boolean modificarJuego;

    @Column(name = "alta_reserva")
    private boolean altaReserva;

    @Column(name = "baja_reserva")
    private boolean bajaReserva;

    @Column(name = "modificar_reserva")
    private boolean modificarReserva;

    @Column(name = "acceso_panel_administracion")
    private boolean accederPanelAdministracion;

    @OneToMany(mappedBy = "permisos", cascade = CascadeType.ALL)
    private List<ABMRol> abmRoles;

    public Permisos() {
        this.abmRoles = new ArrayList<>();
        //HibernateUtil.guardar(this);
    }

    public Permisos(boolean altaRol, boolean bajaRol, boolean modificarRol, boolean altaAdministrador, boolean bajaAdministrador, boolean modificarAdministrador, boolean altaEmpleado, boolean bajaEmpleado, boolean modificarEmpleado, boolean altaCliente, boolean bajaCliente, boolean modificarCliente, boolean altaCatalogo, boolean bajaCatalogo, boolean modificarCatalogo, boolean altaCategoria, boolean bajaCategoria, boolean modificarCategoria, boolean altaJuego, boolean bajaJuego, boolean modificarJuego, boolean altaReserva, boolean bajaReserva, boolean modificarReserva) {
        this();
        this.altaRol = altaRol;
        this.bajaRol = bajaRol;
        this.modificarRol = modificarRol;
        this.altaAdministrador = altaAdministrador;
        this.bajaAdministrador = bajaAdministrador;
        this.modificarAdministrador = modificarAdministrador;
        this.altaEmpleado = altaEmpleado;
        this.bajaEmpleado = bajaEmpleado;
        this.modificarEmpleado = modificarEmpleado;
        this.altaCliente = altaCliente;
        this.bajaCliente = bajaCliente;
        this.modificarCliente = modificarCliente;
        this.altaCatalogo = altaCatalogo;
        this.bajaCatalogo = bajaCatalogo;
        this.modificarCatalogo = modificarCatalogo;
        this.altaCategoria = altaCategoria;
        this.bajaCategoria = bajaCategoria;
        this.modificarCategoria = modificarCategoria;
        this.altaJuego = altaJuego;
        this.bajaJuego = bajaJuego;
        this.modificarJuego = modificarJuego;
        this.altaReserva = altaReserva;
        this.bajaReserva = bajaReserva;
        this.modificarReserva = modificarReserva;
    }

    public void setCanDoAll(boolean valor) {
        this.altaRol = valor;
        this.bajaRol = valor;
        this.modificarRol = valor;
        this.altaAdministrador = valor;
        this.bajaAdministrador = valor;
        this.modificarAdministrador = valor;
        this.altaEmpleado = valor;
        this.bajaEmpleado = valor;
        this.modificarEmpleado = valor;
        this.altaCliente = valor;
        this.bajaCliente = valor;
        this.modificarCliente = valor;
        this.altaCatalogo = valor;
        this.bajaCatalogo = valor;
        this.modificarCatalogo = valor;
        this.altaCategoria = valor;
        this.bajaCategoria = valor;
        this.modificarCategoria = valor;
        this.altaJuego = valor;
        this.bajaJuego = valor;
        this.modificarJuego = valor;
        this.altaReserva = valor;
        this.bajaReserva = valor;
        this.modificarReserva = valor;
        this.accederPanelAdministracion = valor;
        //HibernateUtil.actualizar(this);
    }

    public void setPermisosNuevoRol() {
        this.altaRol = false;
        this.bajaRol = false;
        this.modificarRol = false;
        this.altaAdministrador = false;
        this.bajaAdministrador = false;
        this.modificarAdministrador = false;
        this.altaEmpleado = false;
        this.bajaEmpleado = false;
        this.modificarEmpleado = false;
        this.altaCliente = false;
        this.bajaCliente = false;
        this.modificarCliente = false;
        this.altaCatalogo = false;
        this.bajaCatalogo = false;
        this.modificarCatalogo = false;
        this.altaCategoria = false;
        this.bajaCategoria = false;
        this.modificarCategoria = false;
        this.altaJuego = false;
        this.bajaJuego = false;
        this.modificarJuego = false;
        this.altaReserva = false;
        this.bajaReserva = false;
        this.modificarReserva = false;
        this.accederPanelAdministracion = false;
        //HibernateUtil.actualizar(this);
    }

    public void setPermisosCliente() {
        this.altaRol = false;
        this.bajaRol = false;
        this.modificarRol = false;
        this.altaAdministrador = false;
        this.bajaAdministrador = false;
        this.modificarAdministrador = false;
        this.altaEmpleado = false;
        this.bajaEmpleado = false;
        this.modificarEmpleado = false;
        this.altaCliente = false;
        this.bajaCliente = false;
        this.modificarCliente = false;
        this.altaCatalogo = false;
        this.bajaCatalogo = false;
        this.modificarCatalogo = false;
        this.altaCategoria = false;
        this.bajaCategoria = false;
        this.modificarCategoria = false;
        this.altaJuego = false;
        this.bajaJuego = false;
        this.modificarJuego = false;
        this.altaReserva = true;
        this.bajaReserva = true;
        this.modificarReserva = true;
        this.accederPanelAdministracion = false;
        //HibernateUtil.actualizar(this);
    }

    public void setPermisosEmpleado() {
        this.altaRol = false;
        this.bajaRol = false;
        this.modificarRol = false;
        this.altaAdministrador = false;
        this.bajaAdministrador = false;
        this.modificarAdministrador = false;
        this.altaEmpleado = true;
        this.bajaEmpleado = true;
        this.modificarEmpleado = true;
        this.altaCliente = true;
        this.bajaCliente = true;
        this.modificarCliente = true;
        this.altaCatalogo = true;
        this.bajaCatalogo = true;
        this.modificarCatalogo = true;
        this.altaCategoria = true;
        this.bajaCategoria = true;
        this.modificarCategoria = true;
        this.altaJuego = true;
        this.bajaJuego = true;
        this.modificarJuego = true;
        this.altaReserva = false;
        this.bajaReserva = false;
        this.modificarReserva = true;
        this.accederPanelAdministracion = true;
        //HibernateUtil.actualizar(this);
    }

    /*public void addRol(Rol unRol){
        this.roles.add(unRol);
        //HibernateUtil.actualizar(this);
    }*/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean canAltaRol() {
        return altaRol;
    }

    public void setAltaRol(boolean altaRol) {
        this.altaRol = altaRol;
        HibernateUtil.actualizar(this);
    }

    public boolean canBajaRol() {
        return bajaRol;
    }

    public void setBajaRol(boolean bajaRol) {
        this.bajaRol = bajaRol;
        HibernateUtil.actualizar(this);
    }

    public boolean canModificacionRol() {
        return modificarRol;
    }

    public void setModificacionRol(boolean modificarRol) {
        this.modificarRol = modificarRol;
        HibernateUtil.actualizar(this);
    }

    public boolean canAltaAdministrador() {
        return altaAdministrador;
    }

    public void setAltaAdministrador(boolean altaAdministrador) {
        this.altaAdministrador = altaAdministrador;
        HibernateUtil.actualizar(this);
    }

    public boolean canBajaAdministrador() {
        return bajaAdministrador;
    }

    public void setBajaAdministrador(boolean bajaAdministrador) {
        this.bajaAdministrador = bajaAdministrador;
        HibernateUtil.actualizar(this);
    }

    public boolean canModificacionAdministrador() {
        return modificarAdministrador;
    }

    public void setModificacionAdministrador(boolean modificarAdministrador) {
        this.modificarAdministrador = modificarAdministrador;
        HibernateUtil.actualizar(this);
    }

    public boolean canAltaEmpleado() {
        return altaEmpleado;
    }

    public void setAltaEmpleado(boolean altaEmpleado) {
        this.altaEmpleado = altaEmpleado;
        HibernateUtil.actualizar(this);
    }

    public boolean canBajaEmpleado() {
        return bajaEmpleado;
    }

    public void setBajaEmpleado(boolean bajaEmpleado) {
        this.bajaEmpleado = bajaEmpleado;
        HibernateUtil.actualizar(this);
    }

    public boolean canModificacionEmpleado() {
        return modificarEmpleado;
    }

    public void setModificacionEmpleado(boolean modificarEmpleado) {
        this.modificarEmpleado = modificarEmpleado;
        HibernateUtil.actualizar(this);
    }

    public boolean canAltaCliente() {
        return altaCliente;
    }

    public void setAltaCliente(boolean altaCliente) {
        this.altaCliente = altaCliente;
        HibernateUtil.actualizar(this);
    }

    public boolean canBajaCliente() {
        return bajaCliente;
    }

    public void setBajaCliente(boolean bajaCliente) {
        this.bajaCliente = bajaCliente;
        HibernateUtil.actualizar(this);
    }

    public boolean canModificacionCliente() {
        return modificarCliente;
    }

    public void setModificacionCliente(boolean modificarCliente) {
        this.modificarCliente = modificarCliente;
        HibernateUtil.actualizar(this);
    }

    public boolean canAltaCatalogo() {
        return altaCatalogo;
    }

    public void setAltaCatalogo(boolean altaCatalogo) {
        this.altaCatalogo = altaCatalogo;
        HibernateUtil.actualizar(this);
    }

    public boolean canBajaCatalogo() {
        return bajaCatalogo;
    }

    public void setBajaCatalogo(boolean bajaCatalogo) {
        this.bajaCatalogo = bajaCatalogo;
        HibernateUtil.actualizar(this);
    }

    public boolean canModificacionCatalogo() {
        return modificarCatalogo;
    }

    public void setModificacionCatalogo(boolean modificarCatalogo) {
        this.modificarCatalogo = modificarCatalogo;
        HibernateUtil.actualizar(this);
    }

    public boolean canAltaCategoria() {
        return altaCategoria;
    }

    public void setAltaCategoria(boolean altaCategoria) {
        this.altaCategoria = altaCategoria;
        HibernateUtil.actualizar(this);
    }

    public boolean canBajaCategoria() {
        return bajaCategoria;
    }

    public void setBajaCategoria(boolean bajaCategoria) {
        this.bajaCategoria = bajaCategoria;
        HibernateUtil.actualizar(this);
    }

    public boolean canModificacionCategoria() {
        return modificarCategoria;
    }

    public void setModificacionCategoria(boolean modificarCategoria) {
        this.modificarCategoria = modificarCategoria;
        HibernateUtil.actualizar(this);
    }

    public boolean canAltaJuego() {
        return altaJuego;
    }

    public void setAltaJuego(boolean altaJuego) {
        this.altaJuego = altaJuego;
        HibernateUtil.actualizar(this);
    }

    public boolean canBajaJuego() {
        return bajaJuego;
    }

    public void setBajaJuego(boolean bajaJuego) {
        this.bajaJuego = bajaJuego;
        HibernateUtil.actualizar(this);
    }

    public boolean canModificacionJuego() {
        return modificarJuego;
    }

    public void setModificacionJuego(boolean modificarJuego) {
        this.modificarJuego = modificarJuego;
        HibernateUtil.actualizar(this);
    }

    public boolean canAltaReserva() {
        return altaReserva;
    }

    public void setAltaReserva(boolean altaReserva) {
        this.altaReserva = altaReserva;
        HibernateUtil.actualizar(this);
    }

    public boolean canBajaReserva() {
        return bajaReserva;
    }

    public void setBajaReserva(boolean bajaReserva) {
        this.bajaReserva = bajaReserva;
        HibernateUtil.actualizar(this);
    }

    public boolean canModificacionReserva() {
        return modificarReserva;
    }

    public void setModificacionReserva(boolean modificarReserva) {
        this.modificarReserva = modificarReserva;
        HibernateUtil.actualizar(this);
    }

    public boolean canAccederPanelAdministracion() {
        return accederPanelAdministracion;
    }

    public void setAccederPanelAdministracion(boolean accederPanelAdministracion) {
        this.accederPanelAdministracion = accederPanelAdministracion;
        HibernateUtil.actualizar(this);
    }

    public List<ABMRol> getAbmRoles() {
        return abmRoles;
    }

    public void setAbmRoles(List<ABMRol> abmRoles) {
        this.abmRoles = abmRoles;
    }

    public boolean canAltaUsuario(String nombreRol) {
        for (ABMRol abmRol : this.abmRoles) {
            if (abmRol.canAlta()) {
                return true;
            }
        }
        return false;
    }
    
    public boolean canBajaUsuario(String nombreRol) {
        for (ABMRol abmRol : this.abmRoles) {
            if (abmRol.canBaja()) {
                return true;
            }
        }
        return false;
    }
    
    public boolean canModificarUsuario(String nombreRol) {
        for (ABMRol abmRol : this.abmRoles) {
            if (abmRol.canModificar()) {
                return true;
            }
        }
        return false;
    }

    public void addAMBUsuarioRol(String nombreRol, boolean alta, boolean baja, boolean modificar) throws RolException {
        for (ABMRol abmRol : this.abmRoles) {
            if (abmRol.getUnRol().getNombre().equals(nombreRol)) {
                throw new RolException("Este permiso ya puede dar de alta usuarios con ese rol");
            }
        }
        this.abmRoles.add(new ABMRol(Tienda.getInstance().buscarRol(nombreRol), alta, baja, modificar, this));
        HibernateUtil.actualizar(this);
    }
    
    public void addAMBUsuarioRol(String nombreRol) throws RolException {
        for (ABMRol abmRol : this.abmRoles) {
            if (abmRol.getUnRol().getNombre().equals(nombreRol)) {
                throw new RolException("Este rol ya tiene permiso para dar de alta usuarios del rol indicado");
            }
        }
        this.abmRoles.add(new ABMRol(Tienda.getInstance().buscarRol(nombreRol), false, false, false, this));
        HibernateUtil.actualizar(this);
    }
    
    public ABMRol buscarAMBUsuarioRol(String nombreRol){
        ABMRol abmRol = null;
        Iterator iterAbmRoles = this.abmRoles.iterator();
        while (iterAbmRoles.hasNext()) {
            abmRol = (ABMRol) iterAbmRoles.next();
            if (abmRol.getUnRol().getNombre().equals(nombreRol)){
                return abmRol;
            }
            
        }
        return null;
    }

}
