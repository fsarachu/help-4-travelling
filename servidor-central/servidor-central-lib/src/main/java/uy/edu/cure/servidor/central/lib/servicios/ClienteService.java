package uy.edu.cure.servidor.central.lib.servicios;

import uy.edu.cure.servidor.central.dto.Cliente;

public interface ClienteService {
    void agregar(Integer id, Cliente cliente);

    void eliminar(Integer id);

    void modificar(Integer id, Cliente cliente);

    Cliente obtener(Integer id);

}
