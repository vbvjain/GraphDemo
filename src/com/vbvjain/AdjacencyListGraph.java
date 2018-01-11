package com.vbvjain;

import sun.security.provider.certpath.AdjacencyList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;


public class AdjacencyListGraph implements Graph {
    Node[] adjacencyList;
    int numOfVerticex = 0;
    typeOfGraph typeOfGraph = Graph.typeOfGraph.DI;
    Boolean[] visited;
    Stack<Integer> stack;

    public AdjacencyListGraph(int numOfVerticex, Graph.typeOfGraph typeOfGraph) {
        this.numOfVerticex = numOfVerticex;
        this.typeOfGraph = typeOfGraph;
        adjacencyList = new Node[numOfVerticex];
        visited = new Boolean[numOfVerticex];
        for (int i = 0; i < numOfVerticex; i++) {
            adjacencyList[i] = null;
        }
        for (int i = 0; i < numOfVerticex; i++) {
            visited[i] = false;
        }
        stack = new Stack<>();

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

    @Override
    public void depthFirst(int startingVertex) {
        stack.push(startingVertex);
        printTheNode(startingVertex);
        markVisited(startingVertex);
        traverse();
        }

    private void traverse() {
        Integer peek = stack.peek();
        int unvisitedNode = getUnvisitedNode(peek);
        if (unvisitedNode == -1) {
            stack.pop();
            if (stack.empty()) return;
            traverse();
        } else {
            stack.push(unvisitedNode);
            printTheNode(unvisitedNode);
            markVisited(unvisitedNode);
            traverse();
        }
    }

    private void markVisited(int unvisitedNode) {
        visited[unvisitedNode] = true;
    }

    private void printTheNode(int startingVertex) {
        System.out.println("The Node is " + startingVertex);
    }

    private int getUnvisitedNode(int startingVertex) {
        List<Integer> adjacentVertices = getAdjacentVertices(startingVertex);
        Iterator<Integer> iterator = adjacentVertices.iterator();
        while (iterator.hasNext()){
            Integer next = iterator.next();
            if (!visited[next]) return next;
        }
        return -1;
    }

    private Node getNode(int v2) {
        Node node = new Node();
        node.vertex = v2;
        node.next = null;
        return node;
    }
}
