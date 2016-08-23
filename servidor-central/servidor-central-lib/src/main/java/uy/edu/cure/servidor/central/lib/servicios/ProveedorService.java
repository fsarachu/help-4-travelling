package uy.edu.cure.servidor.central.lib.servicios;

import uy.edu.cure.servidor.central.dto.Proveedor;

/**
 * Created by victor on 22/08/16.
 */
public interface ProveedorService {
    public void agregar(Proveedor proveedor);
    public void eliminar(Proveedor proveedor);
    public void modificar(Proveedor anterior, Proveedor nuevo);
    public Proveedor buscar(Proveedor proveedor);
}
