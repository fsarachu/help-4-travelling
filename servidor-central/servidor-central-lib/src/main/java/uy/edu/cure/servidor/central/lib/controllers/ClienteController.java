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

    public ArrayList<Cliente> listar() {
        ClienteService clienteService = ServiceFactory.getClienteService();

        return clienteService.listar();
    }
}
