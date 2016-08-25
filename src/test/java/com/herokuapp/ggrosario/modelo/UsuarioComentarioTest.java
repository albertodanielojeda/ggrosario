/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.ggrosario.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeoutException;
import net.jodah.concurrentunit.ConcurrentTestCase;
import net.jodah.concurrentunit.Waiter;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author Ojeda Alberto Daniel
 */
@RunWith(value = Parameterized.class)
public class UsuarioComentarioTest extends ConcurrentTestCase {

    @Parameterized.Parameters
    public static Iterable<Object[]> getDatos() {
        List<Object[]> datos = new ArrayList<>();
        datos.add(new Object[]{"Quiero este juego, es muy bueno. Quiza algun dia lo juegue, por ahora va a la lista de deseos"});
        datos.add(new Object[]{"Espero que salga una segunda temporada de este juego :D"});
        datos.add(new Object[]{"Ya lo reservé, mañana voy a presentar mi código y lo instalaré el mismo dia :'D"});
        datos.add(new Object[]{"Alto juego :v"});
        datos.add(new Object[]{"Esta nueva entrega no me satisfajo, no se compara a la primera temporada"});
        datos.add(new Object[]{"Mi hermano lo juega, a mi me parece aburrido xD igual lo voy a reservar porque la semana que viene es su cumpleaños y le quiero regalar este juego :P"});
        datos.add(new Object[]{"¿Alguien puede decirme si vale la pena jugarlo?"});
        datos.add(new Object[]{"Si, es un excelente juego. Te llenará de emociones"});
        datos.add(new Object[]{"Muy buena la pagina"});
        datos.add(new Object[]{"Buenos precios! :D"});
        datos.add(new Object[]{"Me gustaria que añadan la descarga digital posterior al pago vía PayPal u otro medio, seria estupendo!"});
        datos.add(new Object[]{"Fui a canjear el código y me atendieron muy bien! todo 10 puntos"});
        datos.add(new Object[]{"Muy buena la atencion... ahora a jugar!!! :D"});
        datos.add(new Object[]{"MUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUU bueno dijo la vaca"});
        datos.add(new Object[]{"En verdad hay gente que juega a esto? xD"});
        datos.add(new Object[]{"Lo mando a la lista de deseos :D"});
        datos.add(new Object[]{"Reservado, en un par de dias voy a buscarlo... espero que no caduque mi código xD"});
        datos.add(new Object[]{"RECOMENDADO!"});
        datos.add(new Object[]{"Me gusta Minecraft :3"});
        datos.add(new Object[]{"maincra XDD :)"});
        return datos;
    }

    private String descripcion;

    public UsuarioComentarioTest(String descripcion) {
        this.descripcion = descripcion;
    }

    @Test
    public void testSomeMethod() throws TimeoutException, InterruptedException {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i <= 2; i++) {
            threads.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    work();
                    threadAssertTrue(true);
                    resume();
                }
            }));
        }
        
        for (Thread thread : threads){
            thread.start();
            System.out.println("Hilo " + thread.getId()+ " iniciado");
        }
        for (Thread thread : threads){
            thread.join();
            System.out.println("Hilo " + thread.getId()+ " finalizado");
        }
    }

    public void work() {
        Random r = new Random();
        Usuario usuario = Tienda.getInstance().getUsuarios().get(r.nextInt(Tienda.getInstance().getUsuarios().size()));
        Juego juego = Tienda.getInstance().getJuegos().get(r.nextInt(Tienda.getInstance().getJuegos().size()));
        usuario.addComentario(new Comentario(descripcion, usuario, juego));
    }

}
