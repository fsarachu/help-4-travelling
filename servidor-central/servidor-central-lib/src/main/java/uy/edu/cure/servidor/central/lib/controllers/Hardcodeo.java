package uy.edu.cure.servidor.central.lib.controllers;

import uy.edu.cure.servidor.central.dto.*;
import uy.edu.cure.servidor.central.lib.controllers.*;
import uy.edu.cure.servidor.central.lib.servicios.*;
import uy.edu.cure.servidor.central.lib.servicios.memoria.ProveedorServiceImpl;

import java.util.ArrayList;
import java.util.Date;


public class Hardcodeo {

    public Hardcodeo() {
        hardcodeoCiudadPais();
        harcodeoClientes();
        harcodeoCategoria();
        harcodeoProveedor();
        harcodeoServicios();
        harcodeoPromociones();
        harcodeoCarritos();
        harcodeoReservas();

    }

    private void hardcodeoCiudadPais() {
        PaisController paisController = new PaisController();
        CiudadController ciudadController = new CiudadController();

        Pais pais1 = new Pais();
        pais1.setNombre("Uruguay");
        paisController.agregar(pais1);


        Ciudad ciudad1 = new Ciudad();
        ciudad1.setNombre("Maldonado");
        ciudad1.setPais(pais1);
        ciudadController.nueva(ciudad1);

        Ciudad ciudad2 = new Ciudad();
        ciudad2.setNombre("Punta del Este");
        ciudad2.setPais(pais1);
        ciudadController.nueva(ciudad2);

        Pais pais2 = new Pais();
        pais2.setNombre("Brasil");
        paisController.agregar(pais2);

        Ciudad ciudad3 = new Ciudad();
        ciudad3.setNombre("Floripa");
        ciudad3.setPais(pais2);
        ciudadController.nueva(ciudad3);

        Ciudad ciudad4 = new Ciudad();
        ciudad4.setNombre("Camboriu");
        ciudad4.setPais(pais2);
        ciudadController.nueva(ciudad4);
    }

    private void harcodeoCategoria() {
        CategoriaController categoriaController = new CategoriaController();

        Categoria vehiculos = new Categoria();
        vehiculos.setPadre(null);
        vehiculos.setNombre("Vehiculos");
        categoriaController.nueva(vehiculos);

        Categoria autos1 = new Categoria();
        autos1.setPadre(vehiculos);
        autos1.setNombre("Autos");
        categoriaController.nueva(autos1);

        Categoria autos2 = new Categoria();
        autos2.setPadre(vehiculos);
        autos2.setNombre("Camionetas");
        categoriaController.nueva(autos2);

        Categoria autos3 = new Categoria();
        autos3.setPadre(autos1);
        autos3.setNombre("Rent a Car");
        autos3.setImagen("/resources/imagenes/empresas/r1.jpg");
        categoriaController.nueva(autos3);

        Categoria autos4 = new Categoria();
        autos4.setPadre(autos1);
        autos4.setNombre("Car Rental");
        autos4.setImagen("/resources/imagenes/empresas/r2.jpg");
        categoriaController.nueva(autos4);

        Categoria autos5 = new Categoria();
        autos5.setPadre(autos2);
        autos5.setNombre("Rent a Van");
        autos5.setImagen("/resources/imagenes/empresas/r3.jpg");
        categoriaController.nueva(autos5);

        Categoria autos6 = new Categoria();
        autos6.setPadre(autos2);
        autos6.setNombre("Van Rental");
        autos6.setImagen("/resources/imagenes/empresas/r4.jpg");
        categoriaController.nueva(autos6);

        Categoria hoteles = new Categoria();
        hoteles.setPadre(null);
        hoteles.setNombre("Hoteles");
        categoriaController.nueva(hoteles);

        Categoria hotel1 = new Categoria();
        hotel1.setPadre(hoteles);
        hotel1.setNombre("5 estrellas");
        categoriaController.nueva(hotel1);

        Categoria hotel2 = new Categoria();
        hotel2.setPadre(hoteles);
        hotel2.setNombre("4 estrellas");
        categoriaController.nueva(hotel2);

        Categoria hotel3 = new Categoria();
        hotel3.setPadre(hotel1);
        hotel3.setNombre("Conrad");
        hotel3.setImagen("/resources/imagenes/empresas/h4.jpg");
        categoriaController.nueva(hotel3);

        Categoria hotel4 = new Categoria();
        hotel4.setPadre(hotel1);
        hotel4.setNombre("Mantra");
        hotel4.setImagen("/resources/imagenes/empresas/h3.jpg");
        categoriaController.nueva(hotel4);

        Categoria hotel5 = new Categoria();
        hotel5.setPadre(hotel2);
        hotel5.setNombre("Hotel del Lago");
        hotel5.setImagen("/resources/imagenes/empresas/h1.jpg");
        categoriaController.nueva(hotel5);

        Categoria hotel6 = new Categoria();
        hotel6.setPadre(hotel2);
        hotel6.setNombre("Hotel del Rio");
        hotel3.setImagen("/resources/imagenes/empresas/h2.jpg");
        categoriaController.nueva(hotel6);

    }

