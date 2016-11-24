package uy.edu.cure.servidor.central.dto;


public class Proveedor extends Usuario {
    private String nombreEmpresa;
    private String linkEmpresa;

    public Proveedor() {
    }

    public Proveedor(String nombreEmpresa, String linkEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
        this.linkEmpresa = linkEmpresa;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getLinkEmpresa() {
        return linkEmpresa;
    }

    public void setLinkEmpresa(String linkEmpresa) {
        this.linkEmpresa = linkEmpresa;
    }

    @Override
    public String toString() {
        return nombreEmpresa ;
    }
}
