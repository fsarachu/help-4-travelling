package uy.edu.cure.servidor.central.lib.servicios.memoria;


import uy.edu.cure.servidor.central.dto.Carrito;
import uy.edu.cure.servidor.central.lib.servicios.CarritoService;

import java.util.Map;

public class CarritoServiceImpl extends GenericServiceImpl<Carrito> implements CarritoService {

    private static CarritoServiceImpl ourInstance = new CarritoServiceImpl();

    public static CarritoServiceImpl getInstance() {
        return ourInstance;
    }

    private CarritoServiceImpl() {
        super();
    }

    public Integer nextId() {
        Integer maxId = 0;
        for (Map.Entry<Integer, Carrito> entry : coleccion.entrySet()) {
            if (entry.getValue().getId() > maxId) {
                maxId = entry.getValue().getId();
            }
        }

        return maxId + 1;
    }

}
