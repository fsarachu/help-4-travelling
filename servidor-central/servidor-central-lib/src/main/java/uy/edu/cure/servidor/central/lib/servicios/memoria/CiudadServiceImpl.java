package uy.edu.cure.servidor.central.lib.servicios.memoria;

import uy.edu.cure.servidor.central.dto.Ciudad;
import uy.edu.cure.servidor.central.lib.servicios.CiudadService;

public class CiudadServiceImpl extends GenericService<Ciudad> implements CiudadService {

    private static CiudadServiceImpl ourInstance = new CiudadServiceImpl();

    public static CiudadServiceImpl getInstance() {
        return ourInstance;
    }

    private CiudadServiceImpl() {
        super();
    }
}
