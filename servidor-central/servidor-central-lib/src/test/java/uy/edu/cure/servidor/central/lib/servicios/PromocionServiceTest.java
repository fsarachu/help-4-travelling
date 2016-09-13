package uy.edu.cure.servidor.central.lib.servicios;

import junit.framework.TestCase;
import org.junit.BeforeClass;
import org.junit.Test;
import uy.edu.cure.servidor.central.dto.Promocion;
import uy.edu.cure.servidor.central.lib.servicios.memoria.PromocionServiceImpl;

import java.util.ArrayList;

/**
 * Created by victor on 13/09/16.
 */
public class PromocionServiceTest extends TestCase {

    private PromocionService promocionService;

    @BeforeClass
    public void setUp() {
        
        this.promocionService = PromocionServiceImpl.getInstance();
    }

    @Test
    public void testAgregar() throws Exception {
        Promocion promocion = new Promocion();
        promocion.setId(1);
        promocion.setNombre("2 x 1");

        this.promocionService.agregar(promocion.getId(),promocion);

        assertEquals(promocion, this.promocionService.obtener(1));

    }


    public void testEliminar() throws Exception {
        Promocion promocion = new Promocion();
        promocion.setId(101);
        promocion.setNombre("Lleve 4 y page 3");

        this.promocionService.eliminar(101);

        assertNull(this.promocionService.obtener(101));
    }

    public void testModificar() throws Exception {
        Promocion promocion = new Promocion();
        promocion.setId(101);
        promocion.setNombre("Lleve 4 y page 3");
        Promocion promocion1 = new Promocion();
        promocion1.setId(101);
        promocion1.setNombre("Lleve 1 y page 1");

        this.promocionService.agregar(promocion.getId(),promocion);
        this.promocionService.modificar(promocion1.getId(),promocion1);

        assertEquals(promocion1, promocionService.obtener(101));
    }

    public void testObtener() throws Exception {
        Promocion promocion = new Promocion();
        promocion.setId(101);
        promocion.setNombre("2 x 1");

        this.promocionService.agregar(101,promocion);

        assertEquals(promocion, promocionService.obtener(101));

    }

    public void testListar() throws Exception {
        ArrayList<Promocion> expected = new ArrayList<>();
        Promocion promocion1 = new Promocion();
        promocion1.setId(1);
        promocion1.setNombre("Uruguay");
        Promocion promocion2 = new Promocion();
        promocion2.setId(2);
        promocion2.setNombre("Argentina");
        expected.add(promocion1);
        expected.add(promocion2);
        for (Promocion promocion : expected){
            this.promocionService.agregar(promocion.getId(),promocion);
        }
        ArrayList<Promocion> actual = promocionService.listar();
        for (int n=0 ; n<2 ; n++) {
            assertEquals(expected.get(n), actual.get(n));
        }

    }


}