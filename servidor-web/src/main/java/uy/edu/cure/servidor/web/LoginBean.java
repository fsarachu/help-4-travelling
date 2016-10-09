package uy.edu.cure.servidor.web;

import com.sun.xml.internal.ws.wsdl.writer.document.Part;
import uy.edu.cure.servidor.central.dto.Cliente;
import uy.edu.cure.servidor.central.lib.controlErroresInteface.ContrasenaValidator;
import uy.edu.cure.servidor.central.lib.controllers.ClienteController;
import uy.edu.cure.servidor.central.lib.controllers.Hardcodeo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

	private boolean loggedIn;
	private boolean primerlogin;
	private String username = "not loggedin";
	private String mensaje;
	private Cliente cliente;
	private String contrasena;

	public LoginBean(){
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

	public void controloPassword() {
		if (primerlogin) {
			Hardcodeo hardcodeo = new Hardcodeo();
			primerlogin = false;
		}
		ClienteController clienteController = new ClienteController();
        if (clienteController.comprobarlogin(cliente.getNickname(),cliente.getContrasena())) {
			cliente = clienteController.obtenerXNombre(cliente.getNickname());
			loggedIn = true;
			mensaje = null;
		} else {
			mensaje="Usuario incorrecto";
		}
	}

	public boolean usuarioExiste(){
		ClienteController clienteController = new ClienteController();
		if(clienteController.nicknameExiste(this.cliente.getNickname())) {
			this.setMensaje("El usuario ya existe");
		    mensaje="Bienvenido";
			return true;
		}else {
			mensaje="";
			return false;
		}
	}

	public void nuevoUsuario(){
		if (!usuarioExiste()) {
			if (comparoContrasenas()){
				ClienteController clienteController = new ClienteController();
				clienteController.nuevo(cliente);
				mensaje="Cliente creado correctamente";
				cliente = null;
			}
		} else {
			mensaje="El usuario ya existe";
		}
	}

	public void modificar(){
		ClienteController clienteController = new ClienteController();
		clienteController.modificar(cliente);
	}

	public boolean comparoContrasenas(){
		if(!contrasena.equals(cliente.getContrasena())) {
			mensaje = "Las contrasenas no coinciden";
			return false;
		} else {
			return true;
		}

	}

	public void cerrarSesion(){
		loggedIn = false;
	}

}
