package uy.edu.cure.servidor.central.lib.servicios.memoria;

import uy.edu.cure.servidor.central.dto.Pais;
import uy.edu.cure.servidor.central.lib.servicios.PaisService;

public class PaisServiceImpl extends GenericServiceImpl<Pais> implements PaisService {

    private static PaisServiceImpl ourInstance = new PaisServiceImpl();

    public static PaisServiceImpl getInstance() {
        return ourInstance;
    }

    private PaisServiceImpl() {
        super();
    }
}
