package uy.edu.cure.servidor.central.lib.controllers;

import uy.edu.cure.servidor.central.dto.Categoria;
import uy.edu.cure.servidor.central.lib.servicios.CategoriaService;
import uy.edu.cure.servidor.central.lib.servicios.ServiceFactory;

import java.util.ArrayList;

public class CategoriaController {

    public void nueva(Categoria categoria) {
        CategoriaService categoriaService = ServiceFactory.getCategoriaService();

        categoriaService.agregar(categoria.getId(), categoria);
    }

    public void eliminar(int id) {
        CategoriaService ciudadService = ServiceFactory.getCategoriaService();

        ciudadService.eliminar(id);
    }

    public Categoria obtener(Integer id) {
        CategoriaService ciudadService = ServiceFactory.getCategoriaService();

        return ciudadService.obtener(id);
    }

    public void modificar(Integer id, Categoria ciudad1) {
        CategoriaService ciudadService = ServiceFactory.getCategoriaService();

        ciudadService.modificar(id, ciudad1);
    }

    public ArrayList<Categoria> listar() {
        CategoriaService categoriaService = ServiceFactory.getCategoriaService();

        return categoriaService.listar();
    }
}
