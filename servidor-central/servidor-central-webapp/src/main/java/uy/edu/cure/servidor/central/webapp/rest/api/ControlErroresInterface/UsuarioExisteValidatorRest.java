package uy.edu.cure.servidor.central.webapp.rest.api.ControlErroresInterface;

import uy.edu.cure.servidor.central.lib.controlErroresInteface.UsuarioExisteValidator;

/**
 * Created by victor on 16/11/16.
 */
public class UsuarioExisteValidatorRest {

    public boolean validator(String nickname, String email) {
        UsuarioExisteValidator usuarioExisteValidator = new UsuarioExisteValidator();
        return usuarioExisteValidator.validator(nickname, email);
    }
}
