package uy.edu.cure.servidor.central.lib.servicios;

import uy.edu.cure.servidor.central.dto.Cliente;
import uy.edu.cure.servidor.central.dto.Reserva;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ReservaService extends GenericService<Reserva> {
    ArrayList<Reserva> listarReservasCliente(Cliente cliente);
    ArrayList<Reserva> listarReservasProveedor(Integer idProveedor);
    void comprarReserva(Cliente cliente) throws SQLException, ClassNotFoundException;

}
