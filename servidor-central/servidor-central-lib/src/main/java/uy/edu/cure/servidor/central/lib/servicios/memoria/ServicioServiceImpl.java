package uy.edu.cure.servidor.central.lib.servicios.memoria;

import uy.edu.cure.servidor.central.lib.servicios.ServicioService;
import uy.edu.cure.servidor.central.dto.Servicio;
import uy.edu.cure.servidor.central.lib.servicios.ServicioService;

import java.util.ArrayList;
import java.util.HashMap;

public class ServicioServiceImpl implements ServicioService {

    private HashMap<Integer, Servicio> servicios;

    private static ServicioServiceImpl ourInstance = new ServicioServiceImpl();

    public static ServicioServiceImpl getInstance() {
        return ourInstance;
    }

    private ServicioServiceImpl() {
        servicios = new HashMap<>();
    }

    @Override
    public void agregar(Servicio servicio) {
        this.servicios.put(servicio.getId(), servicio);
    }


    @Override
    public void eliminar(Servicio servicio) {
        this.servicios.remove(servicio.getId());
    }

    @Override
    public void modificar(Servicio servicio) {
        this.servicios.put(servicio.getId(), servicio);
    }

    @Override
    public Servicio obtener(int id) {
        return servicios.get(id);
    }
}
