package com.nero.main.java.algrorithm.Union_Find.Optimize_by_Rank;

public class UnionFind4 {
    private int[] rank; // rank[i]表示以i為根的集合所表示的樹的層數
    private int[] parent; // parent[i]表示第i個元素所指向的父節點
    private int count; // 數據個數

    public UnionFind4(int count){
            rank = new int[count];
            parent = new int[count];
            this.count = count;
            // 初始化, 每一個parent[i]指向自己, 表示每一個元素自己自成一個集合
            for (int i = 0; i < count; i++) {
                    parent[i] = i;
                    rank[i] = 1;
                }
        }

    // 查找過程, 查找元素p所對應的集合編號
    // O(h)複雜度, h為樹的高度
    private int find(int p){
            assert (p >= 0 && p < count);

            // 不斷去查詢自己的父親節點, 直到到達根節點
            // 根節點的特點: parent[p] == p
            while(p != parent[p])
                p = parent[p];
            return p;
        }

    // 查看元素p和元素q是否所屬一個集合
    // O(h)複雜度, h為樹的高度
    public boolean isConnected( int p , int q ){
        return find(p) == find(q);
    }

    // 合併元素p和元素q所屬的集合
    // O(h)複雜度, h為樹的高度
    public void unionElements(int p ,int q){
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot)
            return;


        // 根據兩個元素所在樹的元素個數不同判斷合併方向
        // 將元素個數少的集合合併到元素個數多的集合上
        if (rank[pRoot] < rank[qRoot]){
                parent[pRoot] = qRoot;
            }
        else if (rank[qRoot] < rank[pRoot]){
                parent[qRoot] = pRoot;
            }
        else { // rank[qRoot] == rank[pRoot]
                parent[pRoot] = qRoot;
                rank[qRoot] += 1; // 此時,維護rank的值
            }
    }

}
