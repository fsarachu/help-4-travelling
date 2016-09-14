package uy.edu.cure.servidor.central.lib.servicios.memoria;


import uy.edu.cure.servidor.central.dto.Carrito;
import uy.edu.cure.servidor.central.lib.servicios.CarritoService;

public class CarritoServiceImpl extends GenericServiceImpl<Carrito> implements CarritoService {

    private static CarritoServiceImpl ourInstance = new CarritoServiceImpl();

    public static CarritoServiceImpl getInstance() {
        return ourInstance;
    }

    private CarritoServiceImpl() {
        super();
    }

}
