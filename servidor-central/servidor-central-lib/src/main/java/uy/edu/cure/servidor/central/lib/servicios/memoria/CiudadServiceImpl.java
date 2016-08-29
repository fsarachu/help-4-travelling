package uy.edu.cure.servidor.central.lib.servicios.memoria;

import uy.edu.cure.servidor.central.dto.Ciudad;
import uy.edu.cure.servidor.central.lib.servicios.CiudadService;

import java.util.ArrayList;

public class CiudadServiceImpl implements CiudadService {

    private ArrayList<Ciudad> ciudades;

    private static CiudadServiceImpl ourInstance = new CiudadServiceImpl();

    public static CiudadServiceImpl getInstance() {
        return ourInstance;
    }

    private CiudadServiceImpl() {
    }

    @Override
    public void agregar(Ciudad ciudad) {
        this.ciudades.add(ciudad);
    }

    @Override
    public void eliminar(Ciudad ciudad) {
        int index = this.ciudades.indexOf(ciudad);

        if ( index != -1){
            this.ciudades.remove(index);
        }
    }

    @Override
    public void modificar(Ciudad anterior, Ciudad nuevo) {
        int index = this.ciudades.indexOf(anterior);

        if ( index != -1){
            this.ciudades.remove(index);
            this.ciudades.add(nuevo);
        }
    }

    @Override
    public Ciudad obtener(String nombre) {
        for (Ciudad ciudad : this.ciudades) {
            if (ciudad.getNombre().equals(nombre)) {
                return ciudad;
            }
        }
        return null;
    }
}
