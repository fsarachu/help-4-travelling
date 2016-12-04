package uy.edu.cure.servidor.central.lib.controllers;

import uy.edu.cure.servidor.central.dto.EstadoFactura;
import uy.edu.cure.servidor.central.dto.Factura;
import uy.edu.cure.servidor.central.lib.servicios.FacturaService;
//import uy.edu.cure.servidor.central.lib.servicios.ReservaService;
import uy.edu.cure.servidor.central.lib.servicios.ServiceFactory;

import java.util.Date;

public class FacturaController {

    private FacturaService facturaService;
    //private ReservaService reservaService;

    public FacturaController(){
        this.facturaService = ServiceFactory.getFacturaService();
        //this.reservaService = ServiceFactory.getReservaService();
    }

    public void nueva(Factura factura){

        factura.setFecha(new Date());
        factura.setEstado(EstadoFactura.facturada);

        this.facturaService.agregar(-1, factura);
    }

}
