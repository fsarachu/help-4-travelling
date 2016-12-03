package uy.edu.cure.servidor.web;

import uy.edu.cure.servidor.central.dto.Cliente;
import uy.edu.cure.servidor.central.dto.EstadoReserva;
import uy.edu.cure.servidor.central.dto.ItemReserva;
import uy.edu.cure.servidor.central.dto.Reserva;
import uy.edu.cure.servidor.central.dto.TiposListas.ListaReservas;
import uy.edu.cure.servidor.central.lib.controllers.FacturaController;
import uy.edu.cure.servidor.central.lib.controllers.RestController;

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
    private Integer reservaSeleccionada;
    private Integer cantidadReservas;
    private List<Reserva> reservaList = new ArrayList<>();
    private List<ItemReserva> itemReserva = new ArrayList<>();
    @ManagedProperty("#{loginProveedorBean}")
    private LoginProveedorBean loginProveedorBean;


    public ReservaBean() {
    }

    public String modificarEstado(Integer id) {
        EstadoReserva estadoReserva;
        if (obtenerRest(id).getEstado().equals(EstadoReserva.registrada)) {
            estadoReserva = EstadoReserva.cancelada;
        } else {
            estadoReserva = EstadoReserva.registrada;
        }
        actualizarEstadoRest(id, estadoReserva);
        return "index?faces-redirect=true";
    }

    public Reserva obtenerRest(Integer reserva) {
        String url = "http://localhost:8080/servidor-central-webapp/rest/api/reserva/obtener/"+reserva;
        RestController rest = new RestController();
        Reserva u = rest.doGET(url, Reserva.class);
        return u;
    }

    public void actualizarEstadoRest(Integer reserva, EstadoReserva estadoReserva) {
        String url = "http://localhost:8080/servidor-central-webapp/rest/api/reserva/actualizarestado/"+reserva+"/"+estadoReserva;
        RestController rest = new RestController();
        Reserva u = rest.doGET(url, Reserva.class);
    }


    public void cargarReservas(Cliente cliente) {
        String url = "http://localhost:8080/servidor-central-webapp/rest/api/reserva/listarReservaXCliente";
        RestController rest = new RestController();
        reservaList = rest.doPUT(url, cliente , ListaReservas.class).getReservaArrayList();
    }

    public boolean cargarReservasProveedor() {
        String url = "http://localhost:8080/servidor-central-webapp/rest/api/reserva/listarReservaXProveedor/"+ loginProveedorBean.getProveedor().getId();
        RestController rest = new RestController();
        reservaList = rest.doGET(url, ListaReservas.class).getReservaArrayList();
        System.out.print(reservaList.size());
        return true;
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

    public void comprarReserva(Integer idReserva){
        FacturaController facturaController = new FacturaController();
        facturaController.nueva(this.reserva);
        //mensaje = "Reserva Facturada con exito (Y)";
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

    public LoginProveedorBean getLoginProveedorBean() {
        return loginProveedorBean;
    }

    public void setLoginProveedorBean(LoginProveedorBean loginProveedorBean) {
        this.loginProveedorBean = loginProveedorBean;
    }
}
