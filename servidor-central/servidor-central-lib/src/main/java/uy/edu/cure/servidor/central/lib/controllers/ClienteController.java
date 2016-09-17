package uy.edu.cure.servidor.central.lib.controllers;

import uy.edu.cure.servidor.central.dto.Cliente;
import uy.edu.cure.servidor.central.lib.servicios.ClienteService;
import uy.edu.cure.servidor.central.lib.servicios.ServiceFactory;

import java.util.ArrayList;

public class ClienteController {
    private ClienteService clienteService;

    public ClienteController() {
        this.clienteService = ServiceFactory.getClienteService();
    }

    public void nuevo(Cliente cliente) {
        cliente.setId(this.clienteService.nextId());
        this.clienteService.agregar(cliente.getId(), cliente);
    }

    public void eliminar(Integer idCliente) {
        this.clienteService.eliminar(idCliente);
    }

    Cliente obtener(Integer idCliente) {
        return this.clienteService.obtener(idCliente);
    }

    public void modificar(Cliente cliente) {
        this.clienteService.modificar(cliente.getId(), cliente);
    }

    public ArrayList<Cliente> listar() {
        return this.clienteService.listar();
    }
}