    private void harcodeoProveedor() {
        ProveedorController proveedorController = new ProveedorController();

        Proveedor proveedor1 = new Proveedor();
        proveedor1.setNombre("Rentadora Autos");
        proveedor1.setNickname("Rentadora Autos");
        Date nacimiento1 = new Date(116, 2, 15);
        proveedor1.setFechaNacimiento(nacimiento1);
        proveedor1.setNombreEmpresa("Rentadora LTDA");
        proveedor1.setImagen("/resources/imagenes/alquilo1.jpeg");
        proveedor1.setCorreo("tuautoya@llevatelo.com.ya");
        proveedorController.nuevo(proveedor1);

        Proveedor proveedor2 = new Proveedor();
        proveedor2.setNombre("Rentadora Utilitarios");
        proveedor2.setNickname("Rentadora Utilitarios");
        Date nacimiento2 = new Date(116, 2, 12);
        proveedor2.setFechaNacimiento(nacimiento2);
        proveedor2.setNombreEmpresa("Rentadora Utilitarios S.A.");
        proveedor2.setImagen("/resources/imagenes/alquilo2.jpeg");
        proveedor2.setCorreo("masbarato@empujame.com.uy");
        proveedorController.nuevo(proveedor2);

        Proveedor proveedor3 = new Proveedor();
        proveedor3.setNombre("El mejor Hotel");
        proveedor3.setNickname("El mejor Hotel");
        Date nacimiento3 = new Date(116, 2, 12);
        proveedor3.setFechaNacimiento(nacimiento3);
        proveedor3.setNombreEmpresa("El mejor Hotel LTDA");
        proveedor3.setImagen("/resources/imagenes/hotel1.jpeg");
        proveedor3.setCorreo("pocilgalachola@ahinomas.com.isi");
        proveedorController.nuevo(proveedor3);

        Proveedor proveedor4 = new Proveedor();
        proveedor4.setNombre("Tu Hotel");
        proveedor4.setNickname("Tu Hotel");
        Date nacimiento4 = new Date(116, 2, 12);
        proveedor4.setFechaNacimiento(nacimiento4);
        proveedor4.setNombreEmpresa("Tu Hotel S.A.");
        proveedor4.setImagen("/resources/imagenes/hotel2.jpeg");
        proveedor4.setCorreo("estesiestuhotel@reserva.com.ya");
        proveedorController.nuevo(proveedor4);

    }

