package com.nero.main.java.algrorithm.Minimum_Span_Trees.Lazy_Prim;

import com.nero.main.java.algrorithm.Minimum_Span_Trees.Weighted_Graph.Edge;
import com.nero.main.java.algrorithm.Minimum_Span_Trees.Weighted_Graph.ReadWeightedGraph;
import com.nero.main.java.algrorithm.Minimum_Span_Trees.Weighted_Graph.SparseWeightedGraph;

import java.util.Vector;

public class Main2 {
    public static void main(String[] args) {
        String filename = "C:/testG4.txt";
        int V = 8;

        SparseWeightedGraph<Double> g = new SparseWeightedGraph<Double>(V,false);
        ReadWeightedGraph readGraph = new ReadWeightedGraph(g, filename);

        // Test Lazy Prim MST
        System.out.println("Test Lazy Prim MST:");
        LazyPrimMST<Double> lazyPrimMST = new LazyPrimMST<Double>(g);
        Vector<Edge<Double>> mst = lazyPrimMST.mstEdges();
        for( int i = 0 ; i < mst.size() ; i ++ )
            System.out.println(mst.elementAt(i));
        System.out.println("The MST weight is: " + lazyPrimMST.result());

        System.out.println();
    }
}
