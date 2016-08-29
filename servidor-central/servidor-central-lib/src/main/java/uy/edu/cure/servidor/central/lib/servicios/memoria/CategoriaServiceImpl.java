package uy.edu.cure.servidor.central.lib.servicios.memoria;

import uy.edu.cure.servidor.central.dto.Categoria;
import uy.edu.cure.servidor.central.lib.servicios.CategoriaService;

import java.util.ArrayList;

public class CategoriaServiceImpl implements CategoriaService {

    private ArrayList<Categoria> categorias;

    private static CategoriaServiceImpl ourInstance = new CategoriaServiceImpl();

    public static CategoriaServiceImpl getInstance() {
        return ourInstance;
    }

    private CategoriaServiceImpl() {
    }

    @Override
    public void agregar(Categoria categoria) {
        this.categorias.add(categoria);
    }

    @Override
    public void eliminar(Categoria categoria) {
        int index = this.categorias.indexOf(categoria);

        if (index != -1) {
            this.categorias.remove(index);
        }
    }

    @Override
    public void modificar(Categoria anterior, Categoria nuevo) {
        int index = this.categorias.indexOf(anterior);

        if (index != -1) {
            this.categorias.remove(index);
            this.categorias.add(nuevo);
        }

    }

    @Override
    public Categoria obtener(String nombre) {
        for (Categoria categoria : this.categorias) {
            if (categoria.getNombre().equals(nombre)) {
                return categoria;
            }
        }
        return null;
    }
}
