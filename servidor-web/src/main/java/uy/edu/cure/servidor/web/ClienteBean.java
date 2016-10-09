package uy.edu.cure.servidor.web;

import uy.edu.cure.servidor.central.dto.Cliente;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

@ManagedBean
@SessionScoped
public class ClienteBean implements Serializable{
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
