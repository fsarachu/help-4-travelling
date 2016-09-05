package uy.edu.cure.servidor.central.lib.servicios;

import uy.edu.cure.servidor.central.dto.Orden;

import java.util.ArrayList;


public interface OrdenService {
    void agregar(Integer id, Orden orden);

    void eliminar(Integer id);

    void modificar(Integer id, Orden orden);

    Orden obtener(Integer id);

    ArrayList<Orden> listar();
}
