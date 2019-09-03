package com.nero.main.java.algrorithm.Minimum_Span_Trees.Implementation_of_Optimized_Prim_Algorithm;

import com.nero.main.java.algrorithm.Minimum_Span_Trees.Weighted_Graph.ReadWeightedGraph;
import com.nero.main.java.algrorithm.Minimum_Span_Trees.Weighted_Graph.SparseWeightedGraph;

// 測試實現的兩種Prim算法的性能差距
// 可以看出這一節使用索引堆實現的 Prim 算法優於 Lazy Prim算法
public class Main {
        public static void main(String[] args) {

                String filename1 = "C:/Users/Avaron/Desktop/testG1.txt";
                int V1 = 8;

                String filename2 = "C:/Users/Avaron/Desktop/testG2.txt";
                int V2 = 250;

                String filename3 = "C:/Users/Avaron/Desktop/testG3.txt";
                int V3 = 1000;

                String filename4 = "C:/Users/Avaron/Desktop/testG4.txt";
                int V4 = 10000;

                // 文件讀取
                SparseWeightedGraph<Double> g1 = new SparseWeightedGraph<>(V1, false);
                ReadWeightedGraph readGraph1 = new ReadWeightedGraph(g1, filename1);
                System.out.println( filename1 + " load successfully.");

                SparseWeightedGraph<Double> g2 = new SparseWeightedGraph<>(V2, false);
                ReadWeightedGraph readGraph2 = new ReadWeightedGraph(g2, filename2);
                System.out.println( filename2 + " load successfully.");

                SparseWeightedGraph<Double> g3 = new SparseWeightedGraph<>(V3, false);
                ReadWeightedGraph readGraph3 = new ReadWeightedGraph(g3, filename3);
                System.out.println( filename3 + " load successfully.");

                SparseWeightedGraph<Double> g4 = new SparseWeightedGraph<>(V4, false);
                ReadWeightedGraph readGraph4 = new ReadWeightedGraph(g4, filename4);
                System.out.println( filename4 + " load successfully.");

                System.out.println();

                long startTime, endTime;

                // Test Lazy Prim MST
                System.out.println("Test Lazy Prim MST:");

                startTime = System.currentTimeMillis();
                LazyPrimMST<Double> lazyPrimMST1 = new LazyPrimMST<Double>(g1);
                endTime = System.currentTimeMillis();
                System.out.println("Test for G1: " + (endTime-startTime) + "ms.");

                startTime = System.currentTimeMillis();
                LazyPrimMST<Double> lazyPrimMST2 = new LazyPrimMST<Double>(g2);
                endTime = System.currentTimeMillis();
                System.out.println("Test for G2: " + (endTime-startTime) + "ms.");

                startTime = System.currentTimeMillis();
                LazyPrimMST<Double> lazyPrimMST3 = new LazyPrimMST<Double>(g3);
                endTime = System.currentTimeMillis();
                System.out.println("Test for G3: " + (endTime-startTime) + "ms.");

                startTime = System.currentTimeMillis();
                LazyPrimMST<Double> lazyPrimMST4 = new LazyPrimMST<Double>(g4);
                endTime = System.currentTimeMillis();
                System.out.println("Test for G4: " + (endTime-startTime) + "ms.");

                System.out.println();

                // Test Prim MST
                System.out.println("Test Prim MST:");

                startTime = System.currentTimeMillis();
                PrimMST<Double> primMST1 = new PrimMST<Double>(g1);
                endTime = System.currentTimeMillis();
                System.out.println("Test for G1: " + (endTime-startTime) + "ms.");

                startTime = System.currentTimeMillis();
                PrimMST<Double> primMST2 = new PrimMST<Double>(g2);
                endTime = System.currentTimeMillis();
                System.out.println("Test for G2: " + (endTime-startTime) + "ms.");

                startTime = System.currentTimeMillis();
                PrimMST<Double> primMST3 = new PrimMST<Double>(g3);
                endTime = System.currentTimeMillis();
                System.out.println("Test for G3: " + (endTime-startTime) + "ms.");

                startTime = System.currentTimeMillis();
                PrimMST<Double> primMST4 = new PrimMST<Double>(g4);
                endTime = System.currentTimeMillis();
                System.out.println("Test for G4: " + (endTime-startTime) + "ms.");

                System.out.println();

            }
    }
