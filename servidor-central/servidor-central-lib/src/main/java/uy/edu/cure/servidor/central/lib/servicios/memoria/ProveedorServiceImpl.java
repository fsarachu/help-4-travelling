package uy.edu.cure.servidor.central.lib.servicios.memoria;

import uy.edu.cure.servidor.central.dto.Proveedor;
import uy.edu.cure.servidor.central.lib.servicios.ProveedorService;

public class ProveedorServiceImpl extends GenericServiceImpl<Proveedor> implements ProveedorService {

    private static ProveedorServiceImpl ourInstance = new ProveedorServiceImpl();

    public static ProveedorServiceImpl getInstance() {
        return ourInstance;
    }

    private ProveedorServiceImpl() {
        super();
    }
}
