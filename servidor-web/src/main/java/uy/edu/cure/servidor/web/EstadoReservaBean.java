package uy.edu.cure.servidor.web;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

@ManagedBean
@SessionScoped
public enum EstadoReservaBean implements Serializable{
    registrada,
    cancelada,
    pagada,
    facturada
}
