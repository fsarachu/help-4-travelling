package uy.edu.cure.servidor.central.lib.servicios;

import uy.edu.cure.servidor.central.dto.Categoria;

import java.util.ArrayList;

public interface CategoriaService {
    void agregar(Integer id, Categoria categoria);

    void eliminar(Integer id);

    void modificar(Integer id, Categoria categoria);

    Categoria obtener(Integer id);

    ArrayList<Categoria> listar();
}
