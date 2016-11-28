package com.itcr.funciones;

/**
 * @author chrisarrefall
 *
 */
public class Peso {
	private Integer peso;
	
	public void calculadorPeso(double x1,double y1,double x2,double y2){
		x1=Math.pow(x1,4);
		x2=Math.pow(x2,4);
		y1=Math.pow(y1,4);
		y2=Math.pow(y2,4);
		
		peso = (int) Math.sqrt(Math.pow(y1-y2,2)+Math.pow(x1-x2,2));
	}

	public Integer getPeso() {
		return peso;
	}
}
