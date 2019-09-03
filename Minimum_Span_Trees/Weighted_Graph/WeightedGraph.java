package com.nero.main.java.algrorithm.Minimum_Span_Trees.Weighted_Graph;

public interface WeightedGraph<Weight extends Number & Comparable> {
    int V();
    int E();
    void addEdge(Edge<Weight> e);
    boolean hasEdge(int v, int w);
    void show();
    Iterable<Edge<Weight>> adj(int v);
}
