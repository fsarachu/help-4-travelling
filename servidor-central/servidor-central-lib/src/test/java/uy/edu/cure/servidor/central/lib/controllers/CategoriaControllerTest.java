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

        categoriaController.nueva(categoria);

        assertEquals(categoria, categoriaController.obtener(categoria.getId()));
    }

    @Test
    public void testModificar() throws Exception {
        Categoria categoriaOld = new Categoria();

        categoriaController.nueva(categoriaOld);

        Categoria categoriaNew = new Categoria();
        categoriaNew.setId(categoriaOld.getId());

        categoriaController.modificar(categoriaNew);

        assertEquals(categoriaNew, categoriaController.obtener(categoriaNew.getId()));
    }

    @Test
    public void testObtener() throws Exception {
        Categoria categoria = new Categoria();

        categoriaController.nueva(categoria);

        assertEquals(categoria, categoriaController.obtener(categoria.getId()));

    }

    @Test
    public void testListar() throws Exception {
        List<Categoria> expected = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            expected.add(new Categoria(null, null, null, null));
        }

        for (Categoria categoria : expected) {
            categoriaController.nueva(categoria);
        }

        List<Categoria> actual = categoriaController.listar();

        assertTrue(expected.containsAll(actual) && actual.containsAll(expected));

    }

}