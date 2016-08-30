package uy.edu.cure.servidor.central.lib.servicios.memoria;

import uy.edu.cure.servidor.central.dto.Proveedor;
import uy.edu.cure.servidor.central.lib.servicios.ProveedorService;

import java.util.ArrayList;

public class ProveedorServiceImpl implements ProveedorService {

    private ArrayList<Proveedor> proveedores;

    private static ProveedorServiceImpl ourInstance = new ProveedorServiceImpl();

    public static ProveedorServiceImpl getInstance() {
        return ourInstance;
    }

    private ProveedorServiceImpl() {
    }

    @Override
    public void agregar(Proveedor proveedor) {
        this.proveedores.add(proveedor);
    }

    @Override
    public void eliminar(Proveedor proveedor) {
        int index = this.proveedores.indexOf(proveedor);
        if ( index != -1){
            this.proveedores.remove(index);
        }
    }

    @Override
    public void modificar(Proveedor anterior, Proveedor nuevo) {
        int index = this.proveedores.indexOf(anterior);

        if ( index != -1){
            this.proveedores.remove(index);
            this.proveedores.add(nuevo);
        }

    }

    @Override
    public Proveedor obtener(String nombreEmpresa) {
        for (Proveedor proveedor : this.proveedores) {
            if (proveedor.getNombreEmpresa().equals(nombreEmpresa)) {
                return proveedor;
            }
        }
        return null;
    }
}
