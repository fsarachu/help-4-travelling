package uy.edu.cure.servidor.central.lib.servicios;

import uy.edu.cure.servidor.central.dto.Categoria;

public interface CategoriaService {
    void agregar(Categoria categoria);

    void eliminar(Categoria categoria);

    void modificar(Categoria anterior, Categoria nuevo);

    Categoria obtener(String nombre);
}
