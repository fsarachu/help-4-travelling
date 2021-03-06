package uy.edu.cure.servidor.central.lib.controllers;

import uy.edu.cure.servidor.central.dto.Categoria;
import uy.edu.cure.servidor.central.dto.EstadoCategoria;
import uy.edu.cure.servidor.central.lib.servicios.CategoriaService;
import uy.edu.cure.servidor.central.lib.servicios.ServiceFactory;

import java.util.ArrayList;

public class CategoriaController {
    private CategoriaService categoriaService;

    public CategoriaController() {
        this.categoriaService = ServiceFactory.getCategoriaService();
    }

    public void nueva(Categoria nuevaCategoria) {
        nuevaCategoria.setId(this.categoriaService.nextId());

        Categoria padre = nuevaCategoria.getPadre();
        if (padre != null) {
            padre.getHijos().add(nuevaCategoria);
        }

        this.categoriaService.agregar(nuevaCategoria.getId(), nuevaCategoria);
    }

    public void ocultar(Categoria categoria) {
        categoria.setEstado(EstadoCategoria.oculta);

        ArrayList<Categoria> hijos = categoria.getHijos();

        for (Categoria hijo : hijos) {
            ocultar(hijo);
        }
    }

    public Categoria obtener(Integer idCategoria) {
        return this.categoriaService.obtener(idCategoria);
    }

    public void modificar(Categoria categoria) {
        this.categoriaService.modificar(categoria.getId(), categoria);
    }

    public ArrayList<Categoria> listar() {
        return this.categoriaService.listar();
    }

    public ArrayList<Categoria> listarHijos(Categoria padre) {
        return this.categoriaService.listarHijos(padre);
    }

}
