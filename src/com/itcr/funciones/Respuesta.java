package com.itcr.funciones;

import java.util.LinkedList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.itcr.estructurasDeDatos.Grafo;
import com.itcr.usuario.ID;

public class Respuesta {
	private LinkedList<ID> listaBlanca = new LinkedList<ID>();
	private Grafo<ID> grafoGeneral = new Grafo<ID>();
	
	
	public Respuesta(){
	}


	public LinkedList<ID> getListaBlanca() {
		return listaBlanca;
	}


	public Grafo<ID> getGrafoGeneral() {
		return grafoGeneral;
	}


	public void setListaBlanca(LinkedList<ID> listaBlanca) {
		this.listaBlanca = listaBlanca;
	}


	public void setGrafoGeneral(Grafo<ID> grafoGeneral) {
		this.grafoGeneral = grafoGeneral;
	}
	
	
	public static String JSONRespuesta(Respuesta respuesta){
		GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        String respuestaJSON = gson.toJson(respuesta);
		return respuestaJSON;
	}

}
