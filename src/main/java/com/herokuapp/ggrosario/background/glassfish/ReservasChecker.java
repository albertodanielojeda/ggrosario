package com.herokuapp.ggrosario.background.glassfish;

import com.herokuapp.ggrosario.modelo.Reserva;
import com.herokuapp.ggrosario.modelo.Tienda;
import com.herokuapp.ggrosario.modelo.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Schedule;
import javax.ejb.Singleton;

/**
 *
 * @author Ojeda Alberto Daniel
 */
@Singleton
public class ReservasChecker {

    @Schedule(hour = "0", minute = "0", second = "0", persistent = false)
    public void actualizarEstadoReservas() {
        Tienda unaTienda = Tienda.getInstance();

        List<Reserva> reservas = new ArrayList<>();

        for (Usuario usuario : unaTienda.getUsuarios()) {
            for (Reserva reserva : usuario.getReservas()) {
                reservas.add(reserva);
            }
        }

        for (Reserva unaReserva : reservas) {
            if (!unaReserva.isValida()){
                unaReserva.getEstadoReserva().setDescripcion(unaTienda.getUnaConfiguracion().getEstadoReservaCaducada());
                System.out.println("La reserva #" + unaReserva.getId() + " ha caducado");
            }
        }
    }

}
