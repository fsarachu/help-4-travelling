package uy.edu.cure.servidor.central.lib.servicios.memoria;

import uy.edu.cure.servidor.central.dto.Producto;
import uy.edu.cure.servidor.central.lib.servicios.ProductoService;

public class ProductoServiceImpl extends GenericServiceImpl<Producto> implements ProductoService {
    private static ProductoServiceImpl ourInstance = new ProductoServiceImpl();

    public static ProductoServiceImpl getInstance() {
        return ourInstance;
    }

    private ProductoServiceImpl() {
        super();
    }
}
