package uy.edu.cure.servidor.central.lib.servicios.memoria;

import uy.edu.cure.servidor.central.dto.Cliente;
import uy.edu.cure.servidor.central.dto.Reserva;
import uy.edu.cure.servidor.central.lib.servicios.ReservaService;

import java.util.ArrayList;
import java.util.Map;

public class ReservaServiceImpl extends GenericServiceImpl<Reserva> implements ReservaService {

    private static ReservaServiceImpl ourInstance = new ReservaServiceImpl();

    public static ReservaServiceImpl getInstance() {
        return ourInstance;
    }

    private ReservaServiceImpl() {
        super();
    }

    public Integer nextId() {
        Integer maxId = 0;
        for (Map.Entry<Integer, Reserva> entry : coleccion.entrySet()) {
            if (entry.getValue().getId() > maxId) {
                maxId = entry.getValue().getId();
            }
        }

        return maxId + 1;
    }

    @Override
    public ArrayList<Reserva> listarReservasCliente(Cliente cliente) {
        ArrayList<Reserva> reservas = new ArrayList<>();
        Reserva reserva;

        for (Map.Entry<Integer, Reserva> entry : coleccion.entrySet()) {
            reserva = entry.getValue();

            if (reserva.getCliente() == cliente) {
                reservas.add(reserva);
            }
        }

        return reservas;
    }
}
