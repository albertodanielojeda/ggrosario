package com.herokuapp.ggrosario.modelo;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Ojeda Alberto Daniel
 */
@Entity
@Table(name="requisitos_recomendados")
public class RequisitoRecomendado extends Requisito{

    /**
     * Constructor nulo
     */
    public RequisitoRecomendado() {
    }
    
    /**
     * Constructor para instanciar un requisito recomendado
     * @param os Sistema operativo recomendado requerido
     * @param cpu Procesador recomendado requerido
     * @param ram Cantidad de memoria RAM recomendada requerida
     * @param gpu Tarjeta de video recomendada requerida
     * @param hdd Capacidad de disco duro recomendada requerida
     */
    public RequisitoRecomendado(String os, String cpu, String ram, String gpu, String hdd) {
        super(os, cpu, ram, gpu, hdd);
    }
    
    
    
}
