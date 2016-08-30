package uy.edu.cure.servidor.central.lib.servicios;

import uy.edu.cure.servidor.central.dto.Servicio;

public interface ServicioService {
    void agregar(Servicio servicio);

    void eliminar(Servicio servicio);

    void modificar(Servicio anterior, Servicio nuevo);

    Servicio obtener(String nombre);
}
