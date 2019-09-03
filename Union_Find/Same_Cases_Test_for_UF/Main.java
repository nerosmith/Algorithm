package com.nero.main.java.algrorithm.Union_Find.Same_Cases_Test_for_UF;


import com.nero.main.java.algrorithm.Union_Find.UnionFindTestHelper;

public class Main {

    // 對比UF1, UF2, UF3, UF4, UF5和UF6的時間性能
    // 在這裡, 對於不同的UnionFind的實現, 使用相同的測試用例, 讓測試結果更加準確
    public static void main(String[] args) {
            // 使用5000000的數據規模
            int n =  5000000;

            // 生成unionElements的測試用例
            Pair<Integer,Integer>[] unionTest = new Pair[n];
            for (int i = 0; i < n; i++) {
                    int a = (int)(Math.random()*n);
                    int b = (int)(Math.random()*n);
                    unionTest[i] = new Pair<>(a,b);
                }

            // 生成isConnected的測試用例
            Pair<Integer,Integer>[] connectTest = new Pair[n];
            for (int i = 0; i < n; i++) {
                    int a = (int)(Math.random()*n);
                    int b = (int)(Math.random()*n);
                    connectTest[i] = new Pair<>(a, b);
                }

            // 測試UF1 ~ UF6
            // 100萬數據對於UF1和UF2來說太慢了, 不再測試
//            UnionFind uf1 = new UnionFind(n);
//            UnionFindTestHelper.testUF("UF1", uf1, unionTest, connectTest);
//
//            UnionFind2 uf2 = new UnionFind2(n);
//            UnionFindTestHelper.testUF("UF2", uf2, unionTest, connectTest);

            UnionFind3 uf3 = new UnionFind3(n);
            UnionFindTestHelper.testUF("UF3", uf3, unionTest, connectTest);

            UnionFind4 uf4 = new UnionFind4(n);
            UnionFindTestHelper.testUF("UF4", uf4, unionTest, connectTest);

            UnionFind5 uf5 = new UnionFind5(n);
            UnionFindTestHelper.testUF("UF5", uf5, unionTest, connectTest);

            UnionFind6 uf6 = new UnionFind6(n);
            UnionFindTestHelper.testUF("UF6", uf6, unionTest, connectTest);
        }
}
