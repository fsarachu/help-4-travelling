package uy.edu.cure.servidor.central.lib.controlErroresInteface;

import uy.edu.cure.servidor.central.dto.Categoria;
import uy.edu.cure.servidor.central.lib.controllers.CategoriaController;

import java.util.List;

public class CategoriaValidator {

    public boolean validator(String nombre, Categoria padre) {
        boolean valido = true;
        CategoriaController categoriaController = new CategoriaController();
        List<Categoria> categorias = categoriaController.listar();
        for (Categoria cate : categorias) {
            if (cate.getNombre() == nombre && cate.getPadre() == padre) {
                valido = false;
            }
        }
        return valido;
    }
}
