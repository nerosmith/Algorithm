package com.nero.main.java.algrorithm.Shortest_Path.Implementation_of_Bellman_Ford;

import java.util.Stack;
import java.util.Vector;

public class BellmanFord<Weight extends Number & Comparable> {

    private WeightedGraph G; //圖的引用
    private int s; // 起始點
    private Number[] distTo; // distTo[i]存儲從起始點s到i的最短路徑長度
    Edge<Weight>[] from; // from[i]記錄最短路徑中, 到達i點的邊是哪一條
                         // 可以用來恢復整個最短路徑
    boolean hasNegativeCycle; // 標記圖中是否有負權環

    // 構造函數, 使用BellmanFord算法求最短路徑
    public BellmanFord(WeightedGraph graph,int s){
            G = graph;
           this.s =s;
           distTo = new Number[G.V()];
           from = new Edge[G.V()];
           // 初始化所有的節點s都不可達, 由from數組來表示
           for (int i = 0; i < G.V(); i++)
              from[i] = null;
           // 設置distTo[s] = 0, 並且讓from[s]不為NULL, 表示初始s節點可達且距離為 0
           distTo[s] = 0.0;
           from[s] = new Edge<>(s,s,(Weight)(Number)(0.0));

           // Bellman-Ford的過程
           // 進行V-1次循環, 每一次循環求出從起點到其餘所有點, 最多使用pass步可到達的最短距離
            for (int pass = 1; pass < G.V(); pass++) {
                    // 每次循環中對所有的邊進行一遍鬆弛操作
                    // 遍歷所有邊的方式是先遍歷所有的頂點, 然後遍歷和所有頂點相鄰的所有邊
                    for (int i = 0; i < G.V(); i++) {
                            for (Object item : G.adj(i)){
                                    Edge<Weight> e = (Edge<Weight>) item;
                                    // 對於每一個邊首先判斷 e.v() 可達
                                    // 之後看如果e.w()以前沒有到達過， 顯然我們可以更新distTo[e.()]
                                    // 或者e.w()以前雖然到達過, 但是通過這個e我們可以獲得一個更短的距離, 即可以進行一次鬆弛操作, 我們也可以更新distTo[e.w()]
                                    if (from[e.v()] != null && (from[e.w()] == null || distTo[e.v()].doubleValue() + e.wt().doubleValue() <
                                            distTo[e.w()].doubleValue())){
                                            distTo[e.w()] = distTo[e.v()].doubleValue()+e.wt().doubleValue();
                                            from[e.w()] = e;
                                        }
                                }
                        }
                }
            hasNegativeCycle = detectNegativeCycle();
        }

    // 判斷圖中是否有負權環
    boolean detectNegativeCycle() {
            for (int i = 0; i < G.V(); i++) {
                    for (Object item : G.adj(i)){
                            Edge<Weight> e = (Edge<Weight>) item;
                            if (from[e.v()] != null && distTo[e.v()].doubleValue()+e.wt().doubleValue() < distTo[e.w()].doubleValue())
                                return true;
                        }
                }
            return false;
        }

    // 判斷圖中是否有負權環
    boolean negativeCycle(){
            return hasNegativeCycle; }

    // 返回從s點到w點的最短路徑長度
    Number shortestPathTo( int w ){
             assert w >= 0 && w < G.V();
             assert !hasNegativeCycle;
             assert hasPathTo(w);
             return distTo[w];
        }

    // 判斷從s點到w點是否聯通
    private boolean hasPathTo(int w) {
            assert w >= 0 && w <G.V();
            return from[w] != null;
        }

    // 尋找從s 到 w 的最短路徑, 將整個路徑經過的邊存放在 vec 中
    Vector<Edge<Weight>> shortestPath(int w){
            assert w >= 0 && w <G.V();
            assert hasNegativeCycle;
            assert hasPathTo(w);

            // 通過from數組逆向查找到從s到w的路徑, 存放到棧中
            Stack<Edge<Weight>> s = new Stack<>();
            Edge<Weight> e = from[w];
            while( e.v() != this.s){
                s.push(e);
                e = from[e.v()];
            }
            s.push(e);

            // 從棧中依次取出元素, 獲得順序的從s到w的路徑
            Vector<Edge<Weight>> res = new Vector<>();
            while (!s.empty()){
                e = s.pop();
                res.add(e);
            }
            return res;
        }

    // 打印出從s點到w點的路徑
    void showPath(int w){
            assert w >= 0 && w <G.V();
            assert hasNegativeCycle;
            assert hasPathTo(w);

            Vector<Edge<Weight>> res = shortestPath(w);
            for (int i = 0; i < res.size(); i++) {
                System.out.print(res.elementAt(i).v()+" -> ");
                if (1 == res.size()-1)
                    System.out.println(res.elementAt(i).w());
            }
        }

}
