package com.itcr.sockets;



import java.beans.XMLEncoder;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.itcr.interfaz.Interfaz;
import com.itcr.main.Main;
import com.itcr.usuario.ID;

public class ServidorComunicacion implements Runnable {

	private Socket clientSocket;
	private ID usuario;
	private BufferedReader input;
	//private boolean infoCompleta = false;
	private Servidor servidor;
	private PrintWriter out;
	private String respuesta;

	public ServidorComunicacion(Socket clientSocket, ID usuario, Servidor servidor) {

		this.clientSocket = clientSocket;
		this.usuario = usuario;
		this.servidor = servidor;
		

		try {
			this.input = new BufferedReader(new InputStreamReader(this.clientSocket.getInputStream()));
			this.out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream())), true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run() {

		for(double segundos = 0.0; (segundos < 20) && (!Thread.currentThread().isInterrupted()); segundos += 0.5) {

			try {
				//Se obtiene y decodifica la informacion
				String entrada = input.readLine(); 

				if(entrada != null){
					GsonBuilder builder = new GsonBuilder();
					Gson gson = builder.create();
					Codigo info = gson.fromJson(entrada, Codigo.class);

					System.out.println("Se unio");
					System.out.println(info.getMultimedia());
					//System.out.println();
					Boolean bien = Main.validador(info,clientSocket.getInetAddress().toString());
					System.out.println(bien.toString());
					if(bien){
						System.out.println("Bien LLego aqui");
						GsonBuilder builder1 = new GsonBuilder();
						Gson gson1 = builder1.create();
						Codigo respuesta = new Codigo();
						respuesta.setIds(Main.listaBlanca);
						//respuesta.setGrafo(Main.grafoGeneral);
						XMLEncoder xmlEncoder = new XMLEncoder(new FileOutputStream("/Users/chrisarrefall/Documents/respuesta.xml"));
						xmlEncoder.writeObject(respuesta);
						xmlEncoder.close();
						Interfaz.initUsuarios();
						this.respuesta = gson1.toJson(respuesta);
						System.out.println(this.respuesta);
						out.println(this.respuesta);
						//out.flush();
					}
					else{
						System.out.println("LLego aqui");
						GsonBuilder builder2 = new GsonBuilder();
						Gson gson2 = builder2.create();
						Codigo respuesta = new Codigo();
						respuesta.setMultimedia("kill");
						this.respuesta = gson2.toJson(respuesta);
						XMLEncoder xmlEncoder = new XMLEncoder(new FileOutputStream("/Users/chrisarrefall/Documents/respuesta.xml"));
						xmlEncoder.writeObject(respuesta);
						xmlEncoder.close();
						out.println(this.respuesta);
						out.flush();
					}
				}

				Thread.sleep(500);

			} catch (IOException | InterruptedException e) {
				e.printStackTrace();
			}
		}


		this.servidor.clientesConectados().remove(usuario);
	}

}
