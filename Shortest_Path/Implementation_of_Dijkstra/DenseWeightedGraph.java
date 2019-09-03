package com.nero.main.java.algrorithm.Shortest_Path.Implementation_of_Dijkstra;

import java.util.Vector;

// 稠密圖 - 鄰接矩陣
public class DenseWeightedGraph <Weight extends Number & Comparable>
        implements WeightedGraph{

    private int n; // 節點數
    private int m; // 邊數
    private  boolean directed; // 是否為有向圖
    private Edge<Weight>[][] g; //圖的具體數據

    // 構造函數
    public DenseWeightedGraph(int n,boolean directed){
            assert n >= 0;
            this.n = n;
            this.m = 0; // 初始化沒有任何邊
            this.directed = directed;
            // g 初始化為 n*n 的布爾矩陣, 每一個 g[i][j] 均為 null, 表示沒有任和邊
            // false 為 boolean 型變量的默認值
            g = new Edge[n][n];
            for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++)
                        g[i][j] = null;
                }
        }

    // 返回節點個數
    @Override
    public int V() { return n;}

    // 返回邊的個數
    @Override
    public int E() { return m;}

    // 向圖中添加一個邊
    @Override
    public void addEdge(Edge e) {
            assert e.v() >= 0 && e.v() < n;
            assert e.w() >= 0 && e.w() < n;

            if (hasEdge(e.v(),e.w())) return;

            g[e.v()][e.w()] = new Edge<>(e);
            if (e.v() != e.w() && !directed)
                g[e.v()][e.w()] = new Edge(e.w(),e.v(),e.wt());
            m++;
        }

    // 驗證圖中是否有從v到w的邊
    @Override
    public boolean hasEdge(int v, int w) {
            assert v >= 0 && v < n;
            assert w >= 0 && w < n;
            return g[v][w] != null;
        }

    // 顯示圖的訊息
    @Override
    public void show() {
            for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                            if ( g[i][j] != null)
                                System.out.print(g[i][j].wt()+"\t");
                            else
                                System.out.print("NULL\t");
                        }
                    System.out.println();
                }
        }

    // 返回圖中一個頂點的所有鄰邊
    @Override
    public Iterable<Edge<Weight>> adj(int v) {
            assert v >= 0 && v < n;
            Vector<Edge<Weight>> adjV = new Vector<Edge<Weight>>();
            for (int i = 0; i < n; i++) {
                    if (g[v][i] != null)
                        adjV.add(g[v][i]);
                }
            return adjV;
        }
}
