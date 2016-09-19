package uy.edu.cure.servidor.central.lib.servicios;

import uy.edu.cure.servidor.central.dto.Cliente;

public interface ClienteService extends GenericService<Cliente> {
    boolean nicknameExiste(String nickname);
    boolean emailExiste(String nickname);
}
