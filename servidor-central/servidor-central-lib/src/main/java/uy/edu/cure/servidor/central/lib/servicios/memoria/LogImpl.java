package uy.edu.cure.servidor.central.lib.servicios.memoria;


import uy.edu.cure.servidor.central.dto.Log;
import uy.edu.cure.servidor.central.lib.servicios.LogService;

import java.util.ArrayList;
import java.util.Map;


public class LogImpl extends GenericServiceImpl<Log> implements LogService {
    private static LogImpl ourInstance = new LogImpl();

    public static LogImpl getInstance() {
        return ourInstance;
    }

    private LogImpl() {
        super();
    }

    @Override

    public void agregarLog(){
    }

    @Override
    public Integer nextId() {
        return null;
    }
}



   /* public ArrayList<Log> listarServiciosPorCategoria(Categoria categoria) {
        ArrayList<Log> servicios = new ArrayList<>();

        for (Map.Entry<Integer, Producto> entry : coleccion.entrySet()) {
            Producto producto = entry.getValue();

            if (producto.getTipo() == TipoProducto.servicio) {
                Log servicio = (Log) producto;
                for (int i = 0; i < servicio.getCategorias().size(); i++) {

                    if (servicio.getCategorias().get(i).getId().equals(categoria.getId())) {
                        servicios.add(servicio);
                    }
                }

            }
        }

        return servicios;

          }*/


