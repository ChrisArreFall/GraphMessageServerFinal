package com.itcr.visualizer;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import grph.Grph;

import java.util.HashMap;
import java.util.Map;

import com.itcr.usuario.ID;

import cnrs.grph.set.IntSet;
import grph.algo.AdjacencyMatrix;
import grph.properties.IntProperty;

public class Graph
{
    private final Grph g;
    private IntSet vertex;
    private Map<ID, Integer> map = new HashMap<ID, Integer>();
   
    public Graph()
    { 
        g = new Grph();
    }
    
    public void show()
    {
        g.display();
    }
    
    public void addNodos(int n)
    {   
        g.addNVertices(n);
    }
    
    public void removeNodo(ID vertice)
    {
        g.removeVertex(map.get(vertice));
        map.remove(vertice);
    }
    
    public void addArista(ID nodoInicial, ID nodoFinal, int peso)
    {
        int edge = g.addSimpleEdge(map.get(nodoInicial), map.get(nodoFinal), false);
        g.getEdgeWeightProperty().setValue(edge, peso);
        g.getEdgeLabelProperty().setValue(edge,"Peso: "+g.getEdgeWeightProperty().getValueAsString(edge));
    }
    
    public void removerArista(int arista)
    {
      g.removeEdge(arista);
    }
    
    public void setSizeVertice(int noVertice, int size)
    {
        g.getVertexSizeProperty().setValue(noVertice, size);
    }
    
    public void setPesoArista(int edge, int peso)
    {
       g.getEdgeWeightProperty().setValue(edge, peso);
       g.getEdgeLabelProperty().setValue(edge,g.getEdgeWeightProperty().getValueAsString(edge));
    }
    
    public AdjacencyMatrix getMatrixAdyacencia()
    {
       AdjacencyMatrix a = g.getAdjacencyMatrix();
        System.out.println(a.toString());
        return a;
       
    }
    
    public void gridNodos(int ancho, int alto, boolean dirigido, boolean diagonales)
    {
        g.grid(ancho, alto, dirigido, diagonales);
    }
    
    public void setColorNodo(int nodo, int color)
    {
        g.getVertexColorProperty().setValue(nodo, color);
    }
    
    public void setColorArista(int arista, int color)
    {
      g.getEdgeColorProperty().setValue(arista, color);
    }
    
    public int[] getNodos()
    {
      IntSet nVertices = g.getVertices();
      return nVertices.toIntArray();
    }
    
    public int[] getAristas()
    {
      IntSet nAristas = g.getEdges();
      return nAristas.toIntArray();
    }
    
    public Grph getGraph()
    {
      return this.g;  
    }
    
    public IntProperty getPesosAristas()
    {
      IntProperty e = g.getEdgeWeightProperty();
      System.out.println(e.toString());
      return e;
    }
    
    public void setNombreNodo(ID nodo, String nombre)
    {
        g.getVertexLabelProperty().setValue(map.get(nodo), nombre);
        
        
    }
    
    public void setNombreArista(int arista, String nombre)
    {
       g.getEdgeLabelProperty().setValue(arista, nombre);
    }
    public void colorShortPath(ID inicio, ID fin)
    {
       IntSet p = g.getShortestPath(map.get(inicio), map.get(fin), true).getVertexSet();
       vertex = p;
       this.resetColorPath();
       int color = (int)(Math.random() * 14 + 1);
       g.highlightVertices(vertex, color);
       g.highlightEdges(g.getSubgraphInducedByVertices(vertex).getEdges(), color);
       
    }
    public void resetColorPath()
    {
       g.highlightVertices(vertex, 0);
       g.highlightEdges(g.getSubgraphInducedByVertices(vertex).getEdges(), 1);
    }
    public void clearGraph()
    {
    	map.clear();
        g.clear();
    }
    public void addVerticeDiccionario(ID verticeNuevo){
    	map.put(verticeNuevo, g.getNumberOfVertices());
    	g.addVertex();
    	g.getVertexSizeProperty().setValue(map.get(verticeNuevo), 25);
    }
    
    public Integer buscarVertice(ID nodo){
    	return map.get(nodo);	
    }
}
