package uy.edu.cure.servidor.central.lib.servicios.memoria;

import java.util.HashMap;

public class GenericService<T> {
    protected HashMap<Integer, T> coleccion;

    protected GenericService() {
        this.coleccion = new HashMap<>();
    }

    public void agregar(Integer id, T value) {
        this.coleccion.put(id, value);
    }

    public void eliminar(Integer id) {
        this.coleccion.remove(id);
    }

    public void modificar(Integer id, T value) {
        this.coleccion.put(id, value);
    }

    public T obtener(int id) {
        return coleccion.get(id);
    }
}
