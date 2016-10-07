/*package uy.edu.cure.servidor.web;


import uy.edu.cure.servidor.central.dto.Cliente;
import uy.edu.cure.servidor.central.dto.Usuario;
import uy.edu.cure.servidor.central.lib.controlErroresInteface.ContrasenaValidator;
import uy.edu.cure.servidor.central.lib.controllers.ClienteController;
import uy.edu.cure.servidor.central.lib.controllers.Hardcodeo;

import java.io.Serializable;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean
@SessionScoped
public class UsuarioBean implements Serializable{
    private Usuario usuario;
    private Integer id;
    private String nickname;
    private String nombre;
    private String apellido;
    private String correo;
    private Date fechaNacimiento;
    private String imagen;
    private String contrasena;
    private String textoErrorNombre;
    private boolean errorNombre;

    public UsuarioBean(){
        cargarHardcodeo();
    }
    public void cargarHardcodeo(){
        Hardcodeo hardcodeo = new Hardcodeo();
    }



    public UsuarioBean(Integer id, String nickname, String nombre, String apellido, String correo, Date fechaNacimiento, String imagen, String contrasena, String textoErrorNombre, boolean errorNombre) {
        this.id = id;
        this.nickname = nickname;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.fechaNacimiento = fechaNacimiento;
        this.imagen = imagen;
        this.contrasena = contrasena;
        this.textoErrorNombre = textoErrorNombre;
        this.errorNombre = errorNombre;
    }

    public boolean getErrorNombre() { return errorNombre; }

    public void setErrorNombre(boolean errorNombre) {
        this.errorNombre = errorNombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getTextoErrorNombre() {
        return textoErrorNombre;
    }

    public void setTextoErrorNombre(String textoErrorNombre) {
        this.textoErrorNombre = textoErrorNombre;
    }

    public boolean isErrorNombre() {
        return errorNombre;
    }

    public String getContrasena() { return contrasena; }

    public void setContrasena(String contrasena) { this.contrasena = contrasena; }

    public Usuario getUsuario() {
        if (usuario == null){
            usuario =new Cliente();
        }
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
*/