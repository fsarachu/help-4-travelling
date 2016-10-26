package uy.edu.cure.servidor.web;

import uy.edu.cure.servidor.central.dto.Cliente;
import uy.edu.cure.servidor.central.dto.EstadoReserva;
import uy.edu.cure.servidor.central.dto.ItemReserva;
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
    private Integer reservaSeleccionada;
    private Integer cantidadReservas;
    private List<Reserva> reservaList = new ArrayList<>();
    private List<ItemReserva> itemReserva = new ArrayList<>();


    public ReservaBean() {
    }

    public String modificarEstado(Integer id) {
        EstadoReserva estadoReserva;
        ReservaController reservaController = new ReservaController();
        if (reservaController.obtener(id).getEstado().equals(EstadoReserva.registrada)) {
            estadoReserva = EstadoReserva.cancelada;
        } else {
            estadoReserva = EstadoReserva.registrada;
        }
        reservaController.actualizarEstado(id, estadoReserva);
        return "index?faces-redirect=true";
    }

    public void cargarReservas(Cliente cliente) {
        ReservaController reservaController = new ReservaController();
        reservaList = reservaController.listarReservasCliente(cliente);
    }

    public void cargarItemsReserva(Integer idReserva) {
        reservaSeleccionada = idReserva;
        for (int i = 0; i < reservaList.size(); i++) {
            if (reservaList.get(i).getId().equals(idReserva)) {
                for (ItemReserva item : reservaList.get(i).getCarrito().getItems()) {
                    itemReserva.add(item);
                }
            }
        }
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


    public Integer getCantidadReservas() {
        return cantidadReservas;
    }

    public void setCantidadReservas(Integer cantidadReservas) {
        this.cantidadReservas = cantidadReservas;
    }

    public List<ItemReserva> getItemReserva() {
        return itemReserva;
    }

    public void setItemReserva(List<ItemReserva> itemReserva) {
        this.itemReserva = itemReserva;
    }

    public Integer getReservaSeleccionada() {
        return reservaSeleccionada;
    }

    public void setReservaSeleccionada(Integer reservaSeleccionada) {
        this.reservaSeleccionada = reservaSeleccionada;
    }
}
