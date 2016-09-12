package uy.edu.cure.servidor.central.lib.servicios.memoria;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class GenericService<T> {
    protected HashMap<Integer, T> coleccion;
    protected int identity;

    protected GenericService() {
        this.coleccion = new HashMap<>();
        identity = 0;
    }

    public void agregar(Integer id, T value) {
        this.coleccion.put(id, value);
        identity++;
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

    public int getKey(){
        /*
        int res = 0;
        for(Integer entry : coleccion.keySet() ){
            if( entry > res){
                res = entry;
           }
        }
        System.out.println(res  + "  "+ identity );*/
        return this.identity;
    }
}
