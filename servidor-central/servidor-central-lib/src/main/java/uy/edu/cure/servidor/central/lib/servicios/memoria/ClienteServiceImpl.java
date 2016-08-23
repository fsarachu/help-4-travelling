package uy.edu.cure.servidor.central.lib.servicios.memoria;

import uy.edu.cure.servidor.central.dto.Usuario;
import uy.edu.cure.servidor.central.lib.servicios.ClienteService;

public class ClienteServiceImpl implements ClienteService {
    private static ClienteServiceImpl ourInstance = new ClienteServiceImpl();

    public static ClienteServiceImpl getInstance() {
        return ourInstance;
    }

    private ClienteServiceImpl() {
    }

    @Override
    public void agregar(Usuario usuario) {

    }

    @Override
    public void eliminar(Usuario usuario) {

    }

    @Override
    public void modificar(Usuario anterior, Usuario nuevo) {

    }

    @Override
    public Usuario buscar(Usuario usuario) {
        return null;
    }
}
