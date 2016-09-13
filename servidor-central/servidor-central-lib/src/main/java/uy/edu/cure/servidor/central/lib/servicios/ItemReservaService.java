package uy.edu.cure.servidor.central.lib.servicios;

import uy.edu.cure.servidor.central.dto.ItemReserva;

import java.util.ArrayList;

public interface ItemReservaService {
    void agregar(Integer id, ItemReserva itemReserva);

    void eliminar(Integer id);

    void modificar(Integer id, ItemReserva itemReserva);

    ItemReserva obtener(Integer id);

    ArrayList<ItemReserva> listar();
}
