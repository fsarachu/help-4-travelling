package uy.edu.cure.servidor.central.lib.servicios.memoria;

import uy.edu.cure.servidor.central.dto.Cliente;
import uy.edu.cure.servidor.central.dto.Proveedor;
import uy.edu.cure.servidor.central.lib.servicios.ProveedorService;

import java.util.Map;

public class ProveedorServiceImpl extends GenericServiceImpl<Proveedor> implements ProveedorService {

    private static ProveedorServiceImpl ourInstance = new ProveedorServiceImpl();

    public static ProveedorServiceImpl getInstance() {
        return ourInstance;
    }

    private ProveedorServiceImpl() {
        super();
    }

    public Integer nextId() {
        Integer maxId = 0;
        for (Map.Entry<Integer, Proveedor> entry : coleccion.entrySet()) {
            if (entry.getValue().getId() > maxId) {
                maxId = entry.getValue().getId();
            }
        }

        return maxId + 1;
    }

    public Proveedor obtenerXNombre(String nickname) {
        Proveedor proveedor;

        for (Map.Entry<Integer, Proveedor> entry : coleccion.entrySet()) {
            proveedor = entry.getValue();

            if (proveedor.getNickname().equals(nickname)) {
                return proveedor;
            }
        }
        return null;
    }

    @Override
    public boolean nicknameExiste(String nickname) {
        Proveedor proveedor;

        for (Map.Entry<Integer, Proveedor> entry : coleccion.entrySet()) {
            proveedor = entry.getValue();

            if (proveedor.getNickname().equals(nickname)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean emailExiste(String email) {
        Proveedor proveedor;

        for (Map.Entry<Integer, Proveedor> entry : coleccion.entrySet()) {
            proveedor = entry.getValue();

            if (proveedor.getCorreo().equals(email)) {
                return true;
            }
        }

        return false;
    }

    public boolean comprobarlogin(String nickname, String contrasena) {
        Proveedor proveedor;

        for (Map.Entry<Integer, Proveedor> entry : coleccion.entrySet()) {
            proveedor = entry.getValue();

            if (proveedor.getNickname().equals(nickname) && proveedor.getContrasena().equals(contrasena)) {
                return true;
            }
        }

        return false;
    }

    public boolean comprobarloginMail(String mail, String contrasena) {
        Proveedor proveedor;

        for (Map.Entry<Integer, Proveedor> entry : coleccion.entrySet()) {
            proveedor = entry.getValue();

            if (proveedor.getCorreo().equals(mail) && proveedor.getContrasena().equals(contrasena)) {
                return true;
            }
        }

        return false;
    }

}
