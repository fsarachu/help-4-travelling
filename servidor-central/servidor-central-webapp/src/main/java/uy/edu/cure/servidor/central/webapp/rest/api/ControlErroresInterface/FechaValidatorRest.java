package uy.edu.cure.servidor.central.webapp.rest.api.ControlErroresInterface;

import uy.edu.cure.servidor.central.lib.controlErroresInteface.FechaValidator;

/**
 * Created by victor on 16/11/16.
 */
public class FechaValidatorRest {
    public boolean validate(String fecha) {
        FechaValidator fechaValidator = new FechaValidator();
        return fechaValidator.validate(fecha);
    }
}
