package uy.edu.cure.servidor.central.lib.servicios.memoria;

import uy.edu.cure.servidor.central.dto.Servicio;
import uy.edu.cure.servidor.central.lib.servicios.ServicioService;

public class ServicioServiceImpl implements ServicioService {
    private static ServicioServiceImpl ourInstance = new ServicioServiceImpl();

    public static ServicioServiceImpl getInstance() {
        return ourInstance;
    }

    private ServicioServiceImpl() {
    }

    @Override
    public void agregar(Servicio servicio) {

    }

    @Override
    public void eliminar(Servicio servicio) {

    }

    @Override
    public void modificar(Servicio anterior, Servicio nuevo) {

    }

    @Override
    public Servicio buscar(Servicio servicio) {
        return null;
    }
}
