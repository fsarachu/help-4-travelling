package uy.edu.cure.servidor.central.lib.servicios.memoria;

import uy.edu.cure.servidor.central.dto.Pais;
import uy.edu.cure.servidor.central.lib.servicios.PaisService;

import java.util.Map;

public class PaisServiceImpl extends GenericServiceImpl<Pais> implements PaisService {

    private static PaisServiceImpl ourInstance = new PaisServiceImpl();

    public static PaisServiceImpl getInstance() {
        return ourInstance;
    }

    private PaisServiceImpl() {
        super();
    }

    public Integer nextId() {
        Integer maxId = 0;
        for (Map.Entry<Integer, Pais> entry : coleccion.entrySet()) {
            if (entry.getValue().getId() > maxId) {
                maxId = entry.getValue().getId();
            }
        }
        return maxId + 1;
    }
}
