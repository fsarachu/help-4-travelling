package uy.edu.cure.servidor.central.lib.servicios;

import uy.edu.cure.servidor.central.dto.Usuario;

public interface ClienteService {
    void agregar(Usuario usuario);

    void eliminar(Usuario usuario);

    void modificar(Usuario anterior, Usuario nuevo);

    Usuario buscar(Usuario usuario);

}
