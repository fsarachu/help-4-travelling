package uy.edu.cure.servidor.web;

import uy.edu.cure.servidor.central.dto.Servicio;

public class ServicioBean {
    private Servicio servicio;

    public ServicioBean() {
    }

    public Servicio getServicio() {
        if (servicio == null) {
            servicio = new Servicio();
        }
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
}
