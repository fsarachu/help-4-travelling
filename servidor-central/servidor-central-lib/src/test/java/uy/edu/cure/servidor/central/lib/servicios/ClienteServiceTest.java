package uy.edu.cure.servidor.central.lib.servicios;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import uy.edu.cure.servidor.central.dto.Cliente;
import uy.edu.cure.servidor.central.lib.servicios.memoria.ClienteServiceImpl;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ClienteServiceTest {

    private static ClienteService clienteService;

    @BeforeClass
    public static void beforeAll() {
        clienteService = ClienteServiceImpl.getInstance();
    }

    @Before
    public void beforeEach() {
        clienteService.vaciar();
    }

    @Test
    public void testAgregar() throws Exception {
        Cliente cliente = new Cliente();
        cliente.setId(1);
        cliente.setNombre("pepe");

        clienteService.agregar(cliente.getId(), cliente);

        assertEquals(cliente, clienteService.obtener(1));

    }

    @Test
    public void testEliminar() throws Exception {
        Cliente cliente = new Cliente();
        cliente.setId(101);
        cliente.setNombre("pepe");

        clienteService.eliminar(101);

        assertNull(clienteService.obtener(101));
    }

    @Test
    public void testModificar() throws Exception {
        Cliente cliente = new Cliente();
        cliente.setId(101);
        cliente.setNombre("pepe");
        Cliente cliente1 = new Cliente();
        cliente1.setId(101);
        cliente1.setNombre("pepito");

        clienteService.agregar(cliente.getId(), cliente);
        clienteService.modificar(cliente1.getId(), cliente1);

        assertEquals(cliente1, clienteService.obtener(101));
    }

    @Test
    public void testObtener() throws Exception {
        Cliente cliente = new Cliente();
        cliente.setId(101);
        cliente.setNombre("pepe");

        clienteService.agregar(101, cliente);

        assertEquals(cliente, clienteService.obtener(101));

    }

    @Test
    public void testListar() throws Exception {
        ArrayList<Cliente> expected = new ArrayList<>();
        Cliente cliente1 = new Cliente();
        cliente1.setId(1);
        cliente1.setNombre("pepe");
        Cliente cliente2 = new Cliente();
        cliente2.setId(2);
        cliente2.setNombre("pepito");
        expected.add(cliente1);
        expected.add(cliente2);
        for (Cliente cliente : expected) {
            clienteService.agregar(cliente.getId(), cliente);
        }
        ArrayList<Cliente> actual = clienteService.listar();
        for (int n = 0; n < 2; n++) {
            assertEquals(expected.get(n), actual.get(n));
        }

    }

    @Test
    public void testNicknameExiste() throws Exception {
        Cliente cliente = new Cliente();
        cliente.setId(clienteService.nextId());
        cliente.setNickname("lala");

        clienteService.agregar(cliente.getId(), cliente);

        assertTrue(clienteService.nicknameExiste(cliente.getNickname()));
    }

    @Test
    public void testEmailExiste() throws Exception {
        Cliente cliente = new Cliente();
        cliente.setId(clienteService.nextId());
        cliente.setCorreo("lala@gmail.com");

        clienteService.agregar(cliente.getId(), cliente);

        assertTrue(clienteService.emailExiste(cliente.getCorreo()));

    }

    @Test
    public void testNextId() throws Exception {
        Cliente cliente = new Cliente();
        cliente.setId(clienteService.nextId());
        cliente.setNombre("prueba");

        clienteService.agregar(cliente.getId(), cliente);

        assertEquals(cliente, clienteService.obtener(cliente.getId()));

    }
}