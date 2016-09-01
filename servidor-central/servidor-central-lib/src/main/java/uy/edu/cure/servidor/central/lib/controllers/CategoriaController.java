package uy.edu.cure.servidor.central.lib.controllers;

import uy.edu.cure.servidor.central.dto.Categoria;
import uy.edu.cure.servidor.central.lib.servicios.CategoriaService;
import uy.edu.cure.servidor.central.lib.servicios.ServiceFactory;

public class CategoriaController {
    public void alta(Categoria categoria) {
        CategoriaService categoriaService = ServiceFactory.getCategoriaService();

        if(categoria.getPadre() != null) {
            Categoria padre = categoriaService.obtener(categoria.getPadre().getNombre());

            padre.getHijos().add(categoria); // Si padre null?
        }

        categoriaService.agregar(categoria);
    }
}
