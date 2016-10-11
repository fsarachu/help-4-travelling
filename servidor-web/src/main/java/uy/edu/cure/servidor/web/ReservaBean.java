package uy.edu.cure.servidor.web;

import jdk.nashorn.internal.objects.NativeUint8Array;
import uy.edu.cure.servidor.central.dto.Cliente;
import uy.edu.cure.servidor.central.dto.Reserva;
import uy.edu.cure.servidor.central.lib.controllers.ReservaController;

import javax.el.ELContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@SessionScoped
public class ReservaBean implements Serializable{
    private Reserva reserva;
    private List<Reserva> reservaList = new ArrayList<>();
    @ManagedProperty(value = "#{loginBean}")
    private LoginBean loginBean;

    public ReservaBean() {
        /*  //invento cosmico http://stackoverflow.com/questions/25209786/get-bean-values-in-another-bean-in-prime-faces
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        loginBean = (LoginBean) elContext.getELResolver().getValue(elContext, null, "LoginBean");
        */

        try{
            cargarReservas(loginBean.getCliente());
        }catch( NullPointerException e ){
            throw new NullPointerException("[ReservaBean: loginBean = NULL: cargarReservas(loginBean.getCliente()) ]" + e.getMessage() );
        }

    }


    public void setLoginBean(LoginBean loginBean) {
        this.loginBean = loginBean;
    }
    public LoginBean getLoginBean() {
        return this.loginBean;
    }

    public List<Reserva> getReservaList() {
        return reservaList;
    }

    public void setReservaList(List<Reserva> reservaList) {
        this.reservaList = reservaList;
    }

    public Reserva getReserva() {
        if (reserva == null) {
            reserva = new Reserva();
        }
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public void cargarReservas(Cliente cliente) {
        ReservaController reservaController = new ReservaController();
        reservaList = reservaController.listarReservasCliente(cliente);
    }

}
