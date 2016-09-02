package uy.edu.cure.servidor.central.lib.servicios.memoria;

import uy.edu.cure.servidor.central.dto.Categoria;
import uy.edu.cure.servidor.central.lib.servicios.CategoriaService;

public class CategoriaServiceImpl extends GenericService<Categoria> implements CategoriaService {

    private static CategoriaServiceImpl ourInstance = new CategoriaServiceImpl();

    public static CategoriaServiceImpl getInstance() {
        return ourInstance;
    }

    private CategoriaServiceImpl() {
        super();
    }

}
