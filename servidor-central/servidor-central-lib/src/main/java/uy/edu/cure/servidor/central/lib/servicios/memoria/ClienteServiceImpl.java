package uy.edu.cure.servidor.central.lib.servicios.memoria;

import uy.edu.cure.servidor.central.dto.*;
import uy.edu.cure.servidor.central.lib.controllers.CarritoController;
import uy.edu.cure.servidor.central.lib.servicios.ClienteService;
import uy.edu.cure.servidor.central.lib.servicios.ReservaService;
import uy.edu.cure.servidor.central.lib.servicios.ServiceFactory;

import java.util.ArrayList;
import java.util.Map;

public class ClienteServiceImpl extends GenericServiceImpl<Cliente> implements ClienteService {

    private static ClienteServiceImpl ourInstance = new ClienteServiceImpl();

    public static ClienteServiceImpl getInstance() {
        return ourInstance;
    }

    private ClienteServiceImpl() {
        super();
    }

    public Integer nextId() {
        Integer maxId = 0;
        for (Map.Entry<Integer, Cliente> entry : coleccion.entrySet()) {
            if (entry.getValue().getId() > maxId) {
                maxId = entry.getValue().getId();
            }
        }

        return maxId + 1;
    }


    @Override
    public boolean nicknameExiste(String nickname) {
        Cliente cliente;

        for (Map.Entry<Integer, Cliente> entry : coleccion.entrySet()) {
            cliente = entry.getValue();

            if (cliente.getNickname().equals(nickname)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean emailExiste(String email) {
        Cliente cliente;

        for (Map.Entry<Integer, Cliente> entry : coleccion.entrySet()) {
            cliente = entry.getValue();

            if (cliente.getCorreo().equals(email)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public ArrayList<Cliente> listarCompradoresServicio(Servicio servicio) {
        ArrayList<Cliente> clientes = new ArrayList<>();
        ReservaService reservaService = ServiceFactory.getReservaService();

        for (Map.Entry<Integer, Cliente> entry : coleccion.entrySet()) {
            Cliente cliente = entry.getValue();
            ArrayList<Reserva> reservasCliente = reservaService.listarReservasCliente(cliente);

            for (Reserva reserva : reservasCliente) {
                CarritoController carritoController = new CarritoController();
                Carrito carrito = carritoController.obtenerCarrito(reserva.getCarrito().getId());

                ArrayList<ItemReserva> itemsReserva = carrito.getItems();

                for (ItemReserva item : itemsReserva) {
                    if (item.getProducto().equals((Producto) servicio)) {
                        clientes.add(cliente);
                    }
                }
            }

        }

        return clientes;
    }
}
