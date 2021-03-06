package uy.edu.cure.servidor.web;

import uy.edu.cure.servidor.central.dto.Cliente;
import uy.edu.cure.servidor.central.dto.Log;
import uy.edu.cure.servidor.central.lib.controllers.RestController;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;


@ManagedBean(name = "loginClienteBean")
@SessionScoped
public class LoginClienteBean implements Serializable {

    private boolean loggedIn = false;
    private boolean primerlogin = true;
    private String username = "not loggedin";
    private String mensaje;
    private Cliente cliente;
    private String contrasena;
    private Integer cantidadItems;
    @ManagedProperty("#{reservaBean}")
    private ReservaBean reservaBean;


    public LoginClienteBean() {
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

    public String controloPassword() throws UnknownHostException {
        if (primerlogin) {
            hardcodeoRest();
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
                cantidadItems = cliente.getCarrito().getItems().size();

                Log log = new Log();
                log.setUsr(cliente.getNombre());
                log.setIp(""+InetAddress.getLocalHost());
                log.setUrl("http://localhost:8080/secured/LoginBean");
                log.setSo(System.getProperty("os.name"));
                guardarLogRest(log);

                return "secured/index.xhtml?faces-redirect=true";

            } else {
                mensaje = "Usuario no existe";
            }
            return null;
        } else {
            cliente.setCorreo(cliente.getNickname());
            if (comprobarloginMailRest(cliente.getCorreo(), cliente.getContrasena())) {
                loggedIn = true;
                mensaje = null;
                cliente = obtenerXMailRest(cliente.getCorreo());
                cantidadItems = cliente.getCarrito().getItems().size();
                reservaBean.cargarReservas(cliente);

                Log log = new Log();
                log.setUsr(cliente.getNombre());
                log.setIp(""+InetAddress.getLocalHost());
                log.setUrl("http://localhost:8080/secured/LoginBean");
                log.setSo(System.getProperty("os.name"));
                guardarLogRest(log);

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


    public String logueoPerfil() throws UnknownHostException {
        Log log = new Log();
        log.setUsr(cliente.getNombre());
        log.setIp(""+InetAddress.getLocalHost());
        log.setUrl("http://localhost:8080/secured/VerPerfil");
        log.setSo(System.getProperty("os.name"));
        guardarLogRest(log);

        return null;
    }

    public String logueoInfoServicio() throws UnknownHostException {
        Log log = new Log();
        log.setUsr(cliente.getNombre());
        log.setIp(""+InetAddress.getLocalHost());
        log.setUrl("http://localhost:8080/secured/VerInfoServicio");
        log.setSo(System.getProperty("os.name"));
        guardarLogRest(log);

        return null;
    }


    public String logueoInfoReserva() throws UnknownHostException {
        Log log = new Log();
        log.setUsr(cliente.getNombre());
        log.setIp(""+InetAddress.getLocalHost());
        log.setUrl("http://localhost:8080/secured/VerInfoReserva");
        log.setSo(System.getProperty("os.name"));
        guardarLogRest(log);

        return null;
    }

    public String logueoFactura() throws UnknownHostException {
        Log log = new Log();
        log.setUsr(cliente.getNombre());
        log.setIp(""+InetAddress.getLocalHost());
        log.setUrl("http://localhost:8080/secured/PDFFactura");
        log.setSo(System.getProperty("os.name"));
        guardarLogRest(log);

        return null;
    }

    public String logueoComprarReserva() throws UnknownHostException {
        Log log = new Log();
        log.setUsr(cliente.getNombre());
        log.setIp(""+InetAddress.getLocalHost());
        log.setUrl("http://localhost:8080/secured/ComprarReserva");
        log.setSo(System.getProperty("os.name"));
        guardarLogRest(log);

        return null;
    }

    public String logueoMostrarCarrito() throws UnknownHostException {
        Log log = new Log();
        log.setUsr(cliente.getNombre());
        log.setIp(""+InetAddress.getLocalHost());
        log.setUrl("http://localhost:8080/secured/MostrarCarrito");
        log.setSo(System.getProperty("os.name"));
        guardarLogRest(log);

        return null;
    }

    public String logueoAgregarAlCarrito() throws UnknownHostException {
        Log log = new Log();
        log.setUsr(cliente.getNombre());
        log.setIp(""+InetAddress.getLocalHost());
        log.setUrl("http://localhost:8080/secured/AgregarAlCarrito");
        log.setSo(System.getProperty("os.name"));
        guardarLogRest(log);

        return null;
    }



    public void guardarLogRest(Log log){
        String url = "http://localhost:8080/servidor-central-webapp/rest/api/loger/guardar";
        RestController rest = new RestController();
        Log u = rest.doPUT(url, log, Log.class);
    }

    public void hardcodeoRest() {
        String url = "http://localhost:8080/servidor-central-webapp/rest/api/hardcodeo/cargar";
        RestController rest = new RestController();
        boolean u = rest.doGET(url, boolean.class);
    }

    public boolean loginRest(String nickname, String password) {
        String url = "http://localhost:8080/servidor-central-webapp/rest/api/cliente/login/" + nickname + "/" + password;
        RestController rest = new RestController();
        boolean u = rest.doGET(url, boolean.class);
        System.out.print(u);
        return u;
    }


    public boolean comprobarloginMailRest(String correo, String contrasena) {
        String url = "http://localhost:8080/servidor-central-webapp/rest/api/cliente/comprobarloginMail/" + correo + "/" + contrasena;
        RestController rest = new RestController();
        boolean u = rest.doGET(url, boolean.class);
        return u;
    }


    public Cliente obtenerXNombreRest(String cliente) {
        String url = "http://localhost:8080/servidor-central-webapp/rest/api/cliente/obtenerXNombre/"+cliente;
        RestController rest = new RestController();
        Cliente nuevo = rest.doGET(url, Cliente.class);
        return nuevo;
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
        return u;
    }

    public boolean obtenerReservasCliente() {
        return false;
    }

    public boolean comprarReservasCliente() {
        return reservaBean.comprarReserva(cliente);
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
            //          Hardcodeo hardcodeo = new Hardcodeo();
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