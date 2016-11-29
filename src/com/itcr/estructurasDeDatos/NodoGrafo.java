package com.itcr.estructurasDeDatos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class NodoGrafo<T>  implements Serializable{

    private T vertice;

    private List<Arista<T>> aristas;

    private NodoGrafo<T> nodoPadre;

    private boolean esVisitado;

    public NodoGrafo(T vertice) {
        this.vertice = vertice;
        this.aristas = new ArrayList<>();
    }

    public T vertice() {
        return vertice;
    }

    public boolean agregarArista(NodoGrafo<T> nodo, int peso) {
        if (poseeArista(nodo)) {
            return false;
        }
        Arista<T> nuevaArista = new Arista<>(this, nodo, peso);
        return aristas.add(nuevaArista);
    }

    public boolean removerArista(NodoGrafo<T> nodo) {
        Optional<Arista<T>> optional = findEdge(nodo);
        if (optional.isPresent()) {
            return aristas.remove(optional.get());
        }
        return false;
    }

    public boolean poseeArista(NodoGrafo<T> nodo) {
        return findEdge(nodo).isPresent();
    }

    private Optional<Arista<T>> findEdge(NodoGrafo<T> nodo) {
        return aristas.stream()
                .filter(edge -> edge.estaEnMedio(this, nodo))
                .findFirst();
    }

    public List<Arista<T>> aristas() {
        return aristas;
    }

    public int getCantidadAristas() {
        return aristas.size();
    }

    public NodoGrafo<T> nodoPadre() {
        return nodoPadre;
    }

    public boolean esVisitado() {
        return esVisitado;
    }

    public void setVisitado(boolean esVisitado) {
        this.esVisitado = esVisitado;
    }

    public void setPadre(NodoGrafo<T> nodoPadre) {
        this.nodoPadre = nodoPadre;
    }
}
