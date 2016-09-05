package uy.edu.cure.servidor.central.lib.servicios;

import uy.edu.cure.servidor.central.dto.Orden;


public interface OrdenService {
    void agregar(Integer id, Orden orden);

    void eliminar(Integer id);

    void modificar(Integer id, Orden orden);

    Orden obtener(Integer id);
}
