package com.vbvjain;

import sun.security.provider.certpath.AdjacencyList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vaibhavjain on 11/01/18.
 */
public class AdjacencyListGraph implements Graph {
    Node[] adjacencyList;
    int numOfVerticex = 0;
    typeOfGraph typeOfGraph = Graph.typeOfGraph.DI;

    public AdjacencyListGraph(int numOfVerticex, Graph.typeOfGraph typeOfGraph) {
        this.numOfVerticex = numOfVerticex;
        this.typeOfGraph = typeOfGraph;
        adjacencyList = new Node[numOfVerticex];
        for (int i = 0; i < numOfVerticex; i++) {
            adjacencyList[i] = null;
        }
    }

    @Override
    public void makeEdge(int v1, int v2) {
            Node node = getNode(v2);
            addVertexToList(v1,node);
        if (typeOfGraph== Graph.typeOfGraph.UN){
            Node node1 = getNode(v1);
            addVertexToList(v2,node1);
        }
    }


    private void addVertexToList(int v1, Node node) {
        if(adjacencyList[v1]!=null){
            Node n = adjacencyList[v1];
            while(n.next!=null){
                n = n.next;
            }
            n.next = node;
        }
        else {
            adjacencyList[v1] = node;
        }
    }


    @Override
    public List<Integer> getAdjacentVertices(int v) {
        ArrayList<Integer> arrayList = new ArrayList();
        Node t;
        t = adjacencyList[v];
        while(t!=null) {
            arrayList.add(t.vertex);
            t = t.next;
        }
        return arrayList;
    }

    private Node getNode(int v2) {
        Node node = new Node();
        node.vertex = v2;
        node.next = null;
        return node;
    }
}
