package uy.edu.cure.servidor.central.dto.TiposListas;

import uy.edu.cure.servidor.central.dto.Cliente;

import java.util.ArrayList;

/**
 * Created by victor on 17/11/16.
 */
public class ListaClientes {
    private ArrayList<Cliente> clienteArrayList;

    public ListaClientes() {
    }

    public ArrayList<Cliente> getClienteArrayList() {
        return clienteArrayList;
    }

    public void setClienteArrayList(ArrayList<Cliente> clienteArrayList) {
        this.clienteArrayList = clienteArrayList;
    }
}
