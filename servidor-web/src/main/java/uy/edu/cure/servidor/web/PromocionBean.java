package uy.edu.cure.servidor.web;

import uy.edu.cure.servidor.central.dto.Promocion;

public class PromocionBean {
    private Promocion promocion;

    public PromocionBean() {
    }

    public Promocion getPromocion() {
        if (promocion == null){
            promocion = new Promocion();
        }
        return promocion;
    }

    public void setPromocion(Promocion promocion) {
        this.promocion = promocion;
    }
}
