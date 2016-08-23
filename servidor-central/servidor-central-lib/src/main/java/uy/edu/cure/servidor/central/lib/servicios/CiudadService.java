package uy.edu.cure.servidor.central.lib.servicios;

import uy.edu.cure.servidor.central.dto.Ciudad;

/**
 * Created by victor on 22/08/16.
 */
public interface CiudadService {
    public void agregar(Ciudad ciudad);
    public void eliminar(Ciudad ciudad);
    public void modificar(Ciudad anterior, Ciudad nuevo);
    public Ciudad buscar(Ciudad ciudad);

}
