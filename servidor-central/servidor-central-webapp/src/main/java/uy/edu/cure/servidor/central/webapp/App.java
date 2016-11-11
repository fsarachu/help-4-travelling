package uy.edu.cure.servidor.central.webapp;

import uy.edu.cure.servidor.central.webapp.soap.server.HelloWSImpl;

import javax.xml.ws.Endpoint;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        //System.out.println("Hello World!");
        Endpoint.publish("http://localhost:9999/ws/hello667", new HelloWSImpl());
    }
}
