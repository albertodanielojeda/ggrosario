package com.herokuapp.ggrosario.modelo;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Ojeda Alberto Daniel
 */
@Entity
@Table(name="requisitos_minimos")
public class RequisitoMinimo extends Requisito{
    
    /**
     * Constructor nulo
     */
    public RequisitoMinimo(){
    }

    /**
     * Constructor para instanciar un requisito mínimo
     * @param os Sistema operativo mínimo requerido
     * @param cpu Procesador mínimo requerido
     * @param ram Cantidad de memoria RAM mínima requerida
     * @param gpu Tarjeta de video mínima requerida
     * @param hdd Capacidad de disco duro mínima requerida
     */
    public RequisitoMinimo(String os, String cpu, String ram, String gpu, String hdd) {
        super(os, cpu, ram, gpu, hdd);
    }
    
    
    
}
