package uy.edu.cure.servidor.central.lib.servicios.memoria;

import uy.edu.cure.servidor.central.dto.Cliente;
import uy.edu.cure.servidor.central.lib.servicios.ClienteService;

import java.util.ArrayList;
import java.util.Map;

public class ClienteServiceImpl extends GenericServiceImpl<Cliente> implements ClienteService {

    private static ClienteServiceImpl ourInstance = new ClienteServiceImpl();

    public static ClienteServiceImpl getInstance() {
        return ourInstance;
    }

    private ClienteServiceImpl() {
        super();
    }

    public Integer nextId() {
        Integer maxId = 0;
        for (Map.Entry<Integer, Cliente> entry : coleccion.entrySet()) {
            if (entry.getValue().getId() > maxId) {
                maxId = entry.getValue().getId();
            }
        }

        return maxId + 1;
    }


    @Override
    public boolean nicknameExiste(String nickname) {
        ArrayList<Cliente> clientes = new ArrayList<>();
        Cliente cliente;

        for (Map.Entry<Integer, Cliente> entry : coleccion.entrySet()) {
            cliente = entry.getValue();

            if (cliente.getNickname().equals(nickname)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean emailExiste(String email) {
        ArrayList<Cliente> clientes = new ArrayList<>();
        Cliente cliente;

        for (Map.Entry<Integer, Cliente> entry : coleccion.entrySet()) {
            cliente = entry.getValue();

            if (cliente.getNickname().equals(email)) {
                return true;
            }
        }

        return false;
    }
}
