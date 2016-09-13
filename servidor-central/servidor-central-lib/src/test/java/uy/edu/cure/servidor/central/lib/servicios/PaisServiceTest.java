package uy.edu.cure.servidor.central.lib.servicios;

import junit.framework.TestCase;
import org.junit.BeforeClass;
import org.junit.Test;
import uy.edu.cure.servidor.central.dto.Pais;
import uy.edu.cure.servidor.central.lib.servicios.memoria.PaisServiceImpl;

import java.util.ArrayList;

/**
 * Created by victor on 13/09/16.
 */
public class PaisServiceTest extends TestCase {

    private PaisService paisService;

    @BeforeClass
    public void setUp() {
        this.paisService = PaisServiceImpl.getInstance();
    }

    @Test
    public void testAgregar() throws Exception {
        Pais pais = new Pais();
        pais.setId(1);
        pais.setNombre("Uruguay");

        this.paisService.agregar(pais.getId(), pais);

        assertEquals(pais, this.paisService.obtener(1));

    }


    public void testEliminar() throws Exception {
        Pais pais = new Pais();
        pais.setId(101);
        pais.setNombre("Argentina");

        this.paisService.eliminar(101);

        assertNull(this.paisService.obtener(101));
    }

    public void testModificar() throws Exception {
        Pais pais = new Pais();
        pais.setId(101);
        pais.setNombre("Argentina");
        Pais pais1 = new Pais();
        pais1.setId(101);
        pais1.setNombre("Mexico");

        this.paisService.agregar(pais.getId(), pais);
        this.paisService.modificar(pais1.getId(), pais1);

        assertEquals(pais1, paisService.obtener(101));
    }

    public void testObtener() throws Exception {
        Pais pais = new Pais();
        pais.setId(101);
        pais.setNombre("Uruguay");

        this.paisService.agregar(101, pais);

        assertEquals(pais, paisService.obtener(101));

    }

    public void testListar() throws Exception {
        ArrayList<Pais> expected = new ArrayList<>();
        Pais pais1 = new Pais();
        pais1.setId(1);
        pais1.setNombre("Uruguay");
        Pais pais2 = new Pais();
        pais2.setId(2);
        pais2.setNombre("Argentina");
        expected.add(pais1);
        expected.add(pais2);
        for (Pais pais : expected) {
            this.paisService.agregar(pais.getId(), pais);
        }
        ArrayList<Pais> actual = paisService.listar();
        for (int n = 0; n < 2; n++) {
            assertEquals(expected.get(n), actual.get(n));
        }

    }


}