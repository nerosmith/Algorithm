package com.nero.main.java.algrorithm.Union_Find.Path_Compression_Comparison;

public class Main {
    public static void main(String[] args) {
            // 為了能夠方便地看出兩種路徑壓縮算法的不同,我們只使用有5個元素的並查集進行試驗
            int n = 5;

            UnionFind5 uf5 = new UnionFind5(n);
            UnionFind6 uf6 = new UnionFind6(n);

            // 將並查集初始設置成如下的樣子
            //            0
            //           /
            //          1
            //         /
            //        2
            //       /
            //      3
            //     /
            //    4
            for(int i = 1 ; i < n ; i ++){
                    uf5.parent[i] = i-1;
                    uf6.parent[i] = i-1;
                }

            // 現在, 對兩個並查集調用find(4)操作
            uf5.find(n-1);
            uf6.find(n-1);

            // 通過show, 可以看出, 使用迭代的路徑壓縮, 並查集變成這個樣子:
            //     0
            //    / \
            //   1   2
            //      / \
            //     3   4
            System.out.println("UF implements Path Compression by recursion:");
            uf5.show();

            System.out.println();

            // 使用遞歸的路徑壓縮, 並查集變成這個樣子
            //     0
            //  / / \ \
            // 1 2   3 4
            System.out.println("UF implements Path Compression without recursion:");
            uf6.show();
        }
}
