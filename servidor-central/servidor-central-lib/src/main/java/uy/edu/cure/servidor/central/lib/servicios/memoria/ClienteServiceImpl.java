package uy.edu.cure.servidor.central.lib.servicios.memoria;

import uy.edu.cure.servidor.central.dto.Cliente;
import uy.edu.cure.servidor.central.dto.Usuario;
import uy.edu.cure.servidor.central.lib.servicios.ClienteService;

import java.util.ArrayList;

public class ClienteServiceImpl implements ClienteService {

    private ArrayList<Usuario> usuarios;

    private static ClienteServiceImpl ourInstance = new ClienteServiceImpl();

    public static ClienteServiceImpl getInstance() {
        return ourInstance;
    }

    private ClienteServiceImpl() {
    }

    @Override
    public void agregar(Usuario usuario) {
        this.usuarios.add(usuario);
    }

    @Override
    public void eliminar(Usuario usuario) {
        int index = this.usuarios.indexOf(usuario);
        if ( index != -1){
            this.usuarios.remove(index);
        }
    }

    @Override
    public void modificar(Usuario anterior, Usuario nuevo) {
        int index = this.usuarios.indexOf(anterior);

        if ( index != -1){
            this.usuarios.remove(index);
            this.usuarios.add(nuevo);
        }

    }

    @Override
    public Usuario obtener(String nickname) {
        for (Usuario usuario : this.usuarios) {
            if (usuario.getNickname().equals(nickname)) {
                return usuario;
            }
        }
        return null;
    }
}
