package uy.edu.cure.servidor.central.lib.servicios;

import junit.framework.TestCase;
import org.junit.BeforeClass;
import org.junit.Test;
import uy.edu.cure.servidor.central.dto.Servicio;
import uy.edu.cure.servidor.central.lib.servicios.memoria.ServicioServiceImpl;

import java.util.ArrayList;

public class ServicioServiceTest extends TestCase {

    private ServicioService servicioService;

    @BeforeClass
    public void setUp() {
        this.servicioService = ServicioServiceImpl.getInstance();
    }

    @Test
    public void testAgregar() throws Exception {
        Servicio servicio = new Servicio();
        servicio.setId(1);
        servicio.setNombre("Viaje");

        this.servicioService.agregar(servicio.getId(), servicio);

        assertEquals(servicio, this.servicioService.obtener(1));

    }


    public void testEliminar() throws Exception {
        Servicio servicio = new Servicio();
        servicio.setId(101);
        servicio.setNombre("Auto");

        this.servicioService.eliminar(101);

        assertNull(this.servicioService.obtener(101));
    }

    public void testModificar() throws Exception {
        Servicio servicio = new Servicio();
        servicio.setId(101);
        servicio.setNombre("Auto");
        Servicio servicio1 = new Servicio();
        servicio1.setId(101);
        servicio1.setNombre("Moto");

        this.servicioService.agregar(servicio.getId(), servicio);
        this.servicioService.modificar(servicio1.getId(), servicio1);

        assertEquals(servicio1, servicioService.obtener(101));
    }

    public void testObtener() throws Exception {
        Servicio servicio = new Servicio();
        servicio.setId(101);
        servicio.setNombre("Viaje");

        this.servicioService.agregar(101, servicio);

        assertEquals(servicio, servicioService.obtener(101));

    }

    public void testListar() throws Exception {
        ArrayList<Servicio> expected = new ArrayList<>();
        Servicio servicio1 = new Servicio();
        servicio1.setId(1);
        servicio1.setNombre("Viaje");
        Servicio servicio2 = new Servicio();
        servicio2.setId(2);
        servicio2.setNombre("Moto");
        expected.add(servicio1);
        expected.add(servicio2);
        for (Servicio servicio : expected) {
            this.servicioService.agregar(servicio.getId(), servicio);
        }
        ArrayList<Servicio> actual = servicioService.listar();
        for (int n = 0; n < 2; n++) {
            assertEquals(expected.get(n), actual.get(n));
        }

    }
    
}