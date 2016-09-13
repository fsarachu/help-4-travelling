package uy.edu.cure.servidor.central.lib.servicios;

import junit.framework.TestCase;
import org.junit.BeforeClass;
import org.junit.Test;
import uy.edu.cure.servidor.central.dto.Cliente;
import uy.edu.cure.servidor.central.lib.servicios.memoria.ClienteServiceImpl;

import java.util.ArrayList;

public class ClienteServiceTest extends TestCase {


    private ClienteService clienteService;

    @BeforeClass
    public void setUp() {

        this.clienteService = ClienteServiceImpl.getInstance();

    }

    @Test
    public void testAgregar() throws Exception {
        Cliente cliente = new Cliente();
        cliente.setId(1);
        cliente.setNombre("pepe");

        this.clienteService.agregar(cliente.getId(),cliente);

        assertEquals(cliente, this.clienteService.obtener(1));

    }

    public void testEliminar() throws Exception {
        Cliente cliente = new Cliente();
        cliente.setId(101);
        cliente.setNombre("pepe");

        this.clienteService.eliminar(101);

        assertNull(this.clienteService.obtener(101));
    }

    public void testModificar() throws Exception {
        Cliente cliente = new Cliente();
        cliente.setId(101);
        cliente.setNombre("pepe");
        Cliente cliente1 = new Cliente();
        cliente1.setId(101);
        cliente1.setNombre("pepito");

        this.clienteService.agregar(cliente.getId(),cliente);
        this.clienteService.modificar(cliente1.getId(),cliente1);

        assertEquals(cliente1, clienteService.obtener(101));
    }

    public void testObtener() throws Exception {
        Cliente cliente = new Cliente();
        cliente.setId(101);
        cliente.setNombre("pepe");

        this.clienteService.agregar(101,cliente);

        assertEquals(cliente, clienteService.obtener(101));

    }

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
        for (Cliente cliente : expected){
            this.clienteService.agregar(cliente.getId(),cliente);
        }
        ArrayList<Cliente> actual = clienteService.listar();
        for (int n=0 ; n<2 ; n++) {
            assertEquals(expected.get(n), actual.get(n));
        }

    }
}