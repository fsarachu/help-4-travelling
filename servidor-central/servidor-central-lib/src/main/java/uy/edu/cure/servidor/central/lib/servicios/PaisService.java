package uy.edu.cure.servidor.central.lib.servicios;

import uy.edu.cure.servidor.central.dto.Pais;

/**
 * Created by victor on 22/08/16.
 */
public interface PaisService {
    public void agregar(Pais pais);

    public void eliminar(Pais pais);

    public void modificar(Pais anterior, Pais nuevo);

    public Pais buscar(Pais pais);
}
