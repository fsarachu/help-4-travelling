package uy.edu.cure.servidor.central.dto;

public abstract class Producto {
    private Integer id;
    private String nombre;
    private String descripcion;
    private double precio;
    private Proveedor proveedor;
    private TipoProducto tipo;

    public Producto() {

    }
    public Producto(Integer id, String nombre, String descripcion, double precio, Proveedor proveedor, TipoProducto tipo) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.proveedor = proveedor;
        this.tipo = tipo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public TipoProducto getTipo() {
        return tipo;
    }

    protected void setTipo(TipoProducto tipo) {
        this.tipo = tipo;
    }

}
