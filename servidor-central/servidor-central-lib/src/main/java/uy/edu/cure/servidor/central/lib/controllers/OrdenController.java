package uy.edu.cure.servidor.central.lib.controllers;

import uy.edu.cure.servidor.central.dto.Orden;
import uy.edu.cure.servidor.central.lib.servicios.OrdenService;
import uy.edu.cure.servidor.central.lib.servicios.ServiceFactory;

import java.util.ArrayList;

public class OrdenController {

    public void nueva(Orden orden) {
    }

    public ArrayList<Orden> listar() {
        OrdenService ordenService = ServiceFactory.getOrdenService();

        return ordenService.listar();
    }
}
