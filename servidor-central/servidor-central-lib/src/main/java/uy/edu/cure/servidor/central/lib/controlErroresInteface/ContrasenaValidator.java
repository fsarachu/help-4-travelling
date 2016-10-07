package uy.edu.cure.servidor.central.lib.controlErroresInteface;


import uy.edu.cure.servidor.central.dto.Cliente;
import uy.edu.cure.servidor.central.lib.controllers.ClienteController;

import java.util.ArrayList;
import java.util.List;

public class ContrasenaValidator {

    public boolean validate(Cliente cliente) {
        ClienteController clienteController = new ClienteController();
        List<Cliente> clientes = (ArrayList)clienteController.listar();
        boolean validado = false;
        for (Cliente client: clientes) {
            if (client.getNickname().equals(cliente.getNickname()) &&
                    client.getContrasena().equals(cliente.getContrasena())) {
                validado = true;
            }
        }
        return validado;
    }
}
