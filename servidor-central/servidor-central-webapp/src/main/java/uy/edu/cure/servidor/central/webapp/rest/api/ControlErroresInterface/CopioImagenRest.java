package uy.edu.cure.servidor.central.webapp.rest.api.ControlErroresInterface;

import uy.edu.cure.servidor.central.lib.controlErroresInteface.CopioImagen;

import java.io.IOException;

/**
 * Created by victor on 16/11/16.
 */
public class CopioImagenRest {
    public void copioArchivo(String origen, String destino) throws IOException {
        CopioImagen copioImagen = new CopioImagen();
        copioImagen.copioArchivo(origen, destino);
    }
}
