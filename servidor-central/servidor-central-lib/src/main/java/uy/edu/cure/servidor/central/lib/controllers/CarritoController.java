package uy.edu.cure.servidor.central.lib.controllers;

import uy.edu.cure.servidor.central.dto.Carrito;
import uy.edu.cure.servidor.central.dto.Cliente;
import uy.edu.cure.servidor.central.dto.ItemReserva;
import uy.edu.cure.servidor.central.lib.servicios.*;

public class CarritoController {
    private CarritoService carritoService;
    private ItemReservaService itemReservaService;
    private ClienteService clienteService;
    private ProductoService productoService;

    public CarritoController() {
        this.carritoService = ServiceFactory.getCarritoService();
        this.itemReservaService = ServiceFactory.getItemReservaService();
        this.clienteService = ServiceFactory.getClienteService();
        this.productoService = ServiceFactory.getProductoService();
    }

    public Carrito obtenerCarrito(Integer idCarrito) {
        return this.carritoService.obtener(idCarrito);
    }

    public void agregarItem(ItemReserva nuevoItem, Cliente cliente) {
        Carrito carrito = cliente.getCarrito();
        carrito.getItems().add(nuevoItem);
        carrito.actualizarTotal();
    }
}
