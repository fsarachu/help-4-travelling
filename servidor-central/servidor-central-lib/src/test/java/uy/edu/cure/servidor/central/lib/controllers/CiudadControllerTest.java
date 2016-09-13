package uy.edu.cure.servidor.central.lib.controllers;

import junit.framework.TestCase;
import org.junit.BeforeClass;
import org.junit.Test;
import uy.edu.cure.servidor.central.dto.Ciudad;

import java.util.ArrayList;

public class CiudadControllerTest extends TestCase {

    private CiudadController ciudadController;

    @BeforeClass
    public void setUp() {
        this.ciudadController = new CiudadController();
    }


    @Test
    public void testNuevo() throws Exception {
        Ciudad ciudad = new Ciudad();
        ciudad.setId(1);
        ciudad.setNombre("Maldonado");

        this.ciudadController.nuevo(ciudad);

        assertEquals(ciudad, this.ciudadController.obtener(1));
    }

    public void testEliminar() throws Exception {
        Ciudad ciudad = new Ciudad();
        ciudad.setId(101);
        ciudad.setNombre("Maldonado");

        this.ciudadController.eliminar(101);

        assertNull(this.ciudadController.obtener(101));
    }

    public void testModificar() throws Exception {
        Ciudad ciudad = new Ciudad();
        ciudad.setId(101);
        ciudad.setNombre("Maldonado");
        Ciudad ciudad1 = new Ciudad();
        ciudad1.setId(101);
        ciudad1.setNombre("Punta del Este");

        this.ciudadController.nuevo(ciudad);
        this.ciudadController.modificar(ciudad1.getId(), ciudad1);

        assertEquals(ciudad1, ciudadController.obtener(101));
    }

    public void testObtener() throws Exception {
        Ciudad ciudad = new Ciudad();
        ciudad.setId(101);
        ciudad.setNombre("Maldonado");

        this.ciudadController.nuevo(ciudad);

        assertEquals(ciudad, ciudadController.obtener(101));

    }


    public void testListar() throws Exception {
        ArrayList<Ciudad> expected = new ArrayList<>();
        Ciudad ciudad1 = new Ciudad();
        ciudad1.setId(1);
        ciudad1.setNombre("Uruguay");
        Ciudad ciudad2 = new Ciudad();
        ciudad2.setId(2);
        ciudad2.setNombre("Argentina");
        expected.add(ciudad1);
        expected.add(ciudad2);
        for (Ciudad ciudad : expected) {
            this.ciudadController.nuevo(ciudad);
        }
        ArrayList<Ciudad> actual = ciudadController.listar();
        for (int n = 0; n < 2; n++) {
            assertEquals(expected.get(n), actual.get(n));
        }

    }


}