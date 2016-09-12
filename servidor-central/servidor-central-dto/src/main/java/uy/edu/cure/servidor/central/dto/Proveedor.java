package uy.edu.cure.servidor.central.dto;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Date;

public class Proveedor extends Usuario {
    private String nombreEmpresa;
    private String linkEmpresa;
    private ArrayList<Integer> idServicios;
    private ArrayList<Servicio> servicios;
    private ArrayList<Integer> idPromociones;
    private ArrayList<Promocion> promociones;

    public Proveedor(){};

    public Proveedor(Integer id, String nickname, String nombre, String apellido, String correo, Date fechaNacimiento, BufferedImage imagen, String nombreEmpresa, String linkEmpresa, ArrayList<Integer> idServicios, ArrayList<Servicio> servicios, ArrayList<Integer> idPromociones, ArrayList<Promocion> promociones) {
        super(id, nickname, nombre, apellido, correo, fechaNacimiento, imagen);
        this.nombreEmpresa = nombreEmpresa;
        this.linkEmpresa = linkEmpresa;
        this.idServicios = idServicios;
        this.servicios = servicios;
        this.idPromociones = idPromociones;
        this.promociones = promociones;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getLinkEmpresa() {
        return linkEmpresa;
    }

    public void setLinkEmpresa(String linkEmpresa) {
        this.linkEmpresa = linkEmpresa;
    }

    public ArrayList<Integer> getIdServicios() {
        return idServicios;
    }

    public ArrayList<Servicio> getServicios() {
        return servicios;
    }

    public ArrayList<Integer> getIdPromociones() {
        return idPromociones;
    }

    public ArrayList<Promocion> getPromociones() {
        return promociones;
    }

}
