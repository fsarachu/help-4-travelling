package uy.edu.cure.servidor.web;

import uy.edu.cure.servidor.central.dto.Proveedor;

public class ProveedoreBean {
    private Proveedor proveedor;

    public ProveedoreBean() {
    }

    public Proveedor getProveedor() {
        if (proveedor == null) {
            proveedor = new Proveedor();
        }
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
}
