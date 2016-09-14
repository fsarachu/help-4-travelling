package uy.edu.cure.servidor.central.lib.controllers;

import uy.edu.cure.servidor.central.dto.Carrito;
import uy.edu.cure.servidor.central.dto.Cliente;
import uy.edu.cure.servidor.central.dto.ItemReserva;
import uy.edu.cure.servidor.central.lib.servicios.CarritoService;
import uy.edu.cure.servidor.central.lib.servicios.ItemReservaService;
import uy.edu.cure.servidor.central.lib.servicios.ServiceFactory;

public class CarritoController {
    private CarritoService carritoService;
    private ItemReservaService itemReservaService;

    public CarritoController() {
        this.carritoService = ServiceFactory.getCarritoService();
        this.itemReservaService = ServiceFactory.getItemReservaService();
    }

    public Carrito obtenerCarrito(Integer idCarrito) {
        return this.carritoService.obtener(idCarrito);
    }

    public void agregarItem(ItemReserva nuevoItem, Cliente cliente) {
        Carrito carrito = cliente.getCarrito();
        carrito.getItems().add(nuevoItem);
        carrito.actualizarTotal();
    }

    public void eliminarItem(Integer idItem) {
        this.itemReservaService.eliminar(idItem);
    }

}
