package uy.edu.cure.servidor.central.lib.servicios.memoria;

import uy.edu.cure.servidor.central.dto.Proveedor;
import uy.edu.cure.servidor.central.lib.servicios.ProveedorService;

public class ProveedorServiceImpl implements ProveedorService {
    private static ProveedorServiceImpl ourInstance = new ProveedorServiceImpl();

    public static ProveedorServiceImpl getInstance() {
        return ourInstance;
    }

    private ProveedorServiceImpl() {
    }

    @Override
    public void agregar(Proveedor proveedor) {

    }

    @Override
    public void eliminar(Proveedor proveedor) {

    }

    @Override
    public void modificar(Proveedor anterior, Proveedor nuevo) {

    }

    @Override
    public Proveedor buscar(Proveedor proveedor) {
        return null;
    }
}
