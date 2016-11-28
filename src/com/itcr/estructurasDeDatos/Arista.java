package com.itcr.estructurasDeDatos;

public class Arista<T> {

    private NodoGrafo<T> nodo1;

    private NodoGrafo<T> nodo2;

    private int peso;

    public Arista(NodoGrafo<T> nodo1, NodoGrafo<T> nodo2, int peso) {
        this.nodo1 = nodo1;
        this.nodo2 = nodo2;
        this.peso = peso;
    }

    public NodoGrafo<T> nodoInicial() {
        return nodo1;
    }

    public NodoGrafo<T> nodoObjetivo() {
        return nodo2;
    }

    public boolean estaEnMedio(NodoGrafo<T> nodo1, NodoGrafo<T> nodo2) {
        return (this.nodo1 == nodo1 && this.nodo2 == nodo2);
    }

	public int getPeso() {
		return peso;
	}
}
