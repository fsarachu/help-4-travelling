package uy.edu.cure.estacion.de.trabajo;

import com.sun.xml.internal.ws.util.ServiceFinder;
import uy.edu.cure.servidor.central.dto.*;
import uy.edu.cure.servidor.central.lib.controllers.*;
import uy.edu.cure.servidor.central.lib.servicios.CiudadService;
import uy.edu.cure.servidor.central.lib.servicios.ProveedorService;
import uy.edu.cure.servidor.central.lib.servicios.ServiceFactory;

import java.util.Date;


public class Hardcodeo {


    public Hardcodeo() {
        harcodeoCategoria();
        hardcodeoCiudadPais();
        harcodeoProveedor();
        harcodeoServicios();
        harcodeoClientes();
    }
    private void hardcodeoCiudadPais() {
        CiudadController ciudadController = new CiudadController();

        Pais pais1 = new Pais();
        pais1.setId(1);
        pais1.setNombre("Uruguay");

        Ciudad ciudad1 = new Ciudad();
        ciudad1.setId(1);
        ciudad1.setNombre("Maldonado");
        ciudad1.setPais(pais1);
        ciudadController.nueva(ciudad1);

        Ciudad ciudad2 = new Ciudad();
        ciudad2.setId(2);
        ciudad2.setNombre("Punta del este");
        ciudad2.setPais(pais1);
        ciudadController.nueva(ciudad2);

        Pais pais2 = new Pais();
        pais1.setId(2);
        pais1.setNombre("Brasil");

        Ciudad ciudad3 = new Ciudad();
        ciudad3.setId(3);
        ciudad3.setNombre("Floripa");
        ciudad3.setPais(pais2);
        ciudadController.nueva(ciudad3);

        Ciudad ciudad4 = new Ciudad();
        ciudad4.setId(4);
        ciudad4.setNombre("Camboriu");
        ciudad4.setPais(pais2);
        ciudadController.nueva(ciudad4);
    }

    private void harcodeoCategoria() {
        CategoriaController categoriaController = new CategoriaController();

        Categoria vehiculos = new Categoria();
        vehiculos.setId(1);
        vehiculos.setPadre(null);
        vehiculos.setNombre("Vehiculos");
        categoriaController.nueva(vehiculos);

        Categoria autos1 = new Categoria();
        autos1.setId(2);
        autos1.setPadre(vehiculos);
        autos1.setNombre("Autos");
        categoriaController.nueva(autos1);

        Categoria autos2 = new Categoria();
        autos2.setId(3);
        autos2.setPadre(vehiculos);
        autos2.setNombre("Camionetas");
        categoriaController.nueva(autos2);

        Categoria autos3 = new Categoria();
        autos3.setId(4);
        autos3.setPadre(autos1);
        autos3.setNombre("Rent a Car");
        categoriaController.nueva(autos3);

        Categoria autos4 = new Categoria();
        autos4.setId(5);
        autos4.setPadre(autos1);
        autos4.setNombre("Car Rental");
        categoriaController.nueva(autos4);

        Categoria autos5 = new Categoria();
        autos5.setId(6);
        autos5.setPadre(autos2);
        autos5.setNombre("Rent a Van");
        categoriaController.nueva(autos5);

        Categoria autos6 = new Categoria();
        autos6.setId(7);
        autos6.setPadre(autos2);
        autos6.setNombre("Van Rental");
        categoriaController.nueva(autos6);

        Categoria hoteles = new Categoria();
        hoteles.setId(8);
        hoteles.setPadre(null);
        hoteles.setNombre("Hoteles");
        categoriaController.nueva(hoteles);

        Categoria hotel1 = new Categoria();
        hotel1.setId(9);
        hotel1.setPadre(hoteles);
        hotel1.setNombre("5 estrellas");
        categoriaController.nueva(hotel1);

        Categoria hotel2 = new Categoria();
        hotel2.setId(10);
        hotel2.setPadre(hoteles);
        hotel2.setNombre("4 estrellas");
        categoriaController.nueva(hotel2);

        Categoria hotel3 = new Categoria();
        hotel3.setId(11);
        hotel3.setPadre(hotel1);
        hotel3.setNombre("Conrad");
        categoriaController.nueva(hotel3);

        Categoria hotel4 = new Categoria();
        hotel4.setId(12);
        hotel4.setPadre(hotel1);
        hotel4.setNombre("Mantra");
        categoriaController.nueva(hotel4);

        Categoria hotel5 = new Categoria();
        hotel5.setId(13);
        hotel5.setPadre(hotel2);
        hotel5.setNombre("Hotel del Lago");
        categoriaController.nueva(hotel5);

        Categoria hotel6 = new Categoria();
        hotel6.setId(14);
        hotel6.setPadre(hotel2);
        hotel6.setNombre("Hotel del Rio");
        categoriaController.nueva(hotel6);

    }
    private void harcodeoProveedor() {
        ProveedorController proveedorController = new ProveedorController();

        Proveedor proveedor1 = new Proveedor();
        proveedor1.setId(1);
        proveedor1.setNombre("Rentadora");
        proveedor1.setNickname("Rentadora");
        Date nacimiento1 = new Date(2016,02,15);
        proveedor1.setFechaNacimiento(nacimiento1);
        proveedor1.setNombreEmpresa("Rentadora LTDA");
        proveedorController.nuevo(proveedor1);

        Proveedor proveedor2 = new Proveedor();
        proveedor2.setId(2);
        proveedor2.setNombre("Rentadora Dos");
        proveedor2.setNickname("Rentadora Dos");
        Date nacimiento2 = new Date(2016,02,12);
        proveedor2.setFechaNacimiento(nacimiento2);
        proveedor2.setNombreEmpresa("Rentadora Dos S.A.");
        proveedorController.nuevo(proveedor2);

        Proveedor proveedor3 = new Proveedor();
        proveedor3.setId(3);
        proveedor3.setNombre("El mejor Hotel");
        proveedor3.setNickname("El mejor Hotel");
        Date nacimiento3 = new Date(2016,02,12);
        proveedor3.setFechaNacimiento(nacimiento3);
        proveedor3.setNombreEmpresa("El mejor Hotel LTDA");
        proveedorController.nuevo(proveedor3);

        Proveedor proveedor4 = new Proveedor();
        proveedor4.setId(4);
        proveedor4.setNombre("Tu Hotel");
        proveedor4.setNickname("Tu Hotel");
        Date nacimiento4 = new Date(2016,02,12);
        proveedor4.setFechaNacimiento(nacimiento4);
        proveedor4.setNombreEmpresa("Tu Hotel S.A.");
        proveedorController.nuevo(proveedor4);

    }

