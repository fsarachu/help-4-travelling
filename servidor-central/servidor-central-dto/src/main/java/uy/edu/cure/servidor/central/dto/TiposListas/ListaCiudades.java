package uy.edu.cure.servidor.central.dto.TiposListas;

import uy.edu.cure.servidor.central.dto.Ciudad;

import java.util.ArrayList;

/**
 * Created by victor on 19/11/16.
 */
public class ListaCiudades {
    private ArrayList<Ciudad> ciudadArrayList;

    public ListaCiudades() {
    }

    public ArrayList<Ciudad> getCiudadArrayList() {
        return ciudadArrayList;
    }

    public void setCiudadArrayList(ArrayList<Ciudad> ciudadArrayList) {
        this.ciudadArrayList = ciudadArrayList;
    }
}
