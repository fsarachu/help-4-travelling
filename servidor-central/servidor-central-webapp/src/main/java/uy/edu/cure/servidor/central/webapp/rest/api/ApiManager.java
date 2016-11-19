package uy.edu.cure.servidor.central.webapp.rest.api;


import uy.edu.cure.servidor.central.webapp.rest.api.RestControllers.CategoriaRestController;
import uy.edu.cure.servidor.central.webapp.rest.api.RestControllers.ClienteRestController;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

public class ApiManager extends Application {

    private Set<Object> singleton = new HashSet<Object>();

    public ApiManager() {
        singleton.add(new TestRestController());
        singleton.add(new ClienteRestController());
        singleton.add(new CategoriaRestController());
    }

    @Override
    public Set<Object> getSingletons() {
        return singleton;
    }
}
