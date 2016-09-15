package uy.edu.cure.servidor.central.lib.servicios;

import java.util.ArrayList;

public interface GenericService<T> {
    void agregar(Integer id, T obj);

    void eliminar(Integer id);

    void modificar(Integer id, T obj);

    T obtener(Integer id);

    ArrayList<T> listar();

    Integer nextId();
}
