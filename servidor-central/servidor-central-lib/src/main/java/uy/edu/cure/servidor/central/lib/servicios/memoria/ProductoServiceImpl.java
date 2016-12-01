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


    @Override
    public ArrayList<Servicio> listarServiciosPorCategoria(Categoria categoria) {
        ArrayList<Servicio> servicios = new ArrayList<>();

        for (Map.Entry<Integer, Producto> entry : coleccion.entrySet()) {
            Producto producto = entry.getValue();

            if (producto.getTipo() == TipoProducto.servicio) {
                Servicio servicio = (Servicio) producto;
                for (int i = 0; i < servicio.getCategorias().size(); i++) {

                    if (servicio.getCategorias().get(i).getId().equals(categoria.getId())) {
                        servicios.add(servicio);
                    }
                }

            }
        }

        return servicios;
    }

    public ArrayList<Servicio> listarServicios() {
        ArrayList<Servicio> servicios = new ArrayList<>();

        for (Map.Entry<Integer, Producto> entry : coleccion.entrySet()) {
            Producto producto = entry.getValue();

            if (producto.getTipo() == TipoProducto.servicio) {
                Servicio servicio = (Servicio) producto;
                ArrayList<Categoria> categorias = servicio.getCategorias();

                for (Categoria categoria : categorias) {
                    if (categoria.getEstado().equals(EstadoCategoria.visible)) {
                        servicios.add(servicio);
                        break; //TODO
                    }
                }
            }
        }

        return servicios;
    }

    public ArrayList<Promocion> listarPromociones() {
        ArrayList<Promocion> promociones = new ArrayList<>();

        for (Map.Entry<Integer, Producto> entry : coleccion.entrySet()) {
            Producto producto = entry.getValue();

            if (producto.getTipo() == TipoProducto.promocion) {
                promociones.add((Promocion) producto);
            }
        }

        return promociones;
    }

    @Override
    public ArrayList<Promocion> listarPromocionesPorCategoria(Categoria categoria) {
        ArrayList<Promocion> promociones = new ArrayList<>();

        for (Map.Entry<Integer, Producto> entry : coleccion.entrySet()) {
            Producto producto = entry.getValue();

            if (producto.getTipo() == TipoProducto.promocion) {
                Promocion promocion = (Promocion) producto;
                ArrayList<Servicio> serviciosPromocion = promocion.getServicios();

                for (Servicio servicio : serviciosPromocion) {
                    if (servicio.getCategorias().contains(categoria)) {
                        promociones.add(promocion);
                    }
                }
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

    @Override
    public ArrayList<Producto> listarServiciosXProveedor(Integer idproveedor) {
        ArrayList<Producto> productos = new ArrayList<>();
        Producto producto;

        for (Map.Entry<Integer, Producto> entry : coleccion.entrySet()) {
            producto = entry.getValue();

            if (producto.getProveedor().getId().equals(idproveedor)) {
                productos.add(producto);
            }
        }
        return productos;
    }

}
