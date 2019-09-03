package com.nero.main.java.algrorithm.Shortest_Path.Implementation_of_Bellman_Ford;

interface WeightedGraph<Weight extends Number & Comparable> {
    int V();
    int E();
    void addEdge(Edge<Weight> e);
    boolean hasEdge(int v, int w);
    void show();
    Iterable<Edge<Weight>> adj(int v);
}
