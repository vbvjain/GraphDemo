package com.vbvjain;

import java.util.List;

public class Main {

    public static void main(String[] args) {
	    AdjacencyListGraph adjacencyListGraph = new AdjacencyListGraph(9, Graph.typeOfGraph.UN);
        adjacencyListGraph.makeEdge(0,1);
        List<Integer> adjacentVertices = adjacencyListGraph.getAdjacentVertices(3);
        for (int i = 0; i < adjacentVertices.size(); i++) {
            System.out.println(adjacentVertices.get(i));
        }
        adjacencyListGraph.depthFirst(1);

    }
}
