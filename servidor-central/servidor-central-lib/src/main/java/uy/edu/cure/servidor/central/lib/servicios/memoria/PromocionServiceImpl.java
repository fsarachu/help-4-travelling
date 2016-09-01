package uy.edu.cure.servidor.central.lib.servicios.memoria;

import uy.edu.cure.servidor.central.dto.Promocion;
import uy.edu.cure.servidor.central.lib.servicios.PromocionService;

import java.util.ArrayList;

public class PromocionServiceImpl implements PromocionService {

    private ArrayList<Promocion> promociones;

    private static PromocionServiceImpl ourInstance = new PromocionServiceImpl();

    public static PromocionServiceImpl getInstance() {
        return ourInstance;
    }

    private PromocionServiceImpl() {
    }

    @Override
    public void agregar(Promocion promocion) {
        this.promociones.add(promocion);
    }

    @Override
    public void eliminar(Promocion promocion) {
        int index = this.promociones.indexOf(promocion);

        if (index != -1) {
            this.promociones.remove(index);
        }
    }

    @Override
    public void modificar(Promocion anterior, Promocion nueva) {
        int index = this.promociones.indexOf(anterior);

        if (index != -1) {
            this.promociones.remove(index);
            this.promociones.add(nueva);
        }
    }

    @Override
    public Promocion obtener(String nombre) {
        for (Promocion promocion : this.promociones) {
            if (promocion.getNombre().equals(nombre)) {
                return promocion;
            }
        }
        return null;
    }
}
