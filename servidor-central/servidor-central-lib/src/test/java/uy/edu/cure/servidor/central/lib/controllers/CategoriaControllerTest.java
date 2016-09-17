package uy.edu.cure.servidor.central.lib.controllers;

import junit.framework.TestCase;
import org.junit.Test;
import uy.edu.cure.servidor.central.dto.Categoria;
import uy.edu.cure.servidor.central.lib.servicios.CategoriaService;
import uy.edu.cure.servidor.central.lib.servicios.ServiceFactory;

import java.util.ArrayList;
import java.util.List;

public class CategoriaControllerTest extends TestCase {

    private CategoriaController categoriaController;
    private CategoriaService categoriaService;


    @Override
    public void setUp() throws Exception {
        this.categoriaController = new CategoriaController();
        this.categoriaService = ServiceFactory.getCategoriaService();
        this.categoriaService.vaciar();
    }

    @Test
    public void testNuevo() throws Exception {
        Categoria categoria = new Categoria();
        categoria.setNombre("Autos");

        this.categoriaController.nueva(categoria);

        assertEquals(categoria, this.categoriaController.obtener(categoria.getId()));
    }

    @Test
    public void testModificar() throws Exception {
        Categoria categoriaOld = new Categoria();
        categoriaOld.setNombre("Autos");

        this.categoriaController.nueva(categoriaOld);

        Categoria categoriaNew = new Categoria();
        categoriaNew.setId(categoriaOld.getId());
        categoriaNew.setNombre("Motos");

        this.categoriaController.modificar(categoriaNew);

        assertEquals(categoriaNew, categoriaController.obtener(categoriaNew.getId()));
    }

    @Test
    public void testObtener() throws Exception {
        Categoria categoria = new Categoria();
        categoria.setNombre("Autos");

        this.categoriaController.nueva(categoria);

        assertEquals(categoria, categoriaController.obtener(categoria.getId()));

    }

    @Test
    public void testListar() throws Exception {
        List<Categoria> expected = new ArrayList<>();

        expected.add(new Categoria(null, "Autos", null, null));
        expected.add(new Categoria(null, "Vuelo", null, null));

        for (Categoria categoria : expected) {
            this.categoriaController.nueva(categoria);
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