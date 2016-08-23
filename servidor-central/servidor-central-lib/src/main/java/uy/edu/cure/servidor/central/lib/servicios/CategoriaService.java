package uy.edu.cure.servidor.central.lib.servicios;

import uy.edu.cure.servidor.central.dto.Categoria;

/**
 * Created by victor on 22/08/16.
 */
public interface CategoriaService {
    public void agregar(Categoria categoria);
    public void eliminar(Categoria categoria);
    public void modificar(Categoria anterior, Categoria nuevo);
    public Categoria buscar(Categoria categoria);

}
