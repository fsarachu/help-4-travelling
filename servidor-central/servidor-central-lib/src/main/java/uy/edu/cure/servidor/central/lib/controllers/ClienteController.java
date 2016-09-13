package uy.edu.cure.servidor.central.lib.controllers;

import uy.edu.cure.servidor.central.dto.Cliente;
import uy.edu.cure.servidor.central.lib.servicios.ClienteService;
import uy.edu.cure.servidor.central.lib.servicios.ServiceFactory;

import java.util.ArrayList;

public class ClienteController {

    public void nuevo(Cliente cliente) {
        ClienteService clienteService = ServiceFactory.getClienteService();
        //cliente.setId( clienteService.getKey() );
        clienteService.agregar( cliente.getId(), cliente);
    }

    public void eliminar(int id) {
        ClienteService ciudadService = ServiceFactory.getClienteService();

        ciudadService.eliminar(id);
    }

    Cliente obtener(Integer id) {
        ClienteService ciudadService = ServiceFactory.getClienteService();

        return ciudadService.obtener(id);
    }

    public void modificar(Integer id, Cliente ciudad1) {
        ClienteService ciudadService = ServiceFactory.getClienteService();

        ciudadService.modificar(id, ciudad1);
    }


    public ArrayList<Cliente> listar() {
        ClienteService clienteService = ServiceFactory.getClienteService();

        return clienteService.listar();
    }
}
