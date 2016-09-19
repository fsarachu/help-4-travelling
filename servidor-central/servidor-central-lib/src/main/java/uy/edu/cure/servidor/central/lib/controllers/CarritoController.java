package uy.edu.cure.servidor.central.lib.controllers;

import uy.edu.cure.servidor.central.dto.Carrito;
import uy.edu.cure.servidor.central.dto.ItemReserva;
import uy.edu.cure.servidor.central.lib.servicios.CarritoService;
import uy.edu.cure.servidor.central.lib.servicios.ItemReservaService;
import uy.edu.cure.servidor.central.lib.servicios.ServiceFactory;

import java.util.List;

public class CarritoController {

    private CarritoService carritoService;
    private ItemReservaService itemReservaService;

    public CarritoController() {
        this.carritoService = ServiceFactory.getCarritoService();
        this.itemReservaService = ServiceFactory.getItemReservaService();
    }

    private void actualizarTotal(Carrito carrito) {
        List<ItemReserva> items = carrito.getItems();
        double newTotal = 0.0;

        for (ItemReserva item : items) {
            newTotal += item.getSubTotal();
        }

        carrito.setTotal(newTotal);
    }

    private void cargarItemsDesdeIds(Carrito carrito) {
        List<Integer> idItems = carrito.getIdItems();
        List<ItemReserva> items = carrito.getItems();

        items.clear();

        for (Integer idItem : idItems) {
            items.add(this.itemReservaService.obtener(idItem));
        }
    }

    public Carrito obtenerCarrito(Integer idCarrito) {
        Carrito carrito = this.carritoService.obtener(idCarrito);
        this.cargarItemsDesdeIds(carrito);
        this.actualizarTotal(carrito);

        return carrito;
    }

    public void agregarItem(ItemReserva itemReserva) {
        itemReserva.setId(this.itemReservaService.nextId());
        this.itemReservaService.agregar(itemReserva.getId(), itemReserva);

        Carrito carrito = itemReserva.getCarrito();
        carrito.addItem(itemReserva);

        this.actualizarTotal(carrito);
    }

    public void modificarItem(ItemReserva itemReserva) {
        this.itemReservaService.modificar(itemReserva.getId(), itemReserva);

        Carrito carrito = itemReserva.getCarrito();
        this.cargarItemsDesdeIds(carrito);
        this.actualizarTotal(carrito);
    }

    public void eliminarItem(ItemReserva itemReserva) {
        Carrito carrito = itemReserva.getCarrito();

        carrito.removeItem(itemReserva);
        this.itemReservaService.eliminar(itemReserva.getId());

        this.actualizarTotal(carrito);

    }

}
