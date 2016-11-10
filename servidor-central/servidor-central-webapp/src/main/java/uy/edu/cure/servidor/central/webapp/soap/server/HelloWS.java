package uy.edu.cure.servidor.central.webapp.soap.server;

import uy.edu.cure.servidor.central.dto.Usuario;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface HelloWS {

    @WebMethod
    public String sayHello(String name);
    //public void agregar(String usuario);

}
