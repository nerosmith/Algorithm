package com.nero.main.java.algorithm.Union_Find;

public class UnionFindTestHelper {

    // 測試第一版本的並查集,測試元素個數為 n
    public static void testUF1(int n){
             UnionFind uf = new UnionFind(n);
             long startTime = System.currentTimeMillis();

            // 進行 n 次操作, 每次隨機選擇兩個元素進行合併操作
            for (int i = 0; i < n; i++) {
                    int a = (int)(Math.random()*n);
                    int b = (int)(Math.random()*n);
                    uf.unionElements(a,b);
                }

            // 再進行 n 次操作, 每次隨機選擇兩個元素, 查詢他們是否同屬一個集合
            for (int i = 0; i < n; i++) {
                    int a = (int)(Math.random()*n);
                    int b = (int)(Math.random()*n);
                    uf.isConnected(a,b);
                }

            long endTime = System.currentTimeMillis();

            // 打印輸出對這2n個操作的耗時
            System.out.println("UF1, " + 2*n + " ops, " + (endTime-startTime)+ "ms");
        }

    // 測試第二版本的並查集,測試元素個數為 n
    public static void testUF2(int n){
            UnionFind2 uf = new UnionFind2(n);
            long startTime = System.currentTimeMillis();

            // 進行 n 次操作, 每次隨機選擇兩個元素進行合併操作
            for (int i = 0; i < n; i++) {
                    int a = (int)(Math.random()*n);
                    int b = (int)(Math.random()*n);
                    uf.unionElements(a,b);
                }

            // 再進行n次操作, 每次隨機選擇兩個元素, 查詢他們是否同屬一個集合
            for (int i = 0; i < n; i++) {
                    int a = (int)(Math.random()*n);
                    int b = (int)(Math.random()*n);
                    uf.isConnected(a,b);
                }

            long endTime = System.currentTimeMillis();

            // 打印輸出對這2n個操作的耗時
            System.out.println("UF2, " + 2*n + " ops, " + (endTime-startTime) + "ms");
        }

    // 測試第三版本的並查集,測試元素個數為 n
    public static void testUF3(int n){
        UnionFind3 uf = new UnionFind3(n);
        long startTime = System.currentTimeMillis();

        // 進行 n 次操作, 每次隨機選擇兩個元素進行合併操作
        for (int i = 0; i < n; i++) {
                int a = (int)(Math.random()*n);
                int b = (int)(Math.random()*n);
                uf.unionElements(a,b);
            }

        // 再進行n次操作, 每次隨機選擇兩個元素, 查詢他們是否同屬一個集合
        for (int i = 0; i < n; i++) {
                int a = (int)(Math.random()*n);
                int b = (int)(Math.random()*n);
                uf.isConnected(a,b);
            }

        long endTime = System.currentTimeMillis();

            // 打印輸出對這2n個操作的耗時
            System.out.println("UF3, " + 2*n + " ops, " + (endTime-startTime)+ "ms");
        }

    // 測試第三版本的並查集,測試元素個數為 n
    public static void testUF4(int n){
        UnionFind4 uf = new UnionFind4(n);
        long startTime = System.currentTimeMillis();

        // 進行 n 次操作, 每次隨機選擇兩個元素進行合併操作
        for (int i = 0; i < n; i++) {
            int a = (int)(Math.random()*n);
            int b = (int)(Math.random()*n);
            uf.unionElements(a,b);
        }

        // 再進行n次操作, 每次隨機選擇兩個元素, 查詢他們是否同屬一個集合
        for (int i = 0; i < n; i++) {
            int a = (int)(Math.random()*n);
            int b = (int)(Math.random()*n);
            uf.isConnected(a,b);
        }

        long endTime = System.currentTimeMillis();

        // 打印輸出對這2n個操作的耗時
        System.out.println("UF3, " + 2*n + " ops, " + (endTime-startTime)+ "ms");
    }
}
