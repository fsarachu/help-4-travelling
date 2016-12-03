package uy.edu.cure.servidor.central.lib.controllers;


import uy.edu.cure.servidor.central.dto.Log;
import uy.edu.cure.servidor.central.lib.servicios.LogService;
import uy.edu.cure.servidor.central.lib.servicios.ServiceFactory;

public class LogController {
    private LogService logService;

    public LogController() { this.logService = ServiceFactory.getLogService();}

    public void agregarLog(Log log) {





    }

}



