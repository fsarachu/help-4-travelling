package uy.edu.cure.servidor.central.lib.servicios.memoria;
import uy.edu.cure.servidor.central.lib.servicios.ServicioService;
import uy.edu.cure.servidor.central.dto.Servicio;
import uy.edu.cure.servidor.central.lib.servicios.ServicioService;

import java.util.ArrayList;

public class ServicioServiceImpl implements ServicioService {

    private ArrayList<Servicio> servicios;

    private static ServicioServiceImpl ourInstance = new ServicioServiceImpl();

    public static ServicioServiceImpl getInstance() {
        return ourInstance;
    }

    private ServicioServiceImpl() {
    }

    @Override
    public void agregar(Servicio servicio) {
        this.servicios.add(servicio)
    }

    ;


    @Override
    public void eliminar(Servicio servicio) {
        int index = this.servicios.indexOf(servicio);

        if (index != -1) {
            this.servicios.remove(index);
        }
    }

    @Override
    public void modificar(Servicio anterior, Servicio nuevo) {
        int index = this.servicios.indexOf(anterior);

        if (index != -1) {
            this.servicios.remove(index);
            this.servicios.add(nuevo);
        }
    }

    @Override
    public Servicio obtener(String nombre) {
        for (Servicio servicio : this.servicios) {
            if (servicio.getNombre().equals(nombre)) {
                return servicio;
            }
        }
        return null;
    }
}
