package uy.edu.cure.servidor.central.lib.controlErroresInteface;

import uy.edu.cure.servidor.central.lib.controllers.ClienteController;

public class UsuarioExisteValidator {

    public boolean validator(String nickname, String email) {
        ClienteController clienteController = new ClienteController();
        if (clienteController.nicknameExiste(nickname) || clienteController.emailExiste(email)) {
            return false;
        } else {
            return true;
        }
    }
}
