package com.itcr.usuario;

import com.itcr.funciones.Mensaje;

public class Contenedor {
	private ID id;
	private Mensaje mensaje = new Mensaje();
	
	public Contenedor(){
		id = new ID();
	}

	
	public ID getId() {
		return id;
	}
	public void setId(ID id) {
		this.id = id;
	}
	public void setMensaje(Mensaje mensaje) {
		this.mensaje = mensaje;
	}
	public Mensaje getMensaje() {
		return mensaje;
	}
	

}
