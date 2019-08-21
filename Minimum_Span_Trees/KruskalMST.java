package com.nero.main.java.algorithm.Minimum_Span_Trees;

import java.util.Vector;

// Kruskal算法求最小生成樹
public class KruskalMST<Weight extends  Number &  Comparable> {

    private Vector<Edge<Weight>> mst; // 最小生成樹所包含的所有邊
    private Number mstWeight; //最小生成樹的權值

    public KruskalMST(WeightedGraph graph){
            mst = new Vector<Edge<Weight>>();

            // 將圖中的所有邊存放到一個最小堆中
            MinHeap<Edge<Weight>> pq = new MinHeap<>(graph.E());
            for (int i = 0; i < graph.V(); i++) {
                for (Object item : graph.adj(i)) {
                        Edge<Weight> e = (Edge<Weight>) item;
                        if (e.v() <= e.w())
                            pq.insert(e);
                    }
                }

            // 創建一個並查集, 來查看已經訪問的節點的聯通情況
            UnionFind uf = new UnionFind(graph.V());
            while (!pq.isEmpty() && mst.size() < graph.V() - 1){

                   // 從最小堆中依次從小到大取出所有的邊
                   Edge<Weight> e = pq.extractMin();
                   // 如果該邊的兩個端點是聯通的, 說明加入這條邊將產生環, 扔掉這條邊
                   if (uf.isConnected(e.v(),e.w()))
                       continue;
                   // 否則, 將這條邊添加進最小生成樹, 同時標記邊的兩個端點聯通
                   mst.add(e);
                   uf.unionElements(e.v(),e.w());
                }

            // 計算最小生成樹的權值
            mstWeight = mst.elementAt(0).wt();
            for (int i = 1; i < mst.size(); i++)
                mstWeight = mstWeight.doubleValue()+mst.elementAt(i).wt().doubleValue();
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
