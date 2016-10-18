package uy.edu.cure.servidor.web;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;


@ManagedBean
@SessionScoped


public class TreeManagedBean {

    private TreeNode root;

    public TreeManagedBean(){

        this.root = new DefaultTreeNode("Categorias", null);

        TreeNode vehiculos = new DefaultTreeNode("Vehiculos", this.root);     vehiculos.setParent(this.root);
        TreeNode autos = new DefaultTreeNode("Autos", vehiculos);             autos.setParent(vehiculos);
        TreeNode camionetas = new DefaultTreeNode("Camionetas", vehiculos);   camionetas.setParent(vehiculos);


        TreeNode hoteles = new DefaultTreeNode("Hoteles", this.root);         hoteles.setParent(this.root);
        TreeNode cuatro = new DefaultTreeNode("4 Estrellas", hoteles);        cuatro.setParent(hoteles);
        TreeNode hdl = new DefaultTreeNode("Hotel del Lago", cuatro);         hdl.setParent(cuatro);
        TreeNode hdr = new DefaultTreeNode("Hotel del Rio", cuatro);          hdr.setParent(cuatro);

        TreeNode cinco = new DefaultTreeNode("5 Estrellas", hoteles);         cinco.setParent(hoteles);
        TreeNode conrad = new DefaultTreeNode("Conrad", cinco);               conrad.setParent(cinco);
        TreeNode mantra = new DefaultTreeNode("Mantra", cinco);               mantra.setParent(cinco);

        TreeNode vuelos = new DefaultTreeNode("Vuelos", this.root);           vuelos.setParent(this.root);
        TreeNode nac = new DefaultTreeNode("Nacionales", vuelos);             nac.setParent(vuelos);
        TreeNode inter = new DefaultTreeNode("Internacionales", vuelos);      inter.setParent(vuelos);

    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }
}