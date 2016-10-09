/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herokuapp.ggrosario.background.tomcat;

import com.herokuapp.ggrosario.modelo.Reserva;
import com.herokuapp.ggrosario.modelo.Tienda;
import com.herokuapp.ggrosario.modelo.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ojeda Alberto Daniel
 */
class ReservasChecker implements Runnable {

    @Override
    public void run() {
        Tienda unaTienda = Tienda.getInstance();

        List<Reserva> reservas = new ArrayList<>();

        for (Usuario usuario : unaTienda.getUsuarios()) {
            for (Reserva reserva : usuario.getReservas()) {
                reservas.add(reserva);
            }
        }

        for (Reserva unaReserva : reservas) {
            if (unaReserva.isValida()){
                System.out.println("La reserva #" + unaReserva.getId() + " aún es válida");
            }else{
                unaReserva.setEstado(unaTienda.getUnaConfiguracion().getEstadoReservaCaducada());
                System.out.println("La reserva #" + unaReserva.getId() + " ha caducado");
            }
            if (unaReserva.isCaducada()){
                System.out.println("La reserva #" + unaReserva.getId() + " ya ha caducado");
            }
            if (unaReserva.isCumplida()){
                System.out.println("La reserva #" + unaReserva.getId() + " ha sido cumplida");
            }
        }
    }

}
