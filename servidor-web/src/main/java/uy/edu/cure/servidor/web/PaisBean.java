package uy.edu.cure.servidor.web;

import uy.edu.cure.servidor.central.dto.Pais;

public class PaisBean {
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
