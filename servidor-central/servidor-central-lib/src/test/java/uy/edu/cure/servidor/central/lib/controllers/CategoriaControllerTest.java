package uy.edu.cure.servidor.central.lib.controllers;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import uy.edu.cure.servidor.central.dto.Categoria;
import uy.edu.cure.servidor.central.lib.servicios.CategoriaService;
import uy.edu.cure.servidor.central.lib.servicios.ServiceFactory;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CategoriaControllerTest {

    private static CategoriaController categoriaController;
    private static CategoriaService categoriaService;

    @BeforeClass
    public static void beforeAll() {
        categoriaController = new CategoriaController();
        categoriaService = ServiceFactory.getCategoriaService();
    }

    @Before
    public void beforeEach() throws Exception {
        categoriaService.vaciar();
    }

    @Test
    public void testNuevo() throws Exception {
        Categoria categoria = new Categoria();
        categoria.setNombre("Autos");

        categoriaController.nueva(categoria);

        assertEquals(categoria, categoriaController.obtener(categoria.getId()));
    }

    @Test
    public void testModificar() throws Exception {
        Categoria categoriaOld = new Categoria();
        categoriaOld.setNombre("Autos");

        categoriaController.nueva(categoriaOld);

        Categoria categoriaNew = new Categoria();
        categoriaNew.setId(categoriaOld.getId());
        categoriaNew.setNombre("Motos");

        categoriaController.modificar(categoriaNew);

        assertEquals(categoriaNew, categoriaController.obtener(categoriaNew.getId()));
    }

    @Test
    public void testObtener() throws Exception {
        Categoria categoria = new Categoria();
        categoria.setNombre("Autos");

        categoriaController.nueva(categoria);

        assertEquals(categoria, categoriaController.obtener(categoria.getId()));

    }

    @Test
    public void testListar() throws Exception {
        List<Categoria> expected = new ArrayList<>();

        expected.add(new Categoria(null, "Autos", null, null));
        expected.add(new Categoria(null, "Vuelo", null, null));

        for (Categoria categoria : expected) {
            categoriaController.nueva(categoria);
        }

        System.out.println("Expected:");
        for (Categoria categoria : expected) {
            System.out.println(categoria.getId() + " - " + categoria.getNombre());
        }

        List<Categoria> actual = categoriaController.listar();

        System.out.println("Actual:");
        for (Categoria categoria : actual) {
            System.out.println(categoria.getId() + " - " + categoria.getNombre());
        }

        assertTrue(expected.containsAll(actual) && actual.containsAll(expected));

    }

}