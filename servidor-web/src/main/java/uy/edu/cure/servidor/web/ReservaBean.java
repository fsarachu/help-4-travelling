package uy.edu.cure.servidor.web;

import uy.edu.cure.servidor.central.dto.Cliente;
import uy.edu.cure.servidor.central.dto.Reserva;
import uy.edu.cure.servidor.central.lib.controllers.ReservaController;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@SessionScoped
public class ReservaBean implements Serializable {
    private Reserva reserva;
    private Integer cantidadReservas;
    private List<Reserva> reservaList = new ArrayList<>();

    public ReservaBean() {
    }


    public void cantReservas(Integer id) {
        reservaList.clear();
        ReservaController reservaController = new ReservaController();
        ArrayList<Reserva> reservas = reservaController.listar();
        for (Reserva reserva : reservas) {
            if (reserva.getCliente().getId().equals(id)){
                reservaList.add(reserva);
            }
        }
        cantidadReservas = reservaList.size();
    }


    public List<Reserva> getReservaList() {
        return reservaList;
    }

    public void setReservaList(List<Reserva> reservaList) {
        this.reservaList = reservaList;
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

    public void cargarReservas(Cliente cliente) {
        ReservaController reservaController = new ReservaController();
        reservaList = reservaController.listarReservasCliente(cliente);
    }

    public Integer getCantidadReservas() {
        return cantidadReservas;
    }

    public void setCantidadReservas(Integer cantidadReservas) {
        this.cantidadReservas = cantidadReservas;
    }

}
