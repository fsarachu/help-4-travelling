package uy.edu.cure.servidor.central.webapp.soap.server;


import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface HelloWS {

    @WebMethod
    public String sayHello(String name);
    //public void agregar(String usuario);

    @WebMethod public String sayGoodbye(String name);
}
