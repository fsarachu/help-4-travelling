package uy.edu.cure.servidor.central.lib.controlErroresInteface;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class FechaValidator {

    public boolean validate(String fecha) {
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
            formatoFecha.setLenient(false);
            formatoFecha.parse(fecha);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }
}
