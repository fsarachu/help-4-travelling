package uy.edu.cure.servidor.web;

import uy.edu.cure.servidor.central.dto.Pais;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

@ManagedBean
@SessionScoped
public class PaisBean implements Serializable{
    private Pais pais;

    public PaisBean() {
    }

    public Pais getPais() {
        if (pais == null) {
            pais = new Pais();
        }
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
}
