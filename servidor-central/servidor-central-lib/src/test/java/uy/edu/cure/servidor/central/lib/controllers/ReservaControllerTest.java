package uy.edu.cure.servidor.central.lib.controllers;

import junit.framework.TestCase;
import org.junit.BeforeClass;
import org.junit.Test;
import uy.edu.cure.servidor.central.dto.Reserva;

import java.util.ArrayList;

public class ReservaControllerTest extends TestCase {

    private ReservaController reservaController;

    @BeforeClass
    public void setUp() {
        this.reservaController = new ReservaController();
    }


    @Test
    public void testNuevo() throws Exception {
        Reserva reserva = new Reserva();
        reserva.setId(1);
        reserva.setCantidad(1);

        this.reservaController.nueva(reserva);

        assertEquals(reserva, this.reservaController.obtener(1));
    }

    public void testEliminar() throws Exception {
        Reserva reserva = new Reserva();
        reserva.setId(101);
        reserva.setCantidad(2);

        this.reservaController.eliminar(101);

        assertNull(this.reservaController.obtener(101));
    }

    public void testModificar() throws Exception {
        Reserva reserva = new Reserva();
        reserva.setId(101);
        reserva.setCantidad(2);
        Reserva reserva1 = new Reserva();
        reserva1.setId(101);
        reserva1.setCantidad(4);

        this.reservaController.nueva(reserva);
        this.reservaController.modificar(reserva1.getId(), reserva1);

        assertEquals(reserva1, reservaController.obtener(101));
    }

    public void testObtener() throws Exception {
        Reserva reserva = new Reserva();
        reserva.setId(101);
        reserva.setCantidad(2);

        this.reservaController.nueva(reserva);

        assertEquals(reserva, reservaController.obtener(101));

    }


    public void testListar() throws Exception {
        ArrayList<Reserva> expected = new ArrayList<>();
        Reserva reserva1 = new Reserva();
        reserva1.setId(1);
        reserva1.setCantidad(2);
        Reserva reserva2 = new Reserva();
        reserva2.setId(2);
        reserva2.setCantidad(4);
        expected.add(reserva1);
        expected.add(reserva2);
        for (Reserva reserva : expected) {
            this.reservaController.nueva(reserva);
        }
        ArrayList<Reserva> actual = reservaController.listar();
        for (int n = 0; n < 2; n++) {
            assertEquals(expected.get(n), actual.get(n));
        }

    }

}