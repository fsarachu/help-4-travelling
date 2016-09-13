package uy.edu.cure.servidor.central.lib.controllers;

import junit.framework.TestCase;
import org.junit.BeforeClass;
import org.junit.Test;
import uy.edu.cure.servidor.central.dto.Cliente;

import java.util.ArrayList;

public class ClienteControllerTest extends TestCase {

    private ClienteController clienteController;

    @BeforeClass
    public void setUp() {
        this.clienteController = new ClienteController();
    }


    @Test
    public void testNuevo() throws Exception {
        Cliente cliente = new Cliente();
        cliente.setId(1);
        cliente.setNombre("Conaprole");

        this.clienteController.nuevo(cliente);

        assertEquals(cliente, this.clienteController.obtener(1));
    }

    public void testEliminar() throws Exception {
        Cliente cliente = new Cliente();
        cliente.setId(101);
        cliente.setNombre("Parmalat");

        this.clienteController.eliminar(101);

        assertNull(this.clienteController.obtener(101));
    }

    public void testModificar() throws Exception {
        Cliente cliente = new Cliente();
        cliente.setId(101);
        cliente.setNombre("Conaprole");
        Cliente cliente1 = new Cliente();
        cliente1.setId(101);
        cliente1.setNombre("Parmalat");

        this.clienteController.nuevo(cliente);
        this.clienteController.modificar(cliente1.getId(), cliente1);

        assertEquals(cliente1, clienteController.obtener(101));
    }

    public void testObtener() throws Exception {
        Cliente cliente = new Cliente();
        cliente.setId(101);
        cliente.setNombre("Conaprole");

        this.clienteController.nuevo(cliente);

        assertEquals(cliente, clienteController.obtener(101));

    }


    public void testListar() throws Exception {
        ArrayList<Cliente> expected = new ArrayList<>();
        Cliente cliente1 = new Cliente();
        cliente1.setId(1);
        cliente1.setNombre("Conaprole");
        Cliente cliente2 = new Cliente();
        cliente2.setId(2);
        cliente2.setNombre("Parmalat");
        expected.add(cliente1);
        expected.add(cliente2);
        for (Cliente cliente : expected){
            this.clienteController.nuevo(cliente);
        }
        ArrayList<Cliente> actual = clienteController.listar();
        for (int n=0 ; n<2 ; n++) {
            assertEquals(expected.get(n), actual.get(n));
        }

    }

}