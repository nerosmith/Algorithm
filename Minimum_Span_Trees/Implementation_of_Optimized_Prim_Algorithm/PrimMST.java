package com.nero.main.java.algrorithm.Minimum_Span_Trees.Implementation_of_Optimized_Prim_Algorithm;

import com.nero.main.java.algrorithm.Minimum_Span_Trees.Weighted_Graph.Edge;
import com.nero.main.java.algrorithm.Minimum_Span_Trees.Weighted_Graph.WeightedGraph;

import java.util.Vector;

// 使用優化的Prim算法求圖的最小生成樹
public class PrimMST <Weight extends Number & Comparable>{
    private WeightedGraph G; // 圖的引用
    private IndexMinHeap<Weight> ipq; // 最小索引堆
    private Edge<Weight>[] edgeTo; // 訪問的點所對應的邊
    private boolean[] marked; // 標記數組, 在算法運行過程中標記節點i是否被訪問
    private Vector<Edge<Weight>> mst; // 最小生成樹所包含的所有邊
    private Number mstWeight; //最小生成樹的權值

    // 構造函數, 使用 Prim 算法求圖的最小生成樹
    public PrimMST(WeightedGraph graph){
            G = graph;
            assert graph.E() >= 1;
            ipq = new IndexMinHeap<Weight>(graph.V());

            // 算法初始化
            marked = new boolean[G.V()];
            edgeTo = new Edge[G.V()];
            for (int i = 0; i < G.V(); i++) {
                    marked[i] = false;
                    edgeTo[i] = null;
                }
            mst = new Vector<Edge<Weight>>();

            // Prim
            visit(0);
            while (!ipq.isEmpty()){
                // 使用最小索引堆找出已經訪問的邊中權值最小的邊
                // 最小索引堆中存儲的是點的索引, 通過點的索引找到相對應的邊
                    int v = ipq.extractMinIndex();
                    assert edgeTo[v] != null;
                    mst.add(edgeTo[v]);
                    visit(v);
                }

            // 計算最小生成樹的權值
            mstWeight = mst.elementAt(0).wt();
            for (int i = 1; i < mst.size(); i++)
                mstWeight = mstWeight.doubleValue()+mst.elementAt(i).wt().doubleValue();
        }

    // 訪問節點 v
    private void visit(int v) {
            assert !marked[v];
            marked[v] = true;

            // 將和節點 v 相連接的未訪問的另一端點, 和與之相連接的邊, 放入最小堆中
            for (Object item : G.adj(v)){
                    Edge<Weight> e = (Edge<Weight>) item;
                    int w = e.other(v);

                    // 如果邊的另一端點未被訪問
                    if (!marked[w]){
                           // 如果從沒有考慮過這個端點, 直接將這個端點和與之相連接的邊加入索引堆
                           if (edgeTo[w] == null){
                                 edgeTo[w] = e;
                                 ipq.insert(w,e.wt());
                              }
                           // 如果曾經考慮這個端點, 但現在的邊比之前考慮的邊更短, 則進行替換
                           else if (e.wt().compareTo(edgeTo[w].wt()) < 0){
                                 edgeTo[w] = e;
                                 ipq.change(w,e.wt());
                              }
                        }
                }
        }

    // 返回最小生成樹的所有邊
    Vector<Edge<Weight>> mstEdges(){
            return mst;
        }

    // 返回最小生成樹的權值
    Number result(){
            return mstWeight;
        }

}
