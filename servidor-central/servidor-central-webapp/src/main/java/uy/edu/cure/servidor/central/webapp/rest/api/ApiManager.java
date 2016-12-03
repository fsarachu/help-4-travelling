package uy.edu.cure.servidor.central.webapp.rest.api;


import uy.edu.cure.servidor.central.webapp.rest.api.RestControllers.*;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

public class ApiManager extends Application {

    private Set<Object> singleton = new HashSet<Object>();

    public ApiManager() {
        singleton.add(new TestRestController());
        singleton.add(new ClienteRestController());
        singleton.add(new CategoriaRestController());
        singleton.add(new CarritoRestController());
        singleton.add(new CiudadRestController());
        singleton.add(new PaisRestController());
        singleton.add(new ProductoRestController());
        singleton.add(new ProveedorRestController());
        singleton.add(new ReservaRestController());
        singleton.add(new HardcodeoRestController());
        singleton.add(new LogRestController());
    }

    @Override
    public Set<Object> getSingletons() {
        return singleton;
    }
}
