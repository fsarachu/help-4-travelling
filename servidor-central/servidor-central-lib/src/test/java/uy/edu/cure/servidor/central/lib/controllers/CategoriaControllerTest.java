package uy.edu.cure.servidor.central.lib.controllers;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import uy.edu.cure.servidor.central.dto.Categoria;
import uy.edu.cure.servidor.central.dto.EstadoCategoria;
import uy.edu.cure.servidor.central.lib.servicios.CategoriaService;
import uy.edu.cure.servidor.central.lib.servicios.ServiceFactory;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

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
            expected.add(new Categoria(null, null, null, null, null, null));
        }

        for (Categoria categoria : expected) {
            categoriaController.nueva(categoria);
        }

        List<Categoria> actual = categoriaController.listar();

        assertTrue(expected.containsAll(actual) && actual.containsAll(expected));

    }

    @Test
    public void ocultar() throws Exception {
        ArrayList<Categoria> categoriasExpected = new ArrayList<>();

        Categoria categoria1 = new Categoria();
        categoria1.setNombre("Vuelos");
        categoriasExpected.add(categoria1);

        Categoria categoria1_1 = new Categoria();
        categoria1_1.setNombre("Rapidos");
        categoria1_1.setPadre(categoria1);
        categoria1.getHijos().add(categoria1_1);
        categoriasExpected.add(categoria1_1);

        Categoria categoria1_2 = new Categoria();
        categoria1_2.setNombre("Lentos");
        categoria1_2.setPadre(categoria1);
        categoria1.getHijos().add(categoria1_2);
        categoriasExpected.add(categoria1_2);

        Categoria categoria2 = new Categoria();
        categoria2.setNombre("Hoteles");
        categoriasExpected.add(categoria2);

        Categoria categoria2_1 = new Categoria();
        categoria2_1.setNombre("Feos");
        categoria2_1.setPadre(categoria2);
        categoria2.getHijos().add(categoria2_1);
        categoriasExpected.add(categoria2_1);

        Categoria categoria2_2 = new Categoria();
        categoria2_2.setNombre("Lindos");
        categoria2_2.setPadre(categoria2);
        categoria2.getHijos().add(categoria2_2);
        categoriasExpected.add(categoria2_2);

        Categoria categoria2_2_1 = new Categoria();
        categoria2_2_1.setNombre("Caros");
        categoria2_2_1.setPadre(categoria2_2);
        categoria2_2.getHijos().add(categoria2_2_1);
        categoriasExpected.add(categoria2_2_1);

        Categoria categoria2_2_2 = new Categoria();
        categoria2_2_2.setNombre("Baratos");
        categoria2_2_2.setPadre(categoria2_2);
        categoria2_2.getHijos().add(categoria2_2_2);
        categoriasExpected.add(categoria2_2_2);

        for (Categoria categoria : categoriasExpected) {
            categoriaController.nueva(categoria);
        }

        ArrayList<Categoria> categoriasActual = categoriaService.listar();

        assertTrue(categoriasExpected.containsAll(categoriasActual) && categoriasActual.containsAll(categoriasExpected));

        for (Categoria categoria : categoriasActual) {
            assertTrue(categoria.getEstado().equals(EstadoCategoria.visible));
        }

        categoriaController.ocultar(categoria1);

        assertTrue(categoria1.getEstado().equals(EstadoCategoria.oculta));
        assertTrue(categoria1_1.getEstado().equals(EstadoCategoria.oculta));
        assertTrue(categoria1_2.getEstado().equals(EstadoCategoria.oculta));


    }
    @Test
    public void testListarHijos() throws Exception {
        // patch: no va para @BeforeClass para no tocar lo armado
        //Hardcodeo jarco = new Hardcodeo();

        List<Categoria> todas = categoriaController.listar();
        List<Categoria> hijas = null;
        //aproach estadistico :D  "public void nueva(Categoria nuevaCategoria)" deberia retornar ID
        int cant = 0;
        for (Categoria categoria : todas) {
            hijas = categoriaController.listarHijos(categoria);

            for (Categoria categ : hijas ) {
                cant += categoriaController.listarHijos(categ).size();
            }
        }
        //cant = cant / todas.size();
        boolean noFail = true;
        if( cant < 1 ){
            noFail = false;
        }
        assertTrue( noFail);

    }

}