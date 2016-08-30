package uy.edu.cure.servidor.central.lib.servicios.memoria;

import uy.edu.cure.servidor.central.dto.Pais;
import uy.edu.cure.servidor.central.lib.servicios.PaisService;

import java.util.ArrayList;

public class PaisServiceImpl implements PaisService {

    private ArrayList<Pais> paises;

    private static PaisServiceImpl ourInstance = new PaisServiceImpl();

    public static PaisServiceImpl getInstance() {
        return ourInstance;
    }

    private PaisServiceImpl() {
    }

    @Override
    public void agregar(Pais pais) {
        this.paises.add(pais);
    }

    @Override
    public void eliminar(Pais pais) {
        int index = this.paises.indexOf(pais);

        if (index != -1) {
            this.paises.remove(index);
        }
    }

    @Override
    public void modificar(Pais anterior, Pais nuevo) {
        int index = this.paises.indexOf(anterior);

        if (index != -1) {
            this.paises.remove(index);
            this.paises.add(nuevo);
        }
    }

    @Override
    public Pais obtener(String nombre) {
        for (Pais pais : this.paises) {
            if (pais.getNombre().equals(nombre)) {
                return pais;
            }
        }
        return null;
    }
}
