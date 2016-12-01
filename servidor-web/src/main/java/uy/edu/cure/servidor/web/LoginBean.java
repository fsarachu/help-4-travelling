package uy.edu.cure.servidor.web;

import eu.bitwalker.useragentutils.UserAgent;
import uy.edu.cure.servidor.central.dto.Cliente;
import uy.edu.cure.servidor.central.dto.Proveedor;
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
import java.util.logging.Logger;


@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {

    final static Logger logueo = Logger.getLogger(LoginBean.class.getName());
    private HttpServletRequest request;

    private boolean loggedIn;
    private boolean primerlogin;
    private String username = "not loggedin";
    private String mensaje;
    private Cliente cliente;
    private Proveedor proveedor;
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

    public Proveedor getProveedor() {
        if (proveedor == null) {
            proveedor = new Proveedor();
        }
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
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
            cliente = obtenerXNombreRest(cliente.getNickname());
            if (cliente != null) {
                if (loginRest(cliente.getNickname(), cliente.getContrasena())) {
                    loggedIn = true;
                    mensaje = null;
                    cantidadItems = cliente.getCarrito().getItems().size();


                    logueo.warning("USR : " + cliente.getNombre());
                    logueo.warning("IP  : " + InetAddress.getLocalHost());
                    logueo.warning("URL : " + "http://localhost:8080/secured/LoginBean");
                    logueo.warning("S.O : " + System.getProperty("os.name"));



            /*  String userAgent = request.getHeader("user-agent");
                UserAgent ua = UserAgent.parseUserAgentString(userAgent);
                eu.bitwalker.useragentutils.Version browserVersion = ua.getBrowserVersion();

                String browserName = ua.getBrowser().toString();
                int majVersion = Integer.parseInt(browserVersion.getMajorVersion());
                logueo.warning("BROWSER"+ browserName);
            */


                    return "secured/index?faces-redirect=true";

                } else {
                    mensaje = "Usuario no existe";
                }
            }
            return null;
        } else {
            cliente.setCorreo(cliente.getNickname());
            cliente = obtenerXMailRest(cliente.getCorreo());
            if (cliente != null) {
                if (comprobarloginMailRest(cliente.getCorreo(), cliente.getContrasena()) && proveedor == null) {
                    loggedIn = true;
                    mensaje = null;
                    cantidadItems = cliente.getCarrito().getItems().size();
                    reservaBean.cargarReservas(cliente);

                    logueo.warning("USR : " + cliente.getNombre());
                    logueo.warning("IP  : " + InetAddress.getLocalHost());
                    logueo.warning("URL : " + "http://localhost:8080/secured/LoginBean");
                    logueo.warning("S.O : " + System.getProperty("os.name"));


                    String userAgent = request.getHeader("user-agent");
                    UserAgent ua = UserAgent.parseUserAgentString(userAgent);
                    eu.bitwalker.useragentutils.Version browserVersion = ua.getBrowserVersion();

                    String browserName = ua.getBrowser().toString();
                    int majVersion = Integer.parseInt(browserVersion.getMajorVersion());
                    logueo.warning("BROWSER" + browserName);


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
        return null;
    }

    public String controloProveedor() throws UnknownHostException {
        if (primerlogin) {
            hardcodeoRest();
            primerlogin = false;
        }
        String a = "@";
        String correo = proveedor.getNickname();
        int intIndex = correo.indexOf(a);
        if (intIndex == -1) {
            if (loginRestProveedor(proveedor.getNickname(), proveedor.getContrasena())) {
                proveedor = obtenerXNombreRestProveedor(proveedor.getNickname());
                loggedIn = true;
                mensaje = null;

                logueo.warning("USR : " + proveedor.getNombre());
                logueo.warning("IP  : " + InetAddress.getLocalHost());
                logueo.warning("URL : " + "http://localhost:8080/secured/LoginBean");
                logueo.warning("S.O : " + System.getProperty("os.name"));



            /*  String userAgent = request.getHeader("user-agent");
                UserAgent ua = UserAgent.parseUserAgentString(userAgent);
                eu.bitwalker.useragentutils.Version browserVersion = ua.getBrowserVersion();

                String browserName = ua.getBrowser().toString();
                int majVersion = Integer.parseInt(browserVersion.getMajorVersion());
                logueo.warning("BROWSER"+ browserName);
            */


                return "secured/indexProveedores?faces-redirect=true";

            } else {
                mensaje = "Proveedor no existe";
            }
            return null;
        } else {
            proveedor.setCorreo(proveedor.getNickname());
            if (comprobarloginMailRest(proveedor.getCorreo(), proveedor.getContrasena())) {
                proveedor = obtenerXMailRestProveedor(proveedor.getCorreo());
                loggedIn = true;
                mensaje = null;

                logueo.warning("USR : " + proveedor.getNombre());
                logueo.warning("IP  : " + InetAddress.getLocalHost());
                logueo.warning("URL : " + "http://localhost:8080/secured/LoginBean");
                logueo.warning("S.O : " + System.getProperty("os.name"));


                String userAgent = request.getHeader("user-agent");
                UserAgent ua = UserAgent.parseUserAgentString(userAgent);
                eu.bitwalker.useragentutils.Version browserVersion = ua.getBrowserVersion();

                String browserName = ua.getBrowser().toString();
                int majVersion = Integer.parseInt(browserVersion.getMajorVersion());
                logueo.warning("BROWSER" + browserName);


                return "secured/indexProveedores?faces-redirect=true";
            } else {
                if (existeMailRest(proveedor.getCorreo())) {
                    mensaje = "Contraseña incorrecta";
                } else {
                    mensaje = "Proveedor no existe";
                }
                return null;
            }
        }

    }


    public void hardcodeoRest() {
        String url = "http://localhost:8080/servidor-central-webapp/rest/api/hardcodeo/cargar";
        RestController rest = new RestController();
        boolean u = rest.doGET(url, boolean.class);
        System.out.print(u);
    }

    public boolean loginRest(String nickname, String password) {
        String url = "http://localhost:8080/servidor-central-webapp/rest/api/cliente/login/" + nickname + "/" + password;
        RestController rest = new RestController();
        boolean u = rest.doGET(url, boolean.class);
        System.out.print(u);
        return true;
    }

    public boolean loginRestProveedor(String nickname, String password) {
        String url = "http://localhost:8080/servidor-central-webapp/rest/api/proveedor/login/" + nickname + "/" + password;
        RestController rest = new RestController();
        boolean u = rest.doGET(url, boolean.class);
        return true;
    }


    public Cliente obtenerRest(Integer cliente) {
        String url = "http://localhost:8080/servidor-central-webapp/rest/api/cliente/obtener/" + cliente;
        RestController rest = new RestController();
        Cliente u = rest.doGET(url, Cliente.class);
        System.out.println("USER ID: " + u.getId());
        return u;
    }

    public boolean comprobarloginMailRest(String correo, String contrasena) {
        String url = "http://localhost:8080/servidor-central-webapp/rest/api/cliente/comprobarloginMail/" + correo + "/" + contrasena;
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

    public Proveedor obtenerXNombreRestProveedor(String cliente) {
        String url = "http://localhost:8080/servidor-central-webapp/rest/api/proveedor/obtenerXNombre/" + cliente;
        RestController rest = new RestController();
        Proveedor u = rest.doGET(url, Proveedor.class);
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
        return u;
    }


    public Proveedor obtenerXMailRestProveedor(String mail) {
        String url = "http://localhost:8080/servidor-central-webapp/rest/api/proveedor/obtenerXMail/" + mail;
        RestController rest = new RestController();
        Proveedor u = rest.doGET(url, Proveedor.class);
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