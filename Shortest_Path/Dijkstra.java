package com.nero.main.java.algorithm.Shortest_Path;
import java.util.Stack;
import java.util.Vector;

// Dijkstra算法求最短路徑
public class Dijkstra<Weight extends Number & Comparable> {

    private  WeightedGraph G; //圖的引用
    private int s; // 起始點
    private Number[] distTo; // distTo[i]存儲從起始點s到i的最短路徑長度
    private boolean[] marked; // 標記數組, 在算法運行過程中標記節點i是否被訪問
    private Edge<Weight>[] from; // from[i]記錄最短路徑中, 到達i點的邊是哪一條
                                 // 可以用來恢復整個最短路徑

    // 構造函數, 使用Dijkstra算法求最短路徑
    public Dijkstra(WeightedGraph graph,int s){
            // 算法初始化
            G = graph;
            assert s >= 0 && s < G.V();
            this.s =s;
            distTo = new Number[G.V()];
            marked = new boolean[G.V()];
            from = new Edge[G.V()];
            for (int i = 0; i < G.V(); i++) {
                    distTo[i] = 0.0;
                    marked[i] = false;
                    from[i] =null;
                }
            // 使用索引堆記錄當前找到的到達每個頂點的最短距離
            IndexMinHeap<Weight> ipq = new IndexMinHeap<>(G.V());

            // 對於其實點s進行初始化
            distTo[s] = 0.0;
            from[s] = new Edge<>(s,s,(Weight)(Number)(0.0));
            ipq.insert(s,(Weight) distTo[s]);
            marked[s] = true;
            while (!ipq.isEmpty()){
                int v = ipq.extractMinIndex();

                // distTo[v]就是s到v的最短距離
                marked[v] = true;

                // 對v的所有相鄰節點進行更新
                for (Object item : G.adj(v)) {
                    Edge<Weight> e = (Edge<Weight>) item;
                    int w = e.other(v);
                    // 如果從s點到w點的最短路徑還沒有找到
                    if (!marked[w]){
                          // 如果w點以前沒有訪問過
                          // 或者訪問過, 但是通過當前的v點到w點距離更短, 則進行更新
                          if (from[w] == null || distTo[v].doubleValue() + e.wt().doubleValue() <
                                  distTo[w].doubleValue()){
                                  from[w] = e;
                                  if (ipq.contain(w))
                                      ipq.change(w,(Weight) distTo[w]);
                                  else
                                      ipq.insert(w,(Weight) distTo[w]);
                             }
                        }
                   }
              }
        }

    // 返回從s點到w點的最短路徑長度
    Number shortestPathTo(int w){
            assert w >= 0 && w <G.V();
            assert hasPathTo(w);
            return distTo[w];
        }

    // 判斷從s點到w點是否聯通
    private boolean hasPathTo(int w) {
            assert w >= 0 && w < G.V();
            return marked[w];
        }

    // 尋找從 s 到 w 的最短路徑, 將整個路徑經過的邊存放在 vec 中
    Vector<Edge<Weight>> shortestPath(int w){
            assert w >= 0 && w <G.V();
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
            assert hasPathTo(w);

            Vector<Edge<Weight>> path = shortestPath(w);
            for (int i = 0; i < path.size(); i++) {
                    System.out.print(path.elementAt(i).v()+" -> ");
                    if (1 == path.size()-1)
                        System.out.println(path.elementAt(i).w());
                }
        }
}
