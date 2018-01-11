package com.vbvjain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by vaibhavjain on 11/01/18.
 */
public class AdjacencyMatrixGraph implements Graph {
    int[][] adjacencyMatrix;
    int numOfVerticex = 0;
    typeOfGraph typeOfGraph = Graph.typeOfGraph.DI;

    public AdjacencyMatrixGraph(int numOfVerticex,typeOfGraph typeOfGraph) {
        this.numOfVerticex = numOfVerticex;
        this.typeOfGraph = typeOfGraph;
        adjacencyMatrix = new int[numOfVerticex][numOfVerticex];
        for (int i = 0; i < numOfVerticex; i++) {
            for (int j = 0; j < numOfVerticex; j++) {
                adjacencyMatrix[i][j]=0;
            }
        }
    }

    @Override
    public void makeEdge(int v1, int v2) {
        adjacencyMatrix[v1][v2] = 1;
        if (typeOfGraph== Graph.typeOfGraph.UN){
            adjacencyMatrix[v2][v1]=1;
        }
    }

    @Override
    public List<Integer> getAdjacentVertices(int v) {
        List<Integer> adjacentVertexList = new ArrayList<>();
        for (int i = 0; i < numOfVerticex; i++) {
            if (adjacencyMatrix[v][i]==1){
                adjacentVertexList.add(i);
            }
        }
        Collections.sort(adjacentVertexList);
        return adjacentVertexList;
    }

    @Override
    public void depthFirst(int startingVertex) {

    }
}
