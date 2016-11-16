package uy.edu.cure.servidor.central.lib.controllers;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import uy.edu.cure.servidor.central.dto.Cliente;
import uy.edu.cure.servidor.central.lib.servicios.ClienteService;
import uy.edu.cure.servidor.central.lib.servicios.ServiceFactory;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ClienteControllerTest {

    private static ClienteController clienteController;
    private static ClienteService clienteService;

    @BeforeClass
    public static void beforeAll() {
        clienteController = new ClienteController();
        clienteService = ServiceFactory.getClienteService();
    }

    @Before
    public void beforeEach() throws Exception {
        clienteService.vaciar();
    }

    @Test
    public void testNuevo() throws Exception {
        Cliente cliente = new Cliente();
        clienteController.nuevo(cliente);

        assertEquals(cliente, clienteController.obtener(cliente.getId()));
    }

    @Test
    public void testEliminar() throws Exception {
        Cliente cliente = new Cliente();
        clienteController.nuevo(cliente);

        clienteController.eliminar(cliente.getId());

        assertNull(clienteController.obtener(cliente.getId()));
    }

    @Test
    public void testModificar() throws Exception {
        Cliente clienteOld = new Cliente();
        clienteController.nuevo(clienteOld);

        Cliente clienteNew = new Cliente();
        clienteNew.setId(clienteOld.getId());
        clienteController.modificar(clienteNew);

        assertEquals(clienteNew, clienteController.obtener(clienteOld.getId()));
    }

    @Test
    public void testObtener() throws Exception {
        Cliente cliente = new Cliente();
        clienteController.nuevo(cliente);

        assertEquals(cliente, clienteController.obtener(cliente.getId()));
    }


    @Test
    public void testListar() throws Exception {
        List<Cliente> expected = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            expected.add(new Cliente());
        }

        for (Cliente cliente : expected) {
            clienteController.nuevo(cliente);
        }

        List<Cliente> actual = clienteController.listar();

        assertTrue(expected.containsAll(actual) && actual.containsAll(expected));
    }

    @Test
    public void nicknameExiste() throws Exception {
        Cliente cliente = new Cliente();
        cliente.setNickname("lala");

        clienteController.nuevo(cliente);

        assertTrue(clienteController.nicknameExiste(cliente.getNickname()));
    }

    @Test
    public void emailExiste() throws Exception {
        Cliente cliente = new Cliente();
        cliente.setCorreo("lala@gmail.com");

        clienteController.nuevo(cliente);

        assertTrue(clienteController.emailExiste(cliente.getCorreo()));
    }

    @Test
    public void testObtenerXNombre() {
        String nome = "Ruvio Salvaje";

        Cliente cliente = new Cliente();
        cliente.setNickname(nome);
        clienteController.nuevo(cliente);

        Cliente clienteSalvaje = clienteController.obtenerXNombre(nome);

        assertEquals(cliente, clienteSalvaje);
    }

    @Test
    public void testObtenerXMail() {
        String mail = "la_yiyaURSSDelCAP@latinmail.con";

        Cliente cliente = new Cliente();
        cliente.setCorreo(mail);
        clienteController.nuevo(cliente);

        Cliente clienteSalvaje = clienteController.obtenerXMail(mail);

        assertEquals(cliente, clienteSalvaje);
    }

    @Test
    public void testComprobarLogin() {
        Hardcodeo jarc = new Hardcodeo();

        String nick, pass;
        nick = "franco";
        pass = "1234";
        Boolean fla1, fla2;
        fla1 = this.clienteService.comprobarlogin(nick, pass);
        fla2 = this.clienteService.comprobarlogin("fruta", "ensalada");
        assertTrue(fla1);
        assertTrue(!fla2);
    }

    @Test
    public void testComprobarloginMail() {
        Hardcodeo jarc = new Hardcodeo();

        String mail, pass;
        mail = "franco@franco.com";
        pass = "1234";

        boolean ok = this.clienteService.comprobarloginMail(mail, pass);

        assertTrue(ok);
    }

}