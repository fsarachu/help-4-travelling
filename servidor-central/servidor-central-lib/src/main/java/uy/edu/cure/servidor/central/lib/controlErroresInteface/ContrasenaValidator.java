package uy.edu.cure.servidor.central.lib.controlErroresInteface;


import uy.edu.cure.servidor.central.dto.Cliente;
import uy.edu.cure.servidor.central.lib.controllers.ClienteController;

import java.util.ArrayList;
import java.util.List;

public class ContrasenaValidator {

    public boolean validate(String nickname, String contrasena) {
        ClienteController clienteController = new ClienteController();
        List<Cliente> clientes = (ArrayList)clienteController.listar();
        boolean validado = false;
        for (Cliente cliente: clientes) {
            if (cliente.getNickname().equals(nickname) && cliente.getContrasena().equals(contrasena)) {
                validado = true;
            }
        }
        return validado;
    }
}
