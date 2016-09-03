package uy.edu.cure.servidor.central.lib.servicios;

import uy.edu.cure.servidor.central.dto.Reserva;

public interface ReservaService {
    void agregar(Integer id, Reserva reserva);

    void eliminar(Integer id);

    void modificar(Integer id, Reserva reserva);

    Reserva obtener(Integer id);
}
