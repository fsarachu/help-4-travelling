package uy.edu.cure.servidor.central.lib.servicios;

import uy.edu.cure.servidor.central.dto.Categoria;

public interface CategoriaService {
    public void agregar(Categoria categoria);
    public void eliminar(Categoria categoria);
    public void modificar(Categoria anterior, Categoria nuevo);
    public Categoria buscar(Categoria categoria);
}
