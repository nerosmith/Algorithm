package com.nero.main.java.algorithm.Graph_Basics;

import java.util.Vector;

// 稠密圖 - 鄰接矩陣
public class DenseGraph implements Graph{

    private int n; // 節點數
    private int m; // 邊數
    private boolean directed; // 是否為有向圖
    private boolean[][] g; // 圖的具體數據

    // 構造函數
    public DenseGraph(int n,boolean directed){
            assert  n>=0;
            this.n = n;
            this.m = 0; // 初始化沒有任何邊
            this.directed = directed;
            // g初始化為n*n的布爾矩陣, 每一個g[i][j]均為false, 表示沒有任和邊
            // false為boolean型變量的默認值
            g = new boolean[n][n];
        }

    public int V(){return n;} // 返回節點個數
    public int E(){return m;} // 返回邊的個數

    // 向圖中添加一個邊
    public void addEdge(int v,int w){
            assert v >= 0 && v < n;
            assert w >= 0 && w < n;

            if (hasEdge(v,w))
                return;
            g[v][w] = true;
            if (!directed)
                g[w][v] = true;
            m++;
        }

    // 驗證圖中是否有從v到w的邊
    @Override
    public boolean hasEdge(int v, int w) {
            assert v >= 0 && v < n;
            assert w >= 0 && w < n;
            return g[v][w];
        }

    // 顯示圖的信息
    @Override
    public void show() {
            for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++)
                        System.out.print(g[i][j]+"\t");
                    System.out.println();
                }
        }

    // 返回圖中一個頂點的所有鄰邊
    // 由於java使用引用機制，返回一個Vector不會帶來額外開銷
    public Iterable<Integer> adj(int v){
            assert v >= 0 && v < n;
            Vector<Integer> adjV = new Vector<Integer>();
            for (int i = 0; i < n; i++) {
                    if (g[v][i])
                        adjV.add(i);
                }
            return adjV;
        }
}
