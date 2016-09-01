package uy.edu.cure.servidor.central.lib.servicios;

import uy.edu.cure.servidor.central.dto.Cliente;

public interface ClienteService {
    void agregar(Cliente cliente);

    void eliminar(Cliente cliente);

    void modificar(Cliente anterior, Cliente nuevo);

    Cliente obtener(String nickname);

}
