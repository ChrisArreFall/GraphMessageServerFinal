package com.itcr.estructurasDeDatos;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;


//datos a xml y guarda
public class XML{

	public static void write(Object objeto, String file) throws FileNotFoundException{
		XMLEncoder xmlEncoder = new XMLEncoder(new FileOutputStream(file));
		xmlEncoder.writeObject(objeto);
		xmlEncoder.close();
	}


	public static Object read(String filename) throws FileNotFoundException{
		XMLDecoder decoder =new XMLDecoder(new FileInputStream(filename));
		Object objeto = (Object)decoder.readObject();
		decoder.close();
		return objeto;

		
	}



}