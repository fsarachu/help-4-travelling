package uy.edu.cure.servidor.central.lib.servicios;

import uy.edu.cure.servidor.central.dto.Proveedor;

public interface ProveedorService {
    void agregar(Proveedor proveedor);

    void eliminar(Proveedor proveedor);

    void modificar(Proveedor anterior, Proveedor nuevo);

    Proveedor buscar(Proveedor proveedor);
}
