package uy.edu.cure.servidor.central.lib.servicios;

import uy.edu.cure.servidor.central.dto.Cliente;
import uy.edu.cure.servidor.central.dto.Reserva;

import java.util.ArrayList;

public interface ReservaService extends GenericService<Reserva> {
    ArrayList<Reserva> listarReservasCliente(Cliente cliente);
}
