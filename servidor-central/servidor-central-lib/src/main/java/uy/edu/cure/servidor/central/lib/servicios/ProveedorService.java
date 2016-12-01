package uy.edu.cure.servidor.central.lib.servicios;

import uy.edu.cure.servidor.central.dto.Proveedor;

public interface ProveedorService extends GenericService<Proveedor> {
    boolean nicknameExiste(String nickname);
    boolean emailExiste(String nickname);
    Proveedor obtenerXNombre(String nombre);
    boolean comprobarlogin(String nickname, String contrasena);
    boolean comprobarloginMail(String email, String contrasena);

}
