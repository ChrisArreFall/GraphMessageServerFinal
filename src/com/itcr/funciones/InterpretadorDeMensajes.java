package com.itcr.funciones;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.itcr.usuario.Contenedor;

public class InterpretadorDeMensajes {
	private Contenedor mensaje;
	
	public InterpretadorDeMensajes(String mensaje){
		this.mensaje = new Contenedor();
		GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        this.mensaje = gson.fromJson(mensaje, Contenedor.class);
	}

	public Contenedor getMensaje() {
		return mensaje;
	}

	public void setMensaje(Contenedor mensaje) {
		this.mensaje = mensaje;
	}
	
	
}
