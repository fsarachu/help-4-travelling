package uy.edu.cure.servidor.central.lib.servicios.memoria;

import uy.edu.cure.servidor.central.dto.Proveedor;
import uy.edu.cure.servidor.central.lib.servicios.ProveedorService;

import java.util.Map;

public class ProveedorServiceImpl extends GenericServiceImpl<Proveedor> implements ProveedorService {

    private static ProveedorServiceImpl ourInstance = new ProveedorServiceImpl();

    public static ProveedorServiceImpl getInstance() {
        return ourInstance;
    }

    private ProveedorServiceImpl() {
        super();
    }

    public Integer nextId() {
        Integer maxId = 0;
        for (Map.Entry<Integer, Proveedor> entry : coleccion.entrySet()) {
            if (entry.getValue().getId() > maxId) {
                maxId = entry.getValue().getId();
            }
        }

        return maxId + 1;
    }
}
