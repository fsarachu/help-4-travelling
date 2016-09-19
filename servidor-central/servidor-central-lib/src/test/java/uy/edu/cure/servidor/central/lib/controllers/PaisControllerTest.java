package uy.edu.cure.servidor.central.lib.controllers;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import uy.edu.cure.servidor.central.dto.Pais;
import uy.edu.cure.servidor.central.lib.servicios.PaisService;
import uy.edu.cure.servidor.central.lib.servicios.ServiceFactory;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PaisControllerTest {

    private static PaisController paisController;
    private static PaisService paisService;

    @BeforeClass
    public static void beforeAll() {
        paisController = new PaisController();
        paisService = ServiceFactory.getPaisService();
    }

    @Before
    public void beforeEach() {
        paisService.vaciar();
    }

    @Test
    public void agregar() throws Exception {
        Pais pais = new Pais();

        paisController.agregar(pais);

        assertEquals(pais, paisController.obtener(pais.getId()));
    }

    @Test
    public void eliminar() throws Exception {
        Pais pais = new Pais();

        paisController.agregar(pais);
        paisController.eliminar(pais.getId());

        assertNull(paisController.obtener(pais.getId()));
    }

    @Test
    public void obtener() throws Exception {
        Pais pais = new Pais();
        paisController.agregar(pais);

        assertEquals(pais, paisController.obtener(pais.getId()));

    }

    @Test
    public void modificar() throws Exception {
        Pais paisOld = new Pais();
        paisController.agregar(paisOld);

        Pais paisNew = new Pais();
        paisNew.setId(paisOld.getId());
        paisController.modificar(paisNew);

        assertEquals(paisNew, paisController.obtener(paisOld.getId()));
    }

    @Test
    public void listar() throws Exception {
        List<Pais> expected = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            expected.add(new Pais());
        }

        for (Pais ciudad : expected) {
            paisController.agregar(ciudad);
        }

        List<Pais> actual = paisController.listar();

        assertTrue(expected.containsAll(actual) && actual.containsAll(expected));
    }

}