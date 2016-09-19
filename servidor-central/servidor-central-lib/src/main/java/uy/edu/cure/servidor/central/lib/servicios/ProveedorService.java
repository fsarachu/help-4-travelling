package uy.edu.cure.servidor.central.lib.servicios;

import uy.edu.cure.servidor.central.dto.Proveedor;

public interface ProveedorService extends GenericService<Proveedor> {
    boolean nicknameExiste(String nickname);
    boolean emailExiste(String nickname);
}
