package uy.edu.cure.servidor.web;


import uy.edu.cure.servidor.central.dto.Cliente;
import uy.edu.cure.servidor.central.lib.controllers.ClienteController;

import java.io.Serializable;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean
@SessionScoped
public class UsuarioBean implements Serializable{
    private Integer id;
    private String nickname;
    private String nombre;
    private String apellido;
    private String correo;
    private Date fechaNacimiento;
    private String imagen;
    private String textoErrorNombre;
    private boolean errorNombre;

    public String accion(){
        ClienteController clienteController = new ClienteController();
        this.setErrorNombre(false);
        this.setTextoErrorNombre("");
        if(clienteController.nicknameExiste(this.getNickname())) {
            this.setErrorNombre(true);
            this.setTextoErrorNombre("El usuario ya existe");
        }else  if(!this.getNickname().equals("")){
            this.setErrorNombre(true);
            this.setTextoErrorNombre("Debe ingresar un nombre");
        }else{
            return "welcome";
        }
        return "";
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
}
