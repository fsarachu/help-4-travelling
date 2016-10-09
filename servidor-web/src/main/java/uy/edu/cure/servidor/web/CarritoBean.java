package uy.edu.cure.servidor.web;

import uy.edu.cure.servidor.central.dto.Carrito;
import uy.edu.cure.servidor.central.dto.ItemReserva;
import uy.edu.cure.servidor.central.dto.Producto;
import uy.edu.cure.servidor.central.lib.controllers.CarritoController;

import javax.faces.bean.ManagedBean;
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


    public CarritoBean() {
    }

    public void agregar(Producto producto) {
        CarritoController carritoController = new CarritoController();
        ItemReserva item = new ItemReserva();
        item.setCarrito(carrito);
        item.setCantidad(cantidad);
        item.setFechaInicio(fechaInicio);
        item.setFechaFin(fechaFin);
        item.setProducto(producto);
        itemCantidad = (Double) item.getCantidad();
        itemPrecio =  item.getProducto().getPrecio();
        item.setSubTotal(itemCantidad * itemPrecio);
        CarritoController carritofinal = new CarritoController();
        carritofinal.agregarItem(item, item.getCarrito());
        //txtPrecioTotal.setText( String.valueOf( carrito.getTotal() ) );
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
}
