package com.nero.main.java.algrorithm.Graph_Basics;

// 圖的接口
public interface Graph {
    int V();
    int E();
    void addEdge(int v, int w);
    boolean hasEdge(int v, int w);
    void show();
    Iterable<Integer> adj(int v);
}
