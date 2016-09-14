package uy.edu.cure.servidor.central.dto;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Date;

public class Cliente extends Usuario {
    private Carrito carrito;

    public Cliente() {
    }

    public Cliente(Integer id, String nickname, String nombre, String apellido, String correo, Date fechaNacimiento, BufferedImage imagen, Carrito carrito) {
        super(id, nickname, nombre, apellido, correo, fechaNacimiento, imagen);
        this.carrito = carrito;
    }

    @Override
    public String toString() {
        //return super.toString();
        return this.getId() + ": "+ this.getNombre() + " " + this.getApellido() + ";";
    }
}
