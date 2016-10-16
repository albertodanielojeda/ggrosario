package com.herokuapp.ggrosario.modelo;

import com.herokuapp.ggrosario.util.HibernateUtil;
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
        HibernateUtil.guardar(this);
    }

    @Override
    public void setHdd(String hdd) {
        super.setHdd(hdd);
    }

    @Override
    public String getHdd() {
        return super.getHdd();
    }

    @Override
    public void setGpu(String gpu) {
        super.setGpu(gpu);
    }

    @Override
    public String getGpu() {
        return super.getGpu();
    }

    @Override
    public void setRam(String ram) {
        super.setRam(ram);
    }

    @Override
    public String getRam() {
        return super.getRam();
    }

    @Override
    public void setCpu(String cpu) {
        super.setCpu(cpu);
    }

    @Override
    public String getCpu() {
        return super.getCpu();
    }

    @Override
    public void setOs(String os) {
        super.setOs(os);
    }

    @Override
    public String getOs() {
        return super.getOs();
    }

    @Override
    public void setId(int id) {
        super.setId(id);
    }

    @Override
    public int getId() {
        return super.getId();
    }
    
    
    
    
}
