package uy.edu.cure.servidor.central.lib.controllers;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import uy.edu.cure.servidor.central.dto.Ciudad;
import uy.edu.cure.servidor.central.lib.servicios.CiudadService;
import uy.edu.cure.servidor.central.lib.servicios.ServiceFactory;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CiudadControllerTest {

    private static CiudadController ciudadController;
    private static CiudadService ciudadService;

    @BeforeClass
    public static void beforeAll() {
        ciudadController = new CiudadController();
        ciudadService = ServiceFactory.getCiudadService();
    }

    @Before
    public void beforeEach() throws Exception {
        ciudadService.vaciar();
    }

    @Test
    public void testNuevo() throws Exception {
        Ciudad ciudad = new Ciudad();

        ciudadController.nueva(ciudad);

        assertEquals(ciudad, ciudadController.obtener(ciudad.getId()));
    }

    @Test
    public void testEliminar() throws Exception {
        Ciudad ciudad = new Ciudad();

        ciudadController.nueva(ciudad);
        ciudadController.eliminar(ciudad.getId());

        assertNull(ciudadController.obtener(ciudad.getId()));
    }

    @Test
    public void testModificar() throws Exception {
        Ciudad ciudadOld = new Ciudad();
        ciudadController.nueva(ciudadOld);

        Ciudad ciudadNew = new Ciudad();
        ciudadNew.setId(ciudadOld.getId());
        ciudadController.modificar(ciudadNew);

        assertEquals(ciudadNew, ciudadController.obtener(ciudadOld.getId()));
    }

    @Test
    public void testObtener() throws Exception {
        Ciudad ciudad = new Ciudad();
        ciudadController.nueva(ciudad);

        assertEquals(ciudad, ciudadController.obtener(ciudad.getId()));
    }


    @Test
    public void testListar() throws Exception {
        List<Ciudad> expected = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            expected.add(new Ciudad());
        }

        for (Ciudad ciudad : expected) {
            ciudadController.nueva(ciudad);
        }

        List<Ciudad> actual = ciudadController.listar();

        assertTrue(expected.containsAll(actual) && actual.containsAll(expected));
    }


}