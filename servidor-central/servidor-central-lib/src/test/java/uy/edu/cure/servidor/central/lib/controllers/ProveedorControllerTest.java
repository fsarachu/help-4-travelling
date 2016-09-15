package uy.edu.cure.servidor.central.lib.controllers;

import junit.framework.TestCase;
import org.junit.BeforeClass;
import org.junit.Test;
import uy.edu.cure.servidor.central.dto.Proveedor;

import java.util.ArrayList;

public class ProveedorControllerTest extends TestCase {

    private ProveedorController proveedorController;

    @BeforeClass
    public void setUp() {
        this.proveedorController = new ProveedorController();
    }


    @Test
    public void testNuevo() throws Exception {
        Proveedor proveedor = new Proveedor();
        proveedor.setId(1);
        proveedor.setNombre("Conaprole");

        this.proveedorController.nuevo(proveedor);

        assertEquals(proveedor, this.proveedorController.obtener(1));
    }

    public void testEliminar() throws Exception {
        Proveedor proveedor = new Proveedor();
        proveedor.setId(101);
        proveedor.setNombre("Conaprole");

        this.proveedorController.eliminar(101);

        assertNull(this.proveedorController.obtener(101));
    }

    public void testModificar() throws Exception {
        Proveedor proveedor = new Proveedor();
        proveedor.setId(101);
        proveedor.setNombre("Conaprole");
        Proveedor proveedor1 = new Proveedor();
        proveedor1.setId(101);
        proveedor1.setNombre("Parmalat");

        this.proveedorController.nuevo(proveedor);
        this.proveedorController.modificar(proveedor1.getId(), proveedor1);

        assertEquals(proveedor1, proveedorController.obtener(101));
    }

    public void testObtener() throws Exception {
        Proveedor proveedor = new Proveedor();
        proveedor.setId(101);
        proveedor.setNombre("Conaprole");

        this.proveedorController.nuevo(proveedor);

        assertEquals(proveedor, proveedorController.obtener(101));

    }


    public void testListar() throws Exception {
        ArrayList<Proveedor> expected = new ArrayList<>();
        Proveedor proveedor1 = new Proveedor();
        proveedor1.setId(1);
        proveedor1.setNombre("Conaprole");
        Proveedor proveedor2 = new Proveedor();
        proveedor2.setId(2);
        proveedor2.setNombre("Parmalat");
        expected.add(proveedor1);
        expected.add(proveedor2);
        for (Proveedor proveedor : expected) {
            this.proveedorController.nuevo(proveedor);
        }
        ArrayList<Proveedor> actual = proveedorController.listar();
        for (int n = 0; n < 2; n++) {
            assertEquals(expected.get(n), actual.get(n));
        }

    }

}