package com.itcr.main;

import com.itcr.estructurasDeDatos.LinkedList;

public class PruebaEstructuradDatos {
	public static void main(String[] args){
		LinkedList<Integer> prueba = new LinkedList<Integer>();
		prueba.add(0);
		prueba.add(1);
		prueba.add(2);
		prueba.add(3);
		prueba.add(4);
		
		System.out.println(prueba.get(4));
	}

}
