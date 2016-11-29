package com.itcr.sockets;




import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

import com.itcr.usuario.ID;



public class Servidor implements Runnable{

	private ServerSocket serverSocket;
	public static final int SERVERPORT = 4445;
	
	private LinkedList<ID> clientes = new LinkedList<ID>();

    public void run() {
        Socket socket = null;
        try {
            serverSocket = new ServerSocket(SERVERPORT);
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (!Thread.currentThread().isInterrupted()) {
        	
            try {
            	
                socket = serverSocket.accept();
                
                ID usuarioNuevo = new ID();
                usuarioNuevo.setIP(socket.getInetAddress().toString());
                
                ServidorComunicacion hiloComunicador = new ServidorComunicacion(socket, usuarioNuevo, this);
                
                new Thread(hiloComunicador).start();
                clientes.addLast(usuarioNuevo);
                System.out.println("Se pego");
                
                Thread.sleep(100);
                
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void actualizarClientes(LinkedList<ID> clientes){
    	this.clientes = clientes;
    }
    
    public LinkedList<ID> clientesConectados(){
    	return this.clientes;
    }
}

