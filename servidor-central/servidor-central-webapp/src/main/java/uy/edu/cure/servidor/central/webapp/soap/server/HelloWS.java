package uy.edu.cure.servidor.central.webapp.soap.server;

import javax.jws.WebMethod;
import javax.jws.WebService;

// http://localhost:8080/servidor-central-webapp/HelloWSService?wsdl
@WebService
public class HelloWS {
    private String message = new String("Hello, ");

    @WebMethod
    public String sayHello(String name) {
        return message + name + ".";
    }
}
