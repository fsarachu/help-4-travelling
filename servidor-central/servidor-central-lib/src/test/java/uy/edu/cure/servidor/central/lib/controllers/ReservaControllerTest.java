package uy.edu.cure.servidor.central.lib.controllers;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import uy.edu.cure.servidor.central.dto.Cliente;
import uy.edu.cure.servidor.central.dto.Reserva;
import uy.edu.cure.servidor.central.lib.servicios.ReservaService;
import uy.edu.cure.servidor.central.lib.servicios.ServiceFactory;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class ReservaControllerTest {

    private static ReservaController reservaController;
    private static ReservaService reservaService;
    private static ClienteController clienteController;


    @BeforeClass
    public static void beforeAll() {
        reservaController = new ReservaController();
        reservaService = ServiceFactory.getReservaService();
        clienteController = new ClienteController();
    }

    @Before
    public void beforeEach() {
        reservaService.vaciar();
    }

    @Test
    public void nueva() throws Exception {
        Cliente cliente = new Cliente();
        clienteController.nuevo(cliente);

        List<Reserva> reservas = reservaService.listarReservasCliente(cliente);

        assertTrue(reservas.size() == 0);

        reservaController.nueva(cliente);

        reservas = reservaService.listarReservasCliente(cliente);

        assertTrue(reservas.size() == 1);
    }

    @Test
    public void obtener() throws Exception {
        Cliente cliente = new Cliente();
        clienteController.nuevo(cliente);

        reservaController.nueva(cliente);

        Reserva reserva = reservaService.listarReservasCliente(cliente).get(0);

        assertEquals(reserva, reservaController.obtener(reserva.getId()));
    }

    @Test
    public void modificar() throws Exception {
        Cliente cliente = new Cliente();
        clienteController.nuevo(cliente);

        reservaController.nueva(cliente);

        Reserva reservaOld = reservaService.listarReservasCliente(cliente).get(0);

        assertEquals(reservaOld, reservaController.obtener(reservaOld.getId()));

        Reserva reservaNew = new Reserva();
        reservaNew.setId(reservaOld.getId());
        reservaNew.setCliente(reservaOld.getCliente());

        reservaController.modificar(reservaNew);

        assertEquals(reservaNew, reservaController.obtener(reservaOld.getId()));
    }

    @Test
    public void eliminar() throws Exception {

    }

    @Test
    public void listar() throws Exception {

    }

    @Test
    public void actualizarEstado() throws Exception {

    }

}