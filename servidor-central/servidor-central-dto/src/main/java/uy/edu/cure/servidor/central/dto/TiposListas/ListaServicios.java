package uy.edu.cure.servidor.central.dto.TiposListas;

import uy.edu.cure.servidor.central.dto.Servicio;

import java.util.ArrayList;

/**
 * Created by victor on 18/11/16.
 */
public class ListaServicios {
    private ArrayList<Servicio> servicioArrayList;

    public ListaServicios() {
    }

    public ArrayList<Servicio> getServicioArrayList() {
        return servicioArrayList;
    }

    public void setServicioArrayList(ArrayList<Servicio> servicioArrayList) {
        this.servicioArrayList = servicioArrayList;
    }
}
