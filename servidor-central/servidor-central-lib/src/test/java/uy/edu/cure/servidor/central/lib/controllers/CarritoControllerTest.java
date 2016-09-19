package uy.edu.cure.servidor.central.lib.controllers;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import uy.edu.cure.servidor.central.dto.Carrito;
import uy.edu.cure.servidor.central.dto.ItemReserva;
import uy.edu.cure.servidor.central.lib.servicios.CarritoService;
import uy.edu.cure.servidor.central.lib.servicios.ServiceFactory;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CarritoControllerTest {

    private static CarritoController carritoController;
    private static CarritoService carritoService;

    @BeforeClass
    public static void beforeAll() {
        carritoController = new CarritoController();
        carritoService = ServiceFactory.getCarritoService();
    }

    @Before
    public void setUp() throws Exception {
        carritoService.vaciar();
    }

    @Test
    public void obtenerCarrito() throws Exception {
        Carrito carrito = new Carrito();
        carrito.setId(carritoService.nextId());
        carritoService.agregar(carrito.getId(), carrito);

        assertEquals(carrito, carritoController.obtenerCarrito(carrito.getId()));
    }

    @Test
    public void agregarItem() throws Exception {
        Carrito carrito = new Carrito();
        ItemReserva itemReserva = new ItemReserva();

        carritoController.agregarItem(itemReserva, carrito);

        List<ItemReserva> items = carrito.getItems();
        List<Integer> idItems = carrito.getIdItems();

        assertTrue(items.contains(itemReserva) && idItems.contains(itemReserva.getId()));
    }

    @Test
    public void modificarItem() throws Exception {
        Carrito carrito = new Carrito();
        ItemReserva itemReservaOld = new ItemReserva();

        carritoController.agregarItem(itemReservaOld, carrito);

        List<ItemReserva> items = carrito.getItems();
        List<Integer> idItems = carrito.getIdItems();

        assertTrue(items.contains(itemReservaOld) && idItems.contains(itemReservaOld.getId()));

        ItemReserva itemReservaNew = new ItemReserva();
        itemReservaNew.setCarrito(itemReservaOld.getCarrito());
        itemReservaNew.setId(itemReservaOld.getId());

        carritoController.modificarItem(itemReservaNew);

        assertTrue(items.contains(itemReservaNew) && !items.contains(itemReservaOld));
    }

    @Test
    public void eliminarItem() throws Exception {
        Carrito carrito = new Carrito();
        ItemReserva itemReserva = new ItemReserva();

        carritoController.agregarItem(itemReserva, carrito);

        List<ItemReserva> items = carrito.getItems();
        List<Integer> idItems = carrito.getIdItems();

        assertTrue(items.contains(itemReserva) && idItems.contains(itemReserva.getId()));

        carritoController.eliminarItem(itemReserva);

        assertTrue(!items.contains(itemReserva) && !idItems.contains(itemReserva.getId()));
    }

}