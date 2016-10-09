package uy.edu.cure.servidor.web;

import uy.edu.cure.servidor.central.dto.Promocion;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

@ManagedBean
@SessionScoped
public class PromocionBean implements Serializable{
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
