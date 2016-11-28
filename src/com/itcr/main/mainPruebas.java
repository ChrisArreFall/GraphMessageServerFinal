package com.itcr.main;

import com.itcr.funciones.Peso;

public class mainPruebas {


	public static void main(String[] args) {
		Peso peso = new Peso();
		peso.calculadorPeso(5, 4, 6, 9);
		System.out.println(peso.getPeso());
	}
}
