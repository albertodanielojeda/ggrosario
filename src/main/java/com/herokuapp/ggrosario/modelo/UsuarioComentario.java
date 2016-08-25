/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.ggrosario.modelo;

import com.herokuapp.ggrosario.util.HibernateUtil;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Ojeda Alberto Daniel
 */
@Entity
@Table(name="usuarios_comentarios")
public class UsuarioComentario implements Serializable {

    @Id
    @ManyToOne
    @JoinColumns({
     @JoinColumn(name = "fk_usuario_email", referencedColumnName = "email"),
        @JoinColumn(name = "fk_usuario_nick", referencedColumnName = "nick")
    })
    private Usuario unUsuario;

    @Id
    @ManyToOne
    @JoinColumn(name = "fk_comentario_id", referencedColumnName = "id")
    private Comentario unComentario;

    public UsuarioComentario() {
    }

    public UsuarioComentario(Usuario unUsuario, Comentario unComentario) {
        this();
        this.unUsuario = (Usuario) unUsuario;
        this.unComentario = (Comentario) unComentario;
        HibernateUtil.guardar(this);
    }

    // <editor-fold defaultstate="collapsed" desc="Getters and setters methods. Click on the + sign on the left to edit the code.">
    public Usuario getUnUsuario() {
        return unUsuario;
    }

    public void setUnUsuario(Usuario unUsuario) {
        this.unUsuario = unUsuario;
    }

    public Comentario getUnComentario() {
        return unComentario;
    }

    public void setUnComentario(Comentario unComentario) {
        this.unComentario = unComentario;
    }
    // </editor-fold>

}
