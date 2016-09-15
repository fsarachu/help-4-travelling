package uy.edu.cure.servidor.central.lib.servicios;

import uy.edu.cure.servidor.central.dto.Categoria;

import java.util.ArrayList;

public interface CategoriaService extends GenericService<Categoria> {

    ArrayList<Categoria> listarHijos(Categoria categoria);
}
