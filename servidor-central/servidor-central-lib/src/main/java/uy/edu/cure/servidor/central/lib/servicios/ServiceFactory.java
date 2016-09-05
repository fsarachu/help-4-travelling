package uy.edu.cure.servidor.central.lib.servicios;

import uy.edu.cure.servidor.central.lib.servicios.memoria.*;

public class ServiceFactory {
    public static CategoriaService getCategoriaService() {
        return CategoriaServiceImpl.getInstance();
    }

    public static CiudadService getCiudadService() {
        return CiudadServiceImpl.getInstance();
    }

    public static ClienteService getClienteService() {
        return ClienteServiceImpl.getInstance();
    }

    public static PaisService getPaisService() {
        return PaisServiceImpl.getInstance();
    }

    public static ProveedorService getProveedorService() {
        return ProveedorServiceImpl.getInstance();
    }

    public static ServicioService getServicioService() {
        return ServicioServiceImpl.getInstance();
    }

    public static PromocionService getPromocionService() {
        return PromocionServiceImpl.getInstance();
    }

    public static ReservaService getReservaService() {
        return ReservaServiceImpl.getInstance();
    }

    public static OrdenService getOrdenService() {
        return OrdenServiceImpl.getInstance();
    }
}
