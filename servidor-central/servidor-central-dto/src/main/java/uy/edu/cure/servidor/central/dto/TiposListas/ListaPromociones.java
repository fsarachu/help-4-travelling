package uy.edu.cure.servidor.central.dto.TiposListas;

import uy.edu.cure.servidor.central.dto.Promocion;

import java.util.ArrayList;

/**
 * Created by victor on 18/11/16.
 */
public class ListaPromociones {
    private ArrayList<Promocion> promocionArrayList;

    public ListaPromociones() {
    }

    public ArrayList<Promocion> getPromocionArrayList() {
        return promocionArrayList;
    }

    public void setPromocionArrayList(ArrayList<Promocion> promocionArrayList) {
        this.promocionArrayList = promocionArrayList;
    }
}
