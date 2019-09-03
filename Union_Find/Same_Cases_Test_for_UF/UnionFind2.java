package com.nero.main.java.algrorithm.Union_Find.Same_Cases_Test_for_UF;

public class UnionFind2  implements UF{
    // 第二版Union-Find, 使用一個數組構建一棵指向父節點的樹
    // parent[i]表示第一個元素所指向的父節點
    private int[] parent;
    private int count;

    // 構造函數
    public UnionFind2(int count){
            parent = new int[count];
            this.count = count;
            for (int i = 0; i < count; i++)
                parent[i] = i;
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

            parent[pRoot] = qRoot;
        }
}
