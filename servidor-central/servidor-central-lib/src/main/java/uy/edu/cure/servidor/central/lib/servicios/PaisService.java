package uy.edu.cure.servidor.central.lib.servicios;

import uy.edu.cure.servidor.central.dto.Pais;

public interface PaisService {
    void agregar(Integer id, Pais pais);

    void eliminar(Integer id);

    void modificar(Integer id, Pais pais);

    Pais obtener(Integer id);
}
