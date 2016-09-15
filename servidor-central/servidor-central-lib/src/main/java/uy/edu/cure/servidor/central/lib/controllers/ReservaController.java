package uy.edu.cure.servidor.central.lib.controllers;

import uy.edu.cure.servidor.central.dto.Carrito;
import uy.edu.cure.servidor.central.dto.Cliente;
import uy.edu.cure.servidor.central.dto.EstadoReserva;
import uy.edu.cure.servidor.central.dto.Reserva;
import uy.edu.cure.servidor.central.lib.servicios.CarritoService;
import uy.edu.cure.servidor.central.lib.servicios.ReservaService;
import uy.edu.cure.servidor.central.lib.servicios.ServiceFactory;

import java.util.ArrayList;
import java.util.Date;

public class ReservaController {

    private ReservaService reservaService;
    private CarritoService carritoService;

    public ReservaController() {
        this.reservaService = ServiceFactory.getReservaService();
        this.carritoService = ServiceFactory.getCarritoService();
    }

    public void eliminar(int id) {
        ReservaService ciudadService = ServiceFactory.getReservaService();

        ciudadService.eliminar(id);
    }

    Reserva obtener(Integer id) {
        ReservaService ciudadService = ServiceFactory.getReservaService();

        return ciudadService.obtener(id);
    }

    public void modificar(Integer id, Reserva ciudad1) {
        ReservaService ciudadService = ServiceFactory.getReservaService();

        ciudadService.modificar(id, ciudad1);
    }

    public ArrayList<Reserva> listar() {
        return this.reservaService.listar();
    }

    public void nueva(Cliente cliente) {
        Reserva reserva = new Reserva();
        reserva.setId(this.reservaService.nextId());
        reserva.setCliente(cliente);
        reserva.setCarrito(cliente.getCarrito());
        reserva.setFechaCreacion(new Date());
        reserva.setEstado(EstadoReserva.registrada);

        Carrito nuevoCarrito = new Carrito();
        nuevoCarrito.setId(this.carritoService.nextId());
        nuevoCarrito.setCliente(cliente);
        this.carritoService.agregar(nuevoCarrito.getId(), nuevoCarrito);

        cliente.setCarrito(nuevoCarrito);
    }
}
