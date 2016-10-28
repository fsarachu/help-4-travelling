package uy.edu.cure.servidor.central.lib.controllers;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import uy.edu.cure.servidor.central.dto.Ciudad;
import uy.edu.cure.servidor.central.dto.Producto;
import uy.edu.cure.servidor.central.dto.Promocion;
import uy.edu.cure.servidor.central.dto.Servicio;
import uy.edu.cure.servidor.central.lib.servicios.ProductoService;
import uy.edu.cure.servidor.central.lib.servicios.ServiceFactory;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ProductoControllerTest {

    private static ProductoController productoController;
    private static ProductoService productoService;

    @BeforeClass
    public static void beforeAll() {
        productoController = new ProductoController();
        productoService = ServiceFactory.getProductoService();
    }

    @Before
    public void beforeEach() throws Exception {
        productoService.vaciar();
    }

    @Test
    public void testAgregar() throws Exception {
        Producto producto = new Servicio();
        productoController.agregar(producto);
        assertEquals(producto, productoController.obtener(producto.getId()));
    }

    @Test
    public void testModificar() throws Exception {
        Producto productoOld;
        productoOld = new Servicio();
        productoController.agregar(productoOld);

        Producto productoNew = new Servicio();
        productoNew.setId(productoOld.getId());
        productoController.modificar(productoNew);

        assertEquals(productoNew, productoController.obtener(productoOld.getId()));
    }

    @Test
    public void testEliminar() throws Exception {
        Producto producto = new Servicio();
        productoController.agregar(producto);

        productoController.eliminar(producto.getId());

        assertNull(productoController.obtener(producto.getId()));
    }

    @Test
    public void testObtener() throws Exception {
        Producto producto = new Servicio();

        productoController.agregar(producto);

        assertEquals(producto, productoController.obtener(producto.getId()));
    }


    @Test
    public void testListarTodos() throws Exception {
        ArrayList<Producto> expected = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            expected.add(new Servicio());
            expected.add(new Promocion());
        }

        for (Producto producto : expected) {
            productoController.agregar(producto);
        }

        ArrayList<Producto> actual = productoController.listarTodos();

        assertTrue(expected.containsAll(actual) && actual.containsAll(expected));
    }

    @Test
    public void testListarPromociones() throws Exception {
        ArrayList<Producto> expected = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            expected.add(new Promocion());
        }

        for (Producto producto : expected) {
            productoController.agregar(producto);
        }

        ArrayList<Promocion> actual = productoController.listarPromociones();

        assertTrue(expected.containsAll(actual) && actual.containsAll(expected));
    }

    @Test
    public void testListarServiciosPorCiudad() throws Exception {
        ArrayList<Servicio> expected = new ArrayList<>();
        CiudadController ciudadController = new CiudadController();
        Ciudad ciudad = ciudadController.obtener(1);
        Servicio servicio1 = new Servicio();
        Servicio servicio2 = new Servicio();
        servicio1.setOrigen(ciudadController.obtener(1));
        servicio2.setOrigen(ciudadController.obtener(1));
        expected.add(servicio1);
        expected.add(servicio2);


        for (Producto producto : expected) {
            productoController.agregar(producto);
        }

        ArrayList<Servicio> actual = productoController.listarServiciosPorCiudad(ciudad);

        assertTrue(expected.containsAll(actual) && actual.containsAll(expected));

    }

}