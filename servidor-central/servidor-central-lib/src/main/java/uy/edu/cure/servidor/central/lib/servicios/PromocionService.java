package uy.edu.cure.servidor.central.lib.servicios;

import uy.edu.cure.servidor.central.dto.Promocion;

public interface PromocionService {
    void agregar(Promocion promocion);

    void eliminar(Promocion promocion);

    void modificar(Promocion anterior, Promocion nueva);

    Promocion obtener(String nombre);
}
