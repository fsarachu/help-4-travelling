package uy.edu.cure.servidor.central.lib.controllers;

import uy.edu.cure.servidor.central.dto.Cliente;
import uy.edu.cure.servidor.central.dto.Servicio;
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

    public Cliente obtener(Integer idCliente) {
        return this.clienteService.obtener(idCliente);
    }

    public Cliente obtenerXNombre(String nombre) {
        return this.clienteService.obtenerXNombre(nombre);
    }

    public void modificar(Cliente cliente) {
        this.clienteService.modificar(cliente.getId(), cliente);
    }

    public ArrayList<Cliente> listar() {
        return this.clienteService.listar();
    }

    public boolean nicknameExiste(String nickname) {
        return this.clienteService.nicknameExiste(nickname);
    }

    public boolean emailExiste(String email) {
        return this.clienteService.emailExiste(email);
    }

    public boolean comprobarlogin(String nickname, String contrasena) {
        return this.clienteService.comprobarlogin(nickname,contrasena);
    }

        public ArrayList<Cliente> listarCompradoresServicio(Servicio servicio) {
        return this.clienteService.listarCompradoresServicio(servicio);
    }

}
