package uy.edu.cure.servidor.central.lib.servicios.memoria;

import uy.edu.cure.servidor.central.dto.Cliente;
import uy.edu.cure.servidor.central.lib.servicios.ClienteService;

public class ClienteServiceImpl extends GenericServiceImpl<Cliente> implements ClienteService {

    private static ClienteServiceImpl ourInstance = new ClienteServiceImpl();

    public static ClienteServiceImpl getInstance() {
        return ourInstance;
    }

    private ClienteServiceImpl() {
        super();
    }
}
