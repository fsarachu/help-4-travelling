package uy.edu.cure.servidor.central.lib.controllers;

import junit.framework.TestCase;
import org.junit.BeforeClass;
import org.junit.Test;
import uy.edu.cure.servidor.central.dto.Categoria;

import java.util.ArrayList;

public class CategoriaControllerTest extends TestCase {

    private CategoriaController categoriaController;

    @BeforeClass
    public void setUp() {
        this.categoriaController = new CategoriaController();
    }


    @Test
    public void testNuevo() throws Exception {
        Categoria categoria = new Categoria();
        categoria.setId(1);
        categoria.setNombre("Autos");

        this.categoriaController.nueva(categoria);

        assertEquals(categoria, this.categoriaController.obtener(1));
    }


    public void testModificar() throws Exception {
        Categoria categoria = new Categoria();
        categoria.setId(101);
        categoria.setNombre("Autos");
        Categoria categoria1 = new Categoria();
        categoria1.setId(101);
        categoria1.setNombre("Motos");

        this.categoriaController.nueva(categoria);
        this.categoriaController.modificar(categoria1);

        assertEquals(categoria1, categoriaController.obtener(101));
    }

    public void testObtener() throws Exception {
        Categoria categoria = new Categoria();
        categoria.setId(101);
        categoria.setNombre("Autos");

        this.categoriaController.nueva(categoria);

        assertEquals(categoria, categoriaController.obtener(101));

    }


    public void testListar() throws Exception {
        ArrayList<Categoria> expected = new ArrayList<>();
        Categoria categoria1 = new Categoria();
        categoria1.setId(1);
        categoria1.setNombre("Autos");
        Categoria categoria2 = new Categoria();
        categoria2.setId(2);
        categoria2.setNombre("Motos");
        expected.add(categoria1);
        expected.add(categoria2);
        for (Categoria categoria : expected) {
            this.categoriaController.nueva(categoria);
        }
        ArrayList<Categoria> actual = categoriaController.listar();
        for (int n = 0; n < 2; n++) {
            assertEquals(expected.get(n), actual.get(n));
        }

    }

}