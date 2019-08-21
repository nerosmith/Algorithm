package com.nero.main.java.algorithm.Minimum_Span_Trees;

import java.util.Vector;

public class SparseWeightedGraph<Weight extends Number & Comparable>
        implements WeightedGraph {

    private int n; // 節點數
    private int m; // 邊數
    private  boolean directed; // 是否為有向圖
    private Vector<Edge<Weight>>[] g; // 圖的具體數據

    // 構造函數
    public SparseWeightedGraph(int n,boolean directed){
            assert n >= 0;
            this.n = n;
            this.m = 0; // 初始化沒有任何邊
            this.directed = directed;
            // g 初始化為n個空的vector, 表示每一個g[i]都為空, 即沒有任和邊
            g = (Vector<Edge<Weight>>[]) new Vector[n];
            for (int i = 0; i < n; i++)
                g[i] = new Vector<Edge<Weight>>();
        }

    // 返回節點個數
    @Override
    public int V() { return n;}

    // 返回邊的個數
    @Override
    public int E() { return m;}

    // 向圖中添加一個邊, 權值為weight
    @Override
    public void addEdge(Edge e) {
          assert e.v() >= 0 && e.v() < n;
          assert e.w() >= 0 && e.w() < n;
          // 由於在鄰接表的情況, 查找是否有重邊需要遍歷整個鏈表
          // 此程序允許重邊的出現
          g[e.v()].add(new Edge(e));
          if (e.v() != e.w() && !directed)
             g[e.w()].add(new Edge(e.w(),e.v(),e.wt()));

          m++;
        }

    // 驗證圖中是否有從v到w的邊
    @Override
    public boolean hasEdge(int v, int w) {
            assert v >= 0 && v < n;
            assert w >= 0 && w < n;
            for (int i = 0; i < g[v].size(); i++) {
                   if (g[v].elementAt(i).other(v) == w)
                       return true;
                }
            return false;
        }

    // 顯示圖的信息
    @Override
    public void show() {
            for (int i = 0; i < n; i++) {
                System.out.print("vertex " + i + ":\t");
                for (int j = 0; j < g[i].size(); j++) {
                        Edge e = g[i].elementAt(j);
                        System.out.print("( to: " + e.other(i) + ", wt: " + e.wt() + " )\t");
                    }
                System.out.println();
            }
        }

    // 返回圖中一個頂點的所有鄰邊
    @Override
    public Iterable<Edge<Weight>> adj(int v) {
        assert v >= 0 && v < n;
        return g[v];
    }
}
