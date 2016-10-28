package uy.edu.cure.servidor.web;

import uy.edu.cure.servidor.central.dto.Cliente;
import uy.edu.cure.servidor.central.lib.controllers.ClienteController;
import uy.edu.cure.servidor.central.lib.controllers.Hardcodeo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.swing.*;
import java.io.Serializable;

//import uy.edu.cure.servidor.central.lib.controlErroresInteface.ContrasenaValidator;

@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {

    private boolean loggedIn;
    private boolean primerlogin;
    private String username = "not loggedin";
    private String mensaje;
    private Cliente cliente;
    private String contrasena;
    private Integer cantidadItems;
    @ManagedProperty("#{reservaBean}")
    private ReservaBean reservaBean;

    public LoginBean() {
        primerlogin = true;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public String getUsername() {
        return username;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Cliente getCliente() {
        if (cliente == null) {
            cliente = new Cliente();
        }
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public boolean isPrimerlogin() {
        return primerlogin;
    }

    public void setPrimerlogin(boolean primerlogin) {
        this.primerlogin = primerlogin;
    }

    public ReservaBean getReservaBean() {
        return reservaBean;
    }

    public void setReservaBean(ReservaBean reservaBean) {
        this.reservaBean = reservaBean;
    }

    public String controloPassword() {
        if (primerlogin) {
            Hardcodeo hardcodeo = new Hardcodeo();
            primerlogin = false;
        }
        ClienteController clienteController = new ClienteController();
        String a = "@";
        String correo = cliente.getNickname();
        int intIndex = correo.indexOf(a);
        if (intIndex == -1) {
            if (clienteController.comprobarlogin(cliente.getNickname(), cliente.getContrasena())) {
                cliente = clienteController.obtenerXNombre(cliente.getNickname());
                loggedIn = true;
                mensaje = null;
                cantidadItems = cliente.getCarrito().getItems().size();
                reservaBean.cargarReservas(cliente);
                return "secured/index?faces-redirect=true";
            } else {
                if (clienteController.nicknameExiste(this.cliente.getNickname())) {
                    mensaje = "Contraseña incorrecta";
                } else {
                    mensaje = "Usuario no existe";
                }
                return null;
            }
        } else {
            cliente.setCorreo(cliente.getNickname());
            if (clienteController.comprobarloginMail(cliente.getCorreo(), cliente.getContrasena())) {
                cliente = clienteController.obtenerXMail(cliente.getCorreo());
                loggedIn = true;
                mensaje = null;
                cantidadItems = cliente.getCarrito().getItems().size();
                reservaBean.cargarReservas(cliente);
                return "secured/index?faces-redirect=true";
            } else {
                if (clienteController.emailExiste(this.cliente.getCorreo())) {
                    mensaje = "Contraseña incorrecta";
                } else {
                    mensaje = "Usuario no existe";
                }
                return null;
            }
        }
    }

    public boolean emailExiste(String email){
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        email = request.getParameter("form1:inputCORREO");
        ClienteController clienteController = new ClienteController();
        if (clienteController.emailExiste(email)) {
            mensaje = "Email existe";
            return true;
        }
        else {
            mensaje = "";
            return false;
        }
    }

    public boolean altaUsuarioExiste(String usuario) {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        usuario = request.getParameter("form1:inputID");
        cliente.setNickname(usuario);
        if (primerlogin) {
            Hardcodeo hardcodeo = new Hardcodeo();
            primerlogin = false;
        }
        if (usuarioExiste()) {
            mensaje = "Usuario existe";
            return true;
        }
        else {
            mensaje = "";
            return false;
        }
    }

    public boolean usuarioExiste() {
        ClienteController clienteController = new ClienteController();
        if (clienteController.nicknameExiste(cliente.getNickname())) {
            this.setMensaje("El usuario ya existe");
            mensaje = "Bienvenido";
            return true;
        } else {
            mensaje = "";
            return false;
        }
    }

    public String nuevoUsuario() {
        if (!usuarioExiste()) {
            if (comparoContrasenas()) {
                ClienteController clienteController = new ClienteController();
                clienteController.nuevo(cliente);
                mensaje = "Cliente creado correctamente";
                cliente = null;
                return "login?faces-redirect=true";
            }
        } else {
            mensaje = "El usuario ya existe";
        }
        return mensaje;
    }

    public boolean comparoContrasenas() {
        if (!contrasena.equals(cliente.getContrasena())) {
            mensaje = "Las contrasenas no coinciden";
            return false;
        } else {
            return true;
        }

    }

    public String cerrarSesion() {
        loggedIn = false;
        cliente = null;
        return "index?faces-redirect=true";
    }

    public Integer getCantidadItems() {
        return cantidadItems;
    }

    public void setCantidadItems(Integer cantidadItems) {
        this.cantidadItems = cantidadItems;
    }
}