    private void harcodeoClientes() {

        ClienteController clienteController = new ClienteController();
        ///////CarritoController carritoController = new CarritoController();

        Cliente cliente1 = new Cliente();
        cliente1.setNombre("Franco");
        cliente1.setApellido("Sarachu");
        cliente1.setNickname("franco");
        cliente1.setCorreo("franco@franco.com");
        Date nacimiento1 = new Date(85, 0, 11);
        cliente1.setContrasena("1234");
        cliente1.setFechaNacimiento(nacimiento1);
        cliente1.setImagen("/resources/imagenes/fcarne/fot1.jpg");
        /////cliente1.setCarrito(carritoController.obtenerCarrito(1)); ///////
        clienteController.nuevo(cliente1);

        Cliente cliente2 = new Cliente();
        cliente2.setNombre("Nicolas");
        cliente2.setApellido("Pioli");
        cliente2.setNickname("nicolas");
        cliente2.setCorreo("nicolas@nicolas.com");
        Date nacimiento2 = new Date(85, 1, 11);
        cliente2.setContrasena("1234");
        cliente2.setFechaNacimiento(nacimiento2);
        cliente2.setImagen("/resources/imagenes/fcarne/fot2.jpg");
        clienteController.nuevo(cliente2);

        Cliente cliente3 = new Cliente();
        cliente3.setNombre("Santiago");
        cliente3.setApellido("Martinez");
        cliente3.setNickname("santiago");
        cliente3.setCorreo("santiago@santiago.com");
        Date nacimiento3 = new Date(85, 2, 11);
        cliente3.setContrasena("1234");
        cliente3.setFechaNacimiento(nacimiento3);
        cliente3.setImagen("/resources/imagenes/fcarne/fot3.jpg");
        clienteController.nuevo(cliente3);

        Cliente cliente4 = new Cliente();
        cliente4.setNombre("Victor");
        cliente4.setApellido("Torterola");
        cliente4.setNickname("victor");
        cliente4.setCorreo("victor@victor.com");
        Date nacimiento4 = new Date(85, 3, 11);
        cliente4.setContrasena("1234");
        cliente4.setFechaNacimiento(nacimiento4);
        cliente4.setImagen("/resources/imagenes/fcarne/fot4.jpg");
        clienteController.nuevo(cliente4);

        Cliente cliente5 = new Cliente();
        cliente5.setNombre("Viviana");
        cliente5.setApellido("Bruno");
        cliente5.setNickname("viviana");
        cliente5.setCorreo("viviana@viviana.com");
        Date nacimiento5 = new Date(85, 4, 11);
        cliente5.setContrasena("1234");
        cliente5.setFechaNacimiento(nacimiento5);
        cliente5.setImagen("/resources/imagenes/fcarne/fot8.jpg");
        clienteController.nuevo(cliente5);

        Cliente cliente6 = new Cliente();
        cliente6.setNombre("Marcos");
        cliente6.setApellido("Prat");
        cliente6.setNickname("marcos");
        cliente6.setCorreo("marcos@marcos.com");
        Date nacimiento6 = new Date(85, 5, 11);
        cliente6.setContrasena("1234");
        cliente6.setFechaNacimiento(nacimiento6);
        cliente6.setImagen("/resources/imagenes/fcarne/fot5.jpg");
        clienteController.nuevo(cliente6);


    }

