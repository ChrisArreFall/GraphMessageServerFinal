package com.itcr.pruebas;

import java.beans.XMLEncoder;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.LinkedList;

import com.itcr.estructurasDeDatos.Grafo;
import com.itcr.funciones.Mensaje;
import com.itcr.funciones.Peso;
import com.itcr.interfaz.Prueba;
import com.itcr.usuario.ID;
import com.itcr.usuario.Contenedor;
import com.itcr.visualizer.Graph;

public class Prueba1 {

	public static LinkedList<ID> listaBlanca = new LinkedList<ID>();
	public static LinkedList<ID> listaNegra = new LinkedList<ID>();
	public static LinkedList<String> listaMalasPalabras = new LinkedList<String>();
	public static Grafo<ID> grafoGeneral = new Grafo<ID>();
	public static LinkedList<Mensaje> mensajes = new LinkedList<Mensaje>();
	public static Graph g = new Graph();





	public static void main(String[] args) throws FileNotFoundException, InterruptedException {

		Prueba.main();
		g.show();

		//--------------------------------------
		ID id1 = new ID();
		Contenedor usuario1 = new Contenedor();

		id1.setIP("192.168.0.1");
		id1.setMAC("00:00:00:00:00:01");
		id1.setNombre("Armando");

		usuario1.setId(id1);
		usuario1.getId().setX(9.856086);
		usuario1.getId().setY(-83.912851);

		//-------------------------------------
		ID id2 = new ID();
		Contenedor usuario2 = new Contenedor();

		id2.setIP("192.168.0.2");
		id2.setMAC("00:00:00:00:00:02");
		id2.setNombre("Bernardo");


		usuario2.setId(id2);
		usuario2.getId().setX(9.856104);
		usuario2.getId().setY(-83.912827);

		//-------------------------------------
		ID id3 = new ID();
		Contenedor usuario3 = new Contenedor();

		id3.setIP("192.168.0.3");
		id3.setMAC("00:00:00:00:00:03");
		id3.setNombre("Christian");

		usuario3.setId(id3);
		usuario3.getId().setX(9.856140);
		usuario3.getId().setY(-83.912816);

		//-------------------------------------
		ID id4 = new ID();
		Contenedor usuario4 = new Contenedor();

		id4.setIP("192.168.0.4");
		id4.setMAC("00:00:00:00:00:04");
		id4.setNombre("David");

		usuario4.setId(id4);
		usuario4.getId().setX(9.856116);
		usuario4.getId().setY(-83.912768);



		//-------------------------------------
		ID id5 = new ID();
		Contenedor usuario5 = new Contenedor();

		id5.setIP("192.168.0.5");
		id5.setMAC("00:00:00:00:00:05");
		id5.setNombre("Sasuke");

		usuario5.setId(id5);
		usuario5.getId().setX(9.856115);
		usuario5.getId().setY(-83.912743);



		//-------------------------------------
		ID id6 = new ID();
		Contenedor usuario6 = new Contenedor();

		id6.setIP("192.168.0.6");
		id6.setMAC("00:00:00:00:00:06");
		id6.setNombre("Hinata");

		usuario6.setId(id6);
		usuario6.getId().setX(9.856112);
		usuario6.getId().setY(-83.912706);





		//-------------------------------------
		ID id7 = new ID();
		Contenedor usuario7 = new Contenedor();

		id7.setIP("192.168.0.7");
		id7.setMAC("00:00:00:00:00:07");
		id7.setNombre("Itachi");

		usuario7.setId(id7);
		usuario7.getId().setX(9.856164);
		usuario7.getId().setY(-83.912709);





		//-------------------------------------
		ID id8 = new ID();
		Contenedor usuario8 = new Contenedor();

		id8.setIP("192.168.0.8");
		id8.setMAC("00:00:00:00:00:08");
		id8.setNombre("Killer Bee");

		usuario8.setId(id8);
		usuario8.getId().setX(9.856093);
		usuario8.getId().setY(-83.912579);




		//-------------------------------------
		ID id9 = new ID();
		Contenedor usuario9 = new Contenedor();

		id9.setIP("192.168.0.9");
		id9.setMAC("00:00:00:00:00:09");
		id9.setNombre("Madara");

		usuario9.setId(id9);
		usuario9.getId().setX(9.856152);
		usuario9.getId().setY(-83.912429);





		//-------------------------------------
		ID id10 = new ID();
		Contenedor usuario10 = new Contenedor();

		id10.setIP("192.168.0.10");
		id10.setMAC("00:00:00:00:00:10");
		id10.setNombre("Kakashi");

		usuario10.setId(id10);
		usuario10.getId().setX(9.856162);
		usuario10.getId().setY(-83.912576);





		//-------------------------------------
		ID id11 = new ID();
		Contenedor usuario11 = new Contenedor();

		id11.setIP("192.168.0.11");
		id11.setMAC("00:00:00:00:00:11");
		id11.setNombre("Sakura");

		usuario11.setId(id11);
		usuario11.getId().setX(9.856118);
		usuario11.getId().setY(-83.912564);





		//-------------------------------------
		ID id12 = new ID();
		Contenedor usuario12 = new Contenedor();

		id12.setIP("192.168.0.12");
		id12.setMAC("00:00:00:00:00:12");
		id12.setNombre("Orochimaru");

		usuario12.setId(id12);
		usuario12.getId().setX(9.856118);
		usuario12.getId().setY(-83.912564);





		//-------------------------------------
		ID id13 = new ID();
		Contenedor usuario13 = new Contenedor();

		id13.setIP("192.168.0.13");
		id13.setMAC("00:00:00:00:00:13");
		id13.setNombre("Kabuto");

		usuario13.setId(id13);
		usuario13.getId().setX(9.856152);
		usuario13.getId().setY(-83.912497);





		//-------------------------------------
		ID id14 = new ID();
		Contenedor usuario14 = new Contenedor();

		id14.setIP("192.168.0.14");
		id14.setMAC("00:00:00:00:00:14");
		id14.setNombre("Kisame");

		usuario14.setId(id14);
		usuario14.getId().setX(9.856152);
		usuario14.getId().setY(-83.912483);





		//-------------------------------------
		ID id15 = new ID();
		Contenedor usuario15 = new Contenedor();

		id15.setIP("192.168.0.15");
		id15.setMAC("00:00:00:00:00:15");
		id15.setNombre("Naruto");

		usuario15.setId(id15);
		usuario15.getId().setX(9.856152);
		usuario15.getId().setY(-83.912429);


		//----------------------------------
		ID id20 = new ID();
		Contenedor usuario20 = new Contenedor();

		id20.setIP("192.168.0.1");
		id20.setMAC("00:00:00:00:00:20");
		id20.setNombre("Goku");

		usuario20.setId(id20);
		usuario20.getId().setX(11);
		usuario20.getId().setY(15);


		//----------------------------------
		ID id21 = new ID();
		Contenedor usuario21 = new Contenedor();

		id21.setIP("192.168.0.1");
		id21.setMAC("00:00:00:00:00:21");
		id21.setNombre("Gohan");

		usuario21.setId(id21);
		usuario21.getId().setX(10);
		usuario21.getId().setY(14);

		//----------------------------------
		ID id22 = new ID();
		Contenedor usuario22 = new Contenedor();

		id22.setIP("192.168.0.1");
		id22.setMAC("00:00:00:00:00:22");
		id22.setNombre("Vegeta");

		usuario22.setId(id22);
		usuario22.getId().setX(12);
		usuario22.getId().setY(16);

		//----------------------------------
		ID id23 = new ID();
		Contenedor usuario23 = new Contenedor();

		id23.setIP("192.168.0.1");
		id23.setMAC("00:00:00:00:00:23");
		id23.setNombre("Trunks");

		usuario23.setId(id23);
		usuario23.getId().setX(13);
		usuario23.getId().setY(17);

		//----------------------------------
		ID id24 = new ID();
		Contenedor usuario24 = new Contenedor();

		id24.setIP("192.168.0.1");
		id24.setMAC("00:00:00:00:00:24");
		id24.setNombre("Gotenks");

		usuario24.setId(id24);
		usuario24.getId().setX(14);
		usuario24.getId().setY(18);

		//----------------------------------
		ID id25 = new ID();
		Contenedor usuario25 = new Contenedor();

		id25.setIP("192.168.0.1");
		id25.setMAC("00:00:00:00:00:25");
		id25.setNombre("Pan");

		usuario25.setId(id25);
		usuario25.getId().setX(15);
		usuario25.getId().setY(19);

		//----------------------------------
		ID id26 = new ID();
		Contenedor usuario26 = new Contenedor();

		id26.setIP("192.168.0.1");
		id26.setMAC("00:00:00:00:00:26");
		id26.setNombre("Piccolo");

		usuario26.setId(id26);
		usuario26.getId().setX(16);
		usuario26.getId().setY(20);

		//----------------------------------
		ID id27 = new ID();
		Contenedor usuario27 = new Contenedor();

		id27.setIP("192.168.0.1");
		id27.setMAC("00:00:00:00:00:27");
		id27.setNombre("Gogeta");

		usuario27.setId(id27);
		usuario27.getId().setX(17);
		usuario27.getId().setY(21);

		//----------------------------------
		ID id28 = new ID();
		Contenedor usuario28 = new Contenedor();

		id28.setIP("192.168.0.1");
		id28.setMAC("00:00:00:00:00:28");
		id28.setNombre("Veggeto");

		usuario28.setId(id28);
		usuario28.getId().setX(18);
		usuario28.getId().setY(22);

		//----------------------------------
		ID id29 = new ID();
		Contenedor usuario29 = new Contenedor();

		id29.setIP("192.168.0.1");
		id29.setMAC("00:00:00:00:00:29");
		id29.setNombre("krilin");

		usuario29.setId(id29);
		usuario29.getId().setX(19);
		usuario29.getId().setY(23);

		//----------------------------------
		ID id30 = new ID();
		Contenedor usuario30 = new Contenedor();

		id30.setIP("192.168.0.1");
		id30.setMAC("00:00:00:00:00:30");
		id30.setNombre("Yamcha");

		usuario30.setId(id30);
		usuario30.getId().setX(20);
		usuario30.getId().setY(24);

		//----------------------------------
		ID id31 = new ID();
		Contenedor usuario31 = new Contenedor();

		id31.setIP("192.168.0.1");
		id31.setMAC("00:00:00:00:00:31");
		id31.setNombre("Tenchinhan");

		usuario31.setId(id31);
		usuario31.getId().setX(11);
		usuario31.getId().setY(18);

		//----------------------------------
		ID id32 = new ID();
		Contenedor usuario32 = new Contenedor();

		id32.setIP("192.168.0.1");
		id32.setMAC("00:00:00:00:00:31");
		id32.setNombre("Roshi");

		usuario32.setId(id32);
		usuario32.getId().setX(12);
		usuario32.getId().setY(19);

		//----------------------------------
		ID id33 = new ID();
		Contenedor usuario33 = new Contenedor();

		id33.setIP("192.168.0.1");
		id33.setMAC("00:00:00:00:00:32");
		id33.setNombre("Brolly");

		usuario33.setId(id33);
		usuario33.getId().setX(13);
		usuario33.getId().setY(20);

		//----------------------------------
		ID id34 = new ID();
		Contenedor usuario34 = new Contenedor();

		id34.setIP("192.168.0.1");
		id34.setMAC("00:00:00:00:00:3");
		id34.setNombre("Zamazu");

		usuario34.setId(id34);
		usuario34.getId().setX(14);
		usuario34.getId().setY(21);

		//----------------------------------
		ID id35 = new ID();
		Contenedor usuario35 = new Contenedor();

		id35.setIP("192.168.0.1");
		id35.setMAC("00:00:00:00:00:34");
		id35.setNombre("Bardock");

		usuario35.setId(id35);
		usuario35.getId().setX(15);
		usuario35.getId().setY(11);



		//Listade mensajes------------------


		Mensaje mensaje1 = new Mensaje();
		mensaje1.setIPemisor(id1.getIP());
		mensaje1.setIPreceptor(id2.getIP());
		mensaje1.setMensajeOriginal("Hola como esta don Bernardo?");

		//-------------------------------------------------------------

		Mensaje mensaje2 = new Mensaje();
		mensaje2.setIPemisor(id1.getIP());
		mensaje2.setIPreceptor(id2.getIP());
		mensaje2.setMensajeOriginal("Esta en su casa?");

		//-------------------------------------------------------------
		Mensaje mensaje3 = new Mensaje();
		mensaje3.setIPemisor(id2.getIP());
		mensaje3.setIPreceptor(id1.getIP());
		mensaje3.setMensajeOriginal("Bien y usted don Armando?");

		//-------------------------------------------------------------
		Mensaje mensaje4 = new Mensaje();
		mensaje4.setIPemisor(id3.getIP());
		mensaje4.setIPreceptor(id4.getIP());
		mensaje4.setMensajeOriginal("Se viene el huracan D:");

		//-------------------------------------------------------------
		Mensaje mensaje5 = new Mensaje();
		mensaje5.setIPemisor(id4.getIP());
		mensaje5.setIPreceptor(id3.getIP());
		mensaje5.setMensajeOriginal("Es enserio? D:");

		//-------------------------------------------------------------
		Mensaje mensaje6 = new Mensaje();
		mensaje6.setIPemisor(id4.getIP());
		mensaje6.setIPreceptor(id2.getIP());
		mensaje6.setMensajeOriginal("Maeeeee se viene el hp huracan D:");

		//-------------------------------------------------------------


		Mensaje mensaje7 = new Mensaje();
		mensaje7.setIPemisor(id2.getIP());
		mensaje7.setIPreceptor(id1.getIP());
		mensaje7.setMensajeOriginal("SE VIENE EL HURACAAAAAN!!!!");

		//-------------------------------------------------------------


		usuario1.setMensaje(mensaje1);


		mensajes.add(mensaje1);
		mensajes.add(mensaje2);
		mensajes.add(mensaje3);
		mensajes.add(mensaje3);
		mensajes.add(mensaje4);
		mensajes.add(mensaje5);
		mensajes.add(mensaje6);
		mensajes.add(mensaje7);





		//--------------------------------------

		listaBlanca.add(id1);
		constuctorGrafoVizualizador(id1);
		listaBlanca.add(id2);
		constuctorGrafoVizualizador(id2);
		listaBlanca.add(id3);
		constuctorGrafoVizualizador(id3);
		listaBlanca.add(id4);
		constuctorGrafoVizualizador(id4);
		/*
		listaBlanca.add(id5);
		iterarGrafoYConstruirlo(id5);
		listaBlanca.add(id6);
		iterarGrafoYConstruirlo(id6);
		listaBlanca.add(id7);
		iterarGrafoYConstruirlo(id7);
		listaBlanca.add(id8);
		iterarGrafoYConstruirlo(id8);
		listaBlanca.add(id9);
		iterarGrafoYConstruirlo(id9);
		listaBlanca.add(id10);
		iterarGrafoYConstruirlo(id10);
		/*
		listaBlanca.add(id11);
		iterarGrafoYConstruirlo(id11);
		listaBlanca.add(id12);
		iterarGrafoYConstruirlo(id12);
		listaBlanca.add(id13);
		iterarGrafoYConstruirlo(id13);
		listaBlanca.add(id14);
		iterarGrafoYConstruirlo(id14);
		listaBlanca.add(id15);
		iterarGrafoYConstruirlo(id15);
		listaBlanca.add(id20);
		iterarGrafoYConstruirlo(id20);
		listaBlanca.add(id21);
		iterarGrafoYConstruirlo(id21);
		listaBlanca.add(id22);
		iterarGrafoYConstruirlo(id22);
		listaBlanca.add(id23);
		iterarGrafoYConstruirlo(id23);
		listaBlanca.add(id24);
		iterarGrafoYConstruirlo(id24);
		listaBlanca.add(id25);
		iterarGrafoYConstruirlo(id25);
		listaBlanca.add(id26);
		iterarGrafoYConstruirlo(id26);
		listaBlanca.add(id27);
		iterarGrafoYConstruirlo(id27);
		listaBlanca.add(id28);
		iterarGrafoYConstruirlo(id28);
		listaBlanca.add(id29);
		iterarGrafoYConstruirlo(id29);
		listaBlanca.add(id30);
		iterarGrafoYConstruirlo(id30);
		listaBlanca.add(id31);
		iterarGrafoYConstruirlo(id31);
		listaBlanca.add(id32);
		iterarGrafoYConstruirlo(id32);
		listaBlanca.add(id33);
		iterarGrafoYConstruirlo(id33);
		listaBlanca.add(id34);
		iterarGrafoYConstruirlo(id34);
		listaBlanca.add(id35);
		iterarGrafoYConstruirlo(id35);





		guardarListaBlanca(listaBlanca);



		*/
		//g.colorShortPath(id1, id4);
		/*
		Thread.sleep(10000);

		g.removeNodo(id4);
		id4.setX(9.856132);
		id4.setY(-83.912567);

		Thread.sleep(5000);
		
		iterarGrafoYConstruirlo(id4);
		*/


		Thread.sleep(10000);
		Prueba.initUsuarios();
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
	
	

}
