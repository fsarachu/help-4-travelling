package uy.edu.cure.servidor.central.lib.servicios.memoria;

import uy.edu.cure.servidor.central.dto.Cliente;
import uy.edu.cure.servidor.central.dto.Usuario;
import uy.edu.cure.servidor.central.lib.servicios.ClienteService;

import java.util.ArrayList;

public class ClienteServiceImpl implements ClienteService {

    private ArrayList<Usuario> clientes;

    private static ClienteServiceImpl ourInstance = new ClienteServiceImpl();

    public static ClienteServiceImpl getInstance() {
        return ourInstance;
    }

    private ClienteServiceImpl() {
    }

    @Override
    public void agregar(Usuario usuario) {
        this.clientes.add(usuario);
    }

    @Override
    public void eliminar(Usuario usuario) {

    }

    @Override
    public void modificar(Usuario anterior, Usuario nuevo) {

    }

    @Override
    public Usuario obtener(String nickname) {
        return null;
    }
}
