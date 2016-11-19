package uy.edu.cure.servidor.central.webapp.rest.api.ControlErroresInterface;

import uy.edu.cure.servidor.central.dto.Cliente;
import uy.edu.cure.servidor.central.lib.controlErroresInteface.ContrasenaValidator;

/**
 * Created by victor on 16/11/16.
 */
public class ContrasenaValidatorRest {
    public boolean validate(Cliente cliente) {
        ContrasenaValidator contrasenaValidator = new ContrasenaValidator();
        return contrasenaValidator.validate(cliente);
    }
}
