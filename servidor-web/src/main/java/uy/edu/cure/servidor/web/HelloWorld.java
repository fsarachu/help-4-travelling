package uy.edu.cure.servidor.web;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@SessionScoped
public class HelloWorld implements Serializable {

	private String name;
	private String lastName;
	private String textoErrorNombre;
	private int numeros;
	private List<String> opciones;
	
	public HelloWorld(){
		opciones = new ArrayList<>();
		opciones.add("Opción 1");
		opciones.add("Opción 2");
		opciones.add("Opción N");
	}
	
	
	public List<String> getOpciones() {
		return opciones;
	}

	public void setOpciones(List<String> opciones) {
		this.opciones = opciones;
	}

	public int getNumeros() {
		return numeros;
	}

	public void setNumeros(int numeros) {
		this.numeros = numeros;
	}

	public String getTextoErrorNombre() {
		return textoErrorNombre;
	}

	public void setTextoErrorNombre(String textoErrorNombre) {
		this.textoErrorNombre = textoErrorNombre;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	private boolean errorNombre;
	
	
	public boolean getErrorNombre() {
		return errorNombre;
	}

	public void setErrorNombre(boolean errorNombre) {
		this.errorNombre = errorNombre;
	}

	public String accion(){
		this.setErrorNombre(false);
		this.setTextoErrorNombre("");
		if(this.getName().equals("miguel")){
			this.setErrorNombre(true);
			this.setTextoErrorNombre("El usuario ya existe");
		}else  if(!this.getName().equals("")){
			return "welcome";
		}else{
			this.setErrorNombre(true);
			this.setTextoErrorNombre("Debe ingresar un nombre");
		}		
		return "";
	}
	

}
