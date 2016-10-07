package uy.edu.cure.servidor.web;

import uy.edu.cure.servidor.central.dto.Cliente;
import uy.edu.cure.servidor.central.lib.controlErroresInteface.ContrasenaValidator;
import uy.edu.cure.servidor.central.lib.controllers.ClienteController;
import uy.edu.cure.servidor.central.lib.controllers.Hardcodeo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class LoginBean {

	private boolean loggedIn;
	private boolean primerlogin;
	private String username = "not loggedin";
	private String mensaje;
	private Cliente cliente;

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

	public Cliente getCliente() {
		if (cliente == null) {
			cliente = new Cliente();
		}
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String controloPassword() {
		if (primerlogin) {
			Hardcodeo hardcodeo = new Hardcodeo();
			primerlogin = false;
		}
		ContrasenaValidator contrasenaValidator = new ContrasenaValidator();
        if (contrasenaValidator.validate(cliente)) {
		//if (nickname.equals("victor") && contrasena.equals("1234")) {
			loggedIn = true;
			return null;
		} else {
			return mensaje="Usuario incorrecto";
		}
	}

	public String usuarioExiste(){
		ClienteController clienteController = new ClienteController();
		if(clienteController.nicknameExiste(this.cliente.getNickname())) {
			this.setMensaje("El usuario ya existe");
		    return "welcome";
		}
		return "";
	}

}
