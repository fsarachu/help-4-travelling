package uy.edu.cure.servidor.central.lib.servicios.memoria;

import uy.edu.cure.servidor.central.dto.ItemReserva;
import uy.edu.cure.servidor.central.lib.servicios.ItemReservaService;

import java.util.Map;

public class ItemReservaServiceImpl extends GenericServiceImpl<ItemReserva> implements ItemReservaService {

    private static ItemReservaServiceImpl ourInstance = new ItemReservaServiceImpl();

    public static ItemReservaServiceImpl getInstance() {
        return ourInstance;
    }

    private ItemReservaServiceImpl() {
        super();
    }

    public Integer nextId() {
        Integer maxId = 0;
        for (Map.Entry<Integer, ItemReserva> entry : coleccion.entrySet()) {
            if (entry.getValue().getId() > maxId) {
                maxId = entry.getValue().getId();
            }
        }

        return maxId + 1;
    }
}
