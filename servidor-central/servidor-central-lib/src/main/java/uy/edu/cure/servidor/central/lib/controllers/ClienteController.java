package uy.edu.cure.servidor.central.lib.controllers;

import uy.edu.cure.servidor.central.dto.Cliente;
import uy.edu.cure.servidor.central.lib.servicios.ClienteService;
import uy.edu.cure.servidor.central.lib.servicios.ServiceFactory;

public class ClienteController {
    public void alta(Cliente cliente) {
        ClienteService clienteService = ServiceFactory.getClienteService();

        clienteService.agregar(cliente);
    }
}
