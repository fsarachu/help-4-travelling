package uy.edu.cure.servidor.central.lib.servicios.memoria;

import uy.edu.cure.servidor.central.dto.*;
import uy.edu.cure.servidor.central.lib.servicios.ProductoService;

import java.util.ArrayList;
import java.util.Map;

public class ProductoServiceImpl extends GenericServiceImpl<Producto> implements ProductoService {
    private static ProductoServiceImpl ourInstance = new ProductoServiceImpl();

    public static ProductoServiceImpl getInstance() {
        return ourInstance;
    }

    private ProductoServiceImpl() {
        super();
    }

    public Integer nextId() {
        Integer maxId = 0;
        for (Map.Entry<Integer, Producto> entry : coleccion.entrySet()) {
            if (entry.getValue().getId() > maxId) {
                maxId = entry.getValue().getId();
            }
        }

        return maxId + 1;
    }

    public ArrayList<Servicio> listarServicios() {
        ArrayList<Servicio> servicios = new ArrayList<>();
        Producto producto;

        for (Map.Entry<Integer, Producto> entry : coleccion.entrySet()) {
            producto = entry.getValue();

            if (producto.getTipo() == TipoProducto.servicio) {
                servicios.add((Servicio) producto);
            }
        }

        return servicios;
    }

    public ArrayList<Promocion> listarPromociones() {
        ArrayList<Promocion> promociones = new ArrayList<>();
        Producto producto;

        for (Map.Entry<Integer, Producto> entry : coleccion.entrySet()) {
            producto = entry.getValue();

            if (producto.getTipo() == TipoProducto.promocion) {
                promociones.add((Promocion) producto);
            }
        }

        return promociones;
    }

    @Override
    public ArrayList<Servicio> listarServiciosPorCiudad(Ciudad ciudad) {
        ArrayList<Servicio> servicios = new ArrayList<>();
        Producto producto;

        for (Map.Entry<Integer, Producto> entry : coleccion.entrySet()) {
            producto = entry.getValue();

            if (producto.getTipo() == TipoProducto.servicio) {
                Servicio servicio = (Servicio) producto;
                if (servicio.getOrigen() == ciudad || servicio.getDestino() == ciudad) {
                    servicios.add((Servicio) producto);
                }
            }
        }

        return servicios;
    }

}
