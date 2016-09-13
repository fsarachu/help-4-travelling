package uy.edu.cure.servidor.central.lib.servicios;

import junit.framework.TestCase;
import org.junit.BeforeClass;
import org.junit.Test;
import uy.edu.cure.servidor.central.dto.Reserva;
import uy.edu.cure.servidor.central.lib.servicios.memoria.ReservaServiceImpl;

import java.util.ArrayList;

public class ReservaServiceTest extends TestCase {

    private ReservaService reservaService;

    @BeforeClass
    public void setUp() {
        this.reservaService = ReservaServiceImpl.getInstance();
    }

    @Test
    public void testAgregar() throws Exception {
        Reserva reserva = new Reserva();
        reserva.setId(1);
        reserva.setCantidad(2);

        this.reservaService.agregar(reserva.getId(),reserva);

        assertEquals(reserva, this.reservaService.obtener(1));

    }


    public void testEliminar() throws Exception {
        Reserva reserva = new Reserva();
        reserva.setId(101);
        reserva.setCantidad(2);

        this.reservaService.eliminar(101);

        assertNull(this.reservaService.obtener(101));
    }

    public void testModificar() throws Exception {
        Reserva reserva = new Reserva();
        reserva.setId(101);
        reserva.setCantidad(2);
        Reserva reserva1 = new Reserva();
        reserva1.setId(101);
        reserva1.setCantidad(4);

        this.reservaService.agregar(reserva.getId(),reserva);
        this.reservaService.modificar(reserva1.getId(),reserva1);

        assertEquals(reserva1, reservaService.obtener(101));
    }

    public void testObtener() throws Exception {
        Reserva reserva = new Reserva();
        reserva.setId(101);
        reserva.setCantidad(2);

        this.reservaService.agregar(101,reserva);

        assertEquals(reserva, reservaService.obtener(101));

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
        for (Reserva reserva : expected){
            this.reservaService.agregar(reserva.getId(),reserva);
        }
        ArrayList<Reserva> actual = reservaService.listar();
        for (int n=0 ; n<2 ; n++) {
            assertEquals(expected.get(n), actual.get(n));
        }

    }


}