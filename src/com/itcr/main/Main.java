package com.itcr.main;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.LinkedList;

import com.itcr.conexion.Server;
import com.itcr.estructurasDeDatos.BTree;
import com.itcr.estructurasDeDatos.Grafo;
import com.itcr.funciones.Mensaje;
import com.itcr.funciones.Peso;
import com.itcr.funciones.Respuesta;
import com.itcr.interfaz.Interfaz;
import com.itcr.usuario.Contenedor;
import com.itcr.usuario.ID;
import com.itcr.visualizer.Graph;
public class Main {
	public static LinkedList<ID> listaBlanca = new LinkedList<ID>();
	public static LinkedList<ID> listaNegra = new LinkedList<ID>();
	public static LinkedList<String> listaMalasPalabras = new LinkedList<String>();
	public static Grafo<ID> grafoGeneral = new Grafo<ID>();
	public static LinkedList<Mensaje> mensajes = new LinkedList<Mensaje>();
	public static Graph g = new Graph();
	

	public static void main(String[] args) throws FileNotFoundException, InterruptedException {
		Interfaz.main();
		new Server();
		listaNegra = obtenerArchivo("/Users/chrisarrefall/Documents/listaNegra.xml");
		listaBlanca = obtenerArchivo("/Users/chrisarrefall/Documents/listaBlanca.xml");
	}
	
	@SuppressWarnings("unchecked")
	private static LinkedList<ID> obtenerArchivo(String fileName) throws FileNotFoundException{
		LinkedList<ID> archivo = new LinkedList<ID>();
		XMLDecoder decoder = new XMLDecoder(new FileInputStream(fileName));
		archivo = (LinkedList<ID>)decoder.readObject();
		decoder.close();
		return archivo;
	}
	
	public static Boolean analizarLista(LinkedList<ID> lista, String MAC){
		for(int i = 0; i < lista.size(); i++){
			if(lista.get(i).getMAC().equals(MAC)){
				return true;
			}
		}
		return false;
	}
	
	public static Boolean analizarMalasPalabras(BTree<Integer, String> arbolDePalabras){
		for(int i = 0; i < arbolDePalabras.height(); i++){
			if(listaMalasPalabras.contains(arbolDePalabras.get(i))){
				return true;
			}
		}
		return false;
	}
	
	public static Respuesta actualizadorRespuesta(){
		Respuesta respuesta = new Respuesta();
		respuesta.setGrafoGeneral(grafoGeneral);
		respuesta.setListaBlanca(listaBlanca);
		return respuesta;
	}
	
	public static void guardarListaBlanca(LinkedList<ID> listaBlanca) throws FileNotFoundException{
		XMLEncoder xmlEncoder = new XMLEncoder(new FileOutputStream("/Users/chrisarrefall/Documents/listaNegra.xml"));
		xmlEncoder.writeObject(listaBlanca);
		xmlEncoder.close();

	}

	public static void constuctorGrafoVizualizador(ID nodoNuevo){
		Peso peso = new Peso();
		if(listaBlanca.size() == 0){
			listaBlanca.add(nodoNuevo);
			grafoGeneral.agregarVertice(nodoNuevo);
			g.addVerticeDiccionario(nodoNuevo);
		}
		else{
			grafoGeneral.agregarVertice(nodoNuevo);
			g.addVerticeDiccionario(nodoNuevo);
			String nombre = nodoNuevo.getNombre();
			g.setNombreNodo(nodoNuevo, nombre);
			for(int i = 0; i < listaBlanca.size(); i++){
				if(nodoNuevo.equals(listaBlanca.get(i))){

				}
				else{
					peso.calculadorPeso(nodoNuevo.getX(), nodoNuevo.getY(), listaBlanca.get(i).getX(), listaBlanca.get(i).getY());
					if(peso.getPeso()>850){

					}
					else{
						System.out.println(nodoNuevo.getIP() + " X: " + nodoNuevo.getX() + " Y: " + nodoNuevo.getY() + ", " + listaBlanca.get(i).getIP() + " X: " + listaBlanca.get(i).getX() + " Y: " + listaBlanca.get(i).getY());
						grafoGeneral.agregarArista(listaBlanca.get(i), nodoNuevo, peso.getPeso());
						System.out.println(nodoNuevo.getIP() + " a " + listaBlanca.get(i).getIP() + ": " + peso.getPeso().toString());
						g.addArista(listaBlanca.get(i), nodoNuevo, peso.getPeso());
					}
				}
			}
		}
	}
	
	public static void actualizadorGrafoVisualizador(Contenedor mensaje){
		g.removeNodo(buscarPorMAC(mensaje.getId().getMAC()));
		grafoGeneral.removerVertice(buscarPorMAC(mensaje.getId().getMAC()));
		constuctorGrafoVizualizador(mensaje.getId());
		
	}



	public static LinkedList<Mensaje> buscarEnListaEnviados(String IP){
		LinkedList<Mensaje> listaMensajesFiltrada = new LinkedList<Mensaje>();
		for(int i=0;i<mensajes.size();i++){
			if(mensajes.get(i).getIPemisor().equals(IP)){
				listaMensajesFiltrada.add(mensajes.get(i));
			}
			else{
			}
		}
		return listaMensajesFiltrada;
	}
	
	public static LinkedList<Mensaje> buscarEnListaRecibidos(String IP){
		LinkedList<Mensaje> listaMensajesFiltrada = new LinkedList<Mensaje>();
		for(int i=0;i<mensajes.size();i++){
			if(mensajes.get(i).getIPreceptor().equals(IP)){
				listaMensajesFiltrada.add(mensajes.get(i));
			}
			else{
			}
		}
		return listaMensajesFiltrada;
	}
	
	public static ID buscarPorMAC(String mac){
		for(int i = 0; i < listaBlanca.size();i++){
			if(listaBlanca.get(i).getMAC().equals(mac)){
				return listaBlanca.get(i);
			}
		}
		return null;
	}
	
	public static ID buscarPorIP(String ip){
		for(int i = 0; i < listaBlanca.size();i++){
			if(listaBlanca.get(i).getIP().equals(ip)){
				return listaBlanca.get(i);
			}
		}
		return null;
	}
	
	public static void actualizadorID(ID id){
		buscarPorMAC(id.getMAC()).setIP(id.getIP());
		buscarPorMAC(id.getMAC()).setX(id.getX());
		buscarPorMAC(id.getMAC()).setY(id.getY());
	}

	public static void removerGrafoVisualizador(Contenedor mensaje) {
		g.removeNodo(buscarPorMAC(mensaje.getId().getMAC()));
		grafoGeneral.removerVertice(buscarPorMAC(mensaje.getId().getMAC()));
		
	}

}
