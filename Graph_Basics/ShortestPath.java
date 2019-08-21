package com.nero.main.java.algorithm.Graph_Basics;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;

public class ShortestPath {

    private Graph G; // 圖的引用
    private int s; // 起始點
    private boolean[] visited; // 記錄dfs的過程中節點是否被訪問
    private int[] from; // 記錄路徑, from[i]表示查找的路徑上i的上一個節點
    private int[] ord; // 記錄路徑中節點的次序。 ord[i]表示i節點在路徑中的次序

    // 構造函數, 尋路算法, 尋找圖graph從s點到其他點的路徑
    public ShortestPath(Graph graph,int s){
            // 算法初始化
            G = graph;
            assert  s >= 0 && s < G.V();

            visited = new boolean[G.V()];
            from = new int[G.V()];
            ord = new int[G.V()];
            for (int i = 0; i < G.V(); i++) {
                        visited[i] = false;
                        from[i] = -1;
                        ord[i] = -1;
                }
            this.s = s;

            // 無向圖最短路徑算法, 從s開始廣度優先遍歷整張圖
            Queue<Integer> q = new LinkedList<>();

            q.add(s);
            visited[s] = true;
            ord[s] = 0;
            while(!q.isEmpty()){
                 int v = q.remove();
                 for (int i : G.adj(v)) {
                       if (!visited[i]){
                             q.add(i);
                             visited[i] = true;
                             from[i] = v;
                             ord[i] = ord[v]+1;
                         }
                   }
              }
        }

    // 查詢從s點到w點是否有路徑
    public boolean hasPath(int w){
            assert w >= 0 && w < G.V();
            return visited[w];
        }

    // 查詢從s點到w點的路徑, 存放在vec中
    public Vector<Integer> path(int w){
            assert hasPath(w);
            Stack<Integer> s = new Stack<>();

            // 通過from數組逆向查找到從s到w的路徑, 存放到棧中
            int p = w;
            while (p != -1){
                s.push(p);
                p = from[p];
            }

            // 從棧中依次取出元素, 獲得順序的從s到w的路徑
            Vector<Integer> res = new Vector<>();
            while (!s.empty())
                res.add(s.pop());

            return res;
        }

    // 打印出從s點到w點的路徑
    public void showPath(int w){
        assert hasPath(w);
        Vector<Integer> vec = path(w);
        for (int i = 0; i < vec.size(); i++) {
            System.out.print(vec.elementAt(i));
            if (i == vec.size()-1)
                System.out.println();
            else
                System.out.print(" -> ");
        }
    }

    // 查看從s點到w點的最短路徑長度
    // 若從s到w不可達，返回-1
    public int length(int w){
            assert w >= 0 && w < G.V();
            return ord[w];
        }

}
