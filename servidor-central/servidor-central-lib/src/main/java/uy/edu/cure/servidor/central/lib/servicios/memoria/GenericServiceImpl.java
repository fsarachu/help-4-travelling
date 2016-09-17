package uy.edu.cure.servidor.central.lib.servicios.memoria;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Vector;

public class GenericServiceImpl<T> {
    protected HashMap<Integer, T> coleccion;

    protected GenericServiceImpl() {
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

    public T obtener(Integer id) {
        return coleccion.get(id);
    }

    public ArrayList<T> listar() {
        ArrayList<T> list = new ArrayList<>();

        for (Entry<Integer, T> entry : coleccion.entrySet()) {
            list.add(entry.getValue());
        }

        return list;
    }

    public void vaciar() {
        this.coleccion.clear();
    }

}
