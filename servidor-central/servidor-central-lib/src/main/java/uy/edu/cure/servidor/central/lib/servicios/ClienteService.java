package uy.edu.cure.servidor.central.lib.servicios;

import uy.edu.cure.servidor.central.dto.Cliente;
import uy.edu.cure.servidor.central.dto.Servicio;

import java.util.ArrayList;

public interface ClienteService extends GenericService<Cliente> {
    boolean nicknameExiste(String nickname);

    boolean emailExiste(String nickname);

    boolean comprobarlogin(String nickname, String contrasena);

        ArrayList<Cliente> listarCompradoresServicio(Servicio servicio);
}
