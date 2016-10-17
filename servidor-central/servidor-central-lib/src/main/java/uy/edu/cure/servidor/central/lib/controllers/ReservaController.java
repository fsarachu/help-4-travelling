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

    public void nueva(Cliente cliente) {
        Reserva reserva = new Reserva();
        reserva.setId(this.reservaService.nextId());
        reserva.setCliente(cliente);
        reserva.setCarrito(cliente.getCarrito());
        reserva.setFechaCreacion(new Date());
        reserva.setEstado(EstadoReserva.registrada);
        this.reservaService.agregar(reserva.getId(), reserva);

        Carrito nuevoCarrito = new Carrito();
        nuevoCarrito.setId(this.carritoService.nextId());
        nuevoCarrito.setCliente(cliente);
        this.carritoService.agregar(nuevoCarrito.getId(), nuevoCarrito);

        cliente.setCarrito(nuevoCarrito);
    }

    public Reserva obtener(Integer idReserva) {
        return this.reservaService.obtener(idReserva);
    }

    public void modificar(Reserva reserva) {
        this.reservaService.modificar(reserva.getId(), reserva);
    }

    public void eliminar(Integer idReserva) {
        this.reservaService.eliminar(idReserva);
    }

    public ArrayList<Reserva> listar() {
        return this.reservaService.listar();
    }

    public void actualizarEstado(Integer idReserva, EstadoReserva nuevoEstado) {
        Reserva reserva = this.reservaService.obtener(idReserva);
        reserva.setEstado(nuevoEstado);
    }

    public ArrayList<Reserva> listarReservasCliente(Cliente cliente) {
        return this.reservaService.listarReservasCliente(cliente);
    }
}
