package uy.edu.cure.servidor.web;

import uy.edu.cure.servidor.central.dto.Reserva;

public class ReservaBean {
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
