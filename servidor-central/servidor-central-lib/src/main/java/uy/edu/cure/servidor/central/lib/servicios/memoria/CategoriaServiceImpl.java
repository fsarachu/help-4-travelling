package uy.edu.cure.servidor.central.lib.servicios.memoria;

import uy.edu.cure.servidor.central.dto.Categoria;
import uy.edu.cure.servidor.central.lib.servicios.CategoriaService;

import java.util.Map;

public class CategoriaServiceImpl extends GenericServiceImpl<Categoria> implements CategoriaService {

    private static CategoriaServiceImpl ourInstance = new CategoriaServiceImpl();

    public static CategoriaServiceImpl getInstance() {
        return ourInstance;
    }

    private CategoriaServiceImpl() {
        super();
    }

    public Integer nextId() {
        Integer maxId = 0;
        for (Map.Entry<Integer, Categoria> entry : coleccion.entrySet()) {
            if (entry.getValue().getId() > maxId) {
                maxId = entry.getValue().getId();
            }
        }

        return maxId + 1;
    }
}
