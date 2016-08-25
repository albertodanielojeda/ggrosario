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
public class ConfiguracionSetBooleanValuesTest {
    
    @Parameterized.Parameters
    public static Iterable<Object[]> getDatos(){
        List<Object[]> datos = new ArrayList<>();
        datos.add(new Object[] {true, true, false});
        datos.add(new Object[] {false, false, true});
        return datos;
    }
    
    Configuracion configuracion;
    private boolean valor;
    private boolean esperado1;
    private boolean esperado2;
    
    public ConfiguracionSetBooleanValuesTest(boolean valor, boolean esperado1, boolean esperado2) {
        this.valor = valor;
        this.esperado1 = esperado1;
        this.esperado2 = esperado2;
    }
    
    @Before
    public void before(){
        configuracion = new Configuracion();
    }
    
    @Test
    public void testDefaultConfiguration(){
        boolean resultadoIsRegistroJuegosCatalogo = configuracion.isRegistroJuegosCatalogo();
        boolean resultadoresultadoIsRegistroJuegosCategoriaDeCatalogo = configuracion.isRegistroJuegosCategoriaDeCatalogo();
        assertEquals(true, resultadoIsRegistroJuegosCatalogo);
        assertEquals(false, resultadoresultadoIsRegistroJuegosCategoriaDeCatalogo);
    }
    
    @Test
    public void testIsRegistroJuegosCatalogo() {
        configuracion.setRegistroJuegosCatalogo(valor);
        boolean resultadoIsRegistroJuegosCatalogo = configuracion.isRegistroJuegosCatalogo();
        boolean resultadoresultadoIsRegistroJuegosCategoriaDeCatalogo = configuracion.isRegistroJuegosCategoriaDeCatalogo();
        assertEquals(esperado1, resultadoIsRegistroJuegosCatalogo);
        assertEquals(esperado2, resultadoresultadoIsRegistroJuegosCategoriaDeCatalogo);
    }
    
    @Test
    public void testIsRegistroJuegosCategoriaDeCatalogo() {
        configuracion.setRegistroJuegosCategoriaDeCatalogo(valor);
        boolean resultadoIsRegistroJuegosCatalogo = configuracion.isRegistroJuegosCatalogo();
        boolean resultadoresultadoIsRegistroJuegosCategoriaDeCatalogo = configuracion.isRegistroJuegosCategoriaDeCatalogo();
        assertEquals(esperado2, resultadoIsRegistroJuegosCatalogo);
        assertEquals(esperado1, resultadoresultadoIsRegistroJuegosCategoriaDeCatalogo);
    }
}
