package uy.edu.cure.servidor.central.lib.servicios;

import junit.framework.TestCase;
import org.junit.BeforeClass;
import org.junit.Test;
import uy.edu.cure.servidor.central.dto.Categoria;
import uy.edu.cure.servidor.central.lib.servicios.memoria.CategoriaServiceImpl;

import java.util.ArrayList;

public class CategoriaServiceTest extends TestCase {

    private CategoriaService categoriaService;

    @BeforeClass
    public void setUp() {
        this.categoriaService = CategoriaServiceImpl.getInstance();
        //categoriaService = new CategoriaServiceImpl(); Esto se podria hacer si no fuera singleton
    }

    @Test
    public void testAgregar() throws Exception {
        Categoria categoria = new Categoria();
        categoria.setId(1);
        categoria.setNombre("yo");
        categoria.setPadre(null);

        this.categoriaService.agregar(categoria.getId(),categoria);

        assertEquals(categoria, this.categoriaService.obtener(1));

    }

    public void testEliminar() throws Exception {
        Categoria categoria = new Categoria();
        categoria.setId(101);
        categoria.setNombre("pepe");
        categoria.setPadre(null);

        this.categoriaService.eliminar(101);

        assertNull(this.categoriaService.obtener(101));
    }

    public void testModificar() throws Exception {
        Categoria categoria = new Categoria();
        categoria.setId(101);
        categoria.setNombre("pepe");
        categoria.setPadre(null);
        Categoria categoria1 = new Categoria();
        categoria1.setId(101);
        categoria1.setNombre("auto");

        this.categoriaService.agregar(categoria.getId(),categoria);
        this.categoriaService.modificar(categoria1.getId(),categoria1);

        assertEquals(categoria1, categoriaService.obtener(101));
    }

    public void testObtener() throws Exception {
        Categoria categoria = new Categoria();
        categoria.setId(101);
        categoria.setNombre("pepe");
        categoria.setPadre(null);

        this.categoriaService.agregar(101,categoria);

        assertEquals(categoria, categoriaService.obtener(101));

    }

    public void testListar() throws Exception {
        ArrayList<Categoria> expected = new ArrayList<>();
        expected.add(new Categoria(1,"uno",1));
        expected.add(new Categoria(2,"dos",1));
        expected.add(new Categoria(3,"tre",1));
        for (Categoria categoria : expected){
            this.categoriaService.agregar(categoria.getId(),categoria);
        }
        ArrayList<Categoria> actual = categoriaService.listar();
        for (int n=0 ; n<3 ; n++) {
            assertEquals(expected.get(n), actual.get(n));
        }

    }

}