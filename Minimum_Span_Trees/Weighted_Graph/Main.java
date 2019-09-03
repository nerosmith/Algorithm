package com.nero.main.java.algrorithm.Minimum_Span_Trees.Weighted_Graph;

public class Main {
    public static void main(String[] args) {
            // 使用兩種圖的存儲方式讀取testG4.txt文件
            String filename = "C:/testG4.txt";
            SparseWeightedGraph<Double> g1 = new SparseWeightedGraph<>(8,false);
            ReadWeightedGraph readGraph1 = new ReadWeightedGraph(g1,filename);
            System.out.println("test G4 in Sparse Weighted Graph: ");
            g1.show();

            System.out.println();

            DenseWeightedGraph<Double> g2 = new DenseWeightedGraph<>(8,false);
            ReadWeightedGraph readGraph2 = new ReadWeightedGraph(g2,filename);
            System.out.println("test G4 in Sparse Weighted Graph: ");
            g2.show();
        }
}
