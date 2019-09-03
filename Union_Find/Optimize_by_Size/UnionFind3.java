package com.nero.main.java.algrorithm.Union_Find.Optimize_by_Size;

// 第三版Union-Find
public class UnionFind3 {
    private int[] parent; // parent[i]表示第一個元素所指向的父節點
    private int[] sz; // sz[i]表示以i為根的集合中元素個數
    private int count; // 數據個數

    public UnionFind3(int count){
            parent = new int[count];
            sz = new int[count];
            this.count = count;
            // 初始化, 每一個parent[i]指向自己, 表示每一個元素自己自成一個集合
            for (int i = 0; i < count; i++) {
                    parent[i] = i;
                    sz[i] = 1;
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
            if (sz[pRoot] < sz[qRoot]){
                    parent[pRoot] = qRoot;
                    sz[qRoot]+=sz[pRoot];
                }
            else{
                    parent[qRoot] = pRoot;
                    sz[pRoot]+=sz[qRoot];
              }
        }
}
