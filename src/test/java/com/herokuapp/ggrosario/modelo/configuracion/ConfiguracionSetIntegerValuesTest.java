/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.ggrosario.modelo.configuracion;

import com.herokuapp.ggrosario.modelo.Configuracion;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author Ojeda Alberto Daniel
 */
@RunWith(value = Parameterized.class)
public class ConfiguracionSetIntegerValuesTest {
    
    @Parameterized.Parameters
    public static Iterable<Object[]> getDatos(){
        List<Object[]> datos = new ArrayList<>();
        datos.add(new Object[] {1, 1});
        datos.add(new Object[] {2, 2});
        datos.add(new Object[] {3, 3});
        datos.add(new Object[] {4, 4});
        datos.add(new Object[] {5, 5});
        datos.add(new Object[] {6, 6});
        datos.add(new Object[] {7, 7});
        datos.add(new Object[] {8, 8});
        datos.add(new Object[] {9, 9});
        datos.add(new Object[] {10, 10});
        return datos;
    }
    
    Configuracion configuracion;
    private int valor;
    private int esperado;
    
    public ConfiguracionSetIntegerValuesTest(int valor, int esperado) {
        this.valor = valor;
        this.esperado = esperado;
    }
    
    @Before
    public void before(){
        configuracion = new Configuracion();
    }

    @Test
    public void testSetDiasValidezReserva() {
        configuracion.setDiasValidezReserva(valor);
        int resultado = configuracion.getDiasValidezReserva();
        assertEquals(esperado, resultado);
    }
    
    @Test
    public void testSetReservasMinimas() {
        configuracion.setReservasMinimas(valor);
        int resultado = configuracion.getReservasMinimas();
        assertEquals(esperado, resultado);
    }
    
}
