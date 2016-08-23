package uy.edu.cure.servidor.central.lib.servicios;

import uy.edu.cure.servidor.central.dto.Pais;

public interface PaisService {
    void agregar(Pais pais);

    void eliminar(Pais pais);

    void modificar(Pais anterior, Pais nuevo);

    Pais buscar(Pais pais);
}
