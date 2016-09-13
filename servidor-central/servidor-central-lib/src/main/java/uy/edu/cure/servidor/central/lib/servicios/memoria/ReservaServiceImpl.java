package uy.edu.cure.servidor.central.lib.servicios.memoria;

import uy.edu.cure.servidor.central.dto.Reserva;
import uy.edu.cure.servidor.central.lib.servicios.ReservaService;

public class ReservaServiceImpl extends GenericService<Reserva> implements ReservaService {

    private static ReservaServiceImpl ourInstance = new ReservaServiceImpl();

    public static ReservaServiceImpl getInstance() {
        return ourInstance;
    }

    private ReservaServiceImpl() {
        super();
    }
}
