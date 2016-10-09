package uy.edu.cure.servidor.web;

import uy.edu.cure.servidor.central.dto.Ciudad;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

@ManagedBean
@SessionScoped
public class CiudadBean implements Serializable{
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