    private void harcodeoServicios() {

        ProductoController productoController = new ProductoController();
        ProveedorService proveedorService = ServiceFactory.getProveedorService();
        CiudadService ciudadService = ServiceFactory.getCiudadService();
        CategoriaService categoriaService = ServiceFactory.getCategoriaService();

        Servicio servicio1 = new Servicio();
        servicio1.setNombre("Auto x Fin de Semana");
        servicio1.setProveedor(proveedorService.obtener(1));
        servicio1.setOrigen(ciudadService.obtener(3));
        servicio1.setDestino(ciudadService.obtener(4));
        servicio1.setDescripcion("Fin de semana con auto");
        servicio1.setPrecio(300);
        servicio1.getCategorias().add(categoriaService.obtener(4));
        servicio1.getImagenes().add("/resources/imagenes/car/a1.jpg");
        servicio1.getImagenes().add("/resources/imagenes/car/a2.jpg");
        servicio1.getImagenes().add("/resources/imagenes/car/a3.jpg");
        productoController.agregar(servicio1);

        Servicio servicio2 = new Servicio();
        servicio2.setNombre("Auto x 1 dia");
        servicio2.setProveedor(proveedorService.obtener(1));
        servicio2.setOrigen(ciudadService.obtener(1));
        servicio2.setDestino(ciudadService.obtener(2));
        servicio2.setDescripcion("Un dia de auto");
        servicio2.setPrecio(100);
        servicio2.getCategorias().add(categoriaService.obtener(5));
        servicio2.getImagenes().add("/resources/imagenes/car/a4.jpg");
        servicio2.getImagenes().add("/resources/imagenes/car/a5.jpg");
        servicio2.getImagenes().add("/resources/imagenes/car/a6.jpg");
        productoController.agregar(servicio2);

        Servicio servicio3 = new Servicio();
        servicio3.setNombre("Camioneta x Fin de Semana");
        servicio3.setProveedor(proveedorService.obtener(2));
        servicio3.setOrigen(ciudadService.obtener(2));
        servicio3.setDestino(ciudadService.obtener(2));
        servicio3.setDescripcion("Fin de Semana en camioneta");
        servicio3.setPrecio(400);
        servicio3.getCategorias().add(categoriaService.obtener(6));
        servicio3.getImagenes().add("/resources/imagenes/car/v1.jpg");
        servicio3.getImagenes().add("/resources/imagenes/car/v2.jpg");
        servicio3.getImagenes().add("/resources/imagenes/car/v3.jpg");
        productoController.agregar(servicio3);

        Servicio servicio4 = new Servicio();
        servicio4.setNombre("Camioneta x 1 dia");
        servicio4.setProveedor(proveedorService.obtener(2));
        servicio4.setOrigen(ciudadService.obtener(2));
        servicio4.setDestino(ciudadService.obtener(2));
        servicio4.setDescripcion("Un dia de camioneta");
        servicio4.setPrecio(400);
        servicio4.getCategorias().add(categoriaService.obtener(7));
        servicio4.getImagenes().add("/resources/imagenes/car/v4.jpg");
        servicio4.getImagenes().add("/resources/imagenes/car/v5.jpg");
        servicio4.getImagenes().add("/resources/imagenes/car/v6.jpg");
        productoController.agregar(servicio4);

        Servicio servicio5 = new Servicio();
        servicio5.setNombre("Habitacion Simple");
        servicio5.setProveedor(proveedorService.obtener(3));
        servicio5.setOrigen(ciudadService.obtener(5));
        servicio5.setDestino(ciudadService.obtener(1));
        servicio5.setDescripcion("Simple");
        servicio5.setPrecio(50);
        servicio5.getCategorias().add(categoriaService.obtener(11));
        servicio5.getCategorias().add(categoriaService.obtener(12));
        servicio5.getCategorias().add(categoriaService.obtener(13));
        servicio5.getCategorias().add(categoriaService.obtener(14));
        servicio5.getImagenes().add("/resources/imagenes/habitaciones/s1.jpg");
        servicio5.getImagenes().add("/resources/imagenes/habitaciones/s2.jpg");
        servicio5.getImagenes().add("/resources/imagenes/habitaciones/s3.jpg");
        productoController.agregar(servicio5);

        Servicio servicio6 = new Servicio();
        servicio6.setNombre("Habitacion Doble");
        servicio6.setProveedor(proveedorService.obtener(4));
        servicio6.setOrigen(ciudadService.obtener(4));
        servicio6.setDestino(ciudadService.obtener(2));
        servicio6.setDescripcion("Doble");
        servicio6.setPrecio(80);
        servicio6.getCategorias().add(categoriaService.obtener(11));
        servicio6.getCategorias().add(categoriaService.obtener(12));
        servicio6.getImagenes().add("/resources/imagenes/habitaciones/d1.jpg");
        servicio6.getImagenes().add("/resources/imagenes/habitaciones/d2.jpg");
        servicio6.getImagenes().add("/resources/imagenes/habitaciones/d3.jpg");
        productoController.agregar(servicio6);

        Servicio servicio7 = new Servicio();
        servicio7.setNombre("Habitacion Muy Simple");
        servicio7.setProveedor(proveedorService.obtener(3));
        servicio7.setOrigen(ciudadService.obtener(5));
        servicio7.setDestino(ciudadService.obtener(1));
        servicio7.setDescripcion("Muy Simple");
        servicio7.setPrecio(70);
        servicio7.getCategorias().add(categoriaService.obtener(13));
        servicio7.getCategorias().add(categoriaService.obtener(14));
        servicio7.getImagenes().add("/resources/imagenes/habitaciones/s1.jpg");
        servicio7.getImagenes().add("/resources/imagenes/habitaciones/s2.jpg");
        servicio7.getImagenes().add("/resources/imagenes/habitaciones/s3.jpg");
        productoController.agregar(servicio7);

        Servicio servicio8 = new Servicio();
        servicio8.setNombre("Suite Lujo");
        servicio8.setProveedor(proveedorService.obtener(3));
        servicio8.setOrigen(ciudadService.obtener(5));
        servicio8.setDestino(ciudadService.obtener(1));
        servicio8.setDescripcion("Mucho Lujo");
        servicio8.setPrecio(150);
        servicio8.getCategorias().add(categoriaService.obtener(11));
        servicio8.getImagenes().add("/resources/imagenes/habitaciones/t1.jpg");
        servicio8.getImagenes().add("/resources/imagenes/habitaciones/t2.jpg");
        servicio8.getImagenes().add("/resources/imagenes/habitaciones/t3.jpg");
        productoController.agregar(servicio8);

        Servicio servicio9 = new Servicio();
        servicio9.setNombre("Suite Presidencial");
        servicio9.setProveedor(proveedorService.obtener(3));
        servicio9.setOrigen(ciudadService.obtener(5));
        servicio9.setDestino(ciudadService.obtener(1));
        servicio9.setDescripcion("Lujo del bueno");
        servicio9.setPrecio(150);
        servicio9.getCategorias().add(categoriaService.obtener(12));
        servicio9.getImagenes().add("/resources/imagenes/habitaciones/p1.jpg");
        servicio9.getImagenes().add("/resources/imagenes/habitaciones/p2.jpg");
        servicio9.getImagenes().add("/resources/imagenes/habitaciones/p3.jpg");
        productoController.agregar(servicio9);

        Servicio serv1 = new Servicio();
        serv1.setNombre("Cachilas");
        serv1.setProveedor(proveedorService.obtener(2));
        serv1.setOrigen(ciudadService.obtener(2));
        serv1.setDestino(ciudadService.obtener(2));
        serv1.setDescripcion("Aventura Retro");
        serv1.setPrecio(200);
        serv1.getCategorias().add(categoriaService.obtener(5));
        serv1.getImagenes().add("/resources/imagenes/car/c1.jpg");
        serv1.getImagenes().add("/resources/imagenes/car/c2.jpg");
        serv1.getImagenes().add("/resources/imagenes/car/c3.jpg");
        productoController.agregar(serv1);

        Servicio serv2 = new Servicio();
        serv2.setNombre("Ferrari");
        serv2.setProveedor(proveedorService.obtener(2));
        serv2.setOrigen(ciudadService.obtener(2));
        serv2.setDestino(ciudadService.obtener(2));
        serv2.setDescripcion("Ferrari de lujo");
        serv2.setPrecio(110);
        serv2.getCategorias().add(categoriaService.obtener(4));
        serv2.getImagenes().add("/resources/imagenes/car/f1.jpg");
        serv2.getImagenes().add("/resources/imagenes/car/f2.jpg");
        serv2.getImagenes().add("/resources/imagenes/car/f3.jpg");
        productoController.agregar(serv2);
    }


