package uy.edu.cure.servidor.web;

import uy.edu.cure.servidor.central.dto.Carrito;
import uy.edu.cure.servidor.central.dto.Cliente;
import uy.edu.cure.servidor.central.dto.ItemReserva;
import uy.edu.cure.servidor.central.dto.Producto;
import uy.edu.cure.servidor.central.lib.controllers.CarritoController;
import uy.edu.cure.servidor.central.lib.controllers.ClienteController;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.Date;

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
    @ManagedProperty("#{servicioBean}")
    private ServicioBean servicioBean;
    @ManagedProperty("#{loginBean}")
    private LoginBean loginBean;

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
        item.setSubTotal(itemCantidad * itemPrecio);
        CarritoController carritofinal = new CarritoController();
        carritofinal.agregarItem(item, item.getCarrito());
    }

    public Carrito getCarrito() {
        //if (carrito == null) {
            carrito = new Carrito();
       // }
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
}

