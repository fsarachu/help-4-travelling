package uy.edu.cure.servidor.central.lib.servicios.memoria;

import uy.edu.cure.servidor.central.dto.ItemReserva;
import uy.edu.cure.servidor.central.lib.servicios.ItemReservaService;

public class ItemReservaServiceImpl extends GenericServiceImpl<ItemReserva> implements ItemReservaService {

    private static ItemReservaServiceImpl ourInstance = new ItemReservaServiceImpl();

    public static ItemReservaServiceImpl getInstance() {
        return ourInstance;
    }

    private ItemReservaServiceImpl() {
        super();
    }
}