    private void harcodeoPromociones(){

        ProductoController productoctrl = new ProductoController();
        ProveedorController proveedorctrl = new ProveedorController();

        ProveedorService proveedorService = ServiceFactory.getProveedorService();

        ArrayList<Servicio> listaServicios = new ArrayList<Servicio>();
        ArrayList<Integer> listaIdServicios = new ArrayList<Integer>();

        listaServicios.add((Servicio)productoctrl.obtener(1));
        listaIdServicios.add(1);

        Promocion promocion1 = new Promocion();
        promocion1.setDescuento(15);
        promocion1.setServicios(listaServicios);
        promocion1.setIdServicios(listaIdServicios);
        promocion1.setNombre("Promocion 1");
        promocion1.setDescripcion("Descripcion 1");
        promocion1.calcularPrecioPromocion();
        promocion1.setProveedor(proveedorService.obtener(1));

        productoctrl.agregar(promocion1);



        ArrayList<Servicio> listaServicios2 = new ArrayList<Servicio>();
        ArrayList<Integer> listaIdServicios2 = new ArrayList<Integer>();

        listaServicios2.add((Servicio)productoctrl.obtener(2));
        listaIdServicios2.add(2);
        listaServicios2.add((Servicio)productoctrl.obtener(3));
        listaIdServicios2.add(3);

        Promocion promocion2 = new Promocion();
        promocion2.setDescuento(10);
        promocion2.setServicios(listaServicios);
        promocion2.setIdServicios(listaIdServicios);
        promocion2.setNombre("Promocion 2");
        promocion2.setDescripcion("Descripcion 2");
        promocion2.calcularPrecioPromocion();
        promocion2.setProveedor(proveedorctrl.obtener(2));

        productoctrl.agregar(promocion2);

    }


