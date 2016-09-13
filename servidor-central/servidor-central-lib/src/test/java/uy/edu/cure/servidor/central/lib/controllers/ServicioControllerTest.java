package uy.edu.cure.servidor.central.lib.controllers;

import junit.framework.TestCase;
import org.junit.BeforeClass;
import org.junit.Test;
import uy.edu.cure.servidor.central.dto.Servicio;

import java.util.ArrayList;

public class ServicioControllerTest extends TestCase {

    private ServicioController servicioController;

    @BeforeClass
    public void setUp() {
        this.servicioController = new ServicioController();
    }


    @Test
    public void testNuevo() throws Exception {
        Servicio servicio = new Servicio();
        servicio.setId(1);
        servicio.setNombre("Maldonado");

        this.servicioController.nuevo(servicio);

        assertEquals(servicio, this.servicioController.obtener(1));
    }

    public void testEliminar() throws Exception {
        Servicio servicio = new Servicio();
        servicio.setId(101);
        servicio.setNombre("Maldonado");

        this.servicioController.eliminar(101);

        assertNull(this.servicioController.obtener(101));
    }

    public void testModificar() throws Exception {
        Servicio servicio = new Servicio();
        servicio.setId(101);
        servicio.setNombre("Maldonado");
        Servicio servicio1 = new Servicio();
        servicio1.setId(101);
        servicio1.setNombre("Punta del Este");

        this.servicioController.nuevo(servicio);
        this.servicioController.modificar(servicio1.getId(), servicio1);

        assertEquals(servicio1, servicioController.obtener(101));
    }

    public void testObtener() throws Exception {
        Servicio servicio = new Servicio();
        servicio.setId(101);
        servicio.setNombre("Maldonado");

        this.servicioController.nuevo(servicio);

        assertEquals(servicio, servicioController.obtener(101));

    }


    public void testListar() throws Exception {
        ArrayList<Servicio> expected = new ArrayList<>();
        Servicio servicio1 = new Servicio();
        servicio1.setId(1);
        servicio1.setNombre("Uruguay");
        Servicio servicio2 = new Servicio();
        servicio2.setId(2);
        servicio2.setNombre("Argentina");
        expected.add(servicio1);
        expected.add(servicio2);
        for (Servicio servicio : expected) {
            this.servicioController.nuevo(servicio);
        }
        ArrayList<Servicio> actual = servicioController.listar();
        for (int n = 0; n < 2; n++) {
            assertEquals(expected.get(n), actual.get(n));
        }

    }


}