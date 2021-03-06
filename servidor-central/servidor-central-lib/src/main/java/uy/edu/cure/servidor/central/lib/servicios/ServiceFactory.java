package uy.edu.cure.servidor.central.lib.servicios;

import uy.edu.cure.servidor.central.lib.servicios.memoria.*;

public class ServiceFactory {
    public static CarritoService getCarritoService() {
        return CarritoServiceImpl.getInstance();
    }

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

    public static ProductoService getProductoService() { return ProductoServiceImpl.getInstance(); }

    public static ProveedorService getProveedorService() {
        return ProveedorServiceImpl.getInstance();
    }

    public static ItemReservaService getItemReservaService() {
        return ItemReservaServiceImpl.getInstance();
    }

    public static ReservaService getReservaService() {
        return ReservaServiceImpl.getInstance();
    }

    public static FacturaService getFacturaService() { return FacturaServiceImpl.getInstance(); }

    public  static LogService getLogService() { return LogServiceImpl.getInstance(); }
}
