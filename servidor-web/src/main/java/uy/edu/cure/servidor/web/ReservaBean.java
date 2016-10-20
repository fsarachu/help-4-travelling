package uy.edu.cure.servidor.web;

import uy.edu.cure.servidor.central.dto.Cliente;
import uy.edu.cure.servidor.central.dto.Reserva;
import uy.edu.cure.servidor.central.lib.controllers.ReservaController;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ManagedBean
@SessionScoped
public class ReservaBean implements Serializable {
    private Reserva reserva;
    private Integer cantidadReservas;
    private List<Reserva> reservaList = new ArrayList<>();


    public ReservaBean() throws IOException {
        System.out.println("The current runtime classpath covers the following paths:");
        for (URL url : Collections.list(Thread.currentThread().getContextClassLoader().getResources(""))) {
            System.out.println(url);
        }
    }

    public void cantReservas(Cliente cliente) {
        reservaList.clear();
        ReservaController reservaController = new ReservaController();
        ArrayList<Reserva> reservas = reservaController.listarReservasCliente(cliente);
        for (Reserva reserva : reservas) {
            reservaList.add(reserva);
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
