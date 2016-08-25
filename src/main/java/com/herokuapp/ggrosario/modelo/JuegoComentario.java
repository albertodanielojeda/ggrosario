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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Ojeda Alberto Daniel
 */
@Entity
@Table(name = "juegos_comentarios")
public class JuegoComentario implements Serializable {
    
    @Id
    @ManyToOne
    @JoinColumn(name = "fk_juego_id", referencedColumnName = "id")
    private Juego unJuego;

    @Id
    @ManyToOne
    @JoinColumn(name = "fk_comentario_id", referencedColumnName = "id")
    private Comentario unComentario;

    public JuegoComentario() {
    }

    public JuegoComentario(Juego unJuego, Comentario unComentario) {
        this.unJuego = (Juego) unJuego;
        this.unComentario = (Comentario) unComentario;
        HibernateUtil.guardar(this);
    }

    public Juego getUnJuego() {
        return unJuego;
    }

    public void setUnJuego(Juego unJuego) {
        this.unJuego = unJuego;
    }

    public Comentario getUnComentario() {
        return unComentario;
    }

    public void setUnComentario(Comentario unComentario) {
        this.unComentario = unComentario;
    }
    
    
}
