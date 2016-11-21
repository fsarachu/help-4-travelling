package uy.edu.cure.servidor.web;

import uy.edu.cure.servidor.central.dto.*;
import uy.edu.cure.servidor.central.webapp.rest.api.RestControllers.ClienteRestController;
import uy.edu.cure.servidor.central.webapp.rest.api.RestControllers.RestController;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.Random;


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
            HardcodeoBean hardcodeoBean = new HardcodeoBean();
            primerlogin = false;
        }
        String a = "@";
        String correo = cliente.getNickname();
        int intIndex = correo.indexOf(a);
        if (intIndex == -1) {
            if (loginRest(cliente.getNickname(), cliente.getContrasena())) {
                cliente = obtenerXNombreRest(cliente.getNickname());
                loggedIn = true;
                mensaje = null;
                //cantidadItems = cliente.getCarrito().getItems().size();
                return "secured/index?faces-redirect=true";
            } else {
                mensaje = "Usuario no existe";
            }
            return null;
        } else {
            cliente.setCorreo(cliente.getNickname());
            if (comprobarloginMailRest(cliente.getCorreo(), cliente.getContrasena())) {
                cliente = obtenerXMailRest(cliente.getCorreo());
                loggedIn = true;
                mensaje = null;
                cantidadItems = cliente.getCarrito().getItems().size();
                reservaBean.cargarReservas(cliente);
                return "secured/index?faces-redirect=true";
            } else {
                if (existeMailRest(cliente.getCorreo())) {
                    mensaje = "Contraseña incorrecta";
                } else {
                    mensaje = "Usuario no existe";
                }
                return null;
            }
        }
    }

    public boolean loginRest(String nickname, String password) {
        String url = "http://localhost:8080/servidor-central-webapp/rest/api/cliente/login/" + nickname + "/" + password;
        RestController rest = new RestController();
        boolean u = rest.doGET(url, boolean.class);
        System.out.print(u);
        return u;
    }

    public Cliente obtenerRest(Integer cliente) {
        String url = "http://localhost:8080/servidor-central-webapp/rest/api/cliente/obtener/" + cliente;
        RestController rest = new RestController();
        Cliente u = rest.doGET(url, Cliente.class);
        System.out.println("USER ID: " + u.getId());
        return u;
    }



    public boolean comprobarloginMailRest(String correo, String contrasena) {
        String url = "http://localhost:8080/servidor-central-webapp/rest/api/cliente/comprobarloginmail/" + correo + "/" + contrasena;
        RestController rest = new RestController();
        boolean u = rest.doGET(url, boolean.class);
        return u;
    }


    public Cliente obtenerXNombreRest(String cliente) {
        String url = "http://localhost:8080/servidor-central-webapp/rest/api/cliente/obtenerXNombre/" + cliente;
        RestController rest = new RestController();
        Cliente u = rest.doGET(url, Cliente.class);
        return u;
    }

    public boolean existeMailRest(String correo) {
        String url = "http://localhost:8080/servidor-central-webapp/rest/api/cliente/emailExiste/" + correo;
        RestController rest = new RestController();
        boolean u = rest.doGET(url, boolean.class);
        return u;
    }

    public Cliente obtenerXMailRest(String mail) {
        String url = "http://localhost:8080/servidor-central-webapp/rest/api/cliente/obtenerXMail/" + mail;
        RestController rest = new RestController();
        Cliente u = rest.doGET(url, Cliente.class);
        System.out.println("USER ID: " + u.getId());
        return u;
    }


    public boolean nicknameExisteRest(String nickname) {
        String url = "http://localhost:8080/servidor-central-webapp/rest/api/cliente/nicknameExiste/" + nickname;
        RestController rest = new RestController();
        boolean u = rest.doGET(url, boolean.class);
        return u;
    }

    public boolean emailExiste(String email) {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        email = request.getParameter("form1:inputCORREO");
        ClienteRestController clienteController = new ClienteRestController();
        if (existeMailRest(email)) {
            mensaje = "Email existe";
            return true;
        } else {
            mensaje = "";
            return false;
        }
    }

    public boolean altaUsuarioExiste(String usuario) {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        usuario = request.getParameter("form1:inputID");
        cliente.setNickname(usuario);
        if (primerlogin) {
            //HardcodeoRestController hardcodeo = new HardcodeoRestController();
            primerlogin = false;
        }
        if (usuarioExiste()) {
            Random rnd = new Random();
            mensaje = "Usuario existe.... Sugerido: " + usuario + (int) (rnd.nextDouble() * 100);
            return true;
        } else {
            mensaje = "";
            return false;
        }
    }

    public boolean usuarioExiste() {
        if (nicknameExisteRest(cliente.getNickname())) {
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
                String url = "http://localhost:8080/servidor-central-webapp/rest/api/cliente/nuevo/";
                RestController rest = new RestController();
                Cliente u = rest.doPUT(url, cliente, Cliente.class);
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
