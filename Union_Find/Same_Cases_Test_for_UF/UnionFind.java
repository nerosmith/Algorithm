package com.nero.main.java.algrorithm.Union_Find.Same_Cases_Test_for_UF;

public class UnionFind  implements UF{
    private int[] id; // 第一版Union-Find本質就是一個數組
    private int count; // 數據個數

    public UnionFind(int n){
            count = n;
            id = new int[n];
            // 初始化, 每一個id[i]指向自己, 沒有合併的元素
            for (int i = 0; i < n; i++) {
                    id[i] = i;
                }
        }

    // 查找過程, 查找元素p所對應的集合編號
    // O(1)複雜度
    private int find(int p){
            assert p >= 0 && p < count;
            return id[p];
        }

    public boolean isConnected(int p,int q){
            return find(p) == find(q);
        }

    // 合併元素p和元素q所屬的集合
    // O(n) 複雜度
    public void unionElements(int p,int q){
            int pID = find(p);
            int qID = find(q);

            if (pID == qID)
                return;

            // 合併過程需要遍歷一遍所有元素, 將兩個元素的所屬集合編號合
            for (int i = 0; i < count; i++) {
                    if (id[i] == pID)
                        id[i] = qID;
                }
        }
}
