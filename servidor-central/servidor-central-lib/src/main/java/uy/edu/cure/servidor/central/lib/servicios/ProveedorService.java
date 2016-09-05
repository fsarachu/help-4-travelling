package uy.edu.cure.servidor.central.lib.servicios;

import uy.edu.cure.servidor.central.dto.Proveedor;

import java.util.ArrayList;

public interface ProveedorService {
    void agregar(Integer id, Proveedor proveedor);

    void eliminar(Integer id);

    void modificar(Integer id, Proveedor proveedor);

    Proveedor obtener(Integer id);

    ArrayList<Proveedor> listar();
}
