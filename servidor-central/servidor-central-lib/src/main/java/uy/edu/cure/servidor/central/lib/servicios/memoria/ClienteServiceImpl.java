package uy.edu.cure.servidor.central.lib.servicios.memoria;

import uy.edu.cure.servidor.central.dto.Cliente;
import uy.edu.cure.servidor.central.lib.servicios.ClienteService;

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
}
