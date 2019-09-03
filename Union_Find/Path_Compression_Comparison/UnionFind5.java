package com.nero.main.java.algrorithm.Union_Find.Path_Compression_Comparison;

import com.nero.main.java.algrorithm.Union_Find.Same_Cases_Test_for_UF.UF;

public class UnionFind5 implements UF{

    // rank[i]表示以i為根的集合所表示的樹的層數
    // 在後續的代碼中,並不會維護rank的語意, 也就是rank的值在路徑壓縮的過程中, 有可能不在是樹的層數值
    private int[] rank;
    public int[] parent; // parent[i]表示第i個元素所指向的父節點
    private int count; // 數據個數

    public UnionFind5(int count){
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
    public int find(int p){
            assert (p >= 0 && p < count);

            // 路徑壓縮　
            // 方法一 :
            while(p != parent[p]){
                    parent[p] = parent[parent[p]];
                    p = parent[p];
                }
            return p;

            // 方法二(遞歸) :
            // if (p!= parent[p])
            //   parent[p] = find(parent[p]);
            // return parent[p];
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
            else if (rank[pRoot] > rank[qRoot]){
                    parent[qRoot] = pRoot;
                }
            else { // rank[pRoot] == rank[qRoot]
                    parent[pRoot] = qRoot;
                    rank[qRoot] += 1; // 此時,維護rank的值
                }
        }

    // 打印輸出並查集中的parent數據
    public void show(){
        for (int i = 0; i < count; i++)
            System.out.print(parent[i]+" ");
        System.out.println();
      }

}
