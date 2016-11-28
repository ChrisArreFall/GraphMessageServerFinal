package com.itcr.conexion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.itcr.estructurasDeDatos.Grafo;
import com.itcr.funciones.InterpretadorDeMensajes;
import com.itcr.funciones.Respuesta;
import com.itcr.interfaz.Interfaz;
import com.itcr.main.Main;


public class Server {

	ServerSocket myServerSocket;
	boolean ServerOn = true;


	public Server() 
	{ 
		try
		{ 
			myServerSocket = new ServerSocket(11111); 
		} 
		catch(IOException ioe) 
		{ 
			System.out.println("Could not create server socket on port 11111. Quitting."); 
			System.exit(-1); 
		} 




		Calendar now = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
		System.out.println("It is now : " + formatter.format(now.getTime()));




		// Successfully created Server Socket. Now wait for connections. 
		while(ServerOn) 
		{                        
			try
			{ 
				// Accept incoming connections. 
				Socket clientSocket = myServerSocket.accept(); 

				// accept() will block until a client connects to the server. 
				// If execution reaches this point, then it means that a client 
				// socket has been accepted. 

				// For each client, we will start a service thread to 
				// service the client requests. This is to demonstrate a 
				// Multi-Threaded server. Starting a thread also lets our 
				// Server accept multiple connections simultaneously. 

				// Start a Service thread 


				ClientServiceThread cliThread = new ClientServiceThread(clientSocket);
				cliThread.start(); 

			} 
			catch(IOException ioe) 
			{ 
				System.out.println("Exception encountered on accept. Ignoring. Stack Trace :"); 
				ioe.printStackTrace(); 
			} 

		}

		try
		{ 
			myServerSocket.close(); 
			System.out.println("Server Stopped"); 
		} 
		catch(Exception ioe) 
		{ 
			System.out.println("Problem stopping server socket"); 
			System.exit(-1); 
		} 



	} 


	class ClientServiceThread extends Thread 
	{ 
		Socket myClientSocket;
		boolean m_bRunThread = true; 

		public ClientServiceThread() 
		{ 
			super(); 
		} 

		ClientServiceThread(Socket s) 
		{ 
			myClientSocket = s; 

		} 

		public void run() 
		{            
			// Obtain the input stream and the output stream for the socket 
			// A good practice is to encapsulate them with a BufferedReader 
			// and a PrintWriter as shown below. 
			BufferedReader in = null; 
			PrintWriter out = null; 

			// Print out details of this connection 
			System.out.println("Accepted Client Address - " + myClientSocket.getInetAddress().getHostName()); 

			try
			{                                
				in = new BufferedReader(new InputStreamReader(myClientSocket.getInputStream())); 
				out = new PrintWriter(new OutputStreamWriter(myClientSocket.getOutputStream())); 

				// At this point, we can read for input and reply with appropriate output. 

				// Run in a loop until m_bRunThread is set to false 
				while(m_bRunThread) 
				{                    
					InterpretadorDeMensajes mensaje = new InterpretadorDeMensajes(in.readLine());
					// read incoming stream 
					String clientCommand = in.readLine(); 

					System.out.println("Client Says :" + clientCommand);

					if(!ServerOn) 
					{ 
						// Special command. Quit this thread 
						System.out.print("Server has already stopped"); 
						out.println("Server has already stopped"); 
						out.flush(); 
						m_bRunThread = false;   

					} 

					if(Main.analizarLista(Main.listaNegra, mensaje.getMensaje().getId().getMAC())){
						System.out.print("Server has already stopped"); 
						out.println("Usted esta Baneado"); 
						out.flush(); 
						m_bRunThread = false;
					}
					else{
						if(Main.analizarLista(Main.listaBlanca, mensaje.getMensaje().getId().getMAC())){
							if(Main.analizarMalasPalabras(mensaje.getMensaje().getMensaje().getArbolPalabras())){
								Main.listaNegra.addFirst(mensaje.getMensaje().getId());
								Main.listaBlanca.remove(mensaje.getMensaje().getId());
								Main.removerGrafoVisualizador(mensaje.getMensaje());
								Interfaz.initUsuarios();
								System.out.print("Server has already stopped"); 
								out.println("Usted esta Baneado"); 
								out.flush(); 
								m_bRunThread = false;
							}
							else{
								Main.mensajes.add(mensaje.getMensaje().getMensaje());
								Main.actualizadorGrafoVisualizador(mensaje.getMensaje());
								Main.actualizadorID(mensaje.getMensaje().getId());
								
								Main.g.colorShortPath(Main.buscarPorIP(mensaje.getMensaje().getMensaje().getIPemisor()), Main.buscarPorIP(mensaje.getMensaje().getMensaje().getIPreceptor()));
								
								String respuestaJSON = Respuesta.JSONRespuesta(Main.actualizadorRespuesta());
								out.println(respuestaJSON); 
								out.flush();
							}
							
							
						}
						else{
							Grafo.iterarGrafoYConstruirlo(mensaje.getMensaje().getId());
							Main.listaBlanca.add(mensaje.getMensaje().getId());
							Interfaz.initUsuarios();
							//
							//agregar al vizualizador el nodo
							if(!mensaje.getMensaje().getMensaje().equals(null)){
								if(Main.analizarMalasPalabras(mensaje.getMensaje().getMensaje().getArbolPalabras())){
									Main.listaNegra.add(mensaje.getMensaje().getId());
									Main.listaBlanca.remove(mensaje.getMensaje().getId());
									Main.removerGrafoVisualizador(mensaje.getMensaje());
									Interfaz.initUsuarios();
									System.out.print("Server has already stopped"); 
									out.println("Usted esta Baneado"); 
									out.flush(); 
									m_bRunThread = false;
								}
								else{
									//agregar mensaje al vizualizador
									Main.mensajes.add(mensaje.getMensaje().getMensaje());
									Main.actualizadorGrafoVisualizador(mensaje.getMensaje());
									Main.actualizadorID(mensaje.getMensaje().getId());
									
									Main.g.colorShortPath(Main.buscarPorIP(mensaje.getMensaje().getMensaje().getIPemisor()), Main.buscarPorIP(mensaje.getMensaje().getMensaje().getIPreceptor()));
				
									String respuestaJSON = Respuesta.JSONRespuesta(Main.actualizadorRespuesta());
									out.println(respuestaJSON); 
									out.flush(); 
								}
							}
							else{
								
							}
						}
					}
				} 
			} 
			catch(Exception e) 
			{ 
				e.printStackTrace(); 
			} 
			finally
			{ 
				// Clean up 
				try
				{                    
					in.close(); 
					out.close(); 
					myClientSocket.close(); 
					System.out.println("...Stopped"); 
				} 
				catch(IOException ioe) 
				{ 
					ioe.printStackTrace(); 
				} 
			} 
		} 


	} 
}