    private void harcodeoCarritos() {


        CarritoController carritoController = new CarritoController();
        ClienteController clienteController = new ClienteController();
        ProductoController productoController = new ProductoController();


        Cliente cliente1 = clienteController.obtener(1);
        Carrito carrito1 = cliente1.getCarrito();

        ItemReserva itemReserva1 = new ItemReserva();
        itemReserva1.setProducto(productoController.obtener(1));
        itemReserva1.setSubTotal(productoController.obtener(1).getPrecio());
        Date fechaInicio1 = new Date(116, 9, 19);
        itemReserva1.setFechaInicio(fechaInicio1);
        Date fechaFin1 = new Date(116, 11, 21);
        itemReserva1.setFechaFin(fechaFin1);
        itemReserva1.setCantidad(2);

        carritoController.agregarItem(itemReserva1,carrito1);


        Cliente cliente2 = clienteController.obtener(2);
        Carrito carrito2 = cliente2.getCarrito();

        ItemReserva itemReserva2 = new ItemReserva();
        itemReserva2.setProducto(productoController.obtener(2));
        itemReserva2.setSubTotal(productoController.obtener(2).getPrecio());
        Date fechaInicio2 = new Date(116, 9, 19);
        itemReserva2.setFechaInicio(fechaInicio2);
        Date fechaFin2 = new Date(116, 11, 21);
        itemReserva2.setFechaFin(fechaFin2);
        itemReserva2.setCantidad(3);

        carritoController.agregarItem(itemReserva2,carrito2);


        Cliente cliente3 = clienteController.obtener(3);
        Carrito carrito3 = cliente3.getCarrito();

        ItemReserva itemReserva3 = new ItemReserva();
        itemReserva3.setProducto(productoController.obtener(3));
        itemReserva3.setSubTotal(productoController.obtener(3).getPrecio());
        Date fechaInicio3 = new Date(116, 9, 19);
        itemReserva3.setFechaInicio(fechaInicio3);
        Date fechaFin3 = new Date(116, 10, 24);
        itemReserva3.setFechaFin(fechaFin3);
        itemReserva3.setCantidad(1);

        carritoController.agregarItem(itemReserva3,carrito3);


        Cliente cliente4 = clienteController.obtener(4);
        Carrito carrito4 = cliente4.getCarrito();

        ItemReserva itemReserva4 = new ItemReserva();
        itemReserva4.setProducto(productoController.obtener(4));
        itemReserva4.setSubTotal(productoController.obtener(4).getPrecio());
        Date fechaInicio4 = new Date(116, 9, 19);
        itemReserva4.setFechaInicio(fechaInicio4);
        Date fechaFin4 = new Date(116, 11, 13);
        itemReserva4.setFechaFin(fechaFin4);
        itemReserva4.setCantidad(4);

        carritoController.agregarItem(itemReserva4,carrito4);


        Cliente cliente5 = clienteController.obtener(5);
        Carrito carrito5 = cliente5.getCarrito();

        ItemReserva itemReserva5 = new ItemReserva();
        itemReserva5.setProducto(productoController.obtener(5));
        itemReserva5.setSubTotal(productoController.obtener(5).getPrecio());
        Date fechaInicio5 = new Date(116, 9, 19);
        itemReserva5.setFechaInicio(fechaInicio5);
        Date fechaFin5 = new Date(116, 10, 2);
        itemReserva5.setFechaFin(fechaFin5);
        itemReserva5.setCantidad(4);

        carritoController.agregarItem(itemReserva5,carrito5);


        Cliente cliente6 = clienteController.obtener(6);
        Carrito carrito6 = cliente6.getCarrito();

        ItemReserva itemReserva6 = new ItemReserva();
        itemReserva6.setProducto(productoController.obtener(6));
        itemReserva6.setSubTotal(productoController.obtener(6).getPrecio());
        Date fechaInicio6 = new Date(116, 9, 19);
        itemReserva6.setFechaInicio(fechaInicio6);
        Date fechaFin6 = new Date(116, 12, 22);
        itemReserva6.setFechaFin(fechaFin6);
        itemReserva6.setCantidad(3);

        carritoController.agregarItem(itemReserva6,carrito6);


    }


    private void harcodeoReservas(){

        ReservaController reservactrl = new ReservaController();
        ClienteController clientectrl = new ClienteController();

        reservactrl.nueva(clientectrl.obtener(1));

        reservactrl.nueva(clientectrl.obtener(2));
        reservactrl.nueva(clientectrl.obtener(2));

        reservactrl.nueva(clientectrl.obtener(3));

        reservactrl.nueva(clientectrl.obtener(4));

        reservactrl.nueva(clientectrl.obtener(5));
        reservactrl.nueva(clientectrl.obtener(5));
        reservactrl.nueva(clientectrl.obtener(5));

        reservactrl.nueva(clientectrl.obtener(6));
        reservactrl.nueva(clientectrl.obtener(6));

    }
}
