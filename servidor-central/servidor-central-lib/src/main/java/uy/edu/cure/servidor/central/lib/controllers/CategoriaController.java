package uy.edu.cure.servidor.central.lib.controllers;

import uy.edu.cure.servidor.central.dto.Categoria;
import uy.edu.cure.servidor.central.lib.servicios.CategoriaService;
import uy.edu.cure.servidor.central.lib.servicios.ServiceFactory;

import java.util.ArrayList;

public class CategoriaController {
    public void alta(Categoria categoria) {
        CategoriaService categoriaService = ServiceFactory.getCategoriaService();

        if (categoria.getPadre() != null) {
            Categoria padre = categoriaService.obtener(categoria.getPadre().getId());

            padre.getHijos().add(categoria); // Si padre null?
        }

        categoriaService.agregar(categoria.getId(), categoria);
    }

    public ArrayList<Categoria> listar() {
        CategoriaService categoriaService = ServiceFactory.getCategoriaService();

        return categoriaService.listar();
    }
}
