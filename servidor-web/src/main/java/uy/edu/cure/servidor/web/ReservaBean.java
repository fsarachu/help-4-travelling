package uy.edu.cure.servidor.web;

import uy.edu.cure.servidor.central.dto.Reserva;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

@ManagedBean
@SessionScoped
public class ReservaBean implements Serializable{
    private Reserva reserva;

    public ReservaBean() {
    }

    public Reserva getReserva() {
        if (reserva == null) {
            reserva = new Reserva();
        }
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
}
