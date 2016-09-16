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

    public void eliminar(int id) {
        this.clienteService.eliminar(id);
    }

    Cliente obtener(Integer id) {
        return this.clienteService.obtener(id);
    }

    public void modificar(Integer id, Cliente ciudad1) {
        this.clienteService.modificar(id, ciudad1);
    }


    public ArrayList<Cliente> listar() {
        return this.clienteService.listar();
    }
}
