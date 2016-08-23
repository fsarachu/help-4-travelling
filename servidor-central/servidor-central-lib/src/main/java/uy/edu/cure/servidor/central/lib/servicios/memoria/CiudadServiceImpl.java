package uy.edu.cure.servidor.central.lib.servicios.memoria;

import uy.edu.cure.servidor.central.dto.Ciudad;
import uy.edu.cure.servidor.central.lib.servicios.CiudadService;

public class CiudadServiceImpl implements CiudadService {
    private static CiudadServiceImpl ourInstance = new CiudadServiceImpl();

    public static CiudadServiceImpl getInstance() {
        return ourInstance;
    }

    private CiudadServiceImpl() {
    }

    @Override
    public void agregar(Ciudad ciudad) {

    }

    @Override
    public void eliminar(Ciudad ciudad) {

    }

    @Override
    public void modificar(Ciudad anterior, Ciudad nuevo) {

    }

    @Override
    public Ciudad buscar(Ciudad ciudad) {
        return null;
    }
}
