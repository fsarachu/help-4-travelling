package uy.edu.cure.servidor.web;

import uy.edu.cure.servidor.central.dto.TipoProducto;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

@ManagedBean
@SessionScoped
public class TipoProductoBean implements Serializable{
    private TipoProducto tipoProducto;


    public TipoProductoBean() {
    }

    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
    }
}
