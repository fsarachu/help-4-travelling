package uy.edu.cure.servidor.central.lib.servicios;

import uy.edu.cure.servidor.central.dto.Usuario;

/**
 * Created by victor on 22/08/16.
 */
public interface ClienteService {
    public void agregar(Usuario usuario);
    public void eliminar(Usuario usuario);
    public void modificar(Usuario anterior, Usuario nuevo);
    public Usuario buscar(Usuario usuario);

}
