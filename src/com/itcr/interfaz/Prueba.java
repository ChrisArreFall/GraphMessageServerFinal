package com.itcr.interfaz;



import java.awt.EventQueue;
import java.awt.Font;
import java.io.FileNotFoundException;
import java.util.LinkedList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.event.ListSelectionListener;

import com.itcr.funciones.Mensaje;
import com.itcr.pruebas.Prueba1;

import javax.swing.event.ListSelectionEvent;
import javax.swing.ListSelectionModel;

public class Prueba {

	private JFrame frame;
	
	private JLabel datoIP = new JLabel("IP: 0.0.0.0");
	private JLabel datoMAC = new JLabel("MAC: 00:00:00:00:00:00");
	private DefaultListModel<String> MensajesRecibidos = new DefaultListModel<String>();
	private DefaultListModel<String> MensajesEnviados = new DefaultListModel<String>();
	private static DefaultListModel<String> Usuarios = new DefaultListModel<String>();
	/**
	 * Launch the application.
	 * @throws InterruptedException 
	 * @throws FileNotFoundException 
	 */
	public static void main(){
		//Prueba1.main();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Prueba window = new Prueba();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws InterruptedException 
	 */
	public Prueba() throws InterruptedException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws InterruptedException 
	 */
	@SuppressWarnings({ "unchecked", "static-access" })
	private void initialize() throws InterruptedException {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 709, 472);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		@SuppressWarnings("rawtypes")
		JList listaRecibidos = new JList();
		listaRecibidos.setModel(MensajesRecibidos);
	    JScrollPane scrollPane = new JScrollPane(listaRecibidos);
	    
	    frame.getContentPane().add(scrollPane, BorderLayout.EAST);
	    
	    
	    @SuppressWarnings("rawtypes")
		JList listaEnviados = new JList();
		listaEnviados.setModel(MensajesEnviados);
	    JScrollPane scrollPane1 = new JScrollPane(listaEnviados);
	    frame.getContentPane().add(scrollPane1, BorderLayout.CENTER);
	    
	    @SuppressWarnings("rawtypes")
		JList listaUsuarios = new JList();
	    listaUsuarios.addListSelectionListener(new ListSelectionListener() {
	    	public void valueChanged(ListSelectionEvent arg0) {
	    		int index = listaUsuarios.getSelectedIndex();
	    		datoIP.setText("IP: "+ Prueba1.listaBlanca.get(index).getIP());
	    		datoMAC.setText("MAC: "+ Prueba1.listaBlanca.get(index).getMAC());
	    		LinkedList<Mensaje> enviados = Prueba1.buscarEnListaEnviados(Prueba1.listaBlanca.get(index).getIP());
	    		LinkedList<Mensaje> recibidos = Prueba1.buscarEnListaRecibidos(Prueba1.listaBlanca.get(index).getIP());
	    		initListaMensajesRec(recibidos);
	    		initListaMensajesEnv(enviados);
	    		
	    		
	    		
	    	}
	    });
	    listaUsuarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaUsuarios.setModel(Usuarios);
		this.initUsuarios();
	    JScrollPane scrollPane2 = new JScrollPane(listaUsuarios);
	    frame.getContentPane().add(scrollPane2, BorderLayout.WEST);
	    
	    JPanel panel = new JPanel();
	    frame.getContentPane().add(panel, BorderLayout.NORTH);
	    panel.setLayout(new BorderLayout(0, 0));
	    
	    JPanel panel2 = new JPanel();
	    panel.add(panel2, BorderLayout.SOUTH);
	    
	    JLabel lblNewLabel = new JLabel("                          GraphMessageVisualizer");
		lblNewLabel.setFont(new Font("Agency FB", Font.PLAIN, 26));
		panel.add(lblNewLabel, BorderLayout.NORTH);
		panel2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblMensajesEnviados = new JLabel("Mensajes Enviados");
		lblMensajesEnviados.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel2.add(lblMensajesEnviados, BorderLayout.CENTER);
		
		JLabel lblMensajesRecibidos = new JLabel("Mensajes Recibidos                  ");
		lblMensajesRecibidos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel2.add(lblMensajesRecibidos, BorderLayout.EAST);
		
		JLabel lblUsuarios = new JLabel("                 Usuarios                                   ");
		lblUsuarios.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel2.add(lblUsuarios, BorderLayout.WEST);
		
		JPanel panel3 = new JPanel();
		frame.getContentPane().add(panel3, BorderLayout.SOUTH);
		panel3.setLayout(new BorderLayout(0, 0));
		
		panel3.add(datoIP, BorderLayout.NORTH);
		panel3.add(datoMAC, BorderLayout.CENTER);
	    frame.setResizable(false);
	    frame.setVisible(true);	
	}
	
	public static void initUsuarios()
	{
		Usuarios.clear();
		for(int i = 0; i < Prueba1.listaBlanca.size(); i++)
		{
			Usuarios.addElement(Prueba1.listaBlanca.get(i).getNombre()+ "                                   ");
		}
	}
	public void initListaMensajesRec(LinkedList<Mensaje> lista)
	{
		MensajesRecibidos.clear();
		for(int i = 0; i < lista.size(); i++ )
		{
			MensajesRecibidos.addElement("To: "+lista.get(i).getIPemisor() + " " + lista.get(i).getMensajeOriginal());
		}
	}
	
	public void initListaMensajesEnv(LinkedList<Mensaje> lista)
	{
		MensajesEnviados.clear();
		for(int i = 0; i < lista.size(); i++ )
		{
			MensajesEnviados.addElement("From: "+lista.get(i).getIPreceptor() + " " + lista.get(i).getMensajeOriginal());
		}
	}

	
}

