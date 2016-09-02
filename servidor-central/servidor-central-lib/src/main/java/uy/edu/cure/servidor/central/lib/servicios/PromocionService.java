package uy.edu.cure.servidor.central.lib.servicios;

import uy.edu.cure.servidor.central.dto.Promocion;

public interface PromocionService {
    void agregar(Integer id, Promocion promocion);

    void eliminar(Integer id);

    void modificar(Integer id, Promocion promocion);

    Promocion obtener(Integer id);
}
