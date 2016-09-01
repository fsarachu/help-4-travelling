package uy.edu.cure.servidor.central.lib.servicios.memoria;

import uy.edu.cure.servidor.central.dto.Cliente;
import uy.edu.cure.servidor.central.lib.servicios.ClienteService;

import java.util.ArrayList;

public class ClienteServiceImpl implements ClienteService {

    private ArrayList<Cliente> clientes;

    private static ClienteServiceImpl ourInstance = new ClienteServiceImpl();

    public static ClienteServiceImpl getInstance() {
        return ourInstance;
    }

    private ClienteServiceImpl() {
    }

    @Override
    public void agregar(Cliente cliente) {
        this.clientes.add(cliente);
    }

    @Override
    public void eliminar(Cliente cliente) {
        int index = this.clientes.indexOf(cliente);
        if ( index != -1){
            this.clientes.remove(index);
        }
    }

    @Override
    public void modificar(Cliente anterior, Cliente nuevo) {
        int index = this.clientes.indexOf(anterior);

        if ( index != -1){
            this.clientes.remove(index);
            this.clientes.add(nuevo);
        }

    }

    @Override
    public Cliente obtener(String nickname) {
        for (Cliente cliente : this.clientes) {
            if (cliente.getNickname().equals(nickname)) {
                return cliente;
            }
        }
        return null;
    }
}
