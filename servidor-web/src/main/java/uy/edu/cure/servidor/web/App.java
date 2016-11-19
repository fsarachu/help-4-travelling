package uy.edu.cure.servidor.web;

/*import uy.edu.cure.servidor.central.soap.client.HelloWS;
import uy.edu.cure.servidor.central.soap.client.HelloWSImplService;*/

import java.net.URL;

/**
 * Hello world!
 *
 */
public class App {

	/*private HelloWSImplService helloWSImplService;

	public App() throws Exception {
		//helloWSImplService = new HelloWSImplService(new URL("http://localhost:8080/servidor-central-webapp/soap/HelloService?wsdl"));
		//Endpoint.publish("http://localhost:9999/ws/hello667", new HelloWSImpl());
		helloWSImplService = new HelloWSImplService(new URL("http://localhost:9999/ws/hello667?wsdl"));
		HelloWS port = helloWSImplService.getHelloWSImplPort();
		System.out.println(port.sayHello("francisco"));
	}*/

	public static void main(String[] args) throws Exception {
		System.out.println("Hello World!");
		App app = new App();
	}
}
