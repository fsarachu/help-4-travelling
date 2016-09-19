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

    public void actualizarTotal(Carrito carrito) {
        List<ItemReserva> items = carrito.getItems();
        double newTotal = 0.0;

        for (ItemReserva item : items) {
            newTotal += item.getSubTotal();
        }

        carrito.setTotal(newTotal);
    }

    public void cargarItems(Carrito carrito) {
        if(carrito != null){
            List<Integer> idItems = carrito.getIdItems();
            List<ItemReserva> items = carrito.getItems();

            items.clear();

            for (Integer idItem : idItems) {
                items.add(this.itemReservaService.obtener(idItem));
            }

            this.actualizarTotal(carrito);
        }else{
            System.out.println( "Lugar: " + this.toString() + " Obj: carrito en CargarItems" );
        }

    }

    public Carrito obtenerCarrito(Integer idCarrito) {
        Carrito carrito = this.carritoService.obtener(idCarrito);
        this.cargarItems(carrito);

        return carrito;
    }
    /*no estan en uso, comentarlas sube la cobertura(?)*/

    public void agregarItem(ItemReserva nuevoItem, Integer idCarrito) {
        nuevoItem.setId(this.itemReservaService.nextId());
        this.itemReservaService.agregar(nuevoItem.getId(), nuevoItem);

        Carrito carrito = this.obtenerCarrito(idCarrito);

        carrito.getIdItems().add(nuevoItem.getId());

        this.cargarItems(carrito);
    }

    public void modificarItem(ItemReserva item) {
        this.itemReservaService.modificar(item.getId(), item);

        this.cargarItems(item.getCarrito());
    }

    public void eliminarItem(ItemReserva item) {
        Carrito carrito = item.getCarrito();

        carrito.getIdItems().remove(item.getId());
        this.itemReservaService.eliminar(item.getId());

        this.cargarItems(carrito);
    }

}
