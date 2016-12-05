package uy.edu.cure.servidor.central.lib.servicios.memoria;

import uy.edu.cure.servidor.central.dto.Cliente;
import uy.edu.cure.servidor.central.dto.Reserva;
import uy.edu.cure.servidor.central.lib.servicios.Conexion;
import uy.edu.cure.servidor.central.lib.servicios.ReservaService;

import java.sql.SQLException;
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

    public void comprarReserva(Cliente cliente) throws SQLException, ClassNotFoundException {
        ArrayList<Reserva> reservas = listarReservasCliente(cliente);
        for (int i=0 ; i < reservas.size() ; i++) {
            if (!reservas.get(i).getCliente().getId().equals(cliente.getId())) {
                reservas.remove(i);
            }
        }
        guardarFactura(reservas);
    }

    private void guardarFactura(ArrayList<Reserva> reserva) throws SQLException, ClassNotFoundException {
        Conexion conexion = new Conexion();
        conexion.agregar(reserva);
    }

    @Override
    public ArrayList<Reserva> listarReservasCliente(Cliente cliente) {
        ArrayList<Reserva> reservas = new ArrayList<>();
        Reserva reserva;

        for (Map.Entry<Integer, Reserva> entry : coleccion.entrySet()) {
            reserva = entry.getValue();

            if (reserva.getCliente().getId().equals(cliente.getId())) {
                reservas.add(reserva);
            }
        }

        return reservas;
    }

    @Override
    public ArrayList<Reserva> listarReservasProveedor(Integer idProveedor) {
        ArrayList<Reserva> reservas = new ArrayList<>();
        Reserva reserva;

        for (Map.Entry<Integer, Reserva> entry : coleccion.entrySet()) {
            reserva = entry.getValue();
            for (int i = 0; i < reserva.getCarrito().getItems().size(); i++) {
                if (reserva.getCarrito().getItems().get(i).getProducto().getProveedor().getId().equals(idProveedor)) {
                    reservas.add(reserva);
                }
            }
        }
        return reservas;
    }
}
