package uy.edu.cure.servidor.central.lib.servicios.memoria;

import uy.edu.cure.servidor.central.dto.Ciudad;
import uy.edu.cure.servidor.central.lib.servicios.CiudadService;

import java.util.Map;

public class CiudadServiceImpl extends GenericServiceImpl<Ciudad> implements CiudadService {

    private static CiudadServiceImpl ourInstance = new CiudadServiceImpl();

    public static CiudadServiceImpl getInstance() {
        return ourInstance;
    }

    private CiudadServiceImpl() { super();  }

    public Integer nextId() {
        Integer maxId = 0;
        for (Map.Entry<Integer, Ciudad> entry : coleccion.entrySet()) {
            if (entry.getValue().getId() > maxId) {
                maxId = entry.getValue().getId();
            }
        }

        return maxId + 1;
    }
}
