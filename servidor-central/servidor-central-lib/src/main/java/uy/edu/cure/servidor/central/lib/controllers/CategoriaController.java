package uy.edu.cure.servidor.central.lib.controllers;

import uy.edu.cure.servidor.central.dto.Categoria;
import uy.edu.cure.servidor.central.lib.servicios.CategoriaService;
import uy.edu.cure.servidor.central.lib.servicios.ServiceFactory;

import java.util.ArrayList;

public class CategoriaController {
    private CategoriaService categoriaService;

    public CategoriaController() {
        this.categoriaService = ServiceFactory.getCategoriaService();
    }

    public void nueva(Categoria categoria) {
        this.categoriaService.agregar(categoria.getId(), categoria);
    }

    public void eliminar(Integer idCategoria) {
        this.categoriaService.eliminar(idCategoria);
    }

    public Categoria obtener(Integer id) {
        return this.categoriaService.obtener(id);
    }

    public void modificar(Integer id, Categoria ciudad1) {
        this.categoriaService.modificar(id, ciudad1);
    }

    public ArrayList<Categoria> listar() {
        return this.categoriaService.listar();
    }

    public ArrayList<Categoria> listarHijos(Categoria padre) {
        return this.categoriaService.listarHijos(padre);
    }


}
