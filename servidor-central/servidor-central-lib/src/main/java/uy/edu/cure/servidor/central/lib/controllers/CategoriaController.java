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

    public ArrayList<Categoria> listar() {
        CategoriaService categoriaService = ServiceFactory.getCategoriaService();

        return categoriaService.listar();
    }
}
