package uy.edu.cure.servidor.central.lib.servicios;

import uy.edu.cure.servidor.central.dto.Ciudad;

public interface CiudadService {
    void agregar(Ciudad ciudad);

    void eliminar(Ciudad ciudad);

    void modificar(Ciudad anterior, Ciudad nuevo);

    Ciudad buscar(Ciudad ciudad);

}
