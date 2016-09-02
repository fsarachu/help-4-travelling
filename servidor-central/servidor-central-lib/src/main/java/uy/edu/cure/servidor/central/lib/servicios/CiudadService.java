package uy.edu.cure.servidor.central.lib.servicios;

import uy.edu.cure.servidor.central.dto.Ciudad;

public interface CiudadService {
    void agregar(Integer id, Ciudad ciudad);

    void eliminar(Integer id);

    void modificar(Integer id, Ciudad ciudad);

    Ciudad obtener(Integer id);

}
