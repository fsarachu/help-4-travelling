package uy.edu.cure.servidor.central.lib.servicios;

import uy.edu.cure.servidor.central.dto.Categoria;

public interface CategoriaService {
    void agregar(Integer id, Categoria categoria);

    void eliminar(Integer id);

    void modificar(Integer id, Categoria nuevo);

    Categoria obtener(int id);
}
