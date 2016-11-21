package uy.edu.cure.servidor.central.webapp.rest.api.ControlErroresInterface;

import uy.edu.cure.servidor.central.lib.controlErroresInteface.ComparoContrasenaValidator;

/**
 * Created by victor on 16/11/16.
 */
public class ComparoContrasenaValidatorRest {

    public boolean passwordCorrecto(char[] j1,char[] j2) {
        ComparoContrasenaValidator comparoContrasenaValidator = new ComparoContrasenaValidator();
        return comparoContrasenaValidator.passwordCorrecto(j1, j2);
    }

}
