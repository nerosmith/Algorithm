package com.nero.main.java.algrorithm.Minimum_Span_Trees.Implementation_of_Optimized_Prim_Algorithm;


import com.nero.main.java.algrorithm.Minimum_Span_Trees.Lazy_Prim.MinHeap;
import com.nero.main.java.algrorithm.Minimum_Span_Trees.Weighted_Graph.Edge;
import com.nero.main.java.algrorithm.Minimum_Span_Trees.Weighted_Graph.WeightedGraph;

import java.util.Vector;

// 使用Prim算法求圖的最小生成樹
public class LazyPrimMST<Weight extends Number & Comparable> {

    private WeightedGraph<Weight> G; // 圖的引用
    private MinHeap<Edge<Weight>> pq; // 最小堆, 輔助用
    private boolean[] marked; // 標記數組, 在算法運行過程中標記節點i是否被訪問
    private Vector<Edge<Weight>> mst; // 最小生成樹所包含的所有邊
    private Number mstWeight; //最小生成樹的權值

    // 構造函數, 使用Prim算法求圖的最小生成樹
    public LazyPrimMST( WeightedGraph<Weight> graph){
            // 算法初始化
            G = graph;
            pq = new MinHeap<Edge<Weight>>(G.E());
            marked = new boolean[G.V()];
            mst = new Vector<Edge<Weight>>();

            // Lazy Prim
            visit(0);
            while (!pq.isEmpty()){
                  // 使用最小堆找出已經訪問的邊中權值最小的邊
                  Edge<Weight> e = pq.extractMin();
                  // 如果這條邊的兩端都已經訪問過了, 則扔掉這條邊
                  if (marked[e.v()] == marked[e.w()])
                      continue;
                  // 否則, 這條邊則應該存在在最小生成樹中
                  mst.add(e);

                  // 訪問和這條邊連接的還沒有被訪問過的節點
                  if (!marked[e.v()])
                      visit(e.v());
                  else
                      visit(e.w());
                }

            // 計算最小生成樹的權值
            mstWeight = mst.elementAt(0).wt();
            for (int i = 1; i < mst.size(); i++) {
                  mstWeight = mstWeight.doubleValue()+mst.elementAt(i).wt().doubleValue();
                }
        }

    // 訪問節點v
    private void visit(int i) {
            assert !marked[i];
            marked[i] = true;

            // 將和節點 i 相連接的所有未訪問的邊放入最小堆中
            for (Edge<Weight> e: G.adj(i)) {
                    if (!marked[e.other(i)])
                        pq.insert(e);
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
