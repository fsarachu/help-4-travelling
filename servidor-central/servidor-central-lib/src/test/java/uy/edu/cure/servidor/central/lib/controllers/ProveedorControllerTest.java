package uy.edu.cure.servidor.central.lib.controllers;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import uy.edu.cure.servidor.central.dto.Proveedor;
import uy.edu.cure.servidor.central.lib.servicios.ProveedorService;
import uy.edu.cure.servidor.central.lib.servicios.ServiceFactory;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class ProveedorControllerTest {

    private static ProveedorController proveedorController;
    private static ProveedorService proveedorService;

    @BeforeClass
    public static void beforeAll() {
        proveedorController = new ProveedorController();
        proveedorService = ServiceFactory.getProveedorService();
    }

    @Before
    public void beforeEach() throws Exception {
        proveedorService.vaciar();
    }

    @Test
    public void testNuevo() throws Exception {
        Proveedor proveedor = new Proveedor();

        proveedorController.nuevo(proveedor);

        assertEquals(proveedor, proveedorController.obtener(proveedor.getId()));
    }

    @Test
    public void testEliminar() throws Exception {
        Proveedor proveedor = new Proveedor();

        proveedorController.nuevo(proveedor);

        assertEquals(proveedor, proveedorController.obtener(proveedor.getId()));

        proveedorController.eliminar(proveedor.getId());

        assertNull(proveedorController.obtener(proveedor.getId()));
    }

    @Test
    public void testModificar() throws Exception {
        Proveedor proveedorOld = new Proveedor();
        proveedorController.nuevo(proveedorOld);

        Proveedor proveedorNew = new Proveedor();
        proveedorNew.setId(proveedorOld.getId());
        proveedorController.modificar(proveedorNew);

        assertEquals(proveedorNew, proveedorController.obtener(proveedorOld.getId()));
    }

    @Test
    public void testObtener() throws Exception {
        Proveedor proveedor = new Proveedor();

        proveedorController.nuevo(proveedor);

        assertEquals(proveedor, proveedorController.obtener(proveedor.getId()));
    }


    @Test
    public void testListar() throws Exception {
        List<Proveedor> expected = new ArrayList<>();

        expected.add(new Proveedor());
        expected.add(new Proveedor());

        for (Proveedor proveedor : expected) {
            proveedorController.nuevo(proveedor);
        }

        List<Proveedor> actual = proveedorController.listar();

        assertTrue(expected.containsAll(actual) && actual.containsAll(expected));
    }

}