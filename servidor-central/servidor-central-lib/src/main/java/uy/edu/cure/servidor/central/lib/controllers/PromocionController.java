package uy.edu.cure.servidor.central.lib.controllers;

import uy.edu.cure.servidor.central.dto.Promocion;
import uy.edu.cure.servidor.central.dto.Proveedor;
import uy.edu.cure.servidor.central.lib.servicios.PromocionService;
import uy.edu.cure.servidor.central.lib.servicios.ServiceFactory;

import java.util.ArrayList;

public class PromocionController {

    public void nueva(Promocion promocion) {
        PromocionService promocionService = ServiceFactory.getPromocionService();

        promocionService.agregar(promocion.getId(), promocion);

        Proveedor proveedor = promocion.getProveedor();

        proveedor.getPromociones().add(promocion);
    }

    public void eliminar(int id) {
        PromocionService ciudadService = ServiceFactory.getPromocionService();

        ciudadService.eliminar(id);
    }

    Promocion obtener(Integer id) {
        PromocionService ciudadService = ServiceFactory.getPromocionService();

        return ciudadService.obtener(id);
    }

    public void modificar(Integer id, Promocion ciudad1) {
        PromocionService ciudadService = ServiceFactory.getPromocionService();

        ciudadService.modificar(id, ciudad1);
    }


    public ArrayList<Promocion> listar() {
        PromocionService promocionService = ServiceFactory.getPromocionService();

        return promocionService.listar();
    }
}
