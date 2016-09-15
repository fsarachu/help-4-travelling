package uy.edu.cure.servidor.central.dto;

import java.awt.image.BufferedImage;
import java.util.Date;

public class Cliente extends Usuario {
    private Carrito carrito;

    public Cliente() {
    }

    public Cliente(Integer id, String nickname, String nombre, String apellido, String correo, Date fechaNacimiento, BufferedImage imagen, Carrito carrito) {
        super(id, nickname, nombre, apellido, correo, fechaNacimiento, imagen);
        this.carrito = carrito;
    }

    public Carrito getCarrito() {
        return carrito;
    }

    public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }

    @Override
    public String toString() {
        return this.getId() + ": " + this.getNombre() + " " + this.getApellido() + ";";
    }
}
