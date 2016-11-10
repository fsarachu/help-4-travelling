package uy.edu.cure.servidor.central.webapp.rest.api;


import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by victor on 10/11/16.
 */
public class ApiManager extends Application {

    private Set<Object> singleton = new HashSet<Object>();

    public ApiManager() {
        singleton.add(new TestRestController());
        //singleton.add(new ClienteRestController());
    }

    //@Override
    public Set<Object> getSingleton() {
        return singleton;
    }
}
