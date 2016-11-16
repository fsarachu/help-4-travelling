package uy.edu.cure.servidor.web;

import uy.edu.cure.servidor.central.dto.Producto;
import uy.edu.cure.servidor.central.dto.Promocion;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@SessionScoped
public class PromocionBean implements Serializable{
    private Promocion promocion;
    private List<Producto> listarPromos = new ArrayList<Producto>();

    public PromocionBean() {
    }

    public void cargarServicios() {
        listarPromos = null;
        for (Producto producto : listarPromos ) {
            if (producto.getTipo().equals(promocion)) {
                listarPromos.add(producto);
            }
        }
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

    public List<Producto> getListarPromos() {
        return listarPromos;
    }

    public void setListarPromos(List<Producto> listarPromos) {
        this.listarPromos = listarPromos;
    }

}
