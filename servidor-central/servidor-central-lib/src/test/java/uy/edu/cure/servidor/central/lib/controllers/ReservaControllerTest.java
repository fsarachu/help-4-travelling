package uy.edu.cure.servidor.central.lib.controllers;

import org.junit.BeforeClass;
import org.junit.Test;
import uy.edu.cure.servidor.central.lib.servicios.ReservaService;
import uy.edu.cure.servidor.central.lib.servicios.ServiceFactory;

public class ReservaControllerTest {

    private static ReservaController reservaController;
    private static ReservaService reservaService;


    @BeforeClass
    public static void beforeAll() {
        reservaController = new ReservaController();
        reservaService = ServiceFactory.getReservaService();
    }

    @Test
    public void eliminar() throws Exception {

    }

    @Test
    public void obtener() throws Exception {

    }

    @Test
    public void modificar() throws Exception {

    }

    @Test
    public void listar() throws Exception {

    }

    @Test
    public void nueva() throws Exception {

    }

    @Test
    public void actualizarEstado() throws Exception {

    }

}