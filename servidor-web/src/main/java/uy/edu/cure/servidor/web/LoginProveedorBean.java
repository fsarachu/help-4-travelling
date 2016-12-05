package uy.edu.cure.servidor.web;

import eu.bitwalker.useragentutils.UserAgent;
import uy.edu.cure.servidor.central.dto.Log;
import uy.edu.cure.servidor.central.dto.Proveedor;
import uy.edu.cure.servidor.central.lib.controllers.RestController;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Logger;

/**
 * Created by victor on 02/12/16.
 */
@ManagedBean(name = "loginProveedorBean")
@SessionScoped
public class LoginProveedorBean implements Serializable {

    final static Logger logueo = Logger.getLogger(LoginClienteBean.class.getName());
    private HttpServletRequest request;

    private Proveedor proveedor;
    private String mensaje;
    private boolean primerlogin = true;
    private boolean loggedIn;


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

                Log log = new Log();
                log.setUsr(proveedor.getNombre());
                log.setIp(""+InetAddress.getLocalHost());
                log.setUrl("http://localhost:8080/secured/LoginProveedorBean");
                log.setSo(System.getProperty("os.name"));
                guardarLogRest(log);


            /*  String userAgent = request.getHeader("user-agent");
                UserAgent ua = UserAgent.parseUserAgentString(userAgent);
                eu.bitwalker.useragentutils.Version browserVersion = ua.getBrowserVersion();

                String browserName = ua.getBrowser().toString();
                int majVersion = Integer.parseInt(browserVersion.getMajorVersion());
                logueo.warning("BROWSER"+ browserName);
            */


                return "secured/indexProveedores.xhtml?faces-redirect=true";

            } else {
                mensaje = "Proveedor no existe";
            }
            return null;
        } else {
            proveedor.setCorreo(proveedor.getNickname());
            if (comprobarloginMailRest(proveedor.getCorreo(), proveedor.getContrasena())) {
//                    proveedor = obtenerXMailRestProveedor(proveedor.getCorreo());
                loggedIn = true;
                mensaje = null;

                Log log = new Log();
                log.setUsr(proveedor.getNombre());
                log.setIp(""+InetAddress.getLocalHost());
                log.setUrl("http://localhost:8080/secured/LoginProveedorBean");
                log.setSo(System.getProperty("os.name"));
                guardarLogRest(log);

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

    public void guardarLogRest(Log log){
        String url = "http://localhost:8080/servidor-central-webapp/rest/api/loger/guardar";
        RestController rest = new RestController();
        Log u = rest.doPUT(url, log, Log.class);
    }

    public void hardcodeoRest() {
        String url = "http://localhost:8080/servidor-central-webapp/rest/api/hardcodeo/cargar";
        RestController rest = new RestController();
        boolean u = rest.doGET(url, boolean.class);
        System.out.print(u);
    }

    public boolean loginRestProveedor(String nickname, String password) {
        String url = "http://localhost:8080/servidor-central-webapp/rest/api/proveedor/login/" + nickname + "/" + password;
        RestController rest = new RestController();
        boolean u = rest.doGET(url, boolean.class);
        return u;
    }

    public Proveedor obtenerXNombreRestProveedor(String nombre) {
        String url = "http://localhost:8080/servidor-central-webapp/rest/api/proveedor/obtenerXNombre/" + nombre;
        RestController rest = new RestController();
        Proveedor u = rest.doGET(url, Proveedor.class);
        return u;
    }

    public Proveedor obtenerXMailRestProveedor(String mail) {
        String url = "http://localhost:8080/servidor-central-webapp/rest/api/proveedor/obtenerXMail/" + mail;
        RestController rest = new RestController();
        Proveedor u = rest.doGET(url, Proveedor.class);
        return u;
    }

    public boolean existeMailRest(String correo) {
        String url = "http://localhost:8080/servidor-central-webapp/rest/api/proveedor/emailExiste/" + correo;
        RestController rest = new RestController();
        boolean u = rest.doGET(url, boolean.class);
        return u;
    }

    public boolean comprobarloginMailRest(String correo, String contrasena) {
        String url = "http://localhost:8080/servidor-central-webapp/rest/api/cliente/comprobarloginMail/" + correo + "/" + contrasena;
        RestController rest = new RestController();
        boolean u = rest.doGET(url, boolean.class);
        return u;
    }
    public String cerrarSesion() {
        loggedIn = false;
        proveedor = null;
        return "index?faces-redirect=true";
    }


    public Proveedor getProveedor() {
        if (proveedor == null) {
            proveedor = new Proveedor();
        }
        return proveedor;
    }

    public static Logger getLogueo() {
        return logueo;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public boolean isPrimerlogin() {
        return primerlogin;
    }

    public void setPrimerlogin(boolean primerlogin) {
        this.primerlogin = primerlogin;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
}
