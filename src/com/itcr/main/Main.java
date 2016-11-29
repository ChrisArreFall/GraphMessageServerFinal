package com.itcr.main;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.LinkedList;

import com.itcr.estructurasDeDatos.BTree;
import com.itcr.estructurasDeDatos.Grafo;
import com.itcr.funciones.Mensaje;
import com.itcr.funciones.Peso;
import com.itcr.funciones.Respuesta;
import com.itcr.interfaz.Interfaz;
import com.itcr.sockets.Codigo;
import com.itcr.sockets.Servidor;
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
		Thread serverThread = new Thread(new Servidor());
		serverThread.start();
		//new Server();
		listaNegra = obtenerArchivo("/Users/chrisarrefall/Documents/listaNegra.xml");
		listaBlanca = obtenerArchivo("/Users/chrisarrefall/Documents/listaBlanca.xml");
		listaMalasPalabras = obtenerArchivoMalasPalabras("/Users/chrisarrefall/Documents/listaMalasPalabras.xml");
		mensajes = obtenerArchivoMensajes("/Users/chrisarrefall/Documents/listMensajes.xml");
		System.out.println(listaBlanca.size());
		g.show();
		LinkedList<ID> listaTemp = new LinkedList<ID>();
		for(int i = 0;i<listaBlanca.size();i++){
			inicioGrafoVizualizador(listaBlanca.get(i),listaTemp);
			listaTemp.add(listaBlanca.get(i));
		}
		Interfaz.initUsuarios();
	}

	@SuppressWarnings("unchecked")
	private static LinkedList<ID> obtenerArchivo(String fileName) throws FileNotFoundException{
		LinkedList<ID> archivo = new LinkedList<ID>();
		XMLDecoder decoder = new XMLDecoder(new FileInputStream(fileName));
		archivo = (LinkedList<ID>)decoder.readObject();
		decoder.close();
		return archivo;
	}
	
	@SuppressWarnings({"unchecked" })
	private static LinkedList<String> obtenerArchivoMalasPalabras(String fileName) throws FileNotFoundException{
		LinkedList<String> archivo = new LinkedList<String>();
		XMLDecoder decoder = new XMLDecoder(new FileInputStream(fileName));
		archivo = (LinkedList<String>)decoder.readObject();
		decoder.close();
		return archivo;
	}
	
	@SuppressWarnings("unchecked")
	private static LinkedList<Mensaje> obtenerArchivoMensajes(String fileName) throws FileNotFoundException{
		LinkedList<Mensaje> archivo = new LinkedList<Mensaje>();
		XMLDecoder decoder = new XMLDecoder(new FileInputStream(fileName));
		archivo = (LinkedList<Mensaje>)decoder.readObject();
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
	
	public static void inicioGrafoVizualizador(ID nodoNuevo,LinkedList<ID> listaTemp){
		Peso peso = new Peso();
		System.out.println(grafoGeneral.cantidadVertices());
		if(listaTemp.size()==0){
			grafoGeneral.agregarVertice(nodoNuevo);
			g.addVerticeDiccionario(nodoNuevo);
			String nombre = nodoNuevo.getNombre();
			g.setNombreNodo(nodoNuevo, nombre);
			
		}
		else{
			grafoGeneral.agregarVertice(nodoNuevo);
			g.addVerticeDiccionario(nodoNuevo);
			String nombre = nodoNuevo.getNombre();
			g.setNombreNodo(nodoNuevo, nombre);
			for(int i = 0; i < listaTemp.size(); i++){
				if(nodoNuevo.equals(listaTemp.get(i))){

				}
				else{
					peso.calculadorPeso(nodoNuevo.getX(), nodoNuevo.getY(), listaTemp.get(i).getX(), listaTemp.get(i).getY());
					if(peso.getPeso()>850){

					}
					else{
						System.out.println(nodoNuevo.getIP() + " X: " + nodoNuevo.getX() + " Y: " + nodoNuevo.getY() + ", " + listaTemp.get(i).getIP() + " X: " + listaTemp.get(i).getX() + " Y: " + listaTemp.get(i).getY());
						grafoGeneral.agregarArista(listaTemp.get(i), nodoNuevo, peso.getPeso());
						System.out.println(nodoNuevo.getIP() + " a " + listaTemp.get(i).getIP() + ": " + peso.getPeso().toString());
						g.addArista(listaBlanca.get(i), nodoNuevo, peso.getPeso());
					}
				}
			}
			
		}
	}

	public static void constuctorGrafoVizualizador(ID nodoNuevo){
		Peso peso = new Peso();
		if(listaBlanca.size() == 0){
			listaBlanca.add(nodoNuevo);
			grafoGeneral.agregarVertice(nodoNuevo);
			g.addVerticeDiccionario(nodoNuevo);
			String nombre = nodoNuevo.getNombre();
			g.setNombreNodo(nodoNuevo, nombre);
			
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
					if(peso.getPeso()>8500){

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

	public static void actualizadorGrafoVisualizador(ID mensaje){
		g.removeNodo(buscarPorMAC(mensaje.getMAC()));
		System.out.println("aqui llego al actualizadorGrafoVisualizador");
		System.out.println(buscarPorMAC(mensaje.getMAC()));
		grafoGeneral.removerVertice(buscarPorMAC(mensaje.getMAC()));
		constuctorGrafoVizualizador(mensaje);

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
				System.out.println("Se ha encontrado a: "+listaBlanca.get(i).getNombre());
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

	public static void removerGrafoVisualizador(ID mensaje) {
		g.removeNodo(buscarPorMAC(mensaje.getMAC()));
		grafoGeneral.removerVertice(buscarPorMAC(mensaje.getMAC()));

	}
	
	








	public static Boolean validador(Codigo info,String ip){
		Mensaje mensaje = new Mensaje();
		ID usuario = new ID();
		usuario.setIP(ip);
		usuario.setMAC(info.getMAC());
		usuario.setNombre(info.getNombre());
		usuario.setX(info.getX());
		usuario.setY(info.getY());
		mensaje.setIPemisor(ip);
		mensaje.setMensajeOriginal(info.getMultimedia());
		mensaje.setIPreceptor(info.getIPReceptor());
		System.out.println(usuario.getIP()+", "+usuario.getMAC()+", "+usuario.getNombre()+", "+usuario.getX()+", "+usuario.getY());
		if(Main.analizarLista(Main.listaNegra, usuario.getMAC())){
			System.out.print("Se encontro en la lista negra"); 
			return false;
		}
		else{
			if(Main.analizarLista(Main.listaBlanca, usuario.getMAC())){
				if(Main.analizarMalasPalabras(mensaje.getArbolPalabras())){
					System.out.println("estaba en la lista blanca pero tenia malas palabras");
					Main.listaNegra.addFirst(usuario);
					Main.listaBlanca.remove(Main.buscarPorMAC(usuario.getMAC()));
					Main.removerGrafoVisualizador(usuario);
					Interfaz.initUsuarios();
					System.out.print("Server has already stopped"); 
					//out.println("Usted esta Baneado"); 
					//out.flush(); 
					return false;
				}
				else{
					System.out.println("estaba en la lista blanca pero no tenia malas palabras");
					Main.mensajes.add(mensaje);
					Main.actualizadorGrafoVisualizador(usuario);
					Main.actualizadorID(usuario);

					Main.g.colorShortPath(Main.buscarPorIP(mensaje.getIPemisor()), Main.buscarPorIP(mensaje.getIPreceptor()));

					//String respuestaJSON = Respuesta.JSONRespuesta(Main.actualizadorRespuesta());
					//out.println(respuestaJSON); 
					//out.flush();
					return true;
				}


			}
			else{
				System.out.println("no estaba en la lista");
				Main.constuctorGrafoVizualizador(usuario);
				Main.listaBlanca.add(usuario);
				Interfaz.initUsuarios();
				//
				//agregar al vizualizador el nodo
				if(!info.getMultimedia().equals("")){
					System.out.println("no estaba en la lista pero si tenia mensaje");
					if(Main.analizarMalasPalabras(mensaje.getArbolPalabras())){
						System.out.println("no estaba en la lista y malas palabras");
						Main.listaNegra.add(usuario);
						Main.listaBlanca.remove(Main.buscarPorMAC(usuario.getMAC()));
						Main.removerGrafoVisualizador(Main.buscarPorMAC(usuario.getMAC()));
						Interfaz.initUsuarios();
						System.out.print("Server has already stopped"); 
						//out.println("Usted esta Baneado"); 
						//out.flush(); 
						return false;
					}
					else{
						//agregar mensaje al vizualizador
						System.out.println("no estaba en la lista sin malas palabras");
						Main.mensajes.add(mensaje);
						//Grafo.iterarGrafoYConstruirlo(usuario);
						//Main.actualizadorID(Main.buscarPorMAC(usuario.getMAC()));

						Main.g.colorShortPath(Main.buscarPorIP(mensaje.getIPemisor()), Main.buscarPorIP(mensaje.getIPreceptor()));

						//String respuestaJSON = Respuesta.JSONRespuesta(Main.actualizadorRespuesta());
						return true;
					}
				}
				else{
					return true;

				}
			}
		}
		
	} 
} 


