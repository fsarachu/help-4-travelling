package uy.edu.cure.servidor.web;

import uy.edu.cure.servidor.central.dto.Cliente;
import uy.edu.cure.servidor.central.dto.EstadoReserva;
import uy.edu.cure.servidor.central.dto.ItemReserva;
import uy.edu.cure.servidor.central.dto.Reserva;
import uy.edu.cure.servidor.central.dto.TiposListas.ListaReservas;
import uy.edu.cure.servidor.central.lib.controllers.RestController;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
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
    private List<Reserva> reservaListProv = new ArrayList<>();
    private List<ItemReserva> itemReserva = new ArrayList<>();
    private List<ItemReserva> itemReservaProveedor = new ArrayList<>();
    private List<Reserva> reservaCliente = new ArrayList<>();
    private String estadoReserva;
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
        //actualizarEstadoRest(id, estadoReserva);
        return "index?faces-redirect=true";
    }

    public Reserva obtenerRest(Integer reserva) {
        String url = "http://localhost:8080/servidor-central-webapp/rest/api/reserva/obtener/" + reserva;
        RestController rest = new RestController();
        Reserva u = rest.doGET(url, Reserva.class);
        return u;
    }

    public boolean obtenerXClienteRest(Cliente cliente) {
        String url = "http://localhost:8080/servidor-central-webapp/rest/api/reserva/listarReservaXCliente";

        RestController rest = new RestController();
        ListaReservas listaReservas = rest.doPUT(url, cliente, ListaReservas.class);
        reservaCliente = listaReservas.getReservaArrayList();

        if (reservaCliente.size() == 0) {
            return false;
        }
        return true;
    }


    public void actualizarEstadoRest(Integer reserva, String estadoReserva) {
        String url = "http://localhost:8080/servidor-central-webapp/rest/api/reserva/actualizarestado/" + reserva + "/" +estadoReserva;
        RestController rest = new RestController();
        Reserva u = rest.doGET(url, Reserva.class);
    }

    public void modificarEstadoRest(Integer reserva) {
        estadoReserva = FacesContext.getCurrentInstance().
                getExternalContext().getRequestParameterMap().get("hidden1");
        Integer estado = Integer.parseInt(estadoReserva);
        String url = "http://localhost:8080/servidor-central-webapp/rest/api/reserva/estadoreserva/" + reserva + "/" +estado;
        RestController rest = new RestController();
        Reserva u = rest.doGET(url, Reserva.class);
    }

    public void cargarReservas(Cliente cliente) {
        String url = "http://localhost:8080/servidor-central-webapp/rest/api/reserva/listarReservaXCliente";
        RestController rest = new RestController();
        reservaList = rest.doPUT(url, cliente, ListaReservas.class).getReservaArrayList();
    }

    public boolean cargarReservasProveedor() {
        String url = "http://localhost:8080/servidor-central-webapp/rest/api/reserva/listarReservaXProveedor/" + loginProveedorBean.getProveedor().getId();
        RestController rest = new RestController();
        if (rest.doGET(url, ListaReservas.class).getReservaArrayList().size() == 0) {
            return false;
        }
        reservaListProv = rest.doGET(url, ListaReservas.class).getReservaArrayList();
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


    public void cargarItemsReservaProveedor(Integer idReserva) {
        reservaSeleccionada = idReserva;
        for (int i = 0; i < reservaListProv.size(); i++) {
            for (ItemReserva item : reservaListProv.get(i).getCarrito().getItems()) {
                itemReservaProveedor.add(item);
            }
        }
    }

    public boolean comprarReserva(Cliente cliente) {
        String url = "http://localhost:8080/servidor-central-webapp/rest/api/reserva/comprarReserva";
        RestController rest = new RestController();
        boolean log = rest.doPUT(url, cliente, boolean.class);
        return true;
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

    public List<Reserva> getReservaListProv() {
        return reservaListProv;
    }

    public void setReservaListProv(List<Reserva> reservaListProv) {
        this.reservaListProv = reservaListProv;
    }

    public List<ItemReserva> getItemReservaProveedor() {
        return itemReservaProveedor;
    }

    public void setItemReservaProveedor(List<ItemReserva> itemReservaProveedor) {
        this.itemReservaProveedor = itemReservaProveedor;
    }

    public String getEstadoReserva() {
        return estadoReserva;
    }

    public void setEstadoReserva(String estadoReserva) {
        this.estadoReserva = estadoReserva;
    }


    public List<Reserva> getReservaCliente() {
        return reservaCliente;
    }

    public void setReservaCliente(List<Reserva> reservaCliente) {
        this.reservaCliente = reservaCliente;
    }

}
