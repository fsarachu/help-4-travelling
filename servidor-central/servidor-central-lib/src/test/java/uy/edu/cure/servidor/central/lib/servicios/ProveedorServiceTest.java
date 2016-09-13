package uy.edu.cure.servidor.central.lib.servicios;

import junit.framework.TestCase;
import org.junit.BeforeClass;
import org.junit.Test;
import uy.edu.cure.servidor.central.dto.Proveedor;
import uy.edu.cure.servidor.central.lib.servicios.memoria.ProveedorServiceImpl;

import java.util.ArrayList;

public class ProveedorServiceTest extends TestCase {

    private ProveedorService proveedorService;

    @BeforeClass
    public void setUp() {
        this.proveedorService = ProveedorServiceImpl.getInstance();
    }

    @Test
    public void testAgregar() throws Exception {
        Proveedor proveedor = new Proveedor();
        proveedor.setId(1);
        proveedor.setNombre("Conaprole");

        this.proveedorService.agregar(proveedor.getId(),proveedor);

        assertEquals(proveedor, this.proveedorService.obtener(1));

    }


    public void testEliminar() throws Exception {
        Proveedor proveedor = new Proveedor();
        proveedor.setId(101);
        proveedor.setNombre("Parmalat");

        this.proveedorService.eliminar(101);

        assertNull(this.proveedorService.obtener(101));
    }

    public void testModificar() throws Exception {
        Proveedor proveedor = new Proveedor();
        proveedor.setId(101);
        proveedor.setNombre("Parmalat");
        Proveedor proveedor1 = new Proveedor();
        proveedor1.setId(101);
        proveedor1.setNombre("Conaprole");

        this.proveedorService.agregar(proveedor.getId(),proveedor);
        this.proveedorService.modificar(proveedor1.getId(),proveedor1);

        assertEquals(proveedor1, proveedorService.obtener(101));
    }

    public void testObtener() throws Exception {
        Proveedor proveedor = new Proveedor();
        proveedor.setId(101);
        proveedor.setNombre("Conaprole");

        this.proveedorService.agregar(101,proveedor);

        assertEquals(proveedor, proveedorService.obtener(101));

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
        for (Proveedor proveedor : expected){
            this.proveedorService.agregar(proveedor.getId(),proveedor);
        }
        ArrayList<Proveedor> actual = proveedorService.listar();
        for (int n=0 ; n<2 ; n++) {
            assertEquals(expected.get(n), actual.get(n));
        }

    }


}