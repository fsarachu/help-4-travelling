package uy.edu.cure.servidor.central.webapp.rest.api.RestControllers.TiposListas;

import uy.edu.cure.servidor.central.dto.Cliente;

import java.util.ArrayList;

/**
 * Created by victor on 17/11/16.
 */
public class ListaClientes {
    private ArrayList<Cliente> clientes;

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }
}
