package uy.edu.cure.servidor.central.webapp.rest.api.ControlErroresInterface;

import uy.edu.cure.servidor.central.lib.controlErroresInteface.EmailValidator;

/**
 * Created by victor on 16/11/16.
 */
public class EmailValidatorRest {
    public boolean validate(final String hex) {
        EmailValidator emailValidator = new EmailValidator();
        return emailValidator.validate(hex);
    }
}
