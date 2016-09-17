package uy.edu.cure.servidor.central.dto;

import java.util.Date;

public class Cliente extends Usuario {
    private Carrito carrito;

    public Cliente() {
    }

    public Cliente(Carrito carrito) {
        this.carrito = carrito;
    }

    public Cliente(Integer id, String nickname, String nombre, String apellido, String correo, Date fechaNacimiento, String imagen, Carrito carrito) {
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
