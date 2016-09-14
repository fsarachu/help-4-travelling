package uy.edu.cure.servidor.central.lib.servicios.memoria;

import uy.edu.cure.servidor.central.dto.Producto;
import uy.edu.cure.servidor.central.lib.servicios.ProductoService;

import java.util.Map;

public class ProductoServiceImpl extends GenericServiceImpl<Producto> implements ProductoService {
    private static ProductoServiceImpl ourInstance = new ProductoServiceImpl();

    public static ProductoServiceImpl getInstance() {
        return ourInstance;
    }

    private ProductoServiceImpl() {
        super();
    }

    public Integer nextId() {
        Integer maxId = 0;
        for (Map.Entry<Integer, Producto> entry : coleccion.entrySet()) {
            if (entry.getValue().getId() > maxId) {
                maxId = entry.getValue().getId();
            }
        }

        return maxId + 1;
    }
}
