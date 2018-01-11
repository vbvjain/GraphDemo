package com.vbvjain;

import java.util.List;

/**
 * Created by vaibhavjain on 11/01/18.
 */
public interface Graph {
    String UN = "un";
    String DI = "di";

    public enum typeOfGraph{
        UN,DI};
    void makeEdge(int v1,int v2);
    List<Integer> getAdjacentVertices(int v);
    void depthFirst(int startingVertex);
}
