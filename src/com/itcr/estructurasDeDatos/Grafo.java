package com.itcr.estructurasDeDatos;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.itcr.funciones.Peso;
import com.itcr.main.Main;
import com.itcr.usuario.ID;


public class Grafo<T> implements Serializable{

    private final Map<T, NodoGrafo<T>> listaAdyacencia;

    public Grafo() {
        listaAdyacencia = new HashMap<>();
    }

    /**
     * Adds a vertice to the graph.
     * @param vertice        vertice to add
     */
    public boolean agregarVertice(T vertice) {
        if (listaAdyacencia.containsKey(vertice)) {
            return false;
        }
        listaAdyacencia.put(vertice, new NodoGrafo<>(vertice));
        return true;
    }

    /**
     * Agrega una arista dirigida entre dos vertices del grafo.
     * @param vertice1       vertice donde la arista inicia.
     * @param vertice2       vertice donde la arista termina.
     */
    public boolean agregarArista(T vertice1, T vertice2) {
        return agregarArista(vertice1, vertice2, 255);
    }

    /**
     * Agrega una arista pesada y dirigida entre dos vertices del grafo.
     * @param vertice1       vertice donde la arista inicia.
     * @param vertice2       vertice donde la arista termina.
     * @param peso           peso de la arista.
     */
    public boolean agregarArista(T vertice1, T vertice2, int peso) {
        if (!contieneVertice(vertice1) || !contieneVertice(vertice2)) {
            throw new RuntimeException("Vertex does not exist");
        }

        // add the edge
        NodoGrafo<T> node1 = getNodo(vertice1);
        NodoGrafo<T> node2 = getNodo(vertice2);
        return node1.agregarArista(node2, peso) && node2.agregarArista(node1, peso);
    }

    /**
     * Remueve un vertice del grafo.
     * @param vertice        vertice por remover.
     * @return true si el vertice fue removido, false si el vertice no fue encontrado.
     */
    public boolean removerVertice(T vertice) {
        if (!listaAdyacencia.containsKey(vertice)) {
            return false;
        }

        // Obtiene el nodo que sera eliminado
        final NodoGrafo<T> toRemove = getNodo(vertice);

        // Elimina todas la aristas que llevan al nodo
        listaAdyacencia.values().forEach(node -> node.removerArista(toRemove));

        // Remueve el nodo
        listaAdyacencia.remove(vertice);
        return true;
    }

    /**
     * Metodo para remover una arista dirigida entre dos nodos.
     * @param vertice1       vertice donde la arista inicia.
     * @param vertice2       vertice donde la arista termina.
     * @return true si la arista fue removida, false sino se encontro la arista.
     */
    public boolean removerArista(T vertice1, T vertice2) {
        if (!contieneVertice(vertice1) || !contieneVertice(vertice2)) {
            return false;
        }
        return getNodo(vertice1).removerArista(getNodo(vertice2)) && getNodo(vertice2).removerArista(getNodo(vertice1));
    }

    /**
     * Metodo para encontrar la cantidad de vertices en el grafo.
     * @return cantidad de vertices.
     */
    public int cantidadVertices() {
        return listaAdyacencia.keySet().size();
    }

    /**
     * Metodo para encontrar la cantidad de aristas en el grafo.
     * @return cantidad de aristas.
     */
    public int cantidadAristas() {
        return listaAdyacencia.values()
                .stream()
                .mapToInt(NodoGrafo::getCantidadAristas)
                .sum();
    }

    /**
     * Metodo que revisa si un vertice esta contenido en el grafo.
     * @param vertice    vertice por revisar.
     * @return true si se encuentra el vertice, false de lo contrario.
     */
    public boolean contieneVertice(T vertice) {
        return listaAdyacencia.containsKey(vertice);
    }

    /**
     * Metodo que revisa si una arista esta contenida en el grafo.
     * @param vertice1       vertice donde la arista inicia.
     * @param vertice2       vertice donde la arista termina.
     * @return returns true si se encuentra la arista, false de lo contrario.
     */
    public boolean contieneArista(T vertice1, T vertice2) {
        if (!contieneVertice(vertice1) || !contieneVertice(vertice2)) {
            return false;
        }
        return getNodo(vertice1).poseeArista(getNodo(vertice2));
    }

    /**
     * Metodo para encontrar el camino mas corto de un nodo a otro.(Algoritmo Djkstra)
     * @param verticeInicial   vertice donde inicia el camino.
     * @param verticeFinal     vertice donde termina el camino.
     * @return  lista de vertices en el camino mas corto y null si no existe.
     */
   
    private NodoGrafo<T> getNodo(T value) {
        return listaAdyacencia.get(value);
    }
    
    public static void iterarGrafoYConstruirlo(ID nodoNuevo){
    	Peso peso = new Peso();
    	
    	for(int i = 0; i < Main.listaBlanca.size(); i++){
    		peso.calculadorPeso(nodoNuevo.getX(), nodoNuevo.getY(), Main.listaBlanca.get(i).getX(), Main.listaBlanca.get(i).getY());
    		System.out.println(nodoNuevo.getIP() + " a ");
    		Main.grafoGeneral.agregarArista(Main.listaBlanca.get(i), nodoNuevo, peso.getPeso());
    		
    	}
    }


}
