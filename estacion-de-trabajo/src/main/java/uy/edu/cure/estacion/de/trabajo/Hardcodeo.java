package uy.edu.cure.estacion.de.trabajo;

import uy.edu.cure.servidor.central.dto.*;
import uy.edu.cure.servidor.central.lib.controllers.CategoriaController;
import uy.edu.cure.servidor.central.lib.controllers.CiudadController;
import uy.edu.cure.servidor.central.lib.controllers.ProveedorController;

import java.util.Date;


public class Hardcodeo {


    public Hardcodeo() {
        harcodeoCategoria();
        hardcodeoCiudadPais();
        harcodeoProveedor();
    }
    private void hardcodeoCiudadPais() {
        CiudadController ciudadController = new CiudadController();
        Ciudad ciudad = new Ciudad();
        Pais pais = new Pais();
        pais.setId(1);
        pais.setNombre("Uruguay");
        ciudad.setId(1);
        ciudad.setNombre("Maldonado");
        ciudad.setPais(pais);
        ciudadController.nueva(ciudad);
        Ciudad ciudad2 = new Ciudad();
        ciudad2.setId(2);
        ciudad2.setNombre("Punta del este");
        ciudad2.setPais(pais);
        ciudadController.nueva(ciudad2);
        Pais pais1 = new Pais();
        pais1.setId(2);
        pais1.setNombre("Brasil");
        Ciudad ciudad3 = new Ciudad();
        ciudad3.setId(3);
        ciudad3.setNombre("Floripa");
        ciudad3.setPais(pais);
        ciudadController.nueva(ciudad3);
    }

    private void harcodeoCategoria() {
        CategoriaController categoriaController = new CategoriaController();
        Categoria prueba = new Categoria();
        prueba.setId(1);
        prueba.setPadre(null);
        prueba.setNombre("Autos");
        categoriaController.nueva(prueba);
        Categoria prueba1 = new Categoria();
        prueba1.setId(2);
        prueba1.setPadre(null);
        prueba1.setNombre("Vuelos");
        categoriaController.nueva(prueba1);
        Categoria prueba2 = new Categoria();
        prueba2.setId(3);
        prueba2.setPadre(null);
        prueba2.setNombre("Hotel");
        categoriaController.nueva(prueba2);
        Categoria prueba3 = new Categoria();
        prueba3.setId(4);
        prueba3.setPadre(prueba2);
        prueba3.setNombre("premio");
        categoriaController.nueva(prueba3);
    }
    private void harcodeoProveedor() {
        ProveedorController proveedorController = new ProveedorController();
        Proveedor proveedor = new Proveedor();
        proveedor.setId(1);
        proveedor.setNombre("Conaprole");
        proveedor.setNickname("Conaprole");
        Date nacimiento = new Date(2016,02,12);
        proveedor.setFechaNacimiento(nacimiento);
        proveedor.setNombreEmpresa("Conaprole S.A.");
        proveedorController.nuevo(proveedor);
        Proveedor proveedor1 = new Proveedor();
        proveedor1.setId(2);
        proveedor1.setNombre("Parmalat");
        proveedor1.setNickname("Parmalat");
        Date nacimiento1 = new Date(2016,02,15);
        proveedor1.setFechaNacimiento(nacimiento);
        proveedor1.setNombreEmpresa("Parmalat LTDA");
        proveedorController.nuevo(proveedor1);
    }
}
