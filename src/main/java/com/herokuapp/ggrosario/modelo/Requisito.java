package com.herokuapp.ggrosario.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Ojeda Alberto Daniel
 */
@Entity
@Table(name="requisitos")
public abstract class Requisito implements Serializable {
    
    @Id @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @Column(name="os")
    private String os;
    
    @Column(name="cpu")
    private String cpu;
    
    @Column(name="ram")
    private String ram;
    
    @Column(name="gpu")
    private String gpu;
    
    @Column(name="hdd")
    private String hdd;

    
    /**
     * Constructor nulo para inicializar las colecciones (si las hubiera)
     */
    public Requisito() {
    }
    
    /**
     * Constructor para instanciar un requisito (debe hacerse desde una subclase, ya 
     * que esta clase es abstracta y no puede instanciarse)
     * @param os Sistema operativo requerido
     * @param cpu Procesador requerido
     * @param ram Cantidad de memoria RAM requerida
     * @param gpu Tarjeta de video requerida
     * @param hdd Capacidad de disco duro requerida
     */
    public Requisito(String os, String cpu, String ram, String gpu, String hdd) {
        this();
        this.os = os;
        this.cpu = cpu;
        this.ram = ram;
        this.gpu = gpu;
        this.hdd = hdd;
    }

    // <editor-fold defaultstate="collapsed" desc="Getters and setters methods. Click on the + sign on the left to edit the code.">

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public String getHdd() {
        return hdd;
    }

    public void setHdd(String hdd) {
        this.hdd = hdd;
    }
    
    // </editor-fold>
}
