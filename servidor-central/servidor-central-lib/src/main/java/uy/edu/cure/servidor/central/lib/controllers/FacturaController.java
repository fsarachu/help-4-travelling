package uy.edu.cure.servidor.central.lib.controllers;

import uy.edu.cure.servidor.central.dto.EstadoReserva;
import uy.edu.cure.servidor.central.dto.Factura;
import uy.edu.cure.servidor.central.dto.Reserva;
import uy.edu.cure.servidor.central.lib.servicios.FacturaService;
import uy.edu.cure.servidor.central.lib.servicios.ReservaService;
import uy.edu.cure.servidor.central.lib.servicios.ServiceFactory;

import java.util.Date;

public class FacturaController {

    private FacturaService facturaService;
    private ReservaService reservaService;

    public FacturaController(){
        this.facturaService = ServiceFactory.getFacturaService();
        this.reservaService = ServiceFactory.getReservaService();
    }

    public void nueva(Reserva reserva){
        Factura factura = new Factura();
        factura.setId(this.facturaService.nextId());
        factura.setFecha(new Date());
        factura.setEstado(EstadoReserva.facturada);
        //factura.setReserva(reserva);
        this.facturaService.agregar(factura.getId(), factura);
    }

}
