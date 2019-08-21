package com.nero.main.java.algorithm.Graph_Basics;

public class Components {

    Graph G; // 圖的引用
    private boolean[] visited; // 記錄dfs的過程中節點是否被訪問
    private int ccount; // 記錄聯通分量個數
    private int[] id; // 每個節點所對應的聯通分量標記

    void dfs(int v){
            visited[v] = true;
            id[v] = ccount;

            for (int i: G.adj(v)){
                    if (!visited[i])
                        dfs(i);
                }
        }

    // 構造函數, 求出無權圖的聯通分量
    public Components(Graph graph){

            // 算法初始化
            G = graph;
            visited = new boolean[G.V()];
            id  = new int[G.V()];
            ccount = 0;
             for (int i = 0; i < G.V(); i++) {
                    visited[i] = false;
                    id[i] = -1;
                }

            // 求圖的聯通分量
             for (int i = 0; i < G.V(); i++) {
                    if (!visited[i])
                        dfs(i);
                    ccount++;
                }
        }

    // 返回圖的聯通分量個數
    int count(){
            return ccount;
        }

    // 查詢點v和點w是否聯通
    boolean isConnected(int v,int w){
            assert v >= 0 && v < G.V();
            assert w >= 0 && w < G.V();
            return id[v] == id[w];
        }
}
