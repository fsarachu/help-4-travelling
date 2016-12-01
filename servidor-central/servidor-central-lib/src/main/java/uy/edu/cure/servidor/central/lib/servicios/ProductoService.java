package uy.edu.cure.servidor.central.lib.servicios;

import uy.edu.cure.servidor.central.dto.*;

import java.util.ArrayList;

public interface ProductoService extends GenericService<Producto> {

    ArrayList<Servicio> listarServicios();

    ArrayList<Servicio> listarServiciosPorCategoria(Categoria categoria);

    ArrayList<Promocion> listarPromociones();

    ArrayList<Promocion> listarPromocionesPorCategoria(Categoria categoria);

    ArrayList<Servicio> listarServiciosPorCiudad(Ciudad ciudad);

    ArrayList<Producto> listarServiciosXProveedor(Integer proveedor);
}
