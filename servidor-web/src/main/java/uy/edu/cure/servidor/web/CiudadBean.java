package uy.edu.cure.servidor.web;

import uy.edu.cure.servidor.central.dto.Ciudad;

public class CiudadBean {
    private Ciudad ciudad;

    public CiudadBean() {
    }

    public Ciudad getCiudad() {
        if (ciudad == null) {
            ciudad = new Ciudad();
        }
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }
}
