package uy.edu.cure.servidor.central.dto.TiposListas;

import uy.edu.cure.servidor.central.dto.Reserva;

import java.util.ArrayList;

/**
 * Created by victor on 18/11/16.
 */
public class ListaReservas {
    private ArrayList<Reserva> reservaArrayList;

    public ListaReservas() {
    }

    public ArrayList<Reserva> getReservaArrayList() {
        return reservaArrayList;
    }

    public void setReservaArrayList(ArrayList<Reserva> reservaArrayList) {
        this.reservaArrayList = reservaArrayList;
    }
}
