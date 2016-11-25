package uy.edu.cure.servidor.web;

import uy.edu.cure.servidor.central.dto.Carrito;
import uy.edu.cure.servidor.central.dto.Cliente;
import uy.edu.cure.servidor.central.dto.ItemReserva;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ManagedBean
@SessionScoped
public class CarritoBean implements Serializable{

    private Carrito carrito;
    private Integer cantidad;
    private Date fechaInicio;
    private Date fechaFin;
    private String mensaje;
    private Double itemCantidad;
    private Double itemPrecio;
    private Long dias;
    private List<ItemReserva> itemReservas = new ArrayList<ItemReserva>();
    @ManagedProperty("#{servicioBean}")
    private ServicioBean servicioBean;
    @ManagedProperty("#{loginBean}")
    private LoginBean loginBean;
    @ManagedProperty("#{reservaBean}")
    private ReservaBean reservaBean;

    public CarritoBean() {
    }

    public void agregar() {
        ItemReserva item = new ItemReserva();
        carrito = loginBean.getCliente().getCarrito();
        item.setCarrito(carrito);
        item.setCantidad(cantidad);
        item.setFechaInicio(fechaInicio);
        item.setFechaFin(fechaFin);
        item.setProducto(servicioBean.getServicio());
        itemCantidad = item.getCantidad();
        itemPrecio =  item.getProducto().getPrecio();
        long diferenciaEn_ms = fechaFin.getTime() - fechaInicio.getTime();
        long dias = diferenciaEn_ms / (1000 * 60 * 60 * 24);
        item.setSubTotal(itemCantidad * itemPrecio * dias);
        agregarItemRest(item, item.getCarrito());
        loginBean.setCantidadItems(getCarrito().getItems().size());
    }


    public void agregarItemRest(ItemReserva item, Carrito itemCarrito) {
        String url = "http://localhost:8080/servidor-central-webapp/rest/api/carrito/agregarItem/"+item+"/"+itemCarrito;
        RestController rest = new RestController();
        ItemReserva u = rest.doPUT(url, item , ItemReserva.class);
    }

    public void confirmarCarrito() {
        String url = "http://localhost:8080/servidor-central-webapp/rest/api/reserva/nueva/";
        RestController rest = new RestController();
        boolean u = rest.doPUT(url, loginBean.getCliente() , boolean.class);
        loginBean.setCantidadItems(loginBean.getCliente().getCarrito().getItems().size());
        //reservaBean.cargarReservas(loginBean.getCliente());
        mensaje = "Reserva Realizada con exito";
    }


    public void mostrarCarrito() {
        String url = "http://localhost:8080/servidor-central-webapp/rest/api/cliente/obtener/"+loginBean.getCliente().getId();
        RestController rest = new RestController();
        Cliente u = rest.doGET(url, Cliente.class);
        if (u.getCarrito().getIdItems() != null) {
            itemReservas = u.getCarrito().getItems();
        } else {
            mensaje = "Carrito Vacio";
        }
    }

    public String totalCarrito() {
        if (carrito != null) {
            String url = "http://localhost:8080/servidor-central-webapp/rest/api/carrito/actualizarTotal";
            RestController rest = new RestController();
            boolean u = rest.doPUT(url, carrito , boolean.class);
            carrito.setTotal(loginBean.getCliente().getCarrito().getTotal());
        }
        return mensaje = null;
    }

    public void calculoDias(Date fInicio, Date fFin) {
        long diferenciaEn_ms = fFin.getTime() - fInicio.getTime();
        dias = diferenciaEn_ms / (1000 * 60 * 60 * 24);
    }

    public Carrito getCarrito() {
        if (carrito == null) {
            carrito = new Carrito();
        }
        return carrito;
    }

    public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Double getItemCantidad() {
        return itemCantidad;
    }

    public void setItemCantidad(Double itemCantidad) {
        this.itemCantidad = itemCantidad;
    }

    public Double getItemPrecio() {
        return itemPrecio;
    }

    public void setItemPrecio(Double itemPrecio) {
        this.itemPrecio = itemPrecio;
    }

    public ServicioBean getServicioBean() {
        return servicioBean;
    }

    public void setServicioBean(ServicioBean servicioBean) {
        this.servicioBean = servicioBean;
    }

    public LoginBean getLoginBean() {
        return loginBean;
    }

    public void setLoginBean(LoginBean loginBean) {
        this.loginBean = loginBean;
    }

    public ReservaBean getReservaBean() {
        return reservaBean;
    }

    public void setReservaBean(ReservaBean reservaBean) {
        this.reservaBean = reservaBean;
    }

    public List<ItemReserva> getItemReservas() {
        mostrarCarrito();
        return itemReservas;
    }

    public void setItemReservas(List<ItemReserva> itemReservas) {
        this.itemReservas = itemReservas;
    }

    public Long getDias() {
        return dias;
    }

    public void setDias(Long dias) {
        this.dias = dias;
    }
}

