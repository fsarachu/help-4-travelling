package uy.edu.cure.servidor.central.lib.servicios.memoria;


import uy.edu.cure.servidor.central.dto.Log;
import uy.edu.cure.servidor.central.lib.servicios.LogService;


public class LogServiceImpl extends GenericServiceImpl<Log> implements LogService {
    private static LogServiceImpl ourInstance = new LogServiceImpl();

    public static LogServiceImpl getInstance() {
        return ourInstance;
    }

    private LogServiceImpl() {
        super();
    }

    @Override
    public Integer nextId() {
        return null;
    }
}
