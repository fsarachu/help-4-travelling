package uy.edu.cure.servidor.central.lib.controllers;

import junit.framework.TestCase;
import org.junit.BeforeClass;
import org.junit.Test;
import uy.edu.cure.servidor.central.dto.Promocion;
import uy.edu.cure.servidor.central.dto.Proveedor;

import java.util.ArrayList;

public class PromocionControllerTest extends TestCase {

    private PromocionController promocionController;

    @BeforeClass
    public void setUp() {
        this.promocionController = new PromocionController();
    }


    @Test
/*    public void testNuevo() throws Exception {
        Promocion promocion = new Promocion();
        promocion.setId(1);
        promocion.setNombre("Autos");

        this.promocionController.nueva(promocion);

        assertEquals(promocion, this.promocionController.obtener(1));
    }*/

    public void testEliminar() throws Exception {
        Promocion promocion = new Promocion();
        promocion.setId(101);
        promocion.setNombre("Autos");

        this.promocionController.eliminar(101);

        assertNull(this.promocionController.obtener(101));
    }

/*    public void testModificar() throws Exception {
        Promocion promocion1 = new Promocion();
        Proveedor proveedor1 = new Proveedor();
        proveedor1.setId(1);
        proveedor1.setNombreEmpresa("Conaprole");
        promocion1.setId(101);
        promocion1.setNombre("Autos");
        promocion1.setProveedor(proveedor1);
        Promocion promocion2 = new Promocion();
        Proveedor proveedor2 = new Proveedor();
        proveedor2.setId(2);
        proveedor2.setNombreEmpresa("Parmalat");
        promocion2.setId(101);
        promocion2.setNombre("Motos");
        promocion2.setProveedor(proveedor2);
        this.promocionController.nueva(promocion1);
        this.promocionController.modificar(promocion2.getId(), promocion2);

        assertEquals(promocion2, promocionController.obtener(101));
    }

    /*public void testObtener() throws Exception {
        Promocion promocion = new Promocion();
        promocion.setId(101);
        promocion.setNombre("autos");

        this.promocionController.nueva(promocion);

        assertEquals(promocion, promocionController.obtener(101));

    }


    public void testListar() throws Exception {
        ArrayList<Promocion> expected = new ArrayList<>();
        Promocion promocion1 = new Promocion();
        promocion1.setId(1);
        promocion1.setNombre("Autos");
        Promocion promocion2 = new Promocion();
        promocion2.setId(2);
        promocion2.setNombre("Motos");
        expected.add(promocion1);
        expected.add(promocion2);
        for (Promocion promocion : expected) {
            this.promocionController.nueva(promocion);
        }
        ArrayList<Promocion> actual = promocionController.listar();
        for (int n = 0; n < 2; n++) {
            assertEquals(expected.get(n), actual.get(n));
        }

    }*/

}