package uy.edu.cure.servidor.central.lib.servicios.memoria;

import uy.edu.cure.servidor.central.dto.Reserva;
import uy.edu.cure.servidor.central.lib.servicios.OrdenService;

public class OrdenServiceImpl extends GenericService<Reserva> implements OrdenService {

    private static OrdenServiceImpl ourInstance = new OrdenServiceImpl();

    public static OrdenServiceImpl getInstance() {
        return ourInstance;
    }

    private OrdenServiceImpl() {
        super();
    }
}
