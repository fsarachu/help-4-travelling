package uy.edu.cure.servidor.web;

import uy.edu.cure.servidor.central.dto.Carrito;

public class CarritoBean {
    private Carrito carrito;

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
