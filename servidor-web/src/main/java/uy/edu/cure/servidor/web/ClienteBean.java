package uy.edu.cure.servidor.web;

import uy.edu.cure.servidor.central.dto.Cliente;

public class ClienteBean {
    private Cliente cliente;

    public ClienteBean() {
    }

    public Cliente getCliente() {
        if (cliente == null) {
            cliente = new Cliente();
        }
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
