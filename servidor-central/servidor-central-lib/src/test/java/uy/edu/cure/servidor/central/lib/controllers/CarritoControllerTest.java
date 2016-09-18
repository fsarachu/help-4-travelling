package uy.edu.cure.servidor.central.lib.controllers;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import uy.edu.cure.servidor.central.dto.Carrito;
import uy.edu.cure.servidor.central.dto.Cliente; //feo
import uy.edu.cure.servidor.central.dto.ItemReserva; //feo
import uy.edu.cure.servidor.central.lib.servicios.CarritoService;
import uy.edu.cure.servidor.central.lib.servicios.ServiceFactory;
import uy.edu.cure.servidor.central.lib.servicios.ItemReservaService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CarritoControllerTest{//} extends TestCase {

    private static CarritoController carritoController;
    private static CarritoService carritoService;
    private static ItemReservaService itemService;

    @BeforeClass
    public static void beforeAll() {

        carritoController = new CarritoController();
        carritoService = ServiceFactory.getCarritoService();
        carritoService.vaciar();
        itemService = ServiceFactory.getItemReservaService();

        Carrito carrito1 = new Carrito();
        carrito1.setId(1);
            Cliente cliente1 = new Cliente();
        carrito1.setCliente(cliente1);
            ArrayList<ItemReserva> items = new ArrayList<>();
            ArrayList<Integer> itemids =  new ArrayList<>();
            ItemReserva item1 = new ItemReserva();
            ItemReserva item2 = new ItemReserva();
            item1.setId(1);
            item2.setId(2);
            item1.setSubTotal(4023);
            item2.setSubTotal(1000);
            items.add(item1);
            items.add(item2);
            itemids.add(1);
            itemids.add(2);
        itemService.agregar(1, item1);
        itemService.agregar(2, item1);
        carrito1.setItems(items);
        carrito1.setIdItems(itemids);
        carrito1.setTotal(5023);
        carritoService.agregar( 1, carrito1);

    }

    @Before
    public void beforeEach() throws Exception {
        //carritoService.vaciar();
    }

    @Test
    public void testActualizarTotal() throws Exception {
        Carrito carrito = carritoController.obtenerCarrito(1);
        int total = 5023; //jarcode ^
        carrito.setTotal(60);
        carritoController.actualizarTotal(carrito);
        assertEquals(total, carrito.getTotal() ); //double double wtf
    }

    @Test
    public void testCargarItems() throws Exception {
        Carrito carrito1 = carritoController.obtenerCarrito(1);
        assertNotNull(carrito1);
        if( carrito1 != null){
            List<ItemReserva> items = carrito1.getItems();
            assertNotNull(items);
            if(items != null) {
                carrito1.setItems(null);
                carritoController.cargarItems(carrito1);
                assertEquals(items, carrito1.getItems());
            }
        }
    }

    @Test
    public void testObtenerCarrito() throws Exception {
        /*carritoController = new CarritoController();
        carritoService = ServiceFactory.getCarritoService();
        carritoService.vaciar();
        itemService = ServiceFactory.getItemReservaService();
*/
        //Carrito carrito1 = new Carrito();
        /*carrito1.setId(1);
        Cliente cliente1 = new Cliente();
        carrito1.setCliente(cliente1);
        ArrayList<ItemReserva> items = new ArrayList<>();
        ArrayList<Integer> itemids =  new ArrayList<>();
        ItemReserva item1 = new ItemReserva();
        ItemReserva item2 = new ItemReserva();
        item1.setId(1);
        item2.setId(2);
        item1.setSubTotal(4023);
        item2.setSubTotal(1000);
        items.add(item1);
        items.add(item2);
        itemids.add(1);
        itemids.add(2);
        itemService.agregar(1, item1);
        itemService.agregar(2, item1);
        carrito1.setItems(items);
        carrito1.setIdItems(itemids);
        carrito1.setTotal(5023);
        carritoService.agregar( 1, carrito1);
*/
        Carrito carrito1 = carritoController.obtenerCarrito(1);
        assertNotNull(carrito1);
    }

    /*@Test
    public void testListar() throws Exception {
        List<Carrito> expected = new ArrayList<>();

        expected.add(new Carrito(null, "Autos", null, null));
        expected.add(new Carrito(null, "Vuelo", null, null));

        for (Carrito Carrito : expected) {
            carritoController. (Carrito);
        }

        System.out.println("Expected:");
        for (Carrito Carrito : expected) {
            System.out.println(Carrito.getId() + " - " + Carrito.getNombre());
        }

        List<Carrito> actual = carritoController.listar();

        System.out.println("Actual:");
        for (Carrito Carrito : actual) {
            System.out.println(Carrito.getId() + " - " + Carrito.getNombre());
        }

        assertTrue(expected.containsAll(actual) && actual.containsAll(expected));

    }*/

}