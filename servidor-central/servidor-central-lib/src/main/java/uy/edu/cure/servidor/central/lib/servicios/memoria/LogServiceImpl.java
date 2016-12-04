package uy.edu.cure.servidor.central.lib.servicios.memoria;


import uy.edu.cure.servidor.central.dto.Log;
import uy.edu.cure.servidor.central.dto.Reserva;
import uy.edu.cure.servidor.central.lib.servicios.LogService;

import java.util.Map;


public class LogServiceImpl extends GenericServiceImpl<Log> implements LogService {
    private static LogServiceImpl ourInstance = new LogServiceImpl();

    public static LogServiceImpl getInstance() {
        return ourInstance;
    }

    private LogServiceImpl() {
        super();
    }

    //@Override
    public Integer nextId() {
        Integer maxId = 0;
        for (Map.Entry<Integer, Log> entry : coleccion.entrySet()) {
            if (entry.getValue().getId() > maxId) {
                maxId = entry.getValue().getId();
            }
        }

        return maxId + 1;
    }
}
