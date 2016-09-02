package uy.edu.cure.servidor.central.dto;

import java.util.ArrayList;

public class Proveedor extends Usuario {
    private String nombreEmpresa;
    private String linkEmpresa;
    private ArrayList<Servicio> servicios;
    private ArrayList<Promocion> promociones;

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

    public ArrayList<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(ArrayList<Servicio> servicios) {
        this.servicios = servicios;
    }

    public ArrayList<Promocion> getPromociones() {
        return promociones;
    }

    public void setPromociones(ArrayList<Promocion> promociones) {
        this.promociones = promociones;
    }
}
