package uy.edu.cure.servidor.central.dto;


import java.awt.image.BufferedImage;
import java.util.Date;

public class Cliente extends Usuario {
    public Cliente() {
    }

    public Cliente(Integer id, String nickname, String nombre, String apellido, String correo, Date fechaNacimiento, BufferedImage imagen) {
        super(id, nickname, nombre, apellido, correo, fechaNacimiento, imagen);
    }
}
