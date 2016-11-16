package uy.edu.cure.servidor.central.webapp.rest.api.RestControllers;

import uy.edu.cure.servidor.central.dto.Carrito;
import uy.edu.cure.servidor.central.dto.ItemReserva;
import uy.edu.cure.servidor.central.lib.controllers.CarritoController;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;

/**
 * Created by victor on 09/11/16.
 */
public class CarritoRestController {

    @GET
    @Produces
    public void actualizarTotal(Carrito carrito) {
        CarritoController carritoController = new CarritoController();
        carritoController.actualizarTotal(carrito);
    }

    @GET
    @Produces
    public Carrito obtenerCarrito(Integer idCarrito) {
        CarritoController carritoController = new CarritoController();
        return carritoController.obtenerCarrito(idCarrito);
    }

    @GET
    @Produces
    public void agregarItem(ItemReserva itemReserva, Carrito carrito) {
        CarritoController carritoController = new CarritoController();
        carritoController.agregarItem(itemReserva, carrito);
    }

}
