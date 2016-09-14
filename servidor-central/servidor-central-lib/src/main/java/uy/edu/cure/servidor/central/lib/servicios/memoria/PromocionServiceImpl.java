package uy.edu.cure.servidor.central.lib.servicios.memoria;

import uy.edu.cure.servidor.central.dto.Promocion;
import uy.edu.cure.servidor.central.lib.servicios.PromocionService;

public class PromocionServiceImpl extends GenericServiceImpl<Promocion> implements PromocionService {

    private static PromocionServiceImpl ourInstance = new PromocionServiceImpl();

    public static PromocionServiceImpl getInstance() {
        return ourInstance;
    }

    private PromocionServiceImpl() {
        super();
    }

}
