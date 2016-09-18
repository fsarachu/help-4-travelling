package uy.edu.cure.servidor.central.lib.controllers;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import uy.edu.cure.servidor.central.dto.Ciudad;
import uy.edu.cure.servidor.central.dto.Cliente;
import uy.edu.cure.servidor.central.dto.Reserva;
import uy.edu.cure.servidor.central.lib.servicios.CarritoService;
import uy.edu.cure.servidor.central.lib.servicios.CiudadService;
import uy.edu.cure.servidor.central.lib.servicios.ReservaService;
import uy.edu.cure.servidor.central.lib.servicios.ServiceFactory;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ReservaControllerTest{

    private static ReservaController reservaController;
    private static ReservaService reservaService;
    private static CarritoService carritoService;

@BeforeClass
public static void beforeAll() {
    reservaController = new ReservaController();
    reservaService = ServiceFactory.getReservaService();
    carritoService = ServiceFactory.getCarritoService();
}

@Before
public void beforeEach() throws Exception {
    reservaService.vaciar();
}

@Test
public void testNueva() throws Exception {
    Reserva reserva = new Reserva();
    reserva.setId(1);

    Cliente cliente = new Cliente();
    reservaController.nueva(cliente);

    Reserva reserva2;
    reserva2 = reservaController.obtener( reserva.getId() );
    assertNotNull( reserva2 );
    if( reserva2 != null){
        assertEquals(reserva, reserva2 );
    }
}

@Test
public void testEliminar() throws Exception {
    Reserva reserva = new Reserva();
    reserva.setId(1);
    Cliente cliente = new Cliente();
    reservaController.nueva(cliente);
    reservaController.eliminar(reserva.getId());
    assertNull(reservaController.obtener(reserva.getId()));
}

@Test
public void testModificar() throws Exception {
    Reserva reservaOld = new Reserva();
    reservaOld.setId(1);
    Cliente cliente1 = new Cliente();
    cliente1.setId(1);
    reservaOld.setCliente(cliente1);
    reservaController.nueva(cliente1);

    Cliente cliente2 = new Cliente();
    cliente2.setId(cliente1.getId());
    reservaOld.setCliente(cliente2);

    reservaController.modificar(reservaOld);
    Reserva reservaNew = reservaController.obtener(1);
    assertEquals(reservaNew, reservaController.obtener(reservaOld.getId()));
}

@Test
public void testObtener() throws Exception {
    Reserva reserva = new Reserva();
    reserva.setId(1);

    Cliente cliente = new Cliente();
    reservaController.nueva(cliente);

    //assertEquals(reserva, reservaController.obtener(reserva.getId()));
    assertNotNull( reservaController.obtener(reserva.getId() ) );
}


@Test
public void testListar() throws Exception {
    List<Reserva> expected = new ArrayList<>();

    for (int i = 0; i < 2; i++) {
        expected.add(new Reserva());
    }

    for (Reserva reserva : expected) {
        Cliente cliente = new Cliente();
        reservaController.nueva(cliente);
    }

    List<Reserva> actual = reservaController.listar();

    assertTrue(expected.containsAll(actual) && actual.containsAll(expected));
}


}