package uy.edu.cure.servidor.central.lib.servicios;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import uy.edu.cure.servidor.central.dto.Proveedor;
import uy.edu.cure.servidor.central.lib.servicios.memoria.ProveedorServiceImpl;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ProveedorServiceTest {

    private static ProveedorService proveedorService;

    @BeforeClass
    public static void setUp() {
        proveedorService = ProveedorServiceImpl.getInstance();
    }

    @Before
    public void beforeEach() {
        proveedorService.vaciar();
    }

    @Test
    public void testAgregar() throws Exception {
        Proveedor proveedor = new Proveedor();
        proveedor.setId(1);
        proveedor.setNombre("Conaprole");

        proveedorService.agregar(proveedor.getId(), proveedor);

        assertEquals(proveedor, proveedorService.obtener(1));

    }


    @Test
    public void testEliminar() throws Exception {
        Proveedor proveedor = new Proveedor();
        proveedor.setId(101);
        proveedor.setNombre("Parmalat");

        proveedorService.eliminar(101);

        assertNull(proveedorService.obtener(101));
    }

    @Test
    public void testModificar() throws Exception {
        Proveedor proveedor = new Proveedor();
        proveedor.setId(101);
        proveedor.setNombre("Parmalat");
        Proveedor proveedor1 = new Proveedor();
        proveedor1.setId(101);
        proveedor1.setNombre("Conaprole");

        proveedorService.agregar(proveedor.getId(), proveedor);
        proveedorService.modificar(proveedor1.getId(), proveedor1);

        assertEquals(proveedor1, proveedorService.obtener(101));
    }

    @Test
    public void testObtener() throws Exception {
        Proveedor proveedor = new Proveedor();
        proveedor.setId(101);
        proveedor.setNombre("Conaprole");

        proveedorService.agregar(101, proveedor);

        assertEquals(proveedor, proveedorService.obtener(101));
    }

    @Test
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
            proveedorService.agregar(proveedor.getId(), proveedor);
        }
        ArrayList<Proveedor> actual = proveedorService.listar();
        for (int n = 0; n < 2; n++) {
            assertEquals(expected.get(n), actual.get(n));
        }

    }

    @Test
    public void testNicknameExiste() throws Exception {
        Proveedor proveedor = new Proveedor();
        proveedor.setId(proveedorService.nextId());
        proveedor.setNickname("Iberia");

        proveedorService.agregar(proveedor.getId(), proveedor);

        assertTrue(proveedorService.nicknameExiste(proveedor.getNickname()));
    }

    @Test
    public void testEmailExiste() throws Exception {
        Proveedor proveedor = new Proveedor();
        proveedor.setId(proveedorService.nextId());
        proveedor.setCorreo("hola@iberia.com");

        proveedorService.agregar(proveedor.getId(), proveedor);

        assertTrue(proveedorService.emailExiste(proveedor.getCorreo()));

    }
}