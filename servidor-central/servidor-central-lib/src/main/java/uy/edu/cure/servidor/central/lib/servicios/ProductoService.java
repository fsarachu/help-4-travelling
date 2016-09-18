package uy.edu.cure.servidor.central.lib.servicios;

import uy.edu.cure.servidor.central.dto.Producto;
import uy.edu.cure.servidor.central.dto.Promocion;
import uy.edu.cure.servidor.central.dto.Servicio;

import java.util.ArrayList;

public interface ProductoService extends GenericService<Producto> {

    public ArrayList<Servicio> listarServicios();

    public ArrayList<Promocion> listarPromociones();

    public Servicio obtener(Integer idServicio);

}
