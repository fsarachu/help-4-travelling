package uy.edu.cure.servidor.web;

import uy.edu.cure.servidor.central.dto.Cliente;
import uy.edu.cure.servidor.central.dto.Reserva;
import uy.edu.cure.servidor.central.lib.controllers.ReservaController;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
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
    @ManagedProperty(value = "#{loginBean}")
    private LoginBean loginBean;

    public ReservaBean() {

    }

    public void cantidadReservas() {
        ReservaController reservaController = new ReservaController();
        ArrayList<Reserva> reservas = reservaController.listar();
        for (Reserva reserva : reservas) {
            reservaList.add(reserva);
        }
        cantidadReservas = reservaList.size();
    }

    public void setLoginBean(LoginBean loginBean) {
        this.loginBean = loginBean;
    }

    public LoginBean getLoginBean() {
        return this.loginBean;
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
