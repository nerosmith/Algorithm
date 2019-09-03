package com.nero.main.java.algrorithm.Graph_Basics;

import java.util.Vector;

// 稀疏圖 - 鄰接表
public class SparseGraph implements Graph{

    private int n; // 節點數
    private int m; // 邊數
    private boolean directed; // 是否為有向圖
    private Vector<Integer>[] g; // 圖的具體數據

    // 構造函數
    public SparseGraph(int n,boolean directed){
        assert  n>=0;
        this.n = n;
        this.m = 0; // 初始化沒有任何邊
        this.directed = directed;
        // g初始化為n個空的vector, 表示每一個g[i]都為空, 即沒有任何邊
        g = (Vector<Integer>[]) new Vector[n];
        for (int i = 0; i < n; i++)
            g[i] = new Vector<Integer>();
    }

    public int V(){return n;} // 返回節點個數
    public int E(){return m;} // 返回邊的個數

    // 向圖中添加一個邊
    public void addEdge(int v,int w){
            assert v >= 0 && v < n;
            assert w >= 0 && w < n;

            g[v].add(w);
            if (v != w && !directed )
                g[w].add(v);
            m++;
        }

    // 驗證圖中是否有從v到w的邊
    @Override
    public boolean hasEdge(int v, int w) {
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;

        for (int i = 0; i < g[v].size(); i++) {
            if (g[v].elementAt(i) == w)
                return true;
        }
        return false;
    }

    @Override
    public void show() {
            for (int i = 0; i < n; i++) {
                    System.out.print("vertex "+i+":\t");
                    for (int j = 0; j < g[i].size();j++)
                        System.out.print(g[i].elementAt(j)+"\t");
                    System.out.println();
                }
        }


    // 返回圖中一個頂點的所有鄰邊
    // 由於java使用引用機制，返回一個Vector不會帶來額外開銷
    public Iterable<Integer> adj(int v){
            assert v >= 0 && v < n;
            return g[v];
        }
}
