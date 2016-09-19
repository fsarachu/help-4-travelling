package uy.edu.cure.servidor.central.lib.controllers;

import uy.edu.cure.servidor.central.dto.Pais;
import uy.edu.cure.servidor.central.lib.servicios.PaisService;
import uy.edu.cure.servidor.central.lib.servicios.ServiceFactory;

import java.util.ArrayList;

public class PaisController {
    private PaisService paisService;

    public PaisController() {
        this.paisService = ServiceFactory.getPaisService();
    }

    public void agregar(Pais pais) {
        pais.setId(this.paisService.nextId());
        this.paisService.agregar(pais.getId(), pais);
    }

    public void eliminar(Integer idPais) {
        this.paisService.eliminar(idPais);
    }

    Pais obtener(Integer idPais) {
        return this.paisService.obtener(idPais);
    }

    public void modificar(Pais pais) {
        this.paisService.modificar(pais.getId(), pais);
    }

    public ArrayList<Pais> listar() {
        return this.paisService.listar();
    }
}
