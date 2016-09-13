package uy.edu.cure.servidor.central.lib.servicios;

import junit.framework.TestCase;
import org.junit.BeforeClass;
import org.junit.Test;
import uy.edu.cure.servidor.central.dto.Ciudad;
import uy.edu.cure.servidor.central.lib.servicios.memoria.CiudadServiceImpl;

import java.util.ArrayList;

public class CiudadServiceTest extends TestCase {

    private CiudadService ciudadService;

    @BeforeClass
    public void setUp() {
        this.ciudadService = CiudadServiceImpl.getInstance();
    }

    @Test
    public void testAgregar() throws Exception {
        Ciudad ciudad = new Ciudad();
        ciudad.setId(1);
        ciudad.setNombre("Maldonado");

        this.ciudadService.agregar(ciudad.getId(),ciudad);

        assertEquals(ciudad, this.ciudadService.obtener(1));

    }


    public void testEliminar() throws Exception {
        Ciudad ciudad = new Ciudad();
        ciudad.setId(101);
        ciudad.setNombre("Punta del Este");

        this.ciudadService.eliminar(101);

        assertNull(this.ciudadService.obtener(101));
    }

    public void testModificar() throws Exception {
        Ciudad ciudad = new Ciudad();
        ciudad.setId(101);
        ciudad.setNombre("Punta del Este");
        Ciudad ciudad1 = new Ciudad();
        ciudad1.setId(101);
        ciudad1.setNombre("Maldonado");

        this.ciudadService.agregar(ciudad.getId(),ciudad);
        this.ciudadService.modificar(ciudad1.getId(),ciudad1);

        assertEquals(ciudad1, ciudadService.obtener(101));
    }

    public void testObtener() throws Exception {
        Ciudad ciudad = new Ciudad();
        ciudad.setId(101);
        ciudad.setNombre("Punta del Este");

        this.ciudadService.agregar(101,ciudad);

        assertEquals(ciudad, ciudadService.obtener(101));

    }

    public void testListar() throws Exception {
        ArrayList<Ciudad> expected = new ArrayList<>();
        expected.add(new Ciudad(1,"Maldonado",null));
        expected.add(new Ciudad(2,"Punta del Este",null));
        expected.add(new Ciudad(3,"San Carlos",null));
        for (Ciudad ciudad : expected){
            this.ciudadService.agregar(ciudad.getId(),ciudad);
        }
        ArrayList<Ciudad> actual = ciudadService.listar();
        for (int n=0 ; n<3 ; n++) {
            assertEquals(expected.get(n), actual.get(n));
        }

    }

}