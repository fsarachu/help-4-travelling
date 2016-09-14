package uy.edu.cure.servidor.central.lib.servicios.memoria;

import uy.edu.cure.servidor.central.lib.servicios.ServicioService;
import uy.edu.cure.servidor.central.dto.Servicio;

public class ServicioServiceImpl extends GenericServiceImpl<Servicio> implements ServicioService {

    private static ServicioServiceImpl ourInstance = new ServicioServiceImpl();

    public static ServicioServiceImpl getInstance() {
        return ourInstance;
    }

    private ServicioServiceImpl() {
        super();
    }

}