    private void harcodeoServicios() {

        ProductoController productoController = new ProductoController();
        ProveedorService proveedorService = ServiceFactory.getProveedorService();
        CiudadService ciudadService = ServiceFactory.getCiudadService();

        Servicio servicio1 = new Servicio();
        servicio1.setNombre("Auto x 1 dia");
        servicio1.setIdCategorias(2);
        servicio1.setProveedor(proveedorService.obtener(1));
        servicio1.setOrigen(ciudadService.obtener(4));
        servicio1.setDestino(ciudadService.obtener(4));
        servicio1.setDescripcion("Un dia de auto");
        servicio1.setPrecio(100);
        productoController.agregar(servicio1);

        Servicio servicio2 = new Servicio();
        servicio2.setNombre("Auto x Fin de Semana");
        servicio2.setIdCategorias(2);
        servicio2.setProveedor(proveedorService.obtener(2));
        servicio2.setOrigen(ciudadService.obtener(3));
        servicio2.setDestino(ciudadService.obtener(3));
        servicio2.setDescripcion("Fin de Semana con auto");
        servicio2.setPrecio(300);
        productoController.agregar(servicio2);

        Servicio servicio3 = new Servicio();
        servicio3.setNombre("Camioneta x Fin de Semana");
        servicio3.setIdCategorias(3);
        servicio3.setProveedor(proveedorService.obtener(2));
        servicio3.setOrigen(ciudadService.obtener(1));
        servicio3.setDestino(ciudadService.obtener(2));
        servicio3.setDescripcion("Fin de Semana en camioneta");
        servicio3.setPrecio(400);
        productoController.agregar(servicio3);

        Servicio servicio4 = new Servicio();
        servicio4.setNombre("Habitacion Simple");
        servicio4.setIdCategorias(9);
        servicio4.setProveedor(proveedorService.obtener(3));
        servicio4.setOrigen(ciudadService.obtener(2));
        servicio4.setDestino(ciudadService.obtener(2));
        servicio4.setDescripcion("Simple");
        servicio4.setPrecio(50);
        productoController.agregar(servicio4);

        Servicio servicio5 = new Servicio();
        servicio5.setNombre("Habitacion Doble");
        servicio5.setIdCategorias(9);
        servicio5.setProveedor(proveedorService.obtener(4));
        servicio5.setOrigen(ciudadService.obtener(1));
        servicio5.setDestino(ciudadService.obtener(1));
        servicio5.setDescripcion("Doble");
        servicio5.setPrecio(80);
        productoController.agregar(servicio5);
    }

    private void harcodeoClientes() {

        ClienteController clienteController = new ClienteController();

        Cliente cliente1 = new Cliente();
        cliente1.setId(1);
        cliente1.setNombre("Franco");
        cliente1.setApellido("Sarachu");
        cliente1.setNickname("Franco");
        Date nacimiento1 = new Date(2010,01,11);
        cliente1.setFechaNacimiento(nacimiento1);
        clienteController.nuevo(cliente1);

        Cliente cliente2 = new Cliente();
        cliente2.setId(2);
        cliente2.setNombre("Nicolas");
        cliente2.setApellido("Pioli");
        cliente2.setNickname("Nicolas");
        Date nacimiento2 = new Date(2010,01,11);
        cliente2.setFechaNacimiento(nacimiento2);
        clienteController.nuevo(cliente2);

        Cliente cliente3 = new Cliente();
        cliente3.setId(3);
        cliente3.setNombre("Santiago");
        cliente3.setApellido("Martinez");
        cliente3.setNickname("Santiago");
        Date nacimiento3 = new Date(2010,01,11);
        cliente3.setFechaNacimiento(nacimiento3);
        clienteController.nuevo(cliente3);

        Cliente cliente4 = new Cliente();
        cliente4.setId(4);
        cliente4.setNombre("Victor");
        cliente4.setApellido("Torterola");
        cliente4.setNickname("Victor");
        Date nacimiento4 = new Date(2010,01,11);
        cliente4.setFechaNacimiento(nacimiento4);
        clienteController.nuevo(cliente4);

        Cliente cliente5 = new Cliente();
        cliente5.setId(5);
        cliente5.setNombre("Viviana");
        cliente5.setApellido("Bruno");
        cliente5.setNickname("Viviana");
        Date nacimiento5 = new Date(2010,01,11);
        cliente5.setFechaNacimiento(nacimiento5);
        clienteController.nuevo(cliente5);

        Cliente cliente6 = new Cliente();
        cliente6.setId(6);
        cliente6.setNombre("Marcos");
        cliente6.setApellido("Prat");
        cliente6.setNickname("Marcos");
        Date nacimiento6 = new Date(2010,01,11);
        cliente6.setFechaNacimiento(nacimiento6);
        clienteController.nuevo(cliente6);



    }



}
