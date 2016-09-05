package uy.edu.cure.servidor.central.lib.servicios;

import uy.edu.cure.servidor.central.dto.Servicio;

import java.util.ArrayList;

public interface ServicioService {
    void agregar(Integer id, Servicio servicio);

    void eliminar(Integer id);

    void modificar(Integer id, Servicio servicio);

    Servicio obtener(Integer id);

    ArrayList<Servicio> listar();

}